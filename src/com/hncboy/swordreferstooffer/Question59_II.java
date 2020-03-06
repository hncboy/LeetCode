package com.hncboy.swordreferstooffer;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author hncboy
 * @date 2020/3/7 0:09
 * @description 面试题 59-II.队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 * 限制：
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 */
public class Question59_II {

    public static void main(String[] args) {
        Question59_II q = new Question59_II();
        q.push_back(1);
        q.push_back(2);
        q.push_back(3);
        System.out.println(q.max_value());
        System.out.println(q.pop_front());
        System.out.println(q.max_value());
    }

    private LinkedList<Integer> data;
    private LinkedList<Integer> helper;

    private Question59_II() {
        data = new LinkedList<>();
        helper = new LinkedList<>(Collections.singleton(Integer.MIN_VALUE));
    }

    private int max_value() {
        if (data.isEmpty()) {
            return -1;
        }
        return helper.peekFirst();
    }

    private void push_back(int value) {
        // 在 queue 尾部插入元素
        data.addLast(value);
        // 当 helper 不为空 && 尾部元素比 value，删除 helper 尾部元素
        // helper 存放最大值
        while (!helper.isEmpty() && helper.peekLast() < value) {
            helper.removeLast();
        }
        // 将 value 加入到 helper 尾部
        helper.addLast(value);
    }

    private int pop_front() {
        if (data.isEmpty()) {
            return -1;
        }
        int front = data.removeFirst();
        if (helper.peekFirst() == front) {
            helper.removeFirst();
        }
        return front;
    }
}
