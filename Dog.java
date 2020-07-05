package geekbrains;

public class Dog extends Animal {

    public Dog(int age, String name, String color, int weight) {
        super(age, name, color, weight);
    }

    @Override
    public void run(int distance) {
    if (distance < 500) {
        System.out.println(name + " run " + distance + " m.");
    } else {
        System.out.println("i cant do this. im dog");
    }
    }

    @Override
    public void swim(int distance) {
        if (distance < 10) {
            System.out.println(name + " swim" + distance + " m.");
        } else {
            System.out.println("i cant do this. im dog");
        }
    }

    @Override
    public void jump(double height) {
        if (height <= 0.5) {
            System.out.println(name + " jump " + height + " m. ");
        } else {
            System.out.println(name + " is not Jumpy dog");
        }
    }
}