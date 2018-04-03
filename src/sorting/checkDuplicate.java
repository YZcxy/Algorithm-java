package sorting;

import java.util.Arrays;

/**
 * 选用空间复杂度O(1)的排序算法排序，然后查看相邻的值是否相等即可
 * 例如：冒泡，选择，插入，希尔，非递归的堆排序
 */
public class checkDuplicate {
    /**
     * 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
     * 给定一个int数组A及它的大小n，请返回它是否有重复值。
     */
    public boolean checkDuplicate(int[] a, int n) {
        Arrays.sort(a);

        return compareNext(a,n);
    }

    private boolean compareNext (int[] a, int n) {
        for (int i = 0; i < n-1; i++) {
            if (a[i] == a[i+1]) return true;
        }
        return false;
    }

}
