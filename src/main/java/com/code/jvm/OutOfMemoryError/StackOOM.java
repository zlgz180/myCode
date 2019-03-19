package com.code.jvm.OutOfMemoryError;

/**
 * 栈溢出 -Xss128k
 * 
 * @author tianwei
 * @since 2019/3/19 15:10
 */
public class StackOOM {

    private static int stackLength;

    public static void stackLeak() {
        stackLength++;
        // while(1!=2)
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        try {
            stackLeak();
        } catch (Throwable e) {
            System.out.println(stackLength);
            throw e;
        }
    }
}
