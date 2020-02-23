package com.hncboy.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hncboy
 * @date 2019/9/24 9:54
 * @description 1114.按序打印
 *
 * 我们提供了一个类：
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
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

    public static void main(String[] args) {
        Foo1 foo = new Foo1();

        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.println(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.println(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.println(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }

    /**
     * CountDownLatch
     */
    private static class Foo1 {

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
    private static class Foo2 {

        private Semaphore mutex1;
        private Semaphore mutex2;

        Foo2() {
            mutex1 = new Semaphore(0);
            mutex2 = new Semaphore(0);
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

    /**
     * Atomic 原子类
     */
    private static class Foo3 {

        private AtomicInteger atomicInteger;

        Foo3() {
            atomicInteger = new AtomicInteger(0);
        }

        void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            atomicInteger.incrementAndGet();
        }

        void second(Runnable printSecond) throws InterruptedException {
            while (atomicInteger.get() != 1) {
            }
            printSecond.run();
            atomicInteger.incrementAndGet();
        }

        void third(Runnable printThird) throws InterruptedException {
            while (atomicInteger.get() != 2) {
            }
            printThird.run();
        }
    }

    /**
     * wait/notify
     */
    private static class Foo4 {

        private boolean firstFinished;
        private boolean secondFinished;
        private Object lock = new Object();

        Foo4() {
        }

        void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                printFirst.run();
                firstFinished = true;
                lock.notifyAll();
            }
        }

        void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (!firstFinished) {
                    lock.wait();
                }
                printSecond.run();
                secondFinished = true;
                lock.notifyAll();
            }
        }

        void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (!secondFinished) {
                    lock.wait();
                }
                printThird.run();
            }
        }
    }

    /**
     * volatile
     */
    private static class Foo5 {

        private volatile int flag = 0;

        Foo5() {
        }

        void first(Runnable printFirst) throws InterruptedException {
            while (flag != 0) {}
            printFirst.run();
            flag = 1;
        }

        void second(Runnable printSecond) throws InterruptedException {
            while (flag != 1) {}
            printSecond.run();
            flag = 2;
        }

        void third(Runnable printThird) throws InterruptedException {
            while (flag != 2) {}
            printThird.run();
        }
    }
}