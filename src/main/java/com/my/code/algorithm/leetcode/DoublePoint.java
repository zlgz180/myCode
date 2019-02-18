package com.my.code.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4] 输出：[2,4,3,1] 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000 0 <= A[i] <= 5000
 */
public class DoublePoint {
    public static void main(String[] args) {
        int[] t1 = new int[] { 4, 9, 5 };
        int[] t2 = new int[] { 9, 4, 9, 8, 4, 4 };


        // System.out.println(Arrays.toString(intersect(t1, t2)));

        // System.out.println(repeatedNTimes(t2));

        // thirdMax(t1);
        // findKthLargest(t1, 2);

        int[] t3 = new int[] { 99, 99 };
        // containsNearbyDuplicate(t3, 2);

        int[] t4 = new int[] { 1 };
        // System.out.println(search(t4, 2));

        System.out.println(searchInsert(t4, 0));

    }

    /**
     * 求两数组交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int length = nums1.length > nums2.length ? nums2.length : nums1.length;
        int[] ints = new int[length];
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (length - 1 == sum) {
                    return ints;
                }
                if (nums1[i] == nums2[j]) {
                    ints[sum++] = nums1[i];
                    break;
                }
            }
        }
        return ints;
    }

    public static int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>(A.length);
        for (int i = 0; i < A.length; i++) {
            Integer tmp = map.get(A[i]);
            if (tmp != null) {
                map.put(A[i], tmp + 1);
            } else {
                map.put(A[i], 0);
            }
        }
        int sum = 0;
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > sum) {
                sum = value;
                key = entry.getKey();
            }
        }
        return key;
    }

    public static int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxx = Integer.MIN_VALUE;
        int maxxx = Integer.MIN_VALUE;
        int valid = 0;
        boolean flag = true;
        for (int i : nums) {
            if (i == max || i == maxx || i == maxxx) {
                if (flag && i == Integer.MIN_VALUE) {
                    flag = false;
                    valid++;
                }
                continue;
            }
            if (i > max) {
                valid++;
                maxxx = maxx;
                maxx = max;
                max = i;
                continue;
            }
            if (i > maxx) {
                valid++;
                maxxx = maxx;
                maxx = i;
                continue;
            }
            if (i > maxxx) {
                valid++;
                maxxx = i;
                continue;
            }
        }

        if (valid < 3) {
            return max;
        } else {
            return maxxx;
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            queue.add(num);
        }
        Integer result = null;
        for (int i = 0; i < k; i++) {
            result = queue.peek();
            System.out.println(result);
        }
        return result;
    }

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j
     * 的差的绝对值最大为 k。
     * 
     * 示例 1: 输入: nums = [1,2,3,1], k = 3 输出: true <br>
     * 示例 2: 输入: nums = [1,0,1,1], k = 1 输出: true <br>
     * 示例 3: 输入: nums = [1,2,3,1,2,3], k = 2 输出: false <br>
     * 
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) == k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的
     * target，如果目标值存在返回下标，否则返回 -1。
     * 
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int m = -1;

        if (nums.length == 1) {
            return nums[0] >= target ? 0 : 1;
        }
        while (h >= l) {
            if (nums[l] > target) {
                return l;
            }
            if (nums[h] < target) {
                return h + 1;
            }
            m = l + (h - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < target) {
                if (nums[m + 1] > target) {
                    return m + 1;
                }
                l = m + 1;
            }
            if (nums[m] > target) {
                if (nums[m - 1] < target) {
                    return m;
                }
                h = m - 1;
            }
        }
        return m;
    }

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode = new ListNode(0);
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        return listNode.next;
    }

    public int peakIndexInMountainArray(int[] A) {
        int mid = -1;
        int low = 0;
        int high = A.length - 1;
        while (high >= low) {
            mid = low + (high - low) / 2;
            int left = A[mid - 1];
            int right = A[mid + 1];
            int midVal = A[mid];
            if (left < midVal && midVal > right) {
                return mid;
            }
            if (left < midVal && midVal < right) {
                low = mid + 1;
            }
            if (left > midVal && midVal > right) {
                high = mid - 1;
            }
        }
        return mid;
    }

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 示例:
     *
     * 输入: numbers = [2, 7, 11, 15], target = 9 输出: [1,2] 解释: 2 与 7 之和等于目标数 9 。因此
     * index1 = 1, index2 = 2 。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    ints[0] = i + 1;
                    ints[1] = j + 1;
                    return ints;
                }
            }
        }
        return ints;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int[] ints = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int temp = numbers[right] + numbers[left];
            if (temp == target) {
                ints[0] = left + 1;
                ints[1] = right + 1;
                return ints;
            }
            if (temp > target) {
                right--;
            } else {
                left++;
            }
        }
        return ints;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
