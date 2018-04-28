package queueAndStack;

import java.util.Stack;

/**
 * 可查询最值的栈
 */
public class Solution {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
     */
    Stack<Integer> baseStack = new Stack<>();
    Stack<Integer> assStack = new Stack<>();

    public void push(int node) {
        baseStack.push(node);
        if (assStack.empty()) {
            assStack.push(node);
        } else {
            if (node <= assStack.peek()) {
                assStack.push(node);
            }
        }

    }

    public void pop() {
        int val = baseStack.pop();
        if (val == assStack.peek()) {
            assStack.pop();
        }
    }

    public int top() {
        return baseStack.peek();
    }

    public int min() {
        return assStack.peek();
    }

}
