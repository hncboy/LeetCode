package com.hncboy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/10/16 18:14
 * @description 297.二叉树的序列化与反序列化
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * 提示：
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        // 序列化和反序列化的结果互相使用
        SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        System.out.println(s.serialize(node));
        System.out.println(s.deserialize(s.serialize(node)));
    }

    private static final String COMMA = ",";
    private static final String NULL = "null";

    public String serialize(TreeNode root) {
        return serialize(root, "");
    }

    private String serialize(TreeNode root, String result) {
        if (root == null) {
            result += NULL + COMMA;
        } else {
            result += root.val + COMMA;
            result = serialize(root.left, result);
            result = serialize(root.right, result);
        }
        return result;
    }

    private TreeNode deserialize(List<String> list) {
        if (list.get(0).equals(NULL)) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    public TreeNode deserialize(String data) {
        String[] array = data.split(COMMA);
        return deserialize(new LinkedList<>(Arrays.asList(array)));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
