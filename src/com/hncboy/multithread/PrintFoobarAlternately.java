package com.hncboy.multithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hncboy
 * @date 2020/2/23 18:03
 * @description 1115.交替打印FooBar
 *
 * 我们提供一个类：
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * 示例 1:
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 *
 * 示例 2:
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 */
public class PrintFoobarAlternately {

    public static void main(String[] args) {
        FooBar3 fooBar = new FooBar3(2);
        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    /**
     * wait/notify
     */
    private static class FooBar1 {

        private Object object = new Object();
        private volatile boolean flag;

        private int n;

        public FooBar1(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            synchronized (object) {
                for (int i = 0; i < n; i++) {
                    if (flag) {
                        object.wait();
                    }
                    flag = true;
                    printFoo.run();
                    object.notify();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            synchronized (object) {
                for (int i = 0; i < n; i++) {
                    if (!flag) {
                        object.wait();
                    }
                    flag = false;
                    printBar.run();
                    object.notify();
                }
            }
        }
    }

    /**
     * Semaphore
     */
    private static class FooBar2 {

        private Semaphore foo = new Semaphore(1);
        private Semaphore bar = new Semaphore(0);
        private int n;

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                foo.acquire();
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                bar.acquire();
                printBar.run();
                foo.release();
            }
        }
    }

    /**
     * Lock
     * 测试超出时间限制
     */
    private static class FooBar3 {

        private Lock lock = new ReentrantLock(true);
        private boolean flag;
        private int n;

        public FooBar3(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; ) {
                try {
                    lock.lock();
                    if (!flag) {
                        printFoo.run();
                        i++;
                        flag = true;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; ) {
                lock.lock();
                try {
                    if (flag) {
                        printBar.run();
                        i++;
                        flag = false;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    /**
     * Lock+Condition
     * 单纯使用 Lock 自旋可能会超时，加上 Condition，减少占用 CPU 资源
     */
    private static class FooBar4 {

        private ReentrantLock lock = new ReentrantLock();
        private Condition fooCondition = lock.newCondition();
        private Condition barCondition = lock.newCondition();
        private boolean fooRun = true;
        private int n;

        public FooBar4(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            try {
                lock.lock();
                for (int i = 0; i < n; i++) {
                    if (!fooRun) {
                        fooCondition.await();
                        barCondition.signal();
                    }
                    printFoo.run();
                    fooRun = false;
                    barCondition.signal();
                }
            } finally {
                lock.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            try {
                lock.lock();
                for (int i = 0; i < n; i++) {
                    if (fooRun) {
                        barCondition.await();
                        fooCondition.signal();
                    }
                    printBar.run();
                    fooRun = true;
                    fooCondition.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * CyclicBarrier
     * 与 FooBar3 类似，存在自旋消耗 CPU，可能会超时，不过测试没有超时。
     */
    private static class FooBar5 {

        private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        private volatile boolean fooRun = true;
        private int n;

        public FooBar5(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!fooRun) {
                }
                printFoo.run();
                fooRun = false;
                try {
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                try {
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                printBar.run();
                fooRun = true;
            }
        }
    }

    /**
     * CountDownLatch+CyclicBarrier
     * 在 FooBar5 的基础上增加了 latch.await() 阻塞
     */
    private static class FooBar6 {

        private int n;
        private CountDownLatch latch = new CountDownLatch(1);
        private CyclicBarrier barrier = new CyclicBarrier(2);

        public FooBar6(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                printFoo.run();
                latch.countDown();
                try {
                    barrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                latch.await();
                printBar.run();
                latch = new CountDownLatch(1);
                try {
                    barrier.await();
                    barrier.reset();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 无锁
     */
    private static class FooBar7 {

        private int n;
        private volatile boolean fooRun = true;

        public FooBar7(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!fooRun) {
                    Thread.yield();
                }
                printFoo.run();
                fooRun = false;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (fooRun) {
                    Thread.yield();
                }
                printBar.run();
                fooRun = true;
            }
        }
    }
}