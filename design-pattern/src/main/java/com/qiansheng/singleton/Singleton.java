package com.qiansheng.singleton;

/**
 * <p>单例模式的双重检测版本</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2021/4/11 11:13
 */
public class Singleton {

    /**
     * volatile 保证Singleton的可见性
     */
    private static volatile Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        // 第一次判断，避免不必要的同步
        if (null == singleton) {
            // 同步代码块，减少同步影响范围，提高并发性能
            synchronized (Singleton.class) {
                // 第二次同步保证线程安全，防止同一时间有多个线程进来进而创建对个实例
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
