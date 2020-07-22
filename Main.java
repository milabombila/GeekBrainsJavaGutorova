package geekbrains;

public class Main {

    public static void main(String[] args) {
        Cat myFirstCat = new Cat(4,14);

        Human mila = new Human(14,1 );
        Robot topBot = new Robot(1,1);
        Robot jungleBot = new Robot(2,2);
        Robot adcBot = new Robot(1,1);
        Cat support1 = new Cat(1,1);



        Road roadToChallenger = new Road(11);

        Wall wallOfFeeders = new Wall(9);

        mila.run(roadToChallenger);
        mila.jump(wallOfFeeders);

        Jumpable[] myTeam = new Jumpable[] {mila, topBot, jungleBot, adcBot, support1};
        Obstacle[] myTroubles = new Obstacle[] {roadToChallenger, wallOfFeeders};

        for (int i = 0; i < myTeam.length; i++) {
            for (int j = 0; j <myTroubles.length ; j++) {
                if(myTeam[i] instanceof Human){
                    if(myTroubles[j] instanceof Road){
                        ((Human) myTeam[i]).run((Road) myTroubles[j]);
                    } else ((Human) myTeam[i]).jump((Wall) myTroubles[j]);
                }
                if(myTeam[i] instanceof Cat){
                    if(myTroubles[j] instanceof Road){
                        ((Cat) myTeam[i]).run((Road) myTroubles[j]);
                    } else ((Cat) myTeam[i]).jump((Wall) myTroubles[j]);
                }
                if(myTeam[i] instanceof Robot){
                    if(myTroubles[j] instanceof Road){
                        ((Robot) myTeam[i]).run((Road) myTroubles[j]);
                    } else ((Robot) myTeam[i]).jump((Wall) myTroubles[j]);
                }
            }
        }

    }
    }
