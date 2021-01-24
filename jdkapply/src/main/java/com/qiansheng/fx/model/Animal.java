package com.qiansheng.fx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>todo</p>
 *
 * @author zilong.qian@tuya.com
 * @version 1.0
 * @date 2021/1/24 1:21 上午
 */
public abstract class Animal {

    private String name;

    private Integer logs;

    abstract Integer countLegs();

    public <T> void test(List<? super T> dst, List<T> src) {
    }

    static int countLegs1 (List<? extends Animal> animals) {
        int re = 0;
        for (Animal animal : animals) {
            re += animal.countLegs();
        }
        return re;
    }
    static int countLegs2 (List<Animal> animals) {
        int re = 0;
        for (Animal animal : animals) {
            re += animal.countLegs();
        }
        return re;
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        List<Object> tt = new ArrayList<>();;
        List<Animal> animalList = new ArrayList<>();
        Animal.countLegs1(dogs);
        // Animal.countLegs2(animals);

        Animal animal = new Dog();
        animal.test(tt, animalList);
    }
}
