package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/18 22:01
 * @description 1160.拼写单词
 *
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 * 示例 1：
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 *
 * 示例 2：
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 * 提示：
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 */
public class FindWordsThatCanBeFormedByCharacters {

    public static void main(String[] args) {
        FindWordsThatCanBeFormedByCharacters f = new FindWordsThatCanBeFormedByCharacters();
        String[] words1 = {"cat", "bt", "hat", "tree"};
        String[] words2 = {"hello", "world", "leetcode"};
        System.out.println(f.countCharacters(words1, "atach"));
        System.out.println(f.countCharacters(words2, "welldonehoneyr"));
    }

    private int countCharacters(String[] words, String chars) {
        // 统计 chars 中各个字母出现的次数
        int[] table = new int[26];
        for (char ch : chars.toCharArray()) {
            table[ch - 'a']++;
        }

        int count = 0;
        for (String word : words) {
            if (canSpellWords(word, table)) {
                count += word.length();
            }
        }
        return count;
    }

    private boolean canSpellWords(String word, int[] table) {
        int[] temp = new int[26];
        for (char ch : word.toCharArray()) {
            // 当该字母的数量已经和字母表相等时，返回false
            if (temp[ch - 'a'] == table[ch - 'a']) {
                return false;
            }
            temp[ch - 'a']++;
        }
        return true;
    }
}
