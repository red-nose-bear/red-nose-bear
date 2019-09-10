package string;

/**
 * https://blog.csdn.net/believesoul/article/details/79588305
 * jdk版本：1.8+
 * 调用方式：str.intern()
 * 调用后，首先查看字符串常量池中是否含有与调用者内容相同的字符串，
 * 若存在则返回常量池中字符串的引用，若不存在，则向常量池中写入调用者在堆中的引用，并返回该引用
 */
public class InternTest {
}
