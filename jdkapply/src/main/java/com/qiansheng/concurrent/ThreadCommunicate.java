package com.qiansheng.concurrent;


import java.util.Random;
import java.util.concurrent.*;

/**
 *
 * java线程通信的方式
 *
 * @author qiansheng
 */
public class ThreadCommunicate {

    public static void main(String[] args) {
        //demo1();
        //demo2();
        //runDAfterABC();
        runSemaphore();
    }

    private static void runSemaphore() {

        //并发控制,同时只有4个线程获取
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable callable = new Callable() {
            @Override
            public String call() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return getRandomNum();
            }
        };
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        Semaphore semaphore = new Semaphore(4);
        try {
            for (int i = 0; i < 100; i++) {
                semaphore.acquire();
                Future<?> submit = executorService.submit(futureTask);
                System.out.println("future返回值:" + submit.get());
                semaphore.release();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }


    private static void runDAfterABC() {
        CountDownLatch latch = new CountDownLatch(3);
        Thread d = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    System.out.println("D");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        d.start();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A");
                latch.countDown();
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
                latch.countDown();
            }
        });
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
                latch.countDown();
            }
        });
        a.start();
        b.start();
        c.start();
    }

    /**
     * A 1, B 1, B 2, B 3, A 2, A 3
     */
    private static Object lock = new Object();
    private static void demo2() {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        System.out.println("A print:" + 1);
                        lock.wait();
                    }
                    System.out.println("A print:" + 2);
                    System.out.println("A print:" + 3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    print("B");
                    lock.notify();
                }

            }
        });
        a.start();
        b.start();

    }

    private static void demo1() {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                print("A");
            }
        });

        Thread b = new Thread(() -> {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("B");
        });
        a.start();
        b.start();
    }

    private static void print(String threadName) {
        int j = 0;
        while (j <= 3) {
            j++;
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("threadName:" + threadName + ",print:" + j);
        }
    }

    private static String getRandomNum() {
        return String.valueOf(new Random().nextInt(100));
    }
}
