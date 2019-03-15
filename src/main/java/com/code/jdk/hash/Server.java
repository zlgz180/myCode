package com.code.jdk.hash;

/**
 * Server 是对服务器的抽象，一般是 ip+port 的形式。
 *
 * @author tianwei
 * @since 2019/3/12 12:46
 */
public class Server {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
