package linkedList;

import util.ListNode;

/**
 * 有环单链表相交
 */
public class ChkIntersection {
    /**
     * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。
     * 如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
     * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,
     * 与本题求解无关)。请返回一个bool值代表它们是否相交。
     */
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        ListNode loop1 = chkLoop(head1);
        ListNode loop2 = chkLoop(head2);

        if (loop1 == loop2) return true;

        ListNode cur1 = loop1.next;
        while (cur1 != loop1) {
            if (cur1 == loop2) return true;
            cur1 = cur1.next;
        }
        return false;
    }

    private ListNode chkLoop(ListNode head) {
        if (head.next == null) return null;

        ListNode fastCur = head.next.next;
        ListNode slowCur = head.next;

        while (fastCur != null && fastCur != slowCur) {
            if (fastCur.next == null) return null;
            fastCur = fastCur.next.next;
            slowCur = slowCur.next;
        }

        if (fastCur == null) return null;

        fastCur = head;
        while (fastCur != slowCur) {
            fastCur = fastCur.next;
            slowCur = slowCur.next;
        }

        return fastCur;
    }
}
