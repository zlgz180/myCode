package com.notes.book.剑指offer第二版.code.chap2;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloor {
    /**
     * 到达1级台阶只有1种可能，到达2级台阶有2种可能；可记为f(1) = 1,f(2) = 2
     * 要到达3级台阶，可以选择在1级台阶处起跳，也可以选择在2级台阶处起跳，所以只需到达1级台阶的可能情况+到达2级台阶的可能情况，即f(3) =
     * f(2) +f(1) 同理到达n级台阶，可以在n-1级台阶起跳，也可在n-2级台阶起跳，f(n) = f(n-2)+f(n-1)
     * 可以看做是斐波那契数列
     *
     * @param target
     *            要到达的第n级台阶
     * @return 到达n级台阶总共的跳法可能
     */
    public static int jumpFloor(int target) {
        if (target <= 1) {
            return target;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <=target; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(5));
    }
}
