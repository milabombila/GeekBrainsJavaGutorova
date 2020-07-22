package geekbrains;

public class Wall extends Obstacle {
    private double height;

    public Wall (double height) {
        this.height = height;
    }

    public void info() {
        System.out.println("Lenght is " + height);
    }


    public double getHeightOfWall() {
        return height;
    }
    public void checkTheHeight(double height, double jumpingAbility){
        if(height >= jumpingAbility) {
            System.out.println("Ok I'll jump");
        } else {
            System.out.println("Sorry I cant");
        }
    }


}

