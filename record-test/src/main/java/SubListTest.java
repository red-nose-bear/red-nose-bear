import com.alibaba.fastjson.JSON;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class SubListTest {

    public static void main(String[] args) {
        /**
         * ǐ ArrayList的subList结果不可强转为ArrayList否则会抛异常：ClassCastException java.util.RandomAccessSubList cannot be cast to java.util.ArrayList.
         * subList结果是ArrayList的内部类：SubList，是ArrayList的一个视图，SubList所有的操作最终结果会映射到原列表上
         */
        ArrayList a = new ArrayList(Arrays.asList("1", "2", "3", "4"));
        List list = a.subList(0, 2);
        list.set(0, "6");
        a.forEach(item -> {
            System.out.println(item);
        });


    }

}
