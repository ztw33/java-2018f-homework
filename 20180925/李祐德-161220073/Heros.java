import java.util.*;
public class Heros extends Group {
    private int n;
    //private Gourd[] gourdBrothers;
    private ArrayList<Gourd> gourdBrothers;
    private Grandpa grandpa = new Grandpa();
    Heros(){
        gourdBrothers = new ArrayList<>(Arrays.asList(Gourd.values()));
        n = 7;
    }

    public void snake(BattleField battleField) {
        int length = battleField.length();
        for(int i = 0; i < n; i++){
            gourdBrothers.get(i).moveTo(battleField.at(length/2 - gourdBrothers.size()/2 + i,length/4));
        }
        grandpa.moveTo(battleField.at(length/2,0));
    }

    public void crane(BattleField battleField) {
        int length = battleField.length();
        for(int i = 0; i < n; i++) {
            if (i + 1 <= (n + 1)/2) {
                gourdBrothers.get(i).moveTo(battleField.at(length/2 - n/2 + i,length/4 - n/2 + i));
            } else {
                gourdBrothers.get(i).moveTo(battleField.at(length/2 - n/2 + i,length/4 - n/2 - (i - (n+1)/2) + 2));
            }
        }
        grandpa.moveTo(battleField.at(length/2,0));
    }
    public void wildGoose(BattleField battleField){
        int length = battleField.length();
        for(int i = 0; i < n; i++) {
            gourdBrothers.get(i).moveTo(battleField.at(length/2 - n/2 + i, length/4 - n/2 + n - i - 1));
        }
    }
    public void yoke(BattleField battleField){
        int length = battleField.length();
        for(int i = 0; i < n; i++){

        }
    }
    public void scale(BattleField battleField){
        ;
    }
    public void diamond(BattleField battleField){
        ;
    }
    public void crescent(BattleField battleField){
        ;
    }
    public void arrow(BattleField battleField){
        for(int i = 0; i < n; i++){
;           ;
        }
    }
}
