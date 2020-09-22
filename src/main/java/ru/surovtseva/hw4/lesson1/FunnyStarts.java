package ru.surovtseva.hw4.lesson1;

public class FunnyStarts {
    public static void main(String[] args) {


        Action Tom = new Human("Tom",200,1.5f);
        Action Jim = new Human("Jim",220,0.9f);
        Action Barsik = new Cat("Barsik",250,1.1f);
        Action Pushok = new Cat("Pushok",190,1.5f);
        Action C3PO = new Robot("C3PO",210,1.4f);
        Action R2D2 = new Robot("R2D2",270,1.2f);

        Action[] players = {Tom, Jim, Barsik, Pushok, C3PO, R2D2};

        Wall wall = new Wall(1);
        Wall wall1 = new Wall(1.3f);
        Track track = new Track(200);
        Track track1 = new Track(150);

        Hurdles[] hurdles = {wall, track,wall1,track1};

        for (Action player: players) {
            System.out.println(player.getInfo());
            for (Hurdles hurdle: hurdles) {
                if (hurdle.doIT(player)){
                    System.out.println(player.getName() + " преодолел препятсвие: " + hurdle.getType()+
                            " - " + hurdle.getParameter());
                } else {
                    System.out.println(player.getName() + " не смог преодолеть препятствие: " +
                            hurdle.getType()+ " - " + hurdle.getParameter() + " и выбывает из марафона");
                    break;
                }
            }
        }
    }
}
