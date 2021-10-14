package com.hncboy.swordreferstooffer;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2020/2/16 16:04
 * @description 剑指 Offer 09.用两个栈实现队列
 *
 * 两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class Question09 {

    public static void main(String[] args) {
        CQueue c = new CQueue();
        c.appendTail(3);
        c.deleteHead();
        c.deleteHead();
        c.deleteHead();
    }

    private static class CQueue {

        private final Stack<Integer> stack1;
        private final Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * 添加整数到队列尾部
         */
        public void appendTail(int value) {
            // 往栈1中添加整数
            stack1.push(value);
        }

        /**
         * 删除队列头部的整数
         */
        public int deleteHead() {
            // 如果栈2为空
            if (stack2.empty()) {
                // 遍历栈1，依次弹出整数并放入栈2，此时栈2的弹出顺序就是相当于从队列头部弹出
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }

            // 栈2还是为空的话就返回-1
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}
