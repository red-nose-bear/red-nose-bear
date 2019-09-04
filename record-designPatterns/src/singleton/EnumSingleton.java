package singleton;

/**
 * 枚举单例不仅能避免多线程问题，还能防止反序列化重新创建新的对象
 * 枚举的线程安全性及序列化问题：https://www.hollischuang.com/archives/197
 *      1. 枚举类实际上是继承Enum的final类，所有实例都是 public static final 修饰的，所以是线程安全的
 *      2. 枚举自己处理序列化：在序列化的时候，仅仅将枚举对象的name属性输出到结果中，反序列化时则通过
 *          java.lang.Enum 的 valueOf()静态方法根据名字查找枚举对象
 */
public enum  EnumSingleton {
    INSTANCE;
    EnumSingleton() {};
}
