import sort.HuluWaBubbleSort;
import space.*;
import group.*;
import formation.*;
import creature.*;

public class BattleField {
    public BattleField(int N){

    }
    public static void main(String[] args){
        //BattleField field = new BattleField(20);
        //field.displayBattleField();
        TwoDimensionSpace<Creature> space = new TwoDimensionSpace<>(20);
        HuluBrothers huluBrothers = new HuluBrothers();
        Monsters monsters = new Monsters(7);
        huluBrothers.random();
        huluBrothers.generateFormation(new ChangsheFormation(), space, 10, 7, 0);
        space.displaySpace();
        System.out.println();
        huluBrothers.sort(new HuluWaBubbleSort());
        huluBrothers.generateFormation(new ChangsheFormation(), space, 10, 7, 0);
        space.displaySpace();
        monsters.generateFormation(new ChangsheFormation(), space, 10,11, 1);
        space.displaySpace();
        monsters.generateFormation(new HeyiFormation(), space, 12, 18, 1);
        space.displaySpace();
        huluBrothers.generateFormation(new HeyiFormation(), space, 12, 2, 0);
        space.displaySpace();
        monsters.generateFormation(new YanhangFormation(), space, 13, 12, 1);
        space.displaySpace();
        huluBrothers.generateFormation(new HengeFormation(), space, 10, 7, 0);
        space.displaySpace();
        monsters.generateFormation(new FangmenFormation(), space, 10, 12, 1);
        space.displaySpace();
        monsters.generateFormation(new FengshiFormation(), space, 10, 13, 1);
        space.displaySpace();
        huluBrothers.generateFormation(new YulinFormation(), space, 10, 7, 0);
        space.displaySpace();
        /*field.huluBrothers.random();
        field.huluBrothers.shoutBrothersName();
        field.huluBrothers.prioritySort();
        field.huluBrothers.shoutBrothersName();
        field.huluBrothers.random();
        field.huluBrothers.generateChangshe(field.space, 10, 8, 0);
        field.displayBattleField();
        field.huluBrothers.prioritySort();
        field.huluBrothers.shoutBrothersName();
        field.huluBrothers.generateChangshe(field.space, 10, 8, 0);
        field.displayBattleField();*/
    }
}