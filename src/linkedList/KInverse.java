package linkedList;

import util.ListNode;

import java.util.Stack;

/**
 * 链表k逆序
 */
public class KInverse {
    /**
     * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，
     * 如果最后不够K个节点一组，则不调整最后几个节点。
     * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。
     * 调整后为，3->2->1->6->5->4->7->8->null。因为K==3，
     * 所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
     */
    public ListNode inverse(ListNode head, int k) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode resultHead = null;
        ListNode lastEnd = null;
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            if (stack.size() == k) {
                if(lastEnd != null) lastEnd.next = cur;
                if(resultHead == null) resultHead = cur;
                cur = cur.next;
                lastEnd = exchangeStack(stack);
            }else {
                cur = cur.next;
            }

        }
        ListNode endNode = null;
        while (!stack.empty()){
            endNode = stack.pop();
        }
        lastEnd.next = endNode;
        return resultHead;
    }

    private ListNode exchangeStack(Stack<ListNode> stack){
        while (stack != null && !stack.empty()) {
            ListNode temp = stack.pop();
            if (!stack.empty()) {
                temp.next = stack.peek();
            }else {
                return temp;
            }
        }
        return null;
    }


}
