package sorting;

/**
 * 选择排序
 */
public class SelectionSort {
    
    /**
     * 对于一个int数组，请编写一个选择排序算法，对数组元素排序。
     * 给定一个int数组A及数组的大小n，请返回排序后的数组。
     */
    public int[] selectionSort(int[] A, int n) {
        if (A == null || n < 2) return A;
        
        for (int i = 0; i < n-1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (A[j] < min) {
                    min = A[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = A[i];
                A[i] = A[minIndex];
                A[minIndex] = temp;
            }
        }
        return A;
    }
}