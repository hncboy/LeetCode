package com.hncboy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hncboy
 * @date 2019/12/17 9:00
 * @description 225.用队列实现栈
 *
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 注意:
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
public class ImplementStackUsingQueues {

    private Deque<Integer> deque;

    public static void main(String[] args) {
        ImplementStackUsingQueues i = new ImplementStackUsingQueues();
        i.push(1);
        i.push(2);
        System.out.println(i.top());
        System.out.println(i.pop());
        System.out.println(i.empty());
    }

    public ImplementStackUsingQueues() {
        deque = new LinkedList<>();
    }

    public void push(int x) {
        deque.push(x);
    }

    public int pop() {
        return deque.pop();
    }

    public int top() {
        return deque.peek();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}
