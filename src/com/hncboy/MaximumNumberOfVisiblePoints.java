package com.hncboy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hncboy
 * @date 2021/12/16 8:57
 * @description 1610.可见点的最大数目 TODO 没看懂
 */
public class MaximumNumberOfVisiblePoints {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        // 获取当前位置
        int x = location.get(0);
        int y = location.get(1);

        int count = 0;
        double t = angle * Math.PI / 180;
        // 夹角数组
        List<Double> list = new ArrayList<>();
        // 遍历所有点位
        for (List<Integer> point : points) {
            int a = point.get(0);
            int b = point.get(1);
            // 与当前位置重合，则不计算夹角
            if (a == x && b == y) {
                count++;
                continue;
            }
            // 计算夹角
            list.add(Math.atan2(b - y, a - x));
        }

        // 对夹角数组进行排序
        Collections.sort(list);
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            list.add(list.get(i) + 2 * Math.PI);
        }
        for (int i = 0, j = 0; j < 2 * list.size(); j++) {
            while (i < j && list.get(j) - list.get(i) > t) {
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return count + max;
    }
}
