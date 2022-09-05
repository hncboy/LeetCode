package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2022/9/5 09:25
 * 652.寻找重复的子树
 *
 * 给定一棵二叉树 root，返回所有重复的子树。
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 *
 * 示例 2：
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 *
 * 提示：
 * 树中的结点数在[1,10^4]范围内。
 * -200 <= Node.val <= 200
 * 通过次数 63,547 提交次数 106,979
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDuplicateSubtrees {

    private final Map<String, Integer> map = new HashMap<>();
    private final List<TreeNode> result = new LinkedList<>();

    private StringBuilder dfs(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb;
        }

        sb.append(root.val).append('/').append(dfs(root.left)).append('/').append(dfs(root.right));
        String s = sb.toString();
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
            if (map.get(s) == 2) {
                result.add(root);
            }
        } else {
            map.put(s, 1);
        }
        return sb;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
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
