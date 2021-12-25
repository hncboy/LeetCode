package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2021/12/25 12:50
 * 1609.奇偶树
 * 
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 *
 * 示例 1：
 * 输入：root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * 输出：true
 * 解释：每一层的节点值分别是：
 * 0 层：[1]
 * 1 层：[10,4]
 * 2 层：[3,7,9]
 * 3 层：[12,8,6,2]
 * 由于 0 层和 2 层上的节点值都是奇数且严格递增，而 1 层和 3 层上的节点值都是偶数且严格递减，因此这是一棵奇偶树。
 *
 * 示例 2：
 * 输入：root = [5,4,2,3,3,7]
 * 输出：false
 * 解释：每一层的节点值分别是：
 * 0 层：[5]
 * 1 层：[4,2]
 * 2 层：[3,3,7]
 * 2 层上的节点值不满足严格递增的条件，所以这不是一棵奇偶树。
 *
 * 示例 3：
 * 输入：root = [5,9,1,3,5,7]
 * 输出：false
 * 解释：1 层上的节点值应为偶数。
 *
 * 示例 4：
 * 输入：root = [1]
 * 输出：true
 *
 * 示例 5：
 * 输入：root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
 * 输出：true
 *  
 * 提示：
 * 树中节点数在范围 [1, 105] 内
 * 1 <= Node.val <= 106
 * 通过次数 14,502 提交次数 25,643
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/even-odd-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EvenOddTree {

    public static void main(String[] args) {
        EvenOddTree e = new EvenOddTree();
    }

    private final Map<Integer, Integer> map = new HashMap<>();

    public boolean isEvenOddTree(TreeNode root) {
        return dfs(root, 0);
    }

    private boolean dfs(TreeNode root, int depth) {
        // 根据深度判断奇偶
        boolean flag = depth % 2 == 0;
        // 初始化上一个节点的值
        int prev = map.getOrDefault(depth, flag ? Integer.MIN_VALUE : Integer.MAX_VALUE);
        // 当前节点的值
        int curr = root.val;

        if (flag && (curr % 2 == 0 || curr <= prev)) {
            return false;
        }
        if (!flag && (curr % 2 != 0 || curr >= prev)) {
            return false;
        }

        // 记录每层上一次遍历到的节点值
        map.put(depth, curr);

        if (root.left != null && !dfs(root.left, depth + 1)) {
            return false;
        }
        if (root.right != null && !dfs(root.right, depth + 1)) {
            return false;
        }

        return true;
    }

    public boolean isEvenOddTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // true 表示当前为偶数层，false 表示当前为奇数层
        boolean flag = true;

        // 层序遍历
        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int size = queue.size();
            int prev = flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            while (size-- > 0) {
                TreeNode node = queue.poll();
                int curr = node.val;

                // 如果当前是偶数层，则所有节点值是奇数，递增顺序
                if (flag && (curr % 2 == 0 || curr <= prev)) {
                    return false;
                }
                // 如果当前是奇数层，则所有节点值是偶数，递减顺序
                if (!flag && (curr % 2 == 1 || curr >= prev)) {
                    return false;
                }
                prev = curr;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            flag = !flag;
        }
        return true;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
