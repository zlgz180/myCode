package com.code.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tianwei
 */
public class hasCycle {
    public static void main(String[] args) {
        int[] ss = { 9 };
        // int[] ints = new Solution().plusOne(ss);

        int[][] sss = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.toString(new hasCycle().transpose(sss)));
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (slow == null || fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            if (slow.val == fast.val) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            if (slow.val == fast.val || fast.next == null) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aCur = headA;
        ListNode bCur = headB;
        while (aCur != null) {
            while (bCur != null) {
                if (bCur.val == aCur.val) {
                    return aCur;
                }
                bCur = bCur.next;
            }
            aCur = aCur.next;
        }
        return null;
    }

    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        if (digits[0] == 0) {
            int res[] = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }

    public int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        }
        return ans;
    }

    public boolean isMonotonic(int[] A) {
        return q(A);
    }

    private boolean q(int[] A) {
        boolean flag = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] >= A[i + 1]) {
                flag = true;
            }
        }
        return flag;
    }

    private boolean p(int[] A) {
        boolean flag = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 贪心算法不好使
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> l = new ArrayList<>();
        // 每一层取最小值
        for (List<Integer> list : triangle) {
            int min = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                min = Math.min(list.get(i), min);
            }
            l.add(min);
        }

        int sum = 0;
        for (int s : l) {
            sum += s;
        }
        return sum;
    }

    /**
     * 自底向上动态规划, dp[i]表示到第i行时的最小路径和, 先从底层 开始判断, 每向上一层后该层的数据无需再使用可以直接覆盖, 所以
     * 可以把空间复杂度优化到O(N), 但是要注意覆盖时的顺序
     **/
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() < 1) {
            return 0;
        }
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; --i) {
            int size = triangle.get(i).size();
            for (int j = 0; j < size; ++j) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public boolean hasCycle3(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == null || fast == null || fast.next == null || fast.next.next == null) {
                return false;
            }
            if (slow.val == fast.val) {
                return true;
            }
        }
        return false;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
