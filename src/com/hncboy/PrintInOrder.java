package com.hncboy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author hncboy
 * @date 2019/9/24 9:54
 * @description 1114.按序打印
 *
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *  
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 *
 * 示例 2:
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 */
public class PrintInOrder {

    public static void main(String[] args) throws InterruptedException {
        Foo1 foo1 = new Foo1();
        foo1.first(new Thread(() -> System.out.println("first")));
        foo1.second(new Thread(() -> System.out.println("second")));
        foo1.third(new Thread(() -> System.out.println("third")));

        Foo2 foo2 = new Foo2();
        foo2.first(new Thread(() -> System.out.println("first")));
        foo2.second(new Thread(() -> System.out.println("second")));
        foo2.third(new Thread(() -> System.out.println("third")));
    }
}

/**
 * CountDownLatch
 */
class Foo1 {

    private CountDownLatch countDownLatch1;
    private CountDownLatch countDownLatch2;

    Foo1() {
        countDownLatch1 = new CountDownLatch(1);
        countDownLatch2 = new CountDownLatch(1);
    }

    void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        countDownLatch1.countDown();
    }

    void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        printSecond.run();
        countDownLatch2.countDown();
    }

    void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();
        printThird.run();
    }
}

/**
 * Semaphore
 */
class Foo2 {

    private Semaphore mutex1 = new Semaphore(0);
    private Semaphore mutex2 = new Semaphore(0);

    Foo2() {
    }

    void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        mutex1.release();
    }

    void second(Runnable printSecond) throws InterruptedException {
        mutex1.acquire();
        printSecond.run();
        mutex2.release();
    }

    void third(Runnable printThird) throws InterruptedException {
        mutex2.acquire();
        printThird.run();
    }
}