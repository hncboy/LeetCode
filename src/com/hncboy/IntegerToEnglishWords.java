package com.hncboy;

/**
 * @author hncboy
 * @date 2021/10/11 8:07
 * @description 273.整数转换英文表示
 * 
 * 将非负整数 num 转换为其对应的英文表示。
 *
 * 示例 1：
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 *
 * 示例 2：
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 *
 * 示例 3：
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * 示例 4：
 * 输入：num = 1234567891
 * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *  
 *
 * 提示：
 * 0 <= num <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-english-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerToEnglishWords {

    public static void main(String[] args) {
        IntegerToEnglishWords i = new IntegerToEnglishWords();
        System.out.println(i.numberToWords(123));
        System.out.println(i.numberToWords(12345));
        System.out.println(i.numberToWords(1234567));
        System.out.println(i.numberToWords(1234567891));
    }

    /**
     * 1-20 之间的数字
     */
    private final String[] UNDER_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    /**
     * 20-100 之间的 10 的倍数
     */
    private final String[] UNDER_100 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    /**
     * LARGE_INTEGER 集合对应的英文单词
     */
    private final String[] LARGE_INTEGER_WORD = {"Hundred", "Thousand", "Million", "Billion"};
    private final int[] LARGE_INTEGER = {100, 1000, 1000 * 1000, 1000 * 1000 * 1000};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        numToEnglish(num, sb);
        sb.deleteCharAt(0);
        return sb.toString();
    }

    /**
     * 将数字转为英文单词
     *
     * @param num 数字
     * @param sb  单词字符串
     */
    private void numToEnglish(int num, StringBuilder sb) {
        // 数字等于 0 直接返回
        if (num == 0) {
            return;
        }

        // 数字小于 20 直接返回 20 以内的单词
        if (num < 20) {
            sb.append(" ").append(UNDER_20[num]);
            return;
        }

        // 数字小于 100 先加上十位的正数，再递归加上个位的数字
        if (num < 100) {
            sb.append(" ").append(UNDER_100[num / 10]);
            numToEnglish(num % 10, sb);
            return;
        }

        // 数字大于等于 100，从最大的位数开始计算
        for (int i = 3; i >= 0; i--) {
            if (num >= LARGE_INTEGER[i]) {
                // 先转换大数前面的数进行添加
                numToEnglish(num / LARGE_INTEGER[i], sb);
                // 再添加大位的英文单词
                sb.append(" ").append(LARGE_INTEGER_WORD[i]);
                // 最后转换大数后面的数进行添加
                numToEnglish(num % LARGE_INTEGER[i], sb);
                break;
            }
        }
    }
}
