package tpo2;

import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.util.HashMap;

public class Principal {
    public static void main(String[] args) {
        Cat cat1 = new Cat("pupa");
        Cat cat2 = new Cat("benito");
        Cat cat3 = new Cat("julio");
        Dog dog1 = new Dog("mona");
        EpicDoubleHashMap<Integer, Cat, Dog> map = new EpicDoubleHashMap<>();

        map.addFirstValue(1, cat1);
        map.addFirstValue(3, cat3);
        map.addSecondValue(1, dog1);
        map.addTwoValues(2, cat1, dog1);

        System.out.println(map.map1);
        System.out.println(map.map2);

        System.out.println(map.valuesList());
    }
}
