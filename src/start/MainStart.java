package start;
import binarytree.TreePrinter;
import sorting.HeapSort;

public class MainStart{

	public static void main (String[] args) {
        HeapSort p = new HeapSort();
        int[] A = new int[]{1,2,3,5,2,3};
        int[] res = p.heapSort(A,6);
        System.out.print(res);
    }
}