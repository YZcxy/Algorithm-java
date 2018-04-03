package sorting;

/**
 * 改善的堆排序
 */
public class ScaleSort {
    /**
     * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，
     * 每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
     * 请选择一个合适的排序算法针对这个数据进行排序。
     * 给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
     */
    public int[] sortElement(int[] A, int n, int k) {
        if (A == null || n < 2) return A;

        for (int i = 0; i < n; i++) {
            buildMinHeap(A,i,k);
            if (k < n-1) k++;
        }
        return A;
    }

    /**
     * 构建小跟堆
     * 难点在于parent - begin + 1 = (child - begin + 1) / 2
     */
    private void buildMinHeap(int[] A, int begin, int end) {
        if (begin == end) return;
        for (int i = end; i > begin; i--) {
            int parent = ((i - begin + 1) / 2) - 1 + begin;
            while (parent >= begin) {
                if (A[i] < A[parent]) {
                    int temp = A[i];
                    A[i] = A[parent];
                    A[parent] = temp;
                }
                parent = ((parent - begin + 1) / 2) - 1 + begin;
            }
        }
    }


}
