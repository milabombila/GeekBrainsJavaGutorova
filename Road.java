package geekbrains;

public class Road extends Obstacle {
    private int lenghtOfRoad;

    public Road(int lenghtOfRoad) {
        this.lenghtOfRoad = lenghtOfRoad;
    }

    public void info() {
        System.out.println("Lenght is " + lenghtOfRoad);
    }


    public int getlenghtOfRoad() {
        return lenghtOfRoad;
    }
    public void checkTheDistance(int lenghtOfRoad, int distance){
        if(lenghtOfRoad >= distance) {
            System.out.println("Ok I'll do this");
        } else {
            System.out.println("Sorry I cant");
        }
    }
}