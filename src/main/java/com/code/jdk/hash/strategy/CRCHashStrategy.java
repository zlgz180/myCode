package com.code.jdk.hash.strategy;

import java.util.zip.CRC32;

/**
 * CRC 算法
 *
 * @author tianwei
 * @since 2019/3/12 12:44
 */
public class CRCHashStrategy implements HashStrategy {
    @Override
    public int getHashCode(String origin) {
        CRC32 crc32 = new CRC32();
        crc32.update(origin.getBytes());
        return (int) ((crc32.getValue() >> 16) & 0x7fff & 0xffffffffL);
    }
}
