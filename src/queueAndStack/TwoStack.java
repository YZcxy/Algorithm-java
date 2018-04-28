package queueAndStack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 双栈队列
 */
public class TwoStack {
    /**
     * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
     * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，
     * 保证操作序列合法且一定含pop操作，请返回pop的结果序列。
     */
    private Stack<Integer> baseStack = new Stack<>();
    private Stack<Integer> assStack = new Stack<>();
    private int index = 0;

    public int[] twoStack(int[] ope, int n) {
        ArrayList<Integer> result = new ArrayList<>(n);
        for (int num : ope) {
            if (num > 0){
                push(num);
            }
            else if (num == 0){
                pop(result);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void push(int num){
        baseStack.push(num);
    }

    private void pop(ArrayList result){
        if (assStack.empty()) {
            transfer();
        }

        result.add(assStack.pop());
    }

    private void transfer(){
        while (!baseStack.empty()){
            assStack.push(baseStack.pop());
        }
    }
}
