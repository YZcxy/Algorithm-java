package linkedList;

import util.RandomListNode;

import java.util.Hashtable;

/**
 * 复杂链表的复制节点
 */
public class Solution {
    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
     * 另一个特殊指针指向任意一个节点）。
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        Hashtable<RandomListNode, RandomListNode> map = new Hashtable<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode cur = dummy;
        RandomListNode node; // save the new node
        while (pHead != null) {
            // add current node
            if (!map.containsKey(pHead)) {
                node = new RandomListNode(pHead.label);
                map.put(pHead, node);
            } else {
                node = map.get(pHead);
            }
            cur.next = node;
            // add random node
            if (pHead.random != null) {
                if (!map.containsKey(pHead.random)) {
                    node.random = new RandomListNode(pHead.random.label);
                    map.put(pHead.random, node.random);
                } else {
                    node.random = map.get(pHead.random);
                }
            }
            pHead = pHead.next;
            cur = cur.next;
        }
        return dummy.next;

    }
}
