package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/15 9:01
 * @description 118.杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(5));
    }

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        // 遍历所需的行数
        for (int i = 0; i < numRows; i++) {
            List<Integer> sub = new ArrayList<>();
            // 计算每行中的每个数字
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    sub.add(1);
                } else {
                    List<Integer> beforeRow = result.get(i - 1);
                    sub.add(beforeRow.get(j - 1) + beforeRow.get(j));
                }
            }
            result.add(sub);
        }
        return result;
    }
}
