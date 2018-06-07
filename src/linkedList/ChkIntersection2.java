package linkedList;

import util.ListNode;

/**
 * 单链表相交2
 */
public class ChkIntersection2 {
    /**
     * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？
     * 相交的话返回true，不想交的话返回false。
     * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,
     * 与本题求解无关)。请返回一个bool值代表它们是否相交。
     */
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        ListNode loop1 = chkLoop(head1);
        ListNode loop2 = chkLoop(head2);

        //两个单链表
        if (loop1 == null && loop2 == null) {
            ListNode curA = head1;
            ListNode curB = head2;
            ListNode lastA = head1;
            ListNode lastB = head2;

            while (curA != null) {
                lastA = curA;
                curA = curA.next;
            }
            while (curB != null) {
                lastB = curB;
                curB = curB.next;
            }

            return lastA == lastB;

        }else { //至少一个有环
            if (loop1 == loop2) return true;

            ListNode cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) return true;
                cur1 = cur1.next;
            }
            return false;
        }
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
