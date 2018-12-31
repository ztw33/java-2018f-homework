import space.*;
import group.*;
import formation.*;

public class BattleField {
    private TwoDimensionSpace space;
    private HuluBrothers huluBrothers;
    private Monsters monsters;
    public BattleField(int N){
        space = new TwoDimensionSpace(N);
        huluBrothers = new HuluBrothers();
        monsters = new Monsters(7);
    }
    public void displayBattleField(){
        space.displaySpace();
    }
    public static void main(String[] args){
        BattleField field = new BattleField(20);
        //field.displayBattleField();
        field.huluBrothers.random();
        field.huluBrothers.generateFormation(new ChangsheFormation(), field.space, 10, 7, 0);
        field.displayBattleField();
        System.out.println();
        field.huluBrothers.colorSort();
        field.huluBrothers.generateFormation(new ChangsheFormation(), field.space, 10, 7, 0);
        field.displayBattleField();
        field.monsters.generateFormation(new ChangsheFormation(), field.space, 10,11, 1);
        field.displayBattleField();
        field.monsters.generateFormation(new HeyiFormation(), field.space, 12, 18, 1);
        field.displayBattleField();
        field.huluBrothers.generateFormation(new HeyiFormation(), field.space, 12, 2, 0);
        field.space.displaySpace();
        field.monsters.generateFormation(new YanhangFormation(), field.space, 13, 12, 1);
        field.space.displaySpace();
        field.huluBrothers.generateFormation(new HengeFormation(), field.space, 10, 7, 0);
        field.space.displaySpace();
        field.monsters.generateFormation(new FangmenFormation(), field.space, 10, 12, 1);
        field.space.displaySpace();
        field.monsters.generateFormation(new FengshiFormation(), field.space, 10, 13, 1);
        field.space.displaySpace();
        field.huluBrothers.generateFormation(new YulinFormation(), field.space, 10, 7, 0);
        field.space.displaySpace();
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