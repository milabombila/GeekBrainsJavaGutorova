package geekbrains;

public class Robot implements Runnable, Jumpable {
    int distance;
    int jumpingAbility;

    public Robot (int distance, int jumpingAbility){
        this.distance = distance;
        this.jumpingAbility = jumpingAbility;
    }
    @Override
    public void run() {
        System.out.println(" Start running");
    }
    @Override
    public void jump() {
        System.out.println("Start jumping");
    }
    public void run(Road road) {
        System.out.println("I start run");
        road.checkTheDistance(distance, road.getlenghtOfRoad());
    }
    public void jump(Wall wall) {
        System.out.println("I start jump");
        wall.checkTheHeight(jumpingAbility, wall.getHeightOfWall());
    }
}