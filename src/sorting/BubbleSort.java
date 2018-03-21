package sorting;

/**
 * 冒泡排序
 */
public class BubbleSort {
	
    /**
     * 对于一个int数组，请编写一个冒泡排序算法，对数组元素排序。
     * 给定一个int数组A及数组的大小n，请返回排序后的数组。 
     */
    public int[] bubbleSort(int[] A, int n) {
        if (A == null || n < 2) return A;
        
        int index = n - 1;  
        
        while (index > 0) {
        	for (int i = 0; i < index; i++) {
                int j = i + 1;
                if (A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
            index--;
        }
        return A;
    }
}