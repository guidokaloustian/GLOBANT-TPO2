package tpo2;

import Exceptions.AlreadyExistingKeyException;
import Exceptions.NonExistingKeyExcpetion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EpicDoubleHashMap<K extends Number, T, V> {
    HashMap<K, T> map1;
    HashMap<K, V> map2;

    public EpicDoubleHashMap() {
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();
    }

    public void addFirstValue (K key, T value) {
        try {
            if (map1.containsKey(key)) {
                throw new AlreadyExistingKeyException("La clave que esta intengando ingresar ya existe");
            }
            map1.put(key, value);
        } catch (AlreadyExistingKeyException aeke) {
            System.out.println(aeke.getMessage());
            aeke.printStackTrace();
        }
    }

    public void addSecondValue (K key, V value) {
        try {
            if (map2.containsKey(key)) {
                throw new AlreadyExistingKeyException("La clave que esta intengando ingresar ya existe");
            }
            map2.put(key, value);
        } catch (AlreadyExistingKeyException aeke) {
            System.out.println(aeke.getMessage());
            aeke.printStackTrace();
        }
    }

    public void addTwoValues (K key, T value1, V value2) {
        try {
            if (map1.containsKey(key) || map2.containsKey(key)) {
                throw new AlreadyExistingKeyException("La clave que esta intengando ingresar ya existe");
            }
            map1.put(key, value1);
            map2.put(key, value2);
        } catch (AlreadyExistingKeyException aeke) {
            System.out.println(aeke.getMessage());
            aeke.printStackTrace();
        }

    }

    public void getValueT (K key) {
        System.out.println(map1.get(key));
    }

    public void getValueV (K key) {
        System.out.println(map2.get(key));
    }

    public void removeItem (K key) {
        try {
            if (!map1.containsKey(key) || !map2.containsKey(key)) {
                throw new NonExistingKeyExcpetion("No existe ningun item con la clave ingresada");
            }
            map1.remove(key);
            map2.remove(key);
        } catch (NonExistingKeyExcpetion neke) {
            System.out.println(neke.getMessage());
            neke.printStackTrace();
        }
    }

    public ArrayList valuesList() {
        ArrayList<Object> values = new ArrayList<>();
        map1.forEach((key, value) -> {
            values.add(map1.get(key));
        });
        map2.forEach((key, value) -> {
            values.add(map2.get(key));
        }); return values;
    }

    public void checkValues() {
        valuesList();

    }

    private int tValuesSize() {
        return map1.size();
    }

    private int vValuesSize() {
        return map2.size();
    }

    public void amountOfValues() {
        if (tValuesSize() > vValuesSize()) {
            System.out.println("Existen mas valores de tipo 1");
        } else if (tValuesSize() < vValuesSize()) {
            System.out.println("Existen mas valores de tipo 2");
        } else {
            System.out.println((tValuesSize() != 0) ?
                    "Existen la misma cantidad de valores de los dos tipos." : "Aun no existen items.");
        }
    }

    public boolean repeteadValues() {
        valuesList();
        boolean flag = false;
        for (int i = 0; i < valuesList().size(); i++) {
            int j;
            for (j = 0; j < valuesList().size(); j++) {
                if (valuesList().get(i).equals(valuesList().get(j))) {
                    flag = true;
                }
            }
        } return flag;
    }