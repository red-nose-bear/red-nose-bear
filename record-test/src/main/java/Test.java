/**
 * @Classname Test
 * @Description：
 * @Date 2019/12/4
 * @Time 15:59
 * @Author ypf
 **/
public class Test {

    private static final ThreadLocal<String> test = new ThreadLocal<>();

    public static void main(String[] args) {
        test.set("fasdf");
        test.get();
    }

}
