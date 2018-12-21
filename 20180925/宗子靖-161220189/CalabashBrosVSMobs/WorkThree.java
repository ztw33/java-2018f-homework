package CalabashBrosVSMobs;

public class WorkThree {
    public static void main(String[] args){
        BattleField battleField=new BattleField(10,10,false);
        System.out.println("\nFirst battlefield:");
        battleField.printBattleField();
        battleField.mobsRearrange(false);
        System.out.println("\nSecond battlefield:");
        battleField.printBattleField();
    }
}
