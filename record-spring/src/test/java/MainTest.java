import com.alibaba.fastjson.JSON;
import com.kuma.spring.study.beanlifecycle.Cat;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    @Test
    public void mainTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        Cat cat = applicationContext.getBean("cat", Cat.class);
        System.out.println("========= cat: " + JSON.toJSONString(cat) + " =========");
        ((ClassPathXmlApplicationContext) applicationContext).destroy();
    }

}
