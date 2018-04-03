package sorting;

/**
 * 计数排序
 */
public class CountingSort {
    /**
     * 对于一个int数组，请编写一个计数排序算法，对数组元素排序。
     * 给定一个int数组A及数组的大小n，请返回排序后的数组。
     */
    public int[] countingSort(int[] A, int n) {
        if (A == null || n < 2) return A;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int temp = A[i];
            if (temp > max) {
                max = temp;
            }
            if (temp < min) {
                min = temp;
            }
        }

        //创建桶
        int[] bucket = new int[max];
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            bucket[val] += 1;
        }

        //将桶倒出
        int[] result = new int[n];
        int index = 0;
        for (int i = min; i <= max; i++) {
            while (bucket[i] != 0) {
                result[index] = i;
                bucket[i] -= 1;
                index++;
            }
        }

        return result;

    }

}
