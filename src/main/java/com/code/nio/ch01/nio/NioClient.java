package com.code.nio.ch01.nio;

import com.code.nio.ch01.Ch01Const;

import java.util.Scanner;

/**
 * @author Mark老师 享学课堂 https://enjoy.ke.qq.com 类说明：nio通信客户端
 */
public class NioClient {

    private static cn.enjoyedu.ch01.nio.NioClientHandle nioClientHandle;

    public static void start() {
        if (nioClientHandle != null)
            nioClientHandle.stop();
        nioClientHandle = new cn.enjoyedu.ch01.nio.NioClientHandle(Ch01Const.DEFAULT_SERVER_IP, Ch01Const.DEFAULT_PORT);
        new Thread(nioClientHandle, "Client").start();
    }

    // 向服务器发送消息
    public static boolean sendMsg(String msg) throws Exception {
        nioClientHandle.sendMsg(msg);
        return true;
    }

    public static void main(String[] args) throws Exception {
        start();
        Scanner scanner = new Scanner(System.in);
        while (NioClient.sendMsg(scanner.next()))
            ;
    }

}
