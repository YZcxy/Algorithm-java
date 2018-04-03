package sorting;

/**
 * 基数排序
 */
public class RadixSort {
    /**
     * 对于一个int数组，请编写一个基数排序算法，对数组元素排序。
     * 给定一个int数组A及数组的大小n，请返回排序后的数组。保证元素均小于等于2000。
     */
    public int[] radixSort(int[] A, int n) {
        if (A == null || n < 2) return A;

        for (int d = 1; d <= 1000; d *= 10) {
            int[][] bucket = new int[10][n+1];
            //将数组倒入桶中
            for (int i = 0; i < n; i++) {
                int digit = getDigit(A[i],d);
                int index = bucket[digit][0];
                bucket[digit][index + 1] = A[i];
                bucket[digit][0] += 1;
            }
            //将桶倒出新数组
            int [] temp = new int[n];
            int tempIndex = 0;
            for (int i = 0; i < 10; i++) {
                int index = bucket[i][0];
                for (int j = 1; j <= index; j++) {
                    temp[tempIndex++] = bucket[i][j];
                }
            }
            A = temp;
        }
        return A;
    }

    /**
     * 传递一个数，以及想要获取的位数，返回其位数上的值
     * 如果传递123和10，则是返回123的10位上的数字2
     * @param d 只能为1 10 100 。。。
     */
    private int getDigit(int num,int d) {
        return (num / d) % 10;
    }
}
