
public class Battle {
    public static final int N=25;
    public static void main (String[] args) {
            BattleField battleField=new BattleField();
        for(int i=1;i<8;i++){
            battleField.setupField(i);
            battleField.printField();
            battleField.cleanField();
        }
    }
}