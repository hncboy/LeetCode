package com.hncboy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author hncboy
 * @date 2019/11/26 10:55
 * @description 406.根据身高重建队列
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，
 * k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight {

    public static void main(String[] args) {
        QueueReconstructionByHeight q = new QueueReconstructionByHeight();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(q.reconstructQueue(people)));
    }

    private int[][] reconstructQueue(int[][] people) {
        // 排序：[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 一个个插入
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        // 按身高降序，身高一样的按数量升序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        LinkedList<int[]> list = new LinkedList<>();
        // 将矮个子按数量插入到对应的位置，因为前面都比当前的身高高，插到前面满足要求
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(people);
    }
}
