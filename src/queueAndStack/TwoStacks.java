package queueAndStack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 双栈排序
 */
public class TwoStacks {
    /**
     * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
     * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
     * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，
     * 请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
     */
    private Stack<Integer> baseStack = new Stack<>();
    private Stack<Integer> assStack = new Stack<>();

    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        for (int i : numbers){
            baseStack.push(i);
        }

        sort();
        ArrayList<Integer> result = new ArrayList<>();
        while (!assStack.empty()) {
            result.add(assStack.pop());
        }
        return result;
    }

    private void sort(){
        while (!baseStack.empty()) {
            int cur = baseStack.pop();
            if (assStack.empty()){
                assStack.push(cur);
                continue;
            }

            while (!assStack.empty() && assStack.peek() > cur) {
                baseStack.push(assStack.pop());
            }
            assStack.push(cur);
        }
    }
}
