package com.hncboy.swordreferstooffer;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2020/3/15 17:05
 * @description 剑指 Offer 30.包含min函数的栈
 * {@link com.hncboy.MinStack}
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
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
 *  
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question30 {

    private static class MinStack {

        private final Stack<Integer> stack;
        private int min;

        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            // 如果当前元素比最小值小，则先加入最小值，后面再加入当前元素
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            // 加入当前元素
            stack.push(x);
        }

        public void pop() {
            // 如果弹出的是最小值，则最小值需要取再弹出一次的结果
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min;
        }
    }
}
