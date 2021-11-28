package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2021/11/28 12:23
 * @description 919.完全二叉树插入器
 * 
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 *
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 *
 * 示例 1：
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 *
 * 示例 2：
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 *  
 * 提示：
 * 最初给定的树是完全二叉树，且包含 1 到 1000 个节点。
 * 每个测试用例最多调用 CBTInserter.insert  操作 10000 次。
 * 给定节点或插入节点的每个值都在 0 到 5000 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/complete-binary-tree-inserter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CompleteBinaryTreeInserter {

    public static void main(String[] args) {
        CompleteBinaryTreeInserter c = new CompleteBinaryTreeInserter();
    }

    private static class CBTInserter {

        private final List<TreeNode> list = new ArrayList<>();

        public CBTInserter(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            // 将所有节点插入双端队列
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        public int insert(int val) {
            TreeNode node = new TreeNode(val);
            list.add(node);
            // 获取不完全填充的父节点
            int parent = list.size() / 2 - 1;
            if (list.size() % 2 == 0) {
                list.get(parent).left = node;
            } else {
                list.get(parent).right = node;
            }
            return list.get(parent).val;
        }

        public TreeNode get_root() {
            return list.isEmpty() ? null : list.get(0);
        }
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
