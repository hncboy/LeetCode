package com.hncboy;

/**
 * @author hncboy
 * @date 2022/1/3 13:07
 * 390.消除游戏
 * 
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 给你整数 n ，返回 arr 最后剩下的数字。
 *
 * 示例 1：
 * 输入：n = 9
 * 输出：6
 * 解释：
 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * arr = [2, 4, 6, 8]
 * arr = [2, 6]
 * arr = [6]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 *
 * 提示：
 * 1 <= n <= 109
 * 通过次数 26,392 提交次数 43,640
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/elimination-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EliminationGame {

    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        // true 表示从左边开始，false 表示从右边开始
        boolean direction = true;

        while (n > 1) {
            // 从左边开始移除 or（从右边开始移除，数列总数为奇数），将 head 移动到下一个位置
            if (direction || n % 2 == 1) {
                head += step;
            }

            // 步长 * 2
            step *= 2;
            // 总数 / 2
            n /= 2;
            // 取反移除方向
            direction = !direction;
        }

        return head;
    }
}
