package linkedList;

import util.ListNode;

/**
 * 链表指定值清除
 */
public class ClearValue {
    /**
     * 现在有一个单链表。链表中每个节点保存一个整数，
     * 再给定一个值val，把所有等于val的节点删掉。
     * 给定一个单链表的头结点head，同时给定一个值val，
     * 请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。
     * 请保证其他元素的相对顺序。
     */
    public ListNode clear(ListNode head, int val) {
        ListNode cur = head;
        ListNode last = null;
        while (cur != null) {
            if (cur.val == val) {
                if (cur == head) {
                    head = cur.next;
                    cur = head;
                    continue;
                }else {
                    last.next = cur.next;
                    cur = last.next;
                    continue;
                }
            }else {
                last = cur;
                cur = cur.next;
            }
        }
        return head;
    }

}
