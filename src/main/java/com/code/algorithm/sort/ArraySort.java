package com.code.algorithm.sort;

public class ArraySort {

	public static void main(String[] args) {
        int[] array = getArray();
//        selectSort(array);
        //insertSort(array);
        //bubbleSort(array);
        quickSort(array, 0, array.length - 1);
        System.out.println("\n快速排序：");
        for (int i : array) {
            System.out.print(i + ",");
        }
	}

    public static int[] getArray() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 + 100);
            System.out.print(array[i] + ",");
        }
        return array;
    }

    /**
     * @author ZHI
     * 选择排序，先选出待比较值，再在第二次循环中从待排序数组
     * 中找到最小的或最大的数字放在第一次循环的起始位置
     */
    public static void selectSort(int[] array) {
        System.out.println("\n选择排序：");
        int index;
        for (int i = 0; i < array.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        for (int i : array)
            System.out.print(i + ",");
    }

	/**
	 * @author ZHI
	 * 插入排序，预设第一个数值为已经排序好的，然后从后面的数组中拿第一个数字放到前面已经排序
	 * 好的数组中，在放入过程中不停比较，大于该数字的则向后移一位，直到新数字放入已排序好的数
	 * 组中之后，仍然是排序好的数组
	 */
    public static void insertSort(int[] array) {
        System.out.println("\n插入排序：");
        int key;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            int j = i;
            while (j > 0 && key < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
			/*for(;j>0&&key<array[j-1];j--)
				array[j]=array[j-1];*/
            array[j] = key;
        }
        for (int i : array)
            System.out.print(i + ",");
    }

    /**
	 * @author ZHI
	 * 冒泡排序，比较相邻的两个数，不停地找出当前一轮循环中最大或最小的值向一边推过去，
	 * 推过去的一边即为已经排序好的一边，不再遍历。
	 * 模式一：（* 为需要遍历点）
	 * for(int i=0;i<a.length;i++)
	 *   for(int j=0;j<a.length-i-1;j++)
	 *
	 *   * * * * * *
	 *   * * * * *
	 *   * * * *
	 *   * * *
	 *   * *
	 *   *
	 * 模式二：
	 * for(int i=0;i<a.length;i++)
	 *   for(int j=a.length-1;j>i;j--)
	 *
	 *   * * * * * *
	 *     * * * * *
	 *       * * * *
	 *         * * *
	 *           * *
	 *             *
	 */
    public static void bubbleSort(int[] array) {
        System.out.println("\n冒泡排序：");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i : array)
            System.out.print(i + ",");
    }

	/**
	 * @author ZHI
	 * 快速排序，把一个数组分成两部分，取第一个为关键值key，先把右边小于key的值
	 * 放到左边，然后再把左边大于key的值放到右边，直到上下标相等，得到一个中间
	 * 下标，把key放到该下标中。最后在中间值下标处把数组一分为二，分别重复（递归）
	 * 上述步骤，直到结束
	 */
    public static void quickSort(int[] array, int start, int end) {
        if (start >= end)
            return;   //递归出口，所有递归支路都会出现上下标相等，这是递归结束
        int l = start, r = end;
        int mid;
        int key = array[l];//因为key值取出，故整个数组有一个空的位置给予数组移动
        while (l < r) {
            while (array[r] >= key && l < r) {//右边大于key的值略过
                --r;
            }
            array[l] = array[r];//右边小于key的值放到左边（第一次时是放在key值的位置，这是空出右边的位置）
            while (array[l] <= key && l < r) {//左边小于key的值略过
                ++l;
            }
            array[r] = array[l];//左边大于key的值放到右边（放到上面空出来的右边位置）
        }
        array[l] = key;//fixme
        mid = l;//fixme
        //int mid=partition(array,start,end);
        quickSort(array, start, mid - 1); //左递归
        quickSort(array, mid + 1, end);   //右递归
    }

    public static int partition(int[] array, int start, int end) {
        int key = array[start];
        while (start < end) {
            while (array[end] >= key && start < end) {
                --end;
            }
            array[start] = array[end];
            while (array[start] <= key && start < end) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = key;
        return start;
    }

}
