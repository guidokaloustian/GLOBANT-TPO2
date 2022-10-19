package tpo2;

public class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "(Dog) " + "name= " + name;
    }

}
