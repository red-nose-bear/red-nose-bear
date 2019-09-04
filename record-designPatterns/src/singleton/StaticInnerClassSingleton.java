package singleton;

import java.io.Serializable;

/**
 * 使用静态内部类的方式单例
 *      该方法同样利用了classloder机制保证初始化instance时只有一个线程，不同的是只有在显示调用getInstance方法时
 *      才创建实例
 */
public class StaticInnerClassSingleton implements Serializable {
    /**
     * 在静态内部类中初始化实例对象
     */
    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    /**
     * 构造方法私有化，防止外部调用
     */
    private StaticInnerClassSingleton() {}

    /**
     * 对外提供获取实例的静态方法
     */
    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * readResolve方法，防止序列化破坏单例
     */
    private Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}
