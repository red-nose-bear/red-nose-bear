package java8;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import domain.BigDog;
import domain.Dog;

import java.util.*;
import java.util.stream.Collectors;

public class Java8NewFeature {

    public static void main(String[] args) {
        removeSpecifiedEle();
    }

    public static void getIntersectionOfTwoList() {
        List<String> list1 = new ArrayList();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List<String> list2 = new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");

        // 交集
        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
        System.out.println("---得到交集 intersection---");
        intersection.parallelStream().forEach(System.out :: println);

        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);

        // 差集 (list2 - list1)
        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce2 (list2 - list1)---");
        reduce2.parallelStream().forEach(System.out :: println);

        // 并集
        List<String> listAll = list1.parallelStream().collect(Collectors.toList());
        List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        System.out.println("---得到并集 listAll---");
        listAll.parallelStream().forEach(System.out :: println);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
        System.out.println("---得到去重并集 listAllDistinct---");
        listAllDistinct.parallelStream().forEach(System.out :: println);

        System.out.println("---原来的List1---");
        list1.parallelStream().forEach(System.out :: println);
        System.out.println("---原来的List2---");
        list2.parallelStream().forEach(System.out :: println);

        // 一般有filter 操作时，不用并行流parallelStream ,如果用的话可能会导致线程安全问题
    }

    /**
     * list变map，同时处理相同key的情况
     */
    public static void listToMap() {
        List<String> list = Lists.newArrayList("1", "2", "3", "1");
        Map<String, List<String>> map = list.stream().collect(Collectors.toMap(
                key -> key, // 第一个参数作为map的key
                Lists::newArrayList, // 第二个参数作为map的value
                (List<String> newValueList, List<String> oldValueList) -> { // 第三个参数处理key重复的情况
                    oldValueList.addAll(newValueList);
                    return oldValueList;
                }));
        System.out.println(JSON.toJSONString(map));
    }

    /**
     * list转为另一个实体的list
     */
    public static void listToOtherList() {
        Dog dog1 = new Dog();
        dog1.setAge(1);
        dog1.setName("java8");
        List<Dog> list1 = new ArrayList<>();
        list1.add(dog1);

        List<BigDog> list2 = list1.stream().map(dog -> new BigDog(dog.getAge(), dog.getName())).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list2));
    }

    /**
     * 集合变数组
     */
    public static void collectionToArray() {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        String[] strings = set.stream().toArray(String[]::new);
        System.out.println(JSON.toJSONString(strings));
    }

    /**
     * 集合移除指定元素
     */
    public static void removeSpecifiedEle() {
        HashSet<String> set = new HashSet<>();
        set.add("P1");
        set.add("P2");
        set.add("P3");
        BigDog bigDog = new BigDog();
        bigDog.setStrSet(set);
        bigDog.getStrSet().removeIf("P6"::equals);
        System.out.println(bigDog.toString());
    }

}
