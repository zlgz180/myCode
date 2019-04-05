package com.code.jvm;

/**
 * @author tianwei
 * @since 2019-04-05 23:14
 */
public class TLABDemo {

    public static class User {
        public int id = 0;
        public String name = "";
    }

    public static void alloc() {
        User u = new User();
        u.id = 5;
        u.name = "xxx";
    }

    /**
     * -server
     * -XX:+DoEscapeAnalysis
     * -XX:+EliminateAllocations
     * -XX:-UseTLAB
     * -Xmx10m
     * -Xms10m
     * -XX:+PrintGC
     *
     * @param args
     */
    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}
