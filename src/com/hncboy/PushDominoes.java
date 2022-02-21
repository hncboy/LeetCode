package com.hncboy;

/**
 * @author hncboy
 * @date 2022/2/21 9:15
 * 838.推多米诺
 *
 * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 *
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * 返回表示最终状态的字符串。
 *
 * 示例 1：
 * 输入：dominoes = "RR.L"
 * 输出："RR.L"
 *
 * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
 * 示例 2：
 * 输入：dominoes = ".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 *
 * 提示：
 * n == dominoes.length
 * 1 <= n <= 105
 * dominoes[i] 为 'L'、'R' 或 '.'
 * 通过次数 10,836 提交次数 20,407
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/push-dominoes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PushDominoes {

    public String pushDominoes(String dominoes) {
        char[] array = dominoes.toCharArray();
        char left = 'L';
        for (int i = 0; i < array.length; ) {
            int j = i;

            // 找到一段连续的没有被推动的骨牌
            while (j < array.length && array[j] == '.') {
                j++;
            }

            // 获取这段没有被推动骨牌的右边界的一张骨牌
            char right = j < array.length ? array[j] : 'R';

            // 如果左右边界方向相同，那么这些竖立骨牌也会倒向同一方向
            if (left == right) {
                while (i < j) {
                    array[i++] = right;
                }
            } else if (left == 'R' && right == 'L') {
                // 方向相对，那么就从两侧向中间倒
                int k = j - 1;
                while (i < k) {
                    array[i++] = 'R';
                    array[k--] = 'L';
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(array);
    }
}
