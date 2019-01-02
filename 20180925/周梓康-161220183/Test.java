import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        //set up calabash camp
        List<CalabashBrother> calabashSoldier = new ArrayList<>();
        calabashSoldier.add(CalabashBrother.ORANGE);
        calabashSoldier.add(CalabashBrother.YELLOW);
        calabashSoldier.add(CalabashBrother.GREEN);
        calabashSoldier.add(CalabashBrother.CYAN);
        calabashSoldier.add(CalabashBrother.BLUE);
        calabashSoldier.add(CalabashBrother.PURPLE);
        Formation.LINE.instantiate(Formation.Direction.LEFT, new Coordinate(10, 10), new Coordinate(0, 0));
        CalabashCamp calabashCamp = new CalabashCamp(CalabashBrother.RED, calabashSoldier, NonCalabashBrother.GRANDPA, Formation.LINE);

        //sort the calabash brothers
        calabashCamp.shuffle();
        calabashCamp.sortByRank();
        calabashCamp.numberOffByRank();
        calabashCamp.shuffle();
        calabashCamp.sortByColor();
        calabashCamp.numberOffByColor();

        //set up nonCalabash camp
        List<Creature> nonCalabashSoldier = new ArrayList<>();
        for(int i = 0; i < 6; ++i)
            nonCalabashSoldier.add(new Underlying());
        Formation.WING.instantiate(Formation.Direction.LEFT, new Coordinate(10, 12), new Coordinate(0, 19));
        NonCalabashCamp nonCalabashCamp = new NonCalabashCamp(NonCalabashBrother.SCORPION, nonCalabashSoldier, NonCalabashBrother.SNAKE, Formation.WING);

        //set up battlefield
        BattleField battleField = new BattleField(20, 20);
        battleField.add(calabashCamp);
        battleField.add(nonCalabashCamp);
        battleField.display();

        //change formation
        Formation.FLIGHT.instantiate(Formation.Direction.RIGHT, new Coordinate(10, 12), new Coordinate(0, 19));
        nonCalabashCamp.setFormation(Formation.FLIGHT);
        battleField.display();

        //change formation
        Formation.YOKE.instantiate(Formation.Direction.RIGHT, new Coordinate(10, 12), new Coordinate(0, 19));
        nonCalabashCamp.setFormation(Formation.YOKE);
        battleField.display();
    }
}