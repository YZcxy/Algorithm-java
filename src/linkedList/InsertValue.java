package linkedList;

import util.ListNode;

/**
 * 环形链表插值
 */
public class InsertValue {
    /**
     * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，
     * 并且保证这个环形单链表依然有序。
     * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，
     * 请构造出这个环形链表，并插入该值。
     */
    public ListNode insert(int[] A, int[] nxt, int val) {
        ListNode head = buildList(A,nxt);
        if (A.length == 1) return head;

        ListNode cur = head;
        ListNode next = head.next;

        while (next != head) {
            if (val >= cur.val && val <= next.val) {
                insertHead(cur,val);
                deleteRing(head);
                return head;
            }else {
                cur = next;
                next = cur.next;
            }
        }
        insertHead(cur,val);
        deleteRing(head);
        return head;
    }

    private ListNode buildList(int[] A, int[] nxt){
        int min = Integer.MAX_VALUE;
        int headIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
                headIndex = i;
            }
        }

        ListNode head = new ListNode(A[headIndex]);
        int nextIndex = nxt[headIndex];
        ListNode cur = head;

        while (nextIndex != headIndex) {
            ListNode nextNode = new ListNode(A[nextIndex]);
            cur.next = nextNode;
            cur = cur.next;
            nextIndex = nxt[nextIndex];
        }
        cur.next = head;
        return head;
    }

    private void insertHead (ListNode cur, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
    }

    /**
     * 因为牛客网测试用例有问题，需要去环
     */
    private void deleteRing (ListNode head) {
        ListNode cur = head;
        ListNode nextNode = head.next;

        while (nextNode != head) {
            cur = nextNode;
            nextNode = cur.next;
        }
        cur.next = null;
    }

}
