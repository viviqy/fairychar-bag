package com.fairychar.bag.utils;


/**
 * @author chiyo
 */
public class CrcUtil {


    /**
     * 计算接收到数据的crc值
     *
     * @param bytes
     * @return
     */
    public static int calculate(byte[] bytes) {
        int[] subData = new int[bytes.length - 2];
        for (int i = 0; i < subData.length; i++) {
            subData[i] = bytes[i];
        }
        int i0, i1;
        char CRC16Lo, CRC16Hi;
        char SaveHi, SaveLo;
        CRC16Lo = 0xff;
        CRC16Hi = 0Xff;
        for (i0 = 0; i0 < subData.length; i0++) {
            CRC16Lo = (char) (CRC16Lo ^ subData[i0]);
            for (i1 = 0; i1 < 8; i1++) {
                SaveHi = CRC16Hi;
                SaveLo = CRC16Lo;
                CRC16Hi >>= 1;
                CRC16Lo >>= 1;
                if ((SaveHi & 1) == 1) {
                    CRC16Lo |= 0x80;
                }
                if ((SaveLo & 1) == 1) {
                    CRC16Hi ^= 0XA0;
                    CRC16Lo ^= 1;
                }
            }
        }
        return (CRC16Hi << 8) | CRC16Lo;
    }


}