package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/10/29 9:38
 * @description 剑指 Offer II 034.外星语言是否排序
 * 
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 * 示例 1：
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 *
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 *
 * 示例 3：
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *  
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
 *
 * 注意：本题与主站 953 题相同： https://leetcode-cn.com/problems/verifying-an-alien-dictionary/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lwyVBB
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question034 {

    public boolean isAlienSorted(String[] words, String order) {
        // 将字母顺序存入数组
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        // 遍历所有单词
        for (int i = 0; i < words.length - 1; ++i) {
            // 获取相邻的两个单词
            String word1 = words[i];
            String word2 = words[i + 1];

            // 判断是否要继续比较
            boolean continueCompare = true;

            // 遍历这两个单词的字母进行比较
            for (int j = 0; j < Math.min(word1.length(), word2.length()) && continueCompare; j++) {
                // 如果两个字母相等，比较下一个字母
                if (word1.charAt(j) == word2.charAt(j)) {
                    continue;
                }
                // 如果前面单词字母的顺序大于后面单词的字母顺序，则验证失败
                if (index[word1.charAt(j) - 'a'] > index[word2.charAt(j) - 'a']) {
                    return false;
                }
                // 已经比较出高下了
                continueCompare = false;
            }

            // 如果两个单词前缀相等，但是前一个单词的长度更长，则验证失败
            if (continueCompare && word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }
}
