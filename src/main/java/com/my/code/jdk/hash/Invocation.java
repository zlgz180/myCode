package com.my.code.jdk.hash;

/**
 * Invocation 是对请求的抽象，包含一个用于 hash 的 key。
 *
 * @author tianwei
 * @since 2019/3/12 12:46
 */
public class Invocation {
    private String hashKey;

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}
