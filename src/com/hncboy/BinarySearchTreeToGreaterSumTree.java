package com.hncboy;

/**
 * @author hncboy
 * @date 2021/12/4 15:04
 * @description 1038.把二叉搜索树转换为累加树
 * 
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：该题目与 538 {@link ConvertBstToGreaterTree} : https://leetcode-cn.com/problems/convert-bst-to-greater-tree/  相同
 *
 * 示例 1：
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * 示例 2：
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 *
 * 示例 3：
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 *
 * 示例 4：
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 *  
 * 提示：
 * 树中的节点数介于 1 和 100 之间。
 * 每个节点的值介于 0 和 100 之间。
 * 树中的所有值 互不相同 。
 * 给定的树为二叉搜索树。
 * 通过次数 26,875提交次数 33,835
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinarySearchTreeToGreaterSumTree {

    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    /**
     * 反中序遍历
     */
    private int dfs(TreeNode root, int sum) {
        // sum 为所有比当前节点大的节点的和
        if (root == null) {
            return sum;
        }

        // 先遍历右子树，累加右子树所有节点的值
        root.val += dfs(root.right, sum);

        // 再遍历左子树，将累加后的值给左子树节点
        return dfs(root.left, root.val);
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
