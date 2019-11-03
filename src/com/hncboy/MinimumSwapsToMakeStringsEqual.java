package com.hncboy;

/**count-number-of-nice-subarrays
 * @author hncboy
 * @date 2019/11/3 10:30
 * @description 5247.交换字符使得字符串相同
 */
public class MinimumSwapsToMakeStringsEqual {

    public static void main(String[] args) {
        MinimumSwapsToMakeStringsEqual m = new MinimumSwapsToMakeStringsEqual();
        System.out.println(m.minimumSwap("xx", "yy"));
        System.out.println(m.minimumSwap("xy", "yx"));
        System.out.println(m.minimumSwap("xx", "xy"));
        System.out.println(m.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }

    private int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (ch1 == 'x' && ch2 == 'y') {
                xy++;
            } else if (ch1 == 'y' && ch2 == 'x') {
                yx++;
            }
        }
        if (Math.abs(xy - yx) % 2 != 0) {
            return -1;
        }
        if (xy % 2 == 0 && yx % 2 == 0) {
            return xy / 2 + yx / 2;
        }
        return xy / 2 + yx / 2 + 2;
    }
}
