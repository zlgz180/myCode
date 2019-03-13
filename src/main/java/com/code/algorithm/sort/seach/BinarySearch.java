package com.code.algorithm.sort.seach;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 1 };
        // bubbleSort(a, a.length);
        // System.out.println(JSON.toJSONString(a));

        // System.out.println(bSeach2(a, 1));
        System.out.println(8 >>> 1);
    }

    /**
     * 查找第一个重复的数据,二分查找
     *
     * @param t
     * @param val
     * @return
     */
    public static long bSeach2(int[] t, int val) {
        int l = 0;
        int h = t.length - 1;
        int m = -1;
        while (l <= h) {
            m = l + (h - l) >> 1;
            if (t[m] == val) {
                // m不一定是第一个m
                if (m == 0) {
                    return 0;
                }
                if (t[m - 1] != val) {
                    return m;
                }
            }
            if (t[m] < val) {
                l = m + 1;
            }
            if (t[m] > val) {
                h = m - 1;
            }
        }
        return m;
    }

    /**
     * 查找最后一个重复的数据,二分查找
     *
     * @param t
     * @param val
     * @return
     */
    public static long bSeach3(int[] t, int val) {
        int l = 0;
        int h = t.length - 1;
        int m = -1;
        while (l <= h) {
            m = l + (h - l) >> 1;
            if (t[m] == val) {
                if (m == t.length - 1) {
                    return m;
                }
                if (t[m + 1] != val) {
                    return m;
                }
            }
            if (t[m] < val) {
                l = m + 1;
            }
            if (t[m] > val) {
                h = m - 1;
            }
        }
        return m;
    }

    /**
     * 查找第一个大于val的序号
     *
     * @param t
     * @param val
     * @return
     */
    public static long bSeach4(int[] t, int val) {
        int l = 0;
        int h = t.length - 1;
        int m = -1;
        while (l <= h) {
            m = l + (h - l) >> 1;
            if (t[m] == val) {
                return m + 1;
            }
            if (t[m] < val) {
                l = m + 1;
            }
            if (t[m] > val) {
                h = m - 1;
            }
        }
        return m;
    }

    public int search2(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (h >= l) {
            // int mid = (h + l) / 2;
            int mid = l + (h - l) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }

    public long search1(int[] a, int val) {
        int low = 0;
        int high = a.length - 1;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            // long mid = (high + low) / 2;
            if (a[mid] == val) {
                return mid;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else if (a[mid] > val) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public long bSeach(int[] t, int n, int val) {
        return sd(t, n, val, 0, n - 1);
    }

    public long sd(int[] t, int n, int val, int low, int high) {
        int mid = low + (high - low) >> 1;
        if (t[mid] == val) {
            return mid;
        }
        if (t[mid] < val) {
            sd(t, n, val, low, high - 1);
        } else {
            sd(t, n, val, low + 1, high);
        }
        return -1;
    }
}
