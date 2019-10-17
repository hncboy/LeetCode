package com.hncboy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author hncboy
 * @date 2019/10/17 8:41
 * @description 380.常数时间插入、删除和获取随机元素
 * TODO
 */
public class InsertDeleteGetrandomO1 {

    private List<Integer> result;

    public static void main(String[] args) {
        // 初始化一个空的集合。
        InsertDeleteGetrandomO1 randomSet = new InsertDeleteGetrandomO1();
        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        randomSet.insert(1);
        // 返回 false ，表示集合中不存在 2 。
        randomSet.remove(2);
        // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        randomSet.insert(2);
        // getRandom 应随机返回 1 或 2 。
        randomSet.getRandom();
        // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        randomSet.remove(1);
        // 2 已在集合中，所以返回 false 。
        randomSet.insert(2);
        // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        randomSet.getRandom();
    }

    /**
     * Initialize your data structure here.
     */
    private InsertDeleteGetrandomO1() {
        result = new ArrayList<>();
    }

    /**
     * O(n)
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    private boolean insert(int val) {
        if (result.contains(val)) {
            return false;
        }
        result.add(val);
        return true;
    }

    /**
     * O(n)
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    private boolean remove(int val) {
        if (result.contains(val)) {
            return result.remove((Object)val);
        }
        return false;
    }

    /**
     * O(1)
     * Get a random element from the set.
     */
    private int getRandom() {
        int index = new Random().nextInt(result.size());
        return result.get(index);
    }
}
