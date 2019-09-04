package singleton;

import java.io.Serializable;

/**
 * 最初线程安全的懒汉式 - 不可取
 *      - 只有第一次获取实例时才有必要加锁，而synchronized锁住的是整个方法，效率低，
 */
class SynchronizedSingleton implements Serializable {
    /**
     * 定义实例
     */
    private static SynchronizedSingleton instance;

    /**
     * 私有化构造方法
     */
    private SynchronizedSingleton() {}

    /**
     * 对外提供加锁的获取实例的方法
     */
    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }

    /**
     * readResolve方法，防止序列化破坏单例
     */
    private Object readResolve() {
        return getInstance();
    }
}

/**
 * 双重校验锁
 */
public class DoubleCheckSingleton implements Serializable{
    /**
     * 使用volatile修饰，防止指令重排序，避免了多线程下由于指令重排序导致的问题
     *      doubleCheckSingleton = new DoubleCheckSingleton();这步操作分三个指令
     *      1. 给对象分配内存空间
     *      2. 初始化内存，实例化对象
     *      3. 将内存地址赋给引用
     *      若这三个操作按照 1 -> 2 -> 3 进行则不会有问题
     *      若按照 1 -> 3 -> 2 进行则可能会把一个没有初始化的对象给到排队的线程，进而引发问题
     */
    private static volatile DoubleCheckSingleton doubleCheckSingleton;

    private  DoubleCheckSingleton() {}

    public static DoubleCheckSingleton getInstance() {
        if (doubleCheckSingleton == null) {
            synchronized(DoubleCheckSingleton.class) {
                if (doubleCheckSingleton == null) {
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }

        return doubleCheckSingleton;
    }

    /**
     * readResolve方法，防止序列化破坏单例
     */
    private Object readResolve() {
        return getInstance();
    }

}




















