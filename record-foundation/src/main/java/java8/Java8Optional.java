package java8;

import com.alibaba.fastjson.JSON;
import domain.BigDog;
import domain.Dog;

import java.util.Optional;

public class Java8Optional {

    public static void main(String[] args) {
        optTest1();
    }

    public static void optTest1() {
        Dog dog = new Dog();
        dog.setSuccess(true);
        BigDog bg = new BigDog(12, "yiyi");
        bg.setAlive(true);
        dog.setBigDog(bg);
        Dog ddd = null;
        Optional<Dog> dog1 = Optional.ofNullable(dog)
                .filter(Dog::getSuccess);
        System.out.println(JSON.toJSONString(dog1.get()));
        Boolean aBoolean = Optional.ofNullable(dog)
                .filter(Dog::getSuccess)
                .map(d -> d.getBigDog().getAlive())
                .orElse(false);
        System.out.println(aBoolean);
    }

}
