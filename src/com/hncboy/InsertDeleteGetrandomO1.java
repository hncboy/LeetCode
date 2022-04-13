package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/10/17 8:41
 * 380.O(1) 时间插入、删除和获取随机元素
 *
 * 实现RandomizedSet 类：
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 * 示例：
 * 输入
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出
 * [null, true, false, true, 2, true, false, 2]
 * 解释
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 *
 * 提示：
 * -231 <= val <= 231 - 1
 * 最多调用 insert、remove 和 getRandom 函数 2 * 105 次
 * 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。
 * 通过次数 60,666 提交次数 116,500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertDeleteGetrandomO1 {

    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedSet randomSet = new RandomizedSet();
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

    private static class RandomizedSet {

        private final Map<Integer, Integer> dict;
        private final List<Integer> list;
        private final Random rand = new Random();

        public RandomizedSet() {
            dict = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (dict.containsKey(val)) {
                return false;
            }

            int index = list.size();
            dict.put(val, index);
            list.add(index, val);
            return true;
        }

        public boolean remove(int val) {
            if (!dict.containsKey(val)) {
                return false;
            }

            // 获取到最后一个元素的值
            int lastElement = list.get(list.size() - 1);
            // 获取到 val 对应下标
            int index = dict.get(val);
            // 将最后一个元素的下标移动被删除的位置
            list.set(index, lastElement);
            // 修改最后一个元素的对应的下标
            dict.put(lastElement, index);
            // list 列表长度 -1
            list.remove(list.size() - 1);
            // 移除该 val
            dict.remove(val);

            return true;
        }

        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
