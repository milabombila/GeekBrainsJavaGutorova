package geekbrains;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public Cat(String name, int appetite) {
        this(name, appetite, false);
    }

    public void eat(Plate p) {
        satiety = p.grabFood(appetite);
    }
    public void infoCat() {
        System.out.println(" cat " + name + " is not hungry: " + satiety);
    }

}
