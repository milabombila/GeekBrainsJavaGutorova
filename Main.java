package geekbrains;

public class Main {

    public static void main(String[] args) {
        Dog doggie = new Dog (1,"doggie", "black", 22);
        doggie.run(5);
        doggie.jump(555);
        Cat murka = new Cat (22, "Murka", "grey", 25);
        murka.jump(2);
    }
}
