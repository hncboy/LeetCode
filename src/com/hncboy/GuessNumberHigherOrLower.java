package com.hncboy;

/**
 * @author hncboy
 * @date 2020/1/2 19:24
 * @description 374.猜数字大小
 *
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 *
 * 示例 :
 * 输入: n = 10, pick = 6
 * 输出: 6
 */
public class GuessNumberHigherOrLower extends GuessGame {

    public static void main(String[] args) {
        GuessNumberHigherOrLower g = new GuessNumberHigherOrLower();
        System.out.println(g.guessNumber2(10));
    }

    /**
     * 三分查找
     *
     * @param n
     * @return
     */
    private int guessNumber2(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);

            if (res1 == 0) {
                return mid1;
            }
            if (res2 == 0) {
                return mid2;
            }

            if (res1 < 0) {
                // [1, mid1]
                high = mid1 - 1;
            } else if (res2 > 0) {
                // [mid2, n]
                low = mid2 + 1;
            } else {
                // [mid1, mid2]
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     *
     * @param n
     * @return
     */
    private int guessNumber1(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            }
            if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

class GuessGame {

    int guess(int num) {
        return -Integer.compare(num, 6);
    }
}
