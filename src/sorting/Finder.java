package sorting;

/**
 * 有序矩阵查找
 */
public class Finder {
    /**
     * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
     * 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，请返回一个bool值，
     * 代表矩阵中是否存在x。所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
     */
    public boolean findX(int[][] mat, int n, int m, int x) {
        int row = n-1;
        int col = 0;

        while (row >= 0 && col < m) {
            if (mat[row][col] == x) {
                return true;
            }
            if (mat[row][col] > x) {
                row--;
                continue;
            }
            if (mat[row][col] < x) {
                col++;
                continue;
            }
        }
        return false;
    }
}
