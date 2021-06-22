import java.util.Objects;

public class Animals {
    String name;
    int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return age == animals.age &&
                Objects.equals(name, animals.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
