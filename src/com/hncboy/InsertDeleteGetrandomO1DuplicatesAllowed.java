package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/12/20 11:15
 * @description 381.O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 */
public class InsertDeleteGetrandomO1DuplicatesAllowed {

    /**
     * 存储所有元素
     */
    private List<Integer> list;

    /**
     * 存储元素对应的下标集合
     */
    private Map<Integer, Set<Integer>> map;

    /**
     * 集合的长度
     */
    private int size;

    public static void main(String[] args) {
        InsertDeleteGetrandomO1DuplicatesAllowed collection = new InsertDeleteGetrandomO1DuplicatesAllowed();

        // 向集合中插入 1 。返回 true 表示集合不包含 1 。
        System.out.println(collection.insert(1));

        // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
        System.out.println(collection.insert(1));

        // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
        System.out.println(collection.insert(2));

        // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
        System.out.println(collection.getRandom());

        // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
        System.out.println(collection.remove(1));

        // getRandom 应有相同概率返回 1 和 2 。
        System.out.println(collection.getRandom());
    }

    private InsertDeleteGetrandomO1DuplicatesAllowed() {
        list = new ArrayList<>();
        map = new HashMap<>();
        size = 0;
    }

    private boolean insert(int val) {
        list.add(val);

        if (map.containsKey(val)) {
            map.get(val).add(size);
            size++;
            return false;
        }

        map.put(val, new HashSet<>(Collections.singletonList(size)));
        size++;
        return true;
    }

    private boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        size--;

        // 如果最后一个是要删除的元素，直接删除
        if (list.get(size) == val) {
            list.remove(size);
            Set<Integer> indexs = map.get(val);
            indexs.remove(size);
            if (indexs.size() == 0) {
                map.remove(val);
            }
            return true;
        }

        // 删除对应的下标
        Set<Integer> indexs = map.get(val);
        Iterator<Integer> it = indexs.iterator();
        int index = it.next();
        indexs.remove(index);
        if (indexs.size() == 0) {
            map.remove(val);
        }

        // 将最后一个元素覆盖要删除的元素
        int num = list.get(size);
        list.set(index, num);
        // 删除最后一个元素
        list.remove(size);
        // 在 map 中更换最后一个元素的下标
        indexs = map.get(num);
        indexs.remove(size);
        indexs.add(index);
        map.put(num, indexs);
        return true;
    }

    private int getRandom() {
        return list.get(new Random().nextInt(size));
    }
}
