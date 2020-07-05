package geekbrains;

public abstract class Animal {
    // это создание класса
    protected int age;
    protected String name;
    protected String color;
    protected int weight;
    // это создание конструктора

    public Animal (int age, String name, String color, int weight) {
        this.age = age;
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    // метод дейстивя оъекта - бежать
    public abstract void run(int distance);

    public abstract void swim(int distance);
    // метод прыганья
    public abstract void jump(double height);
}
