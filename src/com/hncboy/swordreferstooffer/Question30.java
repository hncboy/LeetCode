package com.hncboy.swordreferstooffer;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2020/3/15 17:05
 * @description 面试题 30.包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 */
public class Question30 {

    private Stack<Integer> stack;
    private int min;

    private Question30() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    private void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    private void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    private int top() {
        return stack.peek();
    }

    private int min() {
        return min;
    }
}
