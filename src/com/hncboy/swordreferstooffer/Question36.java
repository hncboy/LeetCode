package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/6 9:39
 * @description 剑指 Offer 36.二叉搜索树与双向链表
 * 
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * 注意：此题对比原题有改动。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question36 {

    private Node head;
    private Node prev;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        // 中序遍历，构建各个节点 left 和 right 的引用
        dfs(root);

        // 构建头节点和尾节点的指向
        prev.right = head;
        head.left = prev;

        return head;
    }

    /**
     * 中序遍历，访问每个节点时构建 curr 和前驱节点 prev 的引用指向
     *
     * @param curr 当前节点
     */
    private void dfs(Node curr) {
        if (curr == null) {
            return;
        }

        // 往左遍历
        dfs(curr.left);

        // 如果 prev 为空，则当前 curr 节点为头节点，将 curr 指向 head
        if (prev == null) {
            head = curr;
        } else {
            // 如果 prev 不为空，则将 prev 节点的 right 位置指向 curr 节点
            prev.right = curr;
        }

        // 不管 prev 是否为空，当前 curr 节点的 left 位置都是 prev 节点
        curr.left = prev;

        // 将当前 curr 节点指向 prev 节点
        prev = curr;

        // 往右遍历
        dfs(curr.right);//全部迭代完成后，pre指向双向链表中的尾节点
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
