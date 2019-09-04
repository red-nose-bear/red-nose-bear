package base;

/**
 * 代码执行顺序 https://www.cnblogs.com/cup-zh/p/9914622.html
 */
public class ExecutionOrder {

    public static int k = 0;
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
