package com.hncboy.multithread;

/**
 * @author hncboy
 * @date 2021/10/1 13:40
 * @description 1116.打印零与奇偶数
 *
 * 假设有这么一个类：
 *
 * class ZeroEvenOdd {
 *  public ZeroEvenOdd(int n) { ... }     // 构造函数
 *   public void zero(printNumber) { ... }  // 仅打印出 0
 *   public void even(printNumber) { ... }  // 仅打印出 偶数
 *   public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个ZeroEvenOdd类实例将会传递给三个不同的线程：
 * 线程 A 将调用zero()，它只输出 0 。
 * 线程 B 将调用even()，它只输出偶数。
 * 线程 C 将调用odd()，它只输出奇数。
 * 每个线程都有一个printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列010203040506... ，其中序列的长度必须为 2n。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 
 * 示例 2：
 * 输入：n = 5
 * 输出："0102030405"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-zero-even-odd
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrintZeroEvenOdd {

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer intConsumer = System.out::print;

        new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ZeroEvenOdd {
    private int count = 1;
    private int n;
    private volatile boolean run = true;
    private volatile String currentExecuteStatus = "zero";

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (run) {
            if (currentExecuteStatus.equals("zero")) {
                printNumber.accept(0);
                if (count % 2 == 0) {
                    currentExecuteStatus = "even";
                } else {
                    currentExecuteStatus = "odd";
                }
            }
            Thread.yield();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (run) {
            if (currentExecuteStatus.equals("even")) {
                printNumber.accept(count++);
                if (count > n) {
                    run = false;
                    break;
                }
                currentExecuteStatus = "zero";
            }
            Thread.yield();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (run) {
            if (currentExecuteStatus.equals("odd")) {
                printNumber.accept(count++);
                if (count > n) {
                    run = false;
                    break;
                }
                currentExecuteStatus = "zero";
            }
            Thread.yield();
        }
    }
}

interface IntConsumer {

    void accept(int num);
}
