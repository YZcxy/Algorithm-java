package sorting;

/**
 * 归并排序
 */
public class MergeSort {
    
    private int[] temp;
    
    /**
     * 对于一个int数组，请编写一个归并排序算法，对数组元素排序。
     * 给定一个int数组A及数组的大小n，请返回排序后的数组。
     */
    public int[] mergeSort(int[] A, int n) {
        if (A == null || n < 2) return A;
        
        temp = new int[n];
        
        sort(A,0,n-1);
        
        return A;
    }
    
    private void sort (int[] A, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(A, lo, mid);
        sort(A, mid+1, hi);
        merge(A, lo, mid, hi);
        
    }
    
    private void merge (int[] A, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        
        for (int k = lo; k <= hi; k++) {
            temp[k] = A[k];
        }
        
        for (int k = lo; k <= hi; k++) {
            if (i > mid) A[k] = temp[j++];
            else if (j > hi)  A[k] = temp[i++];
            else if (temp[j] < temp[i]) A[k] = temp[j++];
            else A[k] = temp[i++];
        }
    }
}