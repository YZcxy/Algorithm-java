package sorting;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 对于一个int数组，请编写一个快速排序算法，对数组元素排序。
     * 给定一个int数组A及数组的大小n，请返回排序后的数组。
     */
    public int[] quickSort(int[] A, int n) {
        if (A == null || n < 2) return A;
        
        sort(A, 0, n-1);
        return A;
    }
    
    public void sort (int[] A, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition (A, lo, hi);
        sort(A, lo, j-1);
        sort(A, j+1, hi); 
    }
    
    public int partition (int[] A, int lo, int hi) {
        int i = lo, j = hi+1;
        int v = A[lo];
        while (true) {
            while (A[++i] < v) if(i == hi) break;  
            while (v < A[--j]) if(j == lo) break;
            if (i >= j) break;
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        int temp = A[lo];
        A[lo] = A[j];
        A[j] = temp;
        return j;
    }
}    