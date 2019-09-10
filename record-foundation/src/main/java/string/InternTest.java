package string;

/**
 * https://blog.csdn.net/believesoul/article/details/79588305
 * jdk版本：1.8+
 * 调用方式：str.intern()
 * 调用后，首先查看字符串常量池中是否含有与调用者内容相同的字符串，
 * 若存在则返回常量池中字符串的引用，若不存在，则向常量池中写入调用者在堆中的引用，并返回该引用
 */
public class InternTest {

    public static void main(String[] args) {
        // 创建2个对象，常量池中一个对象，堆中一个对象
        String a = new String("abc");
        // 创建1个对象，堆中另外的一个对象
        String b = new String("abc");

        /**
         * intern方法会检查常量池中是否存在该对象
         *      -> 存在：返回该对象
         *      -> 不存在：创建对象并返回该对象，在常量池中存一个指向堆中该对象的引用
         *          不存在往往因为：String s = new String("1") + new String("1")，会有堆中指向11的对象和常量池中1的对象
         */
        // "abc"对象自身的比较
        System.out.println(a.intern() == b.intern()); // true
        // 常量池中对象和堆中对象的比较
        System.out.println(a.intern() == b); // false
        System.out.println(a.intern() == a); // false
    }

}
