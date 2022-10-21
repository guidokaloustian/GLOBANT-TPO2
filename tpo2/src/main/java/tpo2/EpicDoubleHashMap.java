package tpo2;

import Exceptions.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class EpicDoubleHashMap<K extends Number, T, V> {
    private HashMap<K, T> mapT;
    private HashMap<K, V> mapV;

    // Messages
    final private String aeke = "The key you are trying to enter already exists.";
    final private String voe = "There cannot be three equal values.";
    final private String neke = "There is no item with the key entered.";
    final private String neveT = "The entered key does not contain a T value.";
    final private String neveV = "The entered key does not contain a V value.";

    public EpicDoubleHashMap() {
        this.mapT = new HashMap<>();
        this.mapV = new HashMap<>();
    }

    // Method to add the first value to a key.
    // 3) a).
    public void addFirstValue(K key, T value) {
        try {
            if (mapT.containsKey(key)) {
                throw new ExceptionMessages(aeke);
            }
            if (checkValues(value)) {
                throw new ExceptionMessages(voe);
            }
            else {mapT.put(key, value);}
        } catch (ExceptionMessages aeke) {
            System.out.println(aeke.getMessage());
            aeke.printStackTrace(System.out);
        } catch (Exception voe) {
            System.out.println(voe.getMessage());
            voe.printStackTrace(System.out);
        }
    }

    // Method to add the second value to a key.
    // 3) a).
    public void addSecondValue(K key, V value) {
        try {
            if (mapV.containsKey(key)) {
                throw new ExceptionMessages(aeke);
            }
            if (checkValues(value)) {
                throw new ExceptionMessages(voe);
            }
            else {mapV.put(key, value);}
        } catch (ExceptionMessages aeke) {
            System.out.println(aeke.getMessage());
        } catch (Exception voe) {
            System.out.println(voe.getMessage());
            voe.printStackTrace(System.out);
        }
    }

    // Method to add two values to a key.
    // 3) a).
    public void addTwoValues(K key, T value1, V value2) {
        try {
            if (mapT.containsKey(key) || mapV.containsKey(key)) {
                throw new ExceptionMessages(aeke);
            }
            if (checkValues(value1) || (checkValues(value2))) {
                throw new ExceptionMessages(voe);
            }
            else {
                mapT.put(key, value1);
                mapV.put(key, value2);
            }
        } catch (ExceptionMessages aeke) {
            System.out.println(aeke.getMessage());
            aeke.printStackTrace(System.out);
        } catch (Exception voe) {
            System.out.println(voe.getMessage());
            voe.printStackTrace(System.out);
        }
    }

    // Method to get the T value.
    public void getValueT(K key) {
        try {
            if (!mapT.containsKey(key) && mapV.containsKey(key)) {
                throw new ExceptionMessages(neveT);
            }
            if (!mapT.containsKey(key) && !mapV.containsKey(key)) {
                throw new ExceptionMessages(neke);
            }
            else {
                System.out.println("The value of key " + key + " is: " + mapT.get(key));
            }
        } catch (ExceptionMessages neveT) {
            System.out.println(neveT.getMessage());
            neveT.printStackTrace(System.out);
        } catch (Exception neke) {
            System.out.println(neke.getMessage());
            neke.printStackTrace(System.out);
        }
    }

    // Method to get the V value.
    public void getValueV(K key) {
        try {
            if (!mapV.containsKey(key) && mapT.containsKey(key)) {
                throw new ExceptionMessages(neveV);
            }
            if (!mapT.containsKey(key) && !mapV.containsKey(key)) {
                throw new ExceptionMessages(neke);
            }
            else {
                System.out.println("The value of key " + key + " is: " + mapV.get(key));
            }
        } catch (ExceptionMessages neveV) {
            System.out.println(neveV.getMessage());
            neveV.printStackTrace(System.out);
        } catch (Exception neke) {
            System.out.println(neke.getMessage());
            neke.printStackTrace(System.out);
        }
    }

    // Method to remove an item.
    // 3) b).
    public void removeItem(K key) throws RuntimeException{
        try {
            if (!mapT.containsKey(key) && !mapV.containsKey(key)) {
                throw new ExceptionMessages(neke);
            }
            else {
                mapT.remove(key);
                mapV.remove(key);
            }
        } catch (ExceptionMessages neke) {
            System.out.println(neke.getMessage());
            neke.printStackTrace(System.out);
        }
    }

    // Private method that contains an ArrayList with all values.
    private ArrayList valuesList() {
        ArrayList<Object> values = new ArrayList<>();
        mapT.forEach((key, value) -> values.add(mapT.get(key)));
        mapV.forEach((key, value) -> values.add(mapV.get(key)));
        return values;
    }

    // Private method that checks if a value is going to be repeated 3 times.
    private boolean checkValues(Object value) {
        int frequency = 0;
        int i = 0;
        while (i < valuesList().size() && frequency < 2) {
            if (value.equals(valuesList().get(i))) {
                frequency++;
            }
            i++;
        }
        return frequency == 2;
    }

    // Private method to re-use in other methods (gives the size of mapT).
    private int amountOfTValues() {
        return mapT.size();
    }

    // Private method to re-use in other methods (gives the size of mapV).
    private int amountOfVValues() {
        return mapV.size();
    }

    // Method that returns which type has more values.
    public void amountOfValues() {
        if (amountOfTValues() > amountOfVValues()) {
            System.out.println("There are more values of the 1st type.");
        } else if (amountOfTValues() < amountOfVValues()) {
            System.out.println("There are more values of the 2nd type.");
        } else {
            System.out.println((amountOfTValues() != 0) ?
                    "There are the same number of values of both types." : "There are no items yet.");
        }
    }

    // Method that returns the frequency of the values related to a key.
    // 4) b).
    public void amountOfValuesRelatedToKey(K key) {
        if (mapT.containsKey(key)) {
            int frequency1 = Collections.frequency(valuesList(), mapT.get(key));
            System.out.println("The value " + mapT.get(key) + " is repeated " + frequency1 +
                    ((frequency1 == 1) ? " time." : " times."));
        }
        if (mapV.containsKey(key)) {
            int frequency1 = Collections.frequency(valuesList(), mapV.get(key));
            System.out.println("The value " + mapV.get(key) + " is repeated " + frequency1 +
                    ((frequency1 == 1) ? " time." : " times."));
        }
        try {
            if (!mapT.containsKey(key) && !mapV.containsKey(key)) {
                throw new ExceptionMessages(neke);
            }
        } catch (Exception neke) {
            System.out.println(neke.getMessage());
            neke.printStackTrace(System.out);
        }
    }

    // Method that returns true if exists repeated values.
    public boolean repeteadValues() {
        int frequency = 0;
        int i = 0;
        while (i < valuesList().size() && frequency <= 1) {
            frequency = Collections.frequency(valuesList(), valuesList().get(i));
            i++;
        }
        return frequency > 1;
    }
}