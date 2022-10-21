package tpo2;

public class Principal {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Pupa");
        Cat cat2 = new Cat("Benito");
        Cat cat3 = new Cat("Julio");
        Dog dog1 = new Dog("Mona");
        Dog dog2 = new Dog("Maggie");
        Dog dog3 = new Dog("Doggie");
        Dog dog4 = new Dog("Pepe");

        EpicDoubleHashMap<Integer, Cat, Dog> map = new EpicDoubleHashMap<>();

        map.addFirstValue(1, cat1);
        map.addSecondValue(2, dog1);
        map.addTwoValues(3, cat1, dog2);
        map.addTwoValues(4, cat3, dog3);
        map.addSecondValue(7, dog2);

        System.out.println("-".repeat(70));

        // Dos funciones para devolver el valor V o T del item dada una key.
        map.getValueT(1);
        map.getValueV(2);
        System.out.println("-".repeat(70));

        // Función para remover el item que contenga un key en específico.
        System.out.print("Element four removed...");
        map.removeItem(4);
        System.out.println("-".repeat(70));

        //Check si se eliminó.
        System.out.println("Checking the item...");
        map.getValueV(4);
        System.out.println("-".repeat(70));

        // Añadir un item con una key ya existente.
        System.out.print("One element added again...");
        map.addFirstValue(1, cat3);
        System.out.println("-".repeat(70));

        // Remover un item con una key inexistente.
        System.out.print("Delete a nonexistent item...");
        map.removeItem(10);
        System.out.println("-".repeat(70));

        // Añadir un item con un valor/valores que se repita/repitan por lo menos 3 veces.
        System.out.print("Adding cat1 for the third time...");
        map.addFirstValue(5, cat1);
        System.out.println("-".repeat(70));

        // Tratar de obtener el valor V o T de una key, sin que este exista.
        System.out.print("Getting nonexistent value...");
        map.getValueV(1);
        System.out.println("-".repeat(70));

        // Un método que printee si existen más valores de tipo T, V o si tienen la misma cantidad.
        map.amountOfValues();
        System.out.println("-".repeat(70));

        // Un método que dada una key, devuelva cuantos valores existen iguales asociados a la key.
        map.amountOfValuesRelatedToKey(3);
        System.out.println("-".repeat(70));

        // Un método booleano que devuelva true si existen values repetidos, y false en caso contrario.
        System.out.println(map.repeteadValues());
        System.out.println("-".repeat(70));

    }
}
