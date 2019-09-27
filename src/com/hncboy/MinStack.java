package com.hncboy;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/9/27 9:56
 * @description 155.最小栈
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    /**
     * 将元素 x 推入栈中
     *
     * @param x
     */
    private void push(int x) {
        data.add(x);
        // 两个栈长度一样，helper 用于存放最小元素
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }

    /**
     * 删除栈顶的元素
     */
    private void pop() {
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    private int top() {
        return data.peek();
    }

    /**
     * 检索栈中的最小元素
     *
     * @return
     */
    private int getMin() {
        return helper.peek();
    }
}
