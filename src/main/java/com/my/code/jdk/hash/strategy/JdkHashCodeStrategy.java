package com.my.code.jdk.hash.strategy;

/**
 * 最简单、经典的 hashCode 实现
 * 
 * @author tianwei
 * @since 2019/3/12 12:41
 */
public class JdkHashCodeStrategy implements HashStrategy {
    @Override
    public int getHashCode(String origin) {
        return origin.hashCode();
    }
}
