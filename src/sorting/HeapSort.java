package sorting;


import java.util.ArrayList;
import java.util.List;

/**
 * 堆排序
 */
public class HeapSort {

	/**
     * 对于一个int数组，请编写一个堆排序算法，对数组元素排序。
	 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
     */
    public int[] heapSort(int[] A, int n) {
        // write code here
        if (A == null || n < 2) return A;

        int len = A.length;
        int[] result = new int[len];
        int i = 0;

        ArrayList<Integer> list = buildMinHeap(A);
        while (list.size() > 1) {
            result[i++] = minHeapify(list);
        }

        return result;
    }

    /**
     * 根据无序数组生成小根堆
     */
    public ArrayList<Integer> buildMinHeap(int[] A){
        ArrayList<Integer> list = new ArrayList<>(A.length);
        list.add(0);
        for (int i=0; i < A.length; i++) {
            list.add(A[i]);
        }

        int len = list.size();
        for (int i = len-1; i > 1; i--) {
            int parent = i / 2 ;
            while (parent > 0) {
                if(list.get(i) < list.get(parent)){
                    swapList(list,i,parent);
                }
                parent /= 2 ;
            }
        }
        return list;
    }

    public int minHeapify(List<Integer> list) {
        int len = list.size();
        int cur = 1;
        int left = cur * 2,right = cur * 2 + 1;
        while (left < len || right < len) {
            if (left < len && right < len
                    && list.get(left) < list.get(cur)
                    && list.get(right) < list.get(cur)) {
                if (list.get(left) < list.get(right)) {
                    swapList(list,cur,left);
                    cur = left;
                }else {
                    swapList(list,cur,right);
                    cur = right;
                }
                left = cur * 2;
                right = cur * 2 + 1;
                continue;
            }
            if (left < len && list.get(left) < list.get(cur) ) {
                swapList(list,cur,left);
                cur = left;
                left = cur * 2;
                right = cur * 2 + 1;
                continue;
            }

            if (right < len && list.get(right) < list.get(cur) ) {
                swapList(list,cur,right);
                cur = right;
                left = cur * 2;
                right = cur * 2 + 1;
                continue;
            }
            break;
        }
        swapList(list,1,len-1);
        return list.remove(len-1);
    }


    public void swapList(List<Integer> list, int a, int b) {
        int temp = list.get(a);
        list.set(a,list.get(b));
        list.set(b,temp);
    }
}