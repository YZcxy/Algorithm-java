package sorting;

/**
 * 插入排序
 */
public class InsertionSort {

	/**
     * 对于一个int数组，请编写一个插入排序算法，对数组元素排序。
     * 给定一个int数组A及数组的大小n，请返回排序后的数组。
     */
    public int[] insertionSort(int[] A, int n) {
        if (A == null || n < 2) return A;
        
        for (int i = 1; i < n; i++) {
            int temp = A[i];
            int j = i-1; 
            while (j >= 0) {
                if (A[j] > temp) {
                    A[j+1] = A[j];
                    j--;
                } else {
                   break;
                }
            }
            if (j != i-1) {
                A[j+1] = temp;
            }
        }
        return A;
    }
}