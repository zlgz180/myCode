package com.notes.book.剑指offer第二版.code;

/**
 * 数组遍历练习
 *
 *
 * 动态规划时暴力破解的写法
 * 
 * @author tianwei
 * @since 2019-06-12 12:28
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] data = { 1, 2, -3, 4, 5 };
        // forTest(data);
        // whileTest(data);
        // allSum(data);
        // twoPoint(data);

        int[] data2 = { 1, 1, 1, 2, 2, 2, 3, 3, 4 };
        removeDuplicate(data2);
    }

    /**
     * 累加和
     *
     * @param data
     * @return
     */
    public static int allSum(int[] data) {
        // 顺序累加和
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        System.out.println("累加合" + sum);

        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            max = Math.max(data[i], max);
        }
        System.out.println("最大值" + max);

        int min = data[0];
        for (int i = 1; i < data.length; i++) {
            min = Math.min(data[i], min);
        }
        System.out.println("最小值" + min);
        return sum;
    }

    /**
     * 头尾交替输出
     *
     * @param data
     * @return
     */
    public static int twoPoint(int[] data) {
        System.out.println("头尾交替输出");
        int l = 0;
        int r = data.length - 1;
        while (r >= l) {
            if (r == l) {
                System.out.print(data[l]);
                System.out.print("\t");
                r--;
                l++;
                continue;
            }
            System.out.print(data[l]);
            System.out.print("\t");
            System.out.print(data[r]);
            System.out.print("\t");
            l++;
            r--;
        }
        System.out.println();
        System.out.println("头尾交替输出2");

        l = 0;
        r = data.length - 1;
        for (int i = 0; i <= data.length / 2; i++) {
            System.out.print(data[l]);
            System.out.print("\t");
            System.out.print(data[r]);
            System.out.print("\t");
            l++;
            r--;
        }
        return 0;
    }

    /**
     * 有序数组去重输出
     *
     * @param data
     * @return
     */
    public static void removeDuplicate(int[] data) {
        System.out.println("有序数组去重输出，重复数据保留一个");
        System.out.print(data[0]);
        System.out.print("\t");
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1] == data[i]) {
                // 跳过,指针右移
                continue;
            } else {
                System.out.print(data[i]);
                System.out.print("\t");
            }
        }

        System.out.println("有序数组去重输出，重复数据移除");
        // 双指针
        int l = 0;
        int r = 1;
        int index = 0;
        while (index <= data.length - 1) {
            if (data[l] == data[r]) {
                // 得找到r最大值
                r++;
            } else {
                System.out.println(data[r]);
                l = index;
                r = index;
            }
            index++;
        }
    }

    /**
     * 关键想好数组的特点，从内从循环往外想
     * 
     * @param data
     * @return
     */
    public static int forTest(int[] data) {
        System.out.println("从小到大的矩阵");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                System.out.print(data[j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }

        System.out.println("从小到大的倒三角");
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                System.out.print(data[j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }

        System.out.println("从小到大的正三角");
        for (int i = data.length - 1; i >= 0; i--) {
            for (int j = 0; j < data.length - i; j++) {
                System.out.print(data[j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }

        System.out.println("从大到小的倒三角");
        for (int i = 0; i < data.length; i++) {
            for (int j = data.length - 1 - i; j >= 0; j--) {
                System.out.print(data[j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }

        System.out.println("从大到小的正三角");
        for (int i = data.length - 1; i >= 0; i--) {
            for (int j = 0; j <= data.length - i - 1; j++) {
                System.out.print(data[j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
        return 0;
    }

    public static int whileTest(int[] data) {
        System.out.println("从小到大的矩阵");
        int i = 0;
        while (i <= data.length - 1) {
            // 外层循环
            int k = 0;
            while (k <= data.length - 1) {
                // 内层循环
                System.out.print(data[k++]);
                System.out.print("\t");
            }
            System.out.println("\n");
            i++;
        }

        System.out.println("从小到大的倒三角");
        int i2 = 0;
        while (i2 <= data.length - 1) {
            int j = 0;
            while (j <= data.length - i2 - 1) {
                // 内层循环
                System.out.print(data[j++]);
                System.out.print("\t");
            }
            System.out.println("\n");
            i2++;
        }

        System.out.println("从小到大的正三角");
        int i3 = data.length - 1;
        while (i3 >= 0) {
            int j = 0;
            while (j <= data.length - i3 - 1) {
                // 内层循环
                System.out.print(data[j++]);
                System.out.print("\t");
            }
            System.out.println("\n");
            i3--;
        }

        System.out.println("从大到小的倒三角");
        int i4 = data.length - 1;
        while (i4 >= 0) {
            int j = data.length - 1;
            while (j >= data.length - i4 - 1) {
                // 内层循环
                System.out.print(data[j--]);
                System.out.print("\t");
            }
            System.out.println("\n");
            i4--;
        }

        System.out.println("从大到小的正三角");
        int i5 = 0;
        while (i5 <= data.length - 1) {
            int j = data.length - 1;
            while (j >= data.length - i5 - 1) {
                // 内层循环
                System.out.print(data[j--]);
                System.out.print("\t");
            }
            System.out.println("\n");
            i5++;
        }
        return 0;
    }
}
