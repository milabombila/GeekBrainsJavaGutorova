package geekbrains;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    //getter
    //метод, который возвращает значение еды
    public int getFood() {
        return food;
    }

    // setter
    // метод, который устанавливает значение еды
    public boolean grabFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        } else {
            System.out.println("There is no food");
        }
        return false;
    }
    public void addFood(int amount) {
        food += amount;
    }
}
