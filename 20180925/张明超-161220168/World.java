import beings.*;
import formations.*;
public class World {
    public static void main(String[] args){
        EvilParty[] enemy = new EvilParty[8];
        enemy[0] = new Scorpion();
        for(int i = 1; i < 8; i++){
            enemy[i] = new LittleMonster();
        }
        Snake snake = new Snake();
        Grandfather grandfather = new Grandfather();
        CalabashGroup calabashGroup = new CalabashGroup();
        Battlefield battlefield = new Battlefield();
        calabashGroup.shuffle();
        calabashGroup.print();
        calabashGroup.sort(new CalabashCompare());
        calabashGroup.print();
        //calabashGroup.quickSort();
        new SquareCircle().formationCreatrue(battlefield, enemy, snake);
        new LongSnake().formationCreatrue(battlefield, (Creature[]) calabashGroup.getFormationCreatrue(), grandfather);
        battlefield.printField();

        new CraneWing().formationCreatrue(battlefield, enemy, snake);
        battlefield.printField();

        new CrescentMoon().formationCreatrue(battlefield, enemy, snake);
        battlefield.printField();

        new LongSnake().formationCreatrue(battlefield, enemy, snake);
        battlefield.printField();

        new XShape().formationCreatrue(battlefield, enemy, snake);
        battlefield.printField();

        new GeeseFlyShape().formationCreatrue(battlefield, enemy, snake);
        battlefield.printField();

        new FishSquama().formationCreatrue(battlefield, enemy, snake);
        battlefield.printField();
    }
}
