package com.code.algorithm.leetcode;

import java.util.Stack;

/**
 * @author tianwei
 * @since 2019-06-05 14:58
 */
public class IsPalindrome {
    public static void main(String[] args) {
        // System.out.println(isPalindrome(1235421));

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next = new ListNode(1);
        // listNode.next.next.next.next.next.next=new ListNode(3);

        // System.out.println(isPalindrome2(listNode));

        System.out.println(isPalindrome("123321"));
    }

    /**
     * 判断回文数字 121 -121
     * 
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String tmp = String.valueOf(x);
        char[] chars = tmp.toCharArray();
        int l = 0;
        int r = tmp.length() - 1;
        while (l <= r) {
            if (chars[l] == chars[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 请判断一个链表是否为回文链表。
     * 
     * 示例 1:
     * 
     * 输入: 1->2 输出: false 示例 2:
     * 
     * 输入: 1->2->2->1 输出: true
     *
     * 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * 
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        // 取中位 快慢指针找中位
        ListNode slow = head;
        ListNode fast = head;

        // 拆成俩链表
        // 第二条链表
        ListNode newList;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        newList = slow.next;
        slow.next = null;
        System.out.println(slow);

        // 反转第二条链表
        newList = reverse(newList);

        // 比较两个链表的值是否一样
        while (head != null && newList != null) {
            if (head.val == newList.val) {
                head = head.next;
                newList = newList.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.val == stack.peek()) {
                cur = cur.next;
                stack.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    private static ListNode reverse(ListNode curr) {
        if (curr == null) {
            return null;
        }
        ListNode pre = null;
        while (curr != null) {
            // 切断指针
            ListNode next = curr.next;
            // 指针掉头
            curr.next = pre;
            // 后移
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public static boolean isPalindrome(String s) {
        char[] sarr = s.toLowerCase().toCharArray();
        int i = 0;
        int j = sarr.length - 1;
        while (i < j) {
            if (sarr[i] == sarr[j] && ((sarr[i] >= 'a' && sarr[i] <= 'z') || (sarr[i] >= '0' && sarr[i] <= '9'))) {
                i++;
                j--;
            } else if ((sarr[i] < 'a' || sarr[i] > 'z') && (sarr[i] < '0' || sarr[i] > '9')) {
                i++;
            } else if ((sarr[j] < 'a' || sarr[j] > 'z') && (sarr[j] < '0' || sarr[j] > '9')) {
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
