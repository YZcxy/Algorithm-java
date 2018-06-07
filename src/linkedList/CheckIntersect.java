package linkedList;

import util.ListNode;

/**
 * 无环单链表判断相交
 */
public class CheckIntersect {
    /**
     * 现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，
     * 额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
     * 给定两个链表的头结点headA和headB，请返回一个bool值，
     * 代表这两个链表是否相交。保证两个链表长度小于等于500。
     */
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode lastA = headA;
        ListNode lastB = headB;

        while (curA != null) {
            lastA = curA;
            curA = curA.next;
        }
        while (curB != null) {
            lastB = curB;
            curB = curB.next;
        }

        return lastA == lastB;
    }
}
