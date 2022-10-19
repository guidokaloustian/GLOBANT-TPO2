package tpo2;

public class Cat {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean equals(Object obj) {
        Cat otherCat = (Cat) obj;
        return this.name.equals(otherCat.name);
    }
}
