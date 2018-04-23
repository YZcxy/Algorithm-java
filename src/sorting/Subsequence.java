package sorting;

/**
 * 最短子数组
 */
public class Subsequence {
    /**
     * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
     * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。
     * (原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
     */
    public int shortestSubsequence(int[] A, int n) {
        int right = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
                continue;
            }
            if (A[i] < max) {
                right = i;
            }
        }

        int left = n-1;
        int min = Integer.MAX_VALUE;
        for (int j = n-1; j >=0; j--) {
            if (A[j] < min) {
                min = A[j];
                continue;
            }
            if (A[j] > min) {
                left = j;
            }
        }

        if (right > left) {
            return right - left + 1;
        }
        return 0;
    }
}
