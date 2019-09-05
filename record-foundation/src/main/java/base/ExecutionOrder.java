package base;

/**
 * 代码执行顺序 https://www.cnblogs.com/cup-zh/p/9914622.html
 * 执行结果：
 * ----------------------
 * 1:j i=0 n=0
 * 2:构造块 i=1 n=1
 * 3:e1 i=2 n=2
 * 4:j i=3 n=3
 * 5:构造块 i=4 n=4
 * 6:e2 i=5 n=5
 * 7:i i=6 n=6
 * 8:静态块 i=7 n=99
 * 9:j i=8 n=100
 * 10:构造块 i=9 n=101
 * 11:init i=10 n=102
 * ----------------------
 * 分析
 * ----------------------
 * 类的加载过程和jvm内存的分配
 * jvm将.java文件编译而成的.class文件加载到内存，找到程序入口main函数（不执行），加载类的数据
 * 加载类时，JVM会根据属性的数据类型赋默认值（数字类型为0，boolean类型为false，引用类型为null，若加final修饰，则配置constantValue，直接赋值），然后进行静态属性初始化，
 * 并为静态属性分配内存空间
 * 静态方法的声明，静态块的加载，没有优先级之分，按出现顺序执行
 *
 * 对象被创建时，会调用类的动态属性，普通方法声明，构造块，最后调用构造函数
 * 总的来说：
 * 先加载类的静态属性（变量），静态块，静态方法声明
 * 当定义类的对象时，调用非静态属性（变量），构造块，普通方法声明，最后调用类的构造函数
 *
 * ----------------------
 */
public class ExecutionOrder {

    public static int k = 0;
    public static final int x = 6;
    public static ExecutionOrder e1 = new ExecutionOrder("e1");
    public static ExecutionOrder e2 = new ExecutionOrder("e2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    {
        print("构造块");
    }

    static {
        print("静态块");
    }

    public ExecutionOrder(String s) {
        System.out.println((++k) + ":" + s + " i=" + i + " n=" + n);
        ++n;
        ++i;
    }

    public static int print(String s) {
        System.out.println((++k) + ":" + s + " i=" + i + " n=" + n);
        ++i;
        return ++n;
    }

    public static void main(String[] args) {
        ExecutionOrder t = new ExecutionOrder("init");
    }
}
