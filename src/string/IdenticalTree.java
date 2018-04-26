package string;

import util.TreeNode;

/**
 * 相同子树练习
 */
public class IdenticalTree {

    /**
     * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
     * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
     */
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        // write code here
        StringBuffer sbA = new StringBuffer();
        StringBuffer sbB = new StringBuffer();

        serializeTree(A,sbA);
        serializeTree(B,sbB);

        String strA = sbA.toString();
        String strB = sbB.toString();

        return sbA.indexOf(strB)!=-1;
    }

    private void serializeTree(TreeNode cur,StringBuffer sb) {
        if (cur == null) {
            sb.append('#');
            return;
        }
        sb.append(cur.val);

        serializeTree(cur.left,sb);
        serializeTree(cur.right,sb);

    }

}
