package domain;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BigDog {

    private String name;
    private int age;
    private Boolean alive;
    private HashSet<String> strSet;

    public BigDog() {
    }

    public BigDog(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HashSet<String> getStrSet() {
        return strSet;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public void setStrSet(HashSet<String> strSet) {
        this.strSet = strSet;
    }

    @Override
    public String toString() {
        return "BigDog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", strSet=" + JSON.toJSONString(strSet) +
                '}';
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        System.out.println(integers.contains(null));
    }

    public static String validateAndConvertAddress(String provinceName, String cityName, String countyName, String townName, String fullAddress) {

        StringBuilder sb = new StringBuilder();
        sb.append(provinceName);
        if (cityName != null)
            sb.append(cityName);
        if (countyName != null)
            sb.append(countyName);
        if (townName != null)
            sb.append(townName);

        String pre = sb.toString();
        String detailAdress = fullAddress;
        int i = fullAddress.indexOf(pre);
        int len = pre.length();
        if (i == 0) {
            detailAdress = fullAddress.substring(len);
        }

        System.out.println(detailAdress);
        return detailAdress;
    }
}
