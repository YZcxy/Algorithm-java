package queueAndStack;

import java.util.Stack;

/**
 * 数组变树
 */
public class MaxTree {
    /**
     * 对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，
     * MaxTree定义为一棵二叉树，其中的节点与数组元素一一对应，同时对于MaxTree的每棵子树，
     * 它的根的元素值为子树的最大值。现有一建树方法，对于数组中的每个元素，
     * 其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。
     * 若两边都不存在比它大的数，那么它就是树根。请设计O(n)的算法实现这个方法。
     * 给定一个无重复元素的数组A和它的大小n，请返回一个数组，
     * 其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1。
     */
    public int[] buildMaxTree(int[] A, int n) {
        int[] res = new int[n];
        if (n == 0) return res;

        Stack<Integer> stack = new Stack<>();
        int[][] maxAndMin = new int[n][2];

        for (int i = 0; i < n; i++) {
            int num = A[i];
            while (!stack.empty() && num > A[stack.peek()]) stack.pop();

            if (stack.empty()){
                maxAndMin[i][0] = -1;
            }else {
                maxAndMin[i][0] = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            int num = A[i];
            while (!stack.empty() && num > A[stack.peek()]) stack.pop();

            if (stack.empty()){
                maxAndMin[i][1] = -1;
            }else {
                maxAndMin[i][1] = stack.peek();
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int left = maxAndMin[i][0];
            int right = maxAndMin[i][1];
            if (left == right) {
                res[i] = -1;
            }else if (left == -1 || (right != -1 && A[left] > A[right])) {
                res[i] = right;
            }else {
                res[i] = left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxTree m = new MaxTree();
        m.buildMaxTree(new int[]{340,1387,2101,847,1660,733,36,528},8);
    }
}
