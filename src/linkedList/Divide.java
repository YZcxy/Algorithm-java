package linkedList;

import util.ListNode;

/**
 * 链表的分化
 */
public class Divide {
    /**
     * 对于一个链表，我们需要用一个特定阈值完成对它的分化，
     * 使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
     * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，
     * 使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
     */
    public ListNode listDivide(ListNode head, int val) {
        ListNode lowNode = null,highNode = null;
        ListNode lowCur = null,highCur = null;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val <= val){
                if (lowNode == null) {
                    lowNode = cur;
                    lowCur = cur;
                }else {
                    lowCur.next = cur;
                    lowCur = lowCur.next;
                }
            }else {
                if (highNode == null) {
                    highNode = cur;
                    highCur = cur;
                }else {
                    highCur.next = cur;
                    highCur = highCur.next;
                }
            }
            ListNode temp = cur;
            cur = temp.next;
            temp.next = null;
        }

        if (lowNode != null && highNode != null) {
            lowCur.next = highNode;
            return lowNode;
        }else if (lowNode == null) {
            return highNode;
        }else {
            return lowNode;
        }
    }
}
