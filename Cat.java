package geekbrains;

public class Cat extends Animal {

    public Cat(int age, String name, String color, int weight) {
        super(age, name, color, weight);
    }

    @Override
    public void run(int distance) {
        if (distance < 200) {
            System.out.println(name + " run" + distance + " m.");
        } else {
            System.out.println("I cant do this. I'm cat");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Nope, go do it by yourself");
    }

    @Override
    public void jump(double height) {
        if (height <= 2) {
            System.out.println(name + " jump " + height + " m.");
        } else {
            System.out.println( name + " is not Jumpy cat");
        }
    }
}
