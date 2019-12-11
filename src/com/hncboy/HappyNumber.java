package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/11 18:54
 * @description 202.快乐数
 */
public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappy(19));
    }

    public boolean isHappy(int n) {
        // 快慢指针，慢指针走1步，快指针走2步，当两个指针相遇时，判断是否是由1引起的
        int slow = n;
        int fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    private int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
