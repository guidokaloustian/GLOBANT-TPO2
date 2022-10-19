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
        map.addSecondValue(7, dog4);

        // Dos funciones para devolver el valor V o T del item dada una key.
        map.getValueT(1);
        map.getValueV(2);

        // Función para remover el item que contenga un key en específico.
        map.removeItem(4);

        System.out.println("");

        //Check si se eliminó.
        map.getValueV(4);

        System.out.println("");

        // Añadir un item con una key ya existente.
        map.addFirstValue(1, cat3);

        System.out.println("");

        // Remover un item con una key inexistente.
        map.removeItem(10);

        System.out.println("");

        // Añadir un item con un valor/valores que se repita/repitan por lo menos 3 veces.
        map.addFirstValue(5, cat1);

        System.out.println("");

        // Tratar de obtener el valor V o T de una key, sin que este exista.
        map.getValueV(1);

        System.out.println("");

        // Un método que printee si existen más valores de tipo T, V o si tienen la misma cantidad.
        map.amountOfValues();

        System.out.println("");

        // Un método booleano que devuelva true si existen values repetidos, y false en caso contrario.
        System.out.println(map.repeteadValues());

        System.out.println("");



    }
}
