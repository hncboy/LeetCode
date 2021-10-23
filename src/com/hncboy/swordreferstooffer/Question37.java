package com.hncboy.swordreferstooffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hncboy
 * @date 2021/10/23 10:43
 * @description 剑指 Offer 37.序列化二叉树
 * 
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 示例：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * 注意：本题与主站 297 题 {@link com.hncboy.SerializeAndDeserializeBinaryTree}
 * 相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question37 {

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
