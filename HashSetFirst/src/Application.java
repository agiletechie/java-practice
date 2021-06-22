import java.util.HashSet;

public class Application {
    public static void main(String args[]){
        // HashSet takes only unique values
        HashSet<Animals> animals = new HashSet<>();

        Animals animal1 = new Animals("Dog",12);
        Animals animal2 = new Animals("Cat",8);
        Animals animal3 = new Animals("Bird",3);
        Animals animal4 = new Animals("Dog",12);    // Duplicate
        Animals animal5 = new Animals("Kangaroo",24);

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);

        System.out.println(animal1.equals(animal4));

        animals.forEach(System.out::println);

        // Now it is taking only unique values after generating and overriding hashCode in Animals
    }
}
