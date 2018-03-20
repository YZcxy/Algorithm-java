package binarytree;

import util.*;

import java.util.LinkedList;


/**
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，
 * 所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。
 * 保证结点数小于等于500。
 */
public class TreePrinter {

    /**
     * 分析：层序遍历树节点，难点在于要区分出来每一层
     * 简单做法是用两个队列，交替打印每一列。
     * 如果要降低空间复杂度，只用一个队列，就需要用两个指针标识一下行尾节点：
     * last指针指向每一行的最后一个节点（最开始指向根节点），nlast指向每一个最新进入队列的节点，
     * 当遍历到last指针所指的对象时，说明到了行尾，需要换行，此时nlast正好是下一行的行尾，让last=nlast即可。
     */
    public int[][] printTree(TreeNode root) {
        int[][] result = new int[100][100];
        if (root == null) return result;
        int row = 0;
        int col = 0;
        TreeNode last = root;
        TreeNode nlast = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            if (cur.left != null) {
                queue.offer(cur.left);
                nlast = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nlast = cur.right;
            }

            result[row][col++] = cur.val;
            if(cur == last) {
                last = nlast;
                row++;
                col = 0;
            }
            queue.poll();
        }
        return result;
    }
    
}