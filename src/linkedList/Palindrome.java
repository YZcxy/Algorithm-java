package linkedList;

import util.ListNode;

import java.util.Stack;

/**
 * 链表回文结构
 */
public class Palindrome {
    /**
     * 请编写一个函数，检查链表是否为回文。
     * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
     */
    public boolean isPalindrome(ListNode pHead) {
        if(pHead == null) return false;

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = pHead;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = pHead;
        while (cur != null) {
            ListNode temp = stack.pop();
            if (temp.val != cur.val) return false;
            cur = cur.next;
        }
        return true;
    }

}
