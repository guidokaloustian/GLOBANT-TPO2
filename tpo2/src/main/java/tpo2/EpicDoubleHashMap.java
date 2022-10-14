package tpo2;

import java.util.HashMap;

public class EpicDoubleHashMap<K extends Number, T, V> {
    HashMap<K, T> map1;
    HashMap<K, V> map2;

    public EpicDoubleHashMap(HashMap<K, T> map1, HashMap<K, V> map2) {
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();
    }

    public void addFirstMap (K key, T value) {
        map1.put(key, value);
    }

    public void addSecondMap (K key, V value) {
        map2.put(key, value);
    }

    public void addTwoValues (K key, T value1, V value2) {
        map1.put(key, value1);
        map2.put(key, value2);
    }

}
