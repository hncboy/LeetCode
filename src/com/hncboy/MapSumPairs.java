package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2021/11/14 12:02
 * @description 677.键值映射
 * 
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 * 示例：
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);  
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);    
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 * 提示：
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MapSumPairs {

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap") == 3);
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap") == 5);
    }

    private static class MapSum {

        private final TrieNode root;
        private final Map<String, Integer> map;

        public MapSum() {
            root = new TrieNode();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            // 当前 key 的值与旧 key 的值的差
            int delta = val - map.getOrDefault(key, 0);
            // 更新对应 key 的值
            map.put(key, val);
            TrieNode node = root;
            // 遍历 key 的每个字符，构建 Trie 前缀树
            for (char ch : key.toCharArray()) {
                // 如果当前字母不存在，则创建对应节点存储该字母
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new TrieNode();
                }
                // 节点往后移动
                node = node.next[ch - 'a'];
                // 更新当前节点的对应的值
                node.val += delta;
            }
        }

        public int sum(String prefix) {
            TrieNode node = root;
            // 遍历前缀的各个字母
            for (char ch : prefix.toCharArray()) {
                // 如果遇到 null，则表示不存在该前缀
                if (node.next[ch - 'a'] == null) {
                    return 0;
                }
                // 往后移动
                node = node.next[ch - 'a'];
            }
            // 返回该前缀对应的值
            return node.val;
        }

        private static class TrieNode {
            int val = 0;
            TrieNode[] next = new TrieNode[26];
        }
    }
}
