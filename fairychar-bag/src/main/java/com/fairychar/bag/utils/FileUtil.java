package com.fairychar.bag.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public static void createFakeFileByNio(String path, long writeByteSize) throws IOException {
        createFakeFile(path, ((byte) '1'), writeByteSize, 1024);
    }

    public static void createFakeFileByNio(String path, byte fillByte, long writeByteSize) throws IOException {
        createFakeFile(path, fillByte, writeByteSize, 1024);
    }

    public static void createFakeFile(String path, long writeByteSize) throws IOException {
        createFakeFile(path, ((byte) '1'), writeByteSize, 1024);
    }

    public static void createFakeFile(String path, byte fillByte, long writeByteSize) throws IOException {
        createFakeFile(path, fillByte, writeByteSize, 1024);
    }

    public static void createFakeFileByNio(String path, byte fillByte, long writeByteSize, int pipeBufferSize) throws IOException {
        final FileChannel fileChannel = FileChannel.open(Paths.get(path), StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocateDirect(pipeBufferSize);
        try {
            for (int i = 0; i < (writeByteSize / pipeBufferSize); i++) {
                for (int j = 0; j < pipeBufferSize; j++) {
                    buffer.put(fillByte);
                }
                fileChannel.write(buffer);
                buffer.clear();
            }
            for (long i = 0; i < (writeByteSize % pipeBufferSize); i++) {
                buffer.put(fillByte);
            }
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