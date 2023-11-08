package com.fairychar.bag.utils;

import cn.hutool.core.lang.Assert;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * file操作工具类
 *
 * @author chiyo <br>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileUtil {


    public static void concatFile(String outputPath, File head, File... concatFiles) {
        Assert.notNull(head, "head file can not be null");
        Assert.isTrue(head.isFile(), "head file should be a file");
        for (int i = 0; i < concatFiles.length; i++) {
            Assert.notNull(concatFiles[i], String.format("concat file can not be null,index=%d", i));
            Assert.isTrue(concatFiles[i].isFile(), String.format("head file should be a file,index=%d", i));
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(outputPath);
            byte[] buffer = new byte[1024];
            FileInputStream headFileInputStream = new FileInputStream(head);
            while (headFileInputStream.read(buffer) > 0) {
                outputStream.write(buffer);
            }
            for (File concatFile : concatFiles) {
                FileInputStream inputStream = new FileInputStream(concatFile);
                while (inputStream.read(buffer) > 0) {
                    outputStream.write(buffer);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cutFile(String sourceFilePath, String outputFilePath, double start, double end) {
        Assert.isTrue(start >= 0D && start < 1.0D, "start index should greater equal than 0 and less than 1");
        Assert.isTrue(end > 0D && end <= 1.0D, "end index should greater than 0 and less equal than 1");
        try (FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
             BufferedInputStream readStream = new BufferedInputStream(fileInputStream);
             FileOutputStream outputStream = new FileOutputStream(outputFilePath)
        ) {
            int length = 1024;
            byte[] buffer = new byte[length];
            int available = readStream.available();
            long starIndex = ((long) (available * start));
            long endIndex = ((long) (available * end));
            long markIndex = starIndex;
            readStream.skip(starIndex);
            while (markIndex < endIndex) {
                if (endIndex - markIndex >= length) {
                    readStream.read(buffer);
                    outputStream.write(buffer);
                    markIndex += length;
                } else {
                    byte[] remaining = new byte[((int) (endIndex - markIndex))];
                    readStream.read(remaining);
                    outputStream.write(remaining);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createFakeFileByNio(String path, long writeByteSize) throws IOException {
        createFakeFileByNio(path, ((byte) '1'), writeByteSize, 1024);
    }

    public static void createFakeFileByNio(String path, byte fillByte, long writeByteSize) throws IOException {
        createFakeFileByNio(path, fillByte, writeByteSize, 1024);
    }

    public static void createFakeFile(String path, long writeByteSize) throws IOException {
        createFakeFile(path, ((byte) '1'), writeByteSize, 1024);
    }

    public static void createFakeFile(String path, byte fillByte, long writeByteSize) throws IOException {
        createFakeFile(path, fillByte, writeByteSize, 1024);
    }

    public static void createFakeFileByNio(String path, byte fillByte, long writeByteSize, int pipeBufferSize) throws IOException {
        new File(path).createNewFile();
        final FileChannel fileChannel = FileChannel.open(Paths.get(path), StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocateDirect(pipeBufferSize);
        try {
            byte[] dataArray = new byte[pipeBufferSize];
            for (int i = 0; i < pipeBufferSize; i++) {
                dataArray[i] = fillByte;
            }
            long count = writeByteSize / pipeBufferSize;
            for (int i = 0; i < count; i++) {
                buffer.put(dataArray);
                buffer.flip();
                fileChannel.write(buffer);
                buffer.clear();
            }
            for (long i = 0; i < (writeByteSize % pipeBufferSize); i++) {
                buffer.put(fillByte);
            }
            buffer.flip();
            fileChannel.write(buffer, buffer.position());
        } finally {
            buffer.clear();
            fileChannel.close();
        }
    }

    public static void createFakeFile(String path, byte fillByte, long writeByteSize, int pipeBufferSize) throws IOException {
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
        ByteBuffer buffer = ByteBuffer.allocate(pipeBufferSize);
        try {
            for (int i = 0; i < (writeByteSize / pipeBufferSize); i++) {
                //TODO performance up
                for (int j = 0; j < pipeBufferSize; j++) {
                    buffer.put(fillByte);
                }
                outputStream.write(buffer.array());
                buffer.clear();
            }
            for (long i = 0; i < (writeByteSize % pipeBufferSize); i++) {
                buffer.put(fillByte);
            }
            byte[] bytes = new byte[buffer.position()];
            buffer.get(bytes);
            outputStream.write(bytes);
        } finally {
            buffer.clear();
            outputStream.close();
            fileOutputStream.close();
        }
    }
}
/*
                                      /[-])//  ___        
                                 __ --\ `_/~--|  / \      
                               /_-/~~--~~ /~~~\\_\ /\     
                               |  |___|===|_-- | \ \ \    
____________ _/~~~~~~~~|~~\,   ---|---\___/----|  \/\-\   
____________ ~\________|__/   / // \__ |  ||  / | |   | | 
                      ,~-|~~~~~\--, | \|--|/~|||  |   | | 
                      [3-|____---~~ _--'==;/ _,   |   |_| 
                                  /   /\__|_/  \  \__/--/ 
                                 /---/_\  -___/ |  /,--|  
                                 /  /\/~--|   | |  \///   
                                /  / |-__ \    |/         
                               |--/ /      |-- | \        
                              \^~~\\/\      \   \/- _     
                               \    |  \     |~~\~~| \    
                                \    \  \     \   \  | \  
                                  \    \ |     \   \    \ 
                                   |~~|\/\|     \   \   | 
                                  |   |/         \_--_- |\
                                  |  /            /   |/\/
                                   ~~             /  /    
                                                 |__/   W<

*/