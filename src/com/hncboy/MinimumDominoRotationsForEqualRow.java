package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/17 10:36
 * @description 1007.行相等的最少多米诺旋转
 *
 * 在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。
 * （一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
 * 我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。
 * 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。
 * 如果无法做到，返回 -1.
 *
 * 示例 1：
 * 输入：A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * 输出：2
 * 解释：
 * 图一表示：在我们旋转之前， A 和 B 给出的多米诺牌。
 * 如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
 *
 * 示例 2：
 * 输入：A = [3,5,1,2,3], B = [3,6,3,3,4]
 * 输出：-1
 * 解释：
 * 在这种情况下，不可能旋转多米诺牌使一行的值相等。
 *
 * 提示：
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 */
public class MinimumDominoRotationsForEqualRow {

    public static void main(String[] args) {
        MinimumDominoRotationsForEqualRow m = new MinimumDominoRotationsForEqualRow();
        int[] A1 = {2, 1, 2, 4, 2, 2};
        int[] B1 = {5, 2, 6, 2, 3, 2};
        int[] A2 = {3, 5, 1, 2, 3};
        int[] B2 = {3, 6, 3, 3, 4};
        System.out.println(m.minDominoRotations(A1, B1));
        System.out.println(m.minDominoRotations(A2, B2));
    }

    private int minDominoRotations(int[] A, int[] B) {
        // 要形成相等的多米诺骨牌，那么任意一列骨牌的上半部分或下半部分中某个数字一定是符合条件
        // 即该数字在每一列都出现过

        // 检查 A 中的第一个数字是否满足
        int rotations = check(A[0], A, B);
        // 如果 A 中第一个数字不匹配且 A 和 B 中第一个数字相等，则直接返回
        if (rotations != -1 || A[0] == B[0]) {
            return rotations;
        }
        return check(B[0], A, B);
    }

    private int check(int x, int[] A, int[] B) {
        // A 需要旋转的次数
        int rotationsA = 0;
        // B 需要旋转的次数
        int rotationsB = 0;
        for (int i = 0; i < A.length; i++) {
            // 至少有一个数等于 x
            if (A[i] != x && B[i] != x) {
                return -1;
            }
            if (A[i] != x) {
                rotationsA++;
            }
            if (B[i] != x) {
                rotationsB++;
            }
        }
        return Math.min(rotationsA, rotationsB);
    }
}
