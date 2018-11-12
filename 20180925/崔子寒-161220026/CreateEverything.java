import Attributes.Position;
import Creatures.*;
import Formations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CreateEverything {

    private static Heros heros= new Heros();
    private static ArrayList<CalabashBrother> calabashBrothers;
    private static Grandfather grandfather;
    private static ArrayList<Monster> monsters;
    private static Scorpion scorpion = new Scorpion();
    private static Snake snake = new Snake();
    private static Battlefield battlefield = new Battlefield();
    private  static ArrayList<FormationProvider> formationProviders ;

    public static void init() {
        formationProviders = new ArrayList<>();
        formationProviders.addAll(Arrays.asList(new HeYi(),new YanXing(),new ChongE(),
                new ChangShe(),new YuLin(),new Fang(),new YanYue(),new FengShi()));
        monsters = new ArrayList<>();
        for(int i = 0;i < 8;i++) {
            monsters.add(new Monster());
        }
        heros.shuffle();
        heros.lineUp();
        calabashBrothers = heros.getCalabashBrothers();
        grandfather = heros.getGrandfather();
        int delta = 0;
        for(CalabashBrother cb : calabashBrothers) {
            cb.setPosition(delta+1,17);
            delta++;
        }
    }

    public static  void herosEnter() {
        for(CalabashBrother cb:calabashBrothers) {
            battlefield.creatureEnter(cb,cb.getPosition());
        }
        Random rand = new Random();
        int temp_x = 3+rand.nextInt(4);
        grandfather.setPosition(temp_x,19);
        battlefield.creatureEnter(grandfather,grandfather.getPosition());
    }
    public static  void badGuysChangeFormation(FormationProvider formationProvider) {
        Position[] positions = formationProvider.provideFormation();
        for(Monster monster:monsters) {
            monster.setPosition(positions[monsters.indexOf(monster)].getX(),positions[monsters.indexOf(monster)].getY());
        }
        scorpion.setPosition(5,0);
        Random rand = new Random();
        int temp_x = 3+rand.nextInt(4);
        snake.setPosition(temp_x,1);

        for(Monster monster:monsters) {
            battlefield.creatureEnter(monster,monster.getPosition());
        }
        battlefield.creatureEnter(scorpion,scorpion.getPosition());
        battlefield.creatureEnter(snake,snake.getPosition());
        System.out.println("----------------------------------------------------------------------");
    }

    public static  void main(String[] args ) throws InterruptedException{
        init();
        for(FormationProvider fp:formationProviders) {
            herosEnter();
            badGuysChangeFormation(fp);
            battlefield.print();
            battlefield.clear();
            Thread.sleep(1500);

        }
    }
}
