package sorting;

public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        if (A == null || n < 2) return A;

        int len = A.length;
        int h = 1;
        while (h < len/3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i=h; i < len; i++) {
                for (int j=i; j>=h && A[j] < A[j-h]; j -= h) {
                    int temp = A[j];
                    A[j] = A[j-h];
                    A[j-h] = temp;
                }
            }
            h = h/3;
        }

        return A;
    }
}
