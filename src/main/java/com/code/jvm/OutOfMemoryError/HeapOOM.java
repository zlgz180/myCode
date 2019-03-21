package com.code.jvm.OutOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * @author tianwei
 * @since 2019-03-19 14:59
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        int i = 0;
        while (true) {
            System.out.println(i++);
            list.add(new OOMObject());
        }
    }

    static class OOMObject {
    }
}
