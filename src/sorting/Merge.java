package sorting;

/**
 * 两个指针分别从后往前比较，移动即可
 */
public class Merge {
    /**
     * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。
     * 请编写一个方法，将B合并入A并排序。
     * 给定两个有序int数组A和B，A中的缓冲空用0填充，
     * 同时给定A和B的真实大小int n和int m，请返回合并后的数组。
     */
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        int indexA = n - 1;
        int indexB = m - 1;
        int indexTail = n + m - 1;

        while (indexTail >= 0) {
            if (indexA >= 0 && indexB >= 0) {
                if (A[indexA] > B[indexB]) {
                    A[indexTail--] = A[indexA--];
                }else {
                    A[indexTail--] = B[indexB--];
                }
                continue;
            }
            if (indexA >= 0) {
                A[indexTail--] = A[indexA--];
                continue;
            }
            if (indexB >= 0) {
                A[indexTail--] = B[indexB--];
                continue;
            }
        }

        return A;

    }

}
