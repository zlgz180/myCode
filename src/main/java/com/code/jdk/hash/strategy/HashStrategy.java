package com.code.jdk.hash.strategy;

/**
 * @author tianwei
 * @since 2019-03-12 12:38
 */
public interface HashStrategy {
    int getHashCode(String origin);
}
