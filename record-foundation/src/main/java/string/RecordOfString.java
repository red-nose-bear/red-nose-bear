package string;

/**
 * 在Java中，new String("hello")这样的创建方式，到底创建了几个String对象？
 * 1. 若字符串常量池中没有hello，则会创建2个对象：字符串常量池中hello，堆中hello
 * 2. 若字符串常量池中已有hello，则只创建1个对象：堆中hello
 * 有参构造：
 * public String(String original) {
 * this.value = original.value;
 * this.hash = original.hash;
 * }
 */
public class RecordOfString {

    public static void main(String[] args) {
//        verify_1();
//        verify_2();
        test();
    }

    public static void verify_1() {
        String str = new String("hello");
        String after_str = "hello";
        System.out.println(str == after_str);
        /**
         * str 和 after_str 的value指向的是同一个对象（常量池中），说明第一行代码创建了两个对象
         */
    }

    public static void verify_2() {
        String before_str = "hello";
        String str = new String("hello");
        System.out.println(str == before_str);
        /**
         * str 和 after_str 的value指向的是同一个对象（常量池中），说明第2行代码创建了一个对象
         */
    }

    public static void test() {
        String str1 = new StringBuilder("hel").append("lo").toString();
        String str2 = new StringBuilder("ja").append("va").toString();

        System.out.println(str1.intern() == str1); // true
        System.out.println(str2.intern() == str2); // false
        /**
         * 第二个为false，表示字符串常量池中已存在“java”
         * System类里面有一行代码 sun.misc.Version.init();Version类里面有一个静态常量字符串launcher_name=“java”
         * 系统会预装入字符常量，如：“true”，“false”，“java”
         */
    }

}
