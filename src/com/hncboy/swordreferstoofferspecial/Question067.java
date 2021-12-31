package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/12/31 10:02
 * 剑指 Offer II 067.最大的异或
 * 
 * 给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 示例 1：
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：nums = [2,4]
 * 输出：6
 *
 * 示例 4：
 * 输入：nums = [8,10,2]
 * 输出：10
 *
 * 示例 5：
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 *
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * 0 <= nums[i] <= 231 - 1
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 * 注意：本题与主站 421 题 {@link com.hncboy.MaximumXorOfTwoNumbersInAnArray}
 * 相同： https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * 通过次数 2,325 提交次数 3,443
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ms70jA
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question067 {

    /**
     * 字典树的根节点
     */
    private final Trie root = new Trie();

    /**
     * 最高位的二进制位编号为 30
     */
    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 1; i < n; ++i) {
            // 将 nums[i-1] 放入字典树，此时 nums[0 .. i-1] 都在字典树中
            add(nums[i - 1]);
            result = Math.max(result, check(nums[i]));
        }
        return result;
    }

    /**
     * 插入字典树
     */
    public void add(int num) {
        Trie curr = root;
        // 从高位开始遍历
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (curr.left == null) {
                    curr.left = new Trie();
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new Trie();
                }
                curr = curr.right;
            }
        }
    }

    /**
     * 检查当前异或的最大值
     */
    public int check(int num) {
        Trie curr = root;
        int result = 0;
        // 从高位开始遍历
        for (int k = HIGH_BIT; k >= 0; k--) {
            // 先将结果乘 2
            result = result * 2;

            // 取当前的二进制位数
            int bit = (num >> k) & 1;

            // 如果当前二进制位是 0
            if (bit == 0) {
                // 此时应该往为 1 的节点走，也就是 right 节点，0^1=1
                if (curr.right != null) {
                    curr = curr.right;
                    result++;
                } else {
                    curr = curr.left;
                }
            } else {
                // 此时应该往为 0 的节点走，也就是 left 节点，0^1=1
                if (curr.left != null) {
                    curr = curr.left;
                    result++;
                } else {
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    private static class Trie {

        /**
         * 左子树指向表示 0 的子节点
         */
        Trie left = null;

        /**
         * 右子树指向表示 1 的子节点
         */
        Trie right = null;
    }
}
