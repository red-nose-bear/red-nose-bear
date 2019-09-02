package singleton;

import java.io.Serializable;

/**
 * 饿汉式单例
 *      1. 通过static静态初始化，在该类第一次被加载的时候创建实例，避免了线程安全的问题
 *      2. 通过readResolve方法防止序列化破坏单例
 *      3. 缺点：
 *          - 若该类被多个类加载器加载会造成多次实例化
 *          - 若该实例创建后不被使用会造成不必要的消耗
 *      4. 解决缺点：
 *          - 使用静态内部类的方式
 *          - 懒汉式加载
 */
public class Singleton implements Serializable {
    /**
     * 在类内部实例化一个实例
     */
    private static Singleton instance = new Singleton();

    /**
     * 私有化构造函数，外部无法访问
     */
    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

    /**
     * 防止序列化对单例破坏
     */
    private Object readResolve() {
        return instance;
    }
}
