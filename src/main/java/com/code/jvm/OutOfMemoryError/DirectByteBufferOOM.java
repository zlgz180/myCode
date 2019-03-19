package com.code.jvm.OutOfMemoryError;

import java.nio.ByteBuffer;

/**
 * 堆外内存 -XX:MaxDirectMemorySize=3M -XX:+HeapDumpOnOutOfMemoryError
 * 堆外内存溢出是无法dump到效果的
 *
 *
 * -Xms8g -Xmx8g -Xmn3g -Xss512k -XX:MetaspaceSize=256m
 * -XX:MaxMetaspaceSize=512m -XX:+UseConcMarkSweepGC -XX:+DisableExplicitGC
 * -XX:-UseGCOverheadLimit -XX:+UseCMSInitiatingOccupancyOnly
 * -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled
 * -XX:+UseFastAccessorMethods 由于未设置直接内存大小参数 -XX:MaxDirectMemorySize, 那么 CMS GC
 * 堆外内存大小为：old 区 - 1个survivor 区， 即 8G - 314M = 7.8G。
 * 
 * @author tianwei
 * @since 2019/3/19 15:26
 */
public class DirectByteBufferOOM {
    public static void main(String[] args) {
        int i = 0;
        try {
            // Field field = sun.misc.Unsafe.class.getDeclaredFields()[0];
            // field.setAccessible(true);
            // sun.misc.Unsafe unsafe = (sun.misc.Unsafe) field.get(null);
            while (true) {
                ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024);

                // unsafe.allocateMemory(1024 * 1024);
                Thread.sleep(10);
                i++;
                System.out.println(i);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            try {
                Thread.sleep(100000L);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        } finally {
            System.out.println("分配次数：" + i);
        }
        // spring反射都会有个hashmap缓存，来避免重复反射class
        // BeanUtils.copyProperties();
    }
}
