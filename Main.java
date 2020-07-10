package geekbrains;

public class Main {

    public static void main(String[] args) {
       // тип название = значение
        Cat[] kotiki = new Cat[6];
            kotiki[0] = new Cat("Barsik", 5);
            kotiki[1]  = new Cat("Barsik", 5);
            kotiki[2]  = new Cat("Barsik", 5);
            kotiki[3] = new Cat("Barsik", 5);
            kotiki[4] = new Cat("Barsik", 5);
            kotiki[5] = new Cat("Barsik", 5);
            Plate plate = new Plate(100);
            plate.info();
        for (int i = 0; i < kotiki.length; i++) {
            kotiki[i].eat(plate);
            kotiki[i].infoCat();
        }
            plate.info();
        }

}
