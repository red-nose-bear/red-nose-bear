import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
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


        // 四舍五入 保留几位小数
//        Double d = 10.236;
//        System.out.println(new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
//
//        Double f = 10.291;
//        System.out.println(new BigDecimal(f).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
//
//        String g = "10.23";
//        System.out.println(new BigDecimal(g).setScale(1, BigDecimal.ROUND_HALF_UP).toString());
//
//        String h = "10.29";
//        System.out.println(new BigDecimal(h).setScale(1, BigDecimal.ROUND_HALF_UP).toString());

        System.out.println("-----------------------------------------");
        List<String> strings = Arrays.asList("1", "2", "3", "4");

        int randomIndex = ThreadLocalRandom.current().nextInt(strings.size()) % strings.size();

        int temp1 = ThreadLocalRandom.current().nextInt(strings.size());
        int temp2 = strings.size();

        System.out.println(temp1 + "    " + temp2 + "    " + temp1 % temp2);
        System.out.println(randomIndex);

    }

}
