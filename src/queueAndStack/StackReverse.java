package queueAndStack;

import java.util.Stack;

/**
 * 栈的反转
 */
public class StackReverse {
    /**
     * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，
     * 而不能自己申请另外的数据结构。
     * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
     */
    Stack<Integer> stack = new Stack<>();
    int index = 0;
    int[] result = null;

    public int[] reverseStack(int[] A, int n) {
        for (int a : A) {
            stack.push(a);
        }
        result = new int[n];
        reverse();
        return result;
    }

    private int getBottom(){
        if (stack.empty()) return Integer.MIN_VALUE;

        int cur = stack.pop();
        int res = getBottom();
        if (res != Integer.MIN_VALUE) {
            stack.push(cur);
            return res;
        }else {
            return cur;
        }
    }

    private void reverse(){
        if (stack.empty()) return;

        int cur = getBottom();
        reverse();
        stack.push(cur);
        result[index++] = cur;
    }

}
