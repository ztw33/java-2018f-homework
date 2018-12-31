import Attributes.Position;
import Creatures.*;
import Formations.*;
import java.util.Random;

public class CreateEverything {

    private static Heros heros= new Heros();
    private static CalabashBrother[] calabashBrothers;
    private static Grandfather grandfather;
    private static Monster[] monsters = new Monster[8];
    private static Scorpion scorpion = new Scorpion();
    private static Snake snake = new Snake();
    private static Battlefield battlefield = new Battlefield();
    private static FormationProvider[] formationProviders = {new HeYi(),new YanXing(),new ChongE(),
    new ChangShe(),new YuLin(),new Fang(),new YanYue(),new FengShi()};

    public static void init() {
        for(int i = 0;i < 8;i++) {
            monsters[i] = new Monster();
        }
        heros.shuffle();
        heros.lineUp();
        calabashBrothers = heros.getCalabashBrothers();
        grandfather = heros.getGrandfather();
        for(int i = 0;i < 7;i++) {
            calabashBrothers[i].setPosition(i+1,17);
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
        for(int i = 0;i < 8;i++) {
            monsters[i].setPosition(positions[i].getX(),positions[i].getY());
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
    }

    public static  void main(String[] args ) throws InterruptedException{
        init();
        for(FormationProvider fp:formationProviders) {
            herosEnter();
            badGuysChangeFormation(fp);
            battlefield.print();
            battlefield.clear();
            System.out.println("----------------------------------------------------------------------");
            Thread.sleep(1500);

        }
    }
}
