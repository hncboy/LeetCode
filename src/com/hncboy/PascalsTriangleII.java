package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/15 9:21
 * @description 119.杨辉三角 II
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class PascalsTriangleII {

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(3));
    }

    private List<Integer> getRow(int rowIndex) {
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                currentRow.set(j, currentRow.get(j - 1) + currentRow.get(j));
            }
            currentRow.add(1);
        }
        return currentRow;
    }
}
