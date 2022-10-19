package tpo2;

import Exceptions.AlreadyExistingKeyException;
import Exceptions.NonExistingKeyException;
import Exceptions.NonExistingValueException;
import Exceptions.ValueOverflowException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class EpicDoubleHashMap<K extends Number, T, V> {
    private HashMap<K, T> mapT;
    private HashMap<K, V> mapV;

    public EpicDoubleHashMap() {
        this.mapT = new HashMap<>();
        this.mapV = new HashMap<>();
    }


    // Method to add the first value to a key.
    public void addFirstValue(K key, T value) {
        try {
            // 3) a).
            if (mapT.containsKey(key)) {
                throw new AlreadyExistingKeyException("La clave que esta intentando ingresar ya existe.");
            }
            if (checkValues(value)) {
                throw new ValueOverflowException("No puede haber tres valores iguales.");
            }
            mapT.put(key, value);
        } catch (AlreadyExistingKeyException aeke) {
            System.out.println(aeke.getMessage());
            aeke.printStackTrace(System.out);
        }
        catch (ValueOverflowException voe) {
            System.out.println(voe.getMessage());
            voe.printStackTrace(System.out);
        }
    }

    // Method to add the second value to a key.
    public void addSecondValue(K key, V value) {
        try {
            // 3) a).
            if (mapV.containsKey(key)) {
                throw new AlreadyExistingKeyException("La clave que esta intentando ingresar ya existe.");
            }
            if (checkValues(value)) {
                throw new ValueOverflowException("No puede haber tres valores iguales.");
            }
            mapV.put(key, value);
        } catch (AlreadyExistingKeyException aeke) {
            System.out.println(aeke.getMessage());
            aeke.printStackTrace(System.out);
        }
        catch (ValueOverflowException voe) {
            System.out.println(voe.getMessage());
            voe.printStackTrace(System.out);
        }
    }

    // Method to add two values to a key.
    public void addTwoValues(K key, T value1, V value2) {
        try {
            // 3) a).
            if (mapT.containsKey(key) || mapV.containsKey(key)) {
                throw new AlreadyExistingKeyException("La clave que esta intentando ingresar ya existe.");
            }
            if (checkValues(value1) || (checkValues(value2))) {
                throw new ValueOverflowException("No puede haber tres valores iguales.");
            }
            mapT.put(key, value1);
            mapV.put(key, value2);
        } catch (AlreadyExistingKeyException aeke) {
            System.out.println(aeke.getMessage());
            aeke.printStackTrace(System.out);
        }
        catch (ValueOverflowException voe) {
            System.out.println(voe.getMessage());
            voe.printStackTrace(System.out);
        }

    }

    // Method to get the T value.
    public void getValueT(K key) {
        try {
            if (!mapT.containsKey(key) && mapV.containsKey(key)) {
                throw new NonExistingValueException("La clave ingresada no contiene un valor T.");
            }
            if (!mapT.containsKey(key) && !mapV.containsKey(key)){
                throw new NonExistingKeyException("No existe ningun item con la clave ingresada.");
            }
            System.out.println("El valor 1 de " + key + " es: " + mapT.get(key));
        } catch (NonExistingValueException neve) {
            System.out.println(neve.getMessage());
            neve.printStackTrace(System.out);
        }
        catch (NonExistingKeyException neke) {
            System.out.println(neke.getMessage());
            neke.printStackTrace(System.out);
        }
    }

    // Method to get the V value.
    public void getValueV(K key) {
        try {
            if (!mapV.containsKey(key) && mapT.containsKey(key)) {
                throw new NonExistingValueException("La clave ingresada no contiene un valor V.");
            }
            if (!mapT.containsKey(key) && !mapV.containsKey(key)) {
                throw new NonExistingKeyException("No existe ningun item con la clave ingresada.");
            }
            System.out.println("El valor 2 de " + key + " es: " + mapV.get(key));
        } catch (NonExistingValueException neve) {
            System.out.println(neve.getMessage());
            neve.printStackTrace(System.out);
        }
        catch (NonExistingKeyException neke) {
            System.out.println(neke.getMessage());
            neke.printStackTrace(System.out);
        }
    }

    // Method to remove an item.
    public void removeItem(K key) {
        try {
            // 3) b).
            if (!mapT.containsKey(key) && !mapV.containsKey(key)) {
                throw new NonExistingKeyException("No existe ningun item con la clave ingresada.");
            }
            mapT.remove(key);
            mapV.remove(key);
        } catch (NonExistingKeyException neke) {
            System.out.println(neke.getMessage());
            neke.printStackTrace(System.out);
        }
    }

    // Private method that contains an ArrayList with all values.
    private ArrayList valuesList() {
        ArrayList<Object> values = new ArrayList<>();
        mapT.forEach((key, value) -> {
            values.add(mapT.get(key));
        });
        mapV.forEach((key, value) -> {
            values.add(mapV.get(key));
        });
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
            System.out.println("Existen mas valores de tipo 1");
        } else if (amountOfTValues() < amountOfVValues()) {
            System.out.println("Existen mas valores de tipo 2");
        } else {
            System.out.println((amountOfTValues() != 0) ?
                    "Existen la misma cantidad de valores de los dos tipos." : "Aun no existen items.");
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