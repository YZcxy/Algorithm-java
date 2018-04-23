package sorting;

/**
 * 三色排序练习题
 */
public class ThreeColor {

    /**
     * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
     * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
     */
    public int[] sortThreeColor(int[] A, int n) {
        if (A == null || n < 2) return A;

        int left = 0;
        int right = n-1;

        for (int i = 0; i <= right; ) {
            if (A[i] == 0) {
                swapInteger(A,i,left);
                left++;
                i++;
                continue;
            }
            if (A[i] == 1) {
                i++;
                continue;
            }
            if (A[i] == 2) {
                swapInteger(A,i,right);
                right--;
                continue;
            }
        }

        return A;
    }

    private void swapInteger (int[] A, int a, int b) {
        if (a == b) return;
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
