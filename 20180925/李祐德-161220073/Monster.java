import java.util.*;
public class Monster extends Group {
    static Serpent SERPENT;
    static Scorpion SCORPION;
    //static Minion[] minions;
    static ArrayList<Minion> minions;
    int num_of_minion;
    Monster() {
        num_of_minion = 100;
        SCORPION = new Scorpion();
        SERPENT = new Serpent();
        minions = new ArrayList<>(Arrays.asList(new Minion[num_of_minion]));
        for(int i = 0; i < num_of_minion; i++) {
            minions.set(i, new Minion());
        }
    }
    public void reformate(){
        for(int i = 0; i < num_of_minion; i++){
            minions.get(i).fallBack();
        }
        SERPENT.fallBack();
        SCORPION.fallBack();
    }
    public void snake(BattleField battleField){
        reformate();
        int length = battleField.length();
        int n = 6;
        SCORPION.moveTo(battleField.at(length / 2 , length * 3 / 4));
        for(int i = 0; i < n; i++) {
            if (i < n / 2) {
                minions.get(i).moveTo(battleField.at(length / 2 - n / 2 + i, length * 3 / 4));
            } else {
                minions.get(i).moveTo(battleField.at(length / 2 - n / 2 + i + 1, length * 3 / 4));
            }
        }
        SERPENT.moveTo(battleField.at(length/2, length - 1));
    }
    public void crane(BattleField battleField){
        reformate();
        int n = 6;
        int length = battleField.length();
        SCORPION.moveTo(battleField.at(length/2, length*3/4));
        for(int i = 0; i < n; i++) {
            if (i + 1 <= (n + 1)/2) {
                minions.get(i).moveTo(battleField.at(length/2 - n/2 + i,length*3/4 - n/2 + i));
            } else {
                minions.get(i).moveTo(battleField.at(length/2 - n/2 + i + 1,length*3/4 - n/2 - (i - (n+1)/2) + 2));
            }
        }
        SERPENT.moveTo(battleField.at(length/2,length - 1));
    }
    public void wildGoose(BattleField battleField){
        int n = 6;
        int length = battleField.length();
        SCORPION.moveTo(battleField.at(length/2, length*3/4));
        for(int i = 0; i < n; i++) {
            if (i < n / 2) {
                minions.get(i).moveTo(battleField.at(length / 2 - n / 2 + i, length*3 / 4 - n / 2 + n - i - 1));
            } else {
                minions.get(i).moveTo(battleField.at(length / 2 - n / 2 + i + 1, length*3 / 4 - n / 2 + n - i));
            }
        }
        SERPENT.moveTo(battleField.at(length/2, length - 1));
    }
    public void yoke(BattleField battleField){
        int n = 6;
        int length = battleField.length();
        SCORPION.moveTo(battleField.at(length/2, length*3/4));
        for(int i = 0; i < n; i++) {
            if (i < n / 2) {
                minions.get(i).moveTo(battleField.at(length / 2 - n/2 + i, length * 3 / 4 + i % 2 - 1));
            } else {
                minions.get(i).moveTo(battleField.at(length / 2 - n/2 + i + 1, length * 3 / 4 + (i + 1) % 2 - 1));
            }
        }
        SERPENT.moveTo(battleField.at(length/2, length - 1));
    }
    public void scale(BattleField battleField){
        int n = 6;
        int length = battleField.length();
        int col = 3;
        int cur = 0;
        for(int i = 1; i <= col; i++){
            for(int j = 0; j < i; j++){
                minions.get(cur).moveTo(battleField.at(length/2 -  i + 1 + 2*j, length/2 + col / 2 + i));
                cur++;
            }
        }
        SCORPION.moveTo(battleField.at(length/2, length/2 + col + 2));
        SERPENT.moveTo(battleField.at(length/2, length - 1));
    }
    public void diamond(BattleField battleField){
        int n = 9;
        int length = battleField.length();
        int col = 5;
        int cur = 0;
        for(int i = 1; i <= col; i++){
            if(i == 1 || i == col){
                minions.get(cur).moveTo(battleField.at(length/2, length / 2 + i - 1));
                cur++;
            } else {
                if (i <= col / 2 + 1) {
                    minions.get(cur).moveTo(battleField.at(length / 2 - i + 1, length / 2 + i - 1));
                    cur++;
                    minions.get(cur).moveTo(battleField.at(length / 2 + i - 1, length / 2 + i - 1));
                    cur++;
                } else {
                    minions.get(cur).moveTo(battleField.at(length / 2 - (col - i), length / 2 + i - 1));
                    cur++;
                    minions.get(cur).moveTo(battleField.at(length / 2 + (col - i), length / 2 + i - 1));
                    cur++;
                }
            }
        }
        SCORPION.moveTo(battleField.at(length/2, length/2 + col / 2));
        SERPENT.moveTo(battleField.at(length/2, length - 1));
    }
    public void crescent(BattleField battleField) {
        int n = 19;
        int col = 3;
        int cur = 0;
        int length = battleField.length();
        for(int i = 1; i <= col; i++){
            if(i == 1){
                minions.get(cur).moveTo(battleField.at(length / 2 - 1, length / 2 + 1));
                cur++;
                minions.get(cur).moveTo(battleField.at(length / 2 , length / 2 + 1));
                cur++;
                minions.get(cur).moveTo(battleField.at(length / 2 + 1, length / 2 + 1));
                cur++;
            } else {
                minions.get(cur).moveTo(battleField.at(length / 2 - 1, length / 2 + 1 + i - 1));
                cur++;
                minions.get(cur).moveTo(battleField.at(length / 2 , length / 2 + 1 + i - 1));
                cur++;
                minions.get(cur).moveTo(battleField.at(length / 2 + 1, length / 2 + 1 + i - 1));
                cur++;
                for(int j = 0; j < i; j++){
                    minions.get(cur).moveTo(battleField.at(length/2 - (j + 2), length / 2 + 1 + i - 1 + j + 1));
                    cur++;
                }
                for(int j = 0; j < i; j++){
                    minions.get(cur).moveTo(battleField.at(length/2 + (j + 2), length / 2 + 1 + i - 1 + j + 1));
                    cur++;
                }
            }
        }
        SCORPION.moveTo(battleField.at(length/2, length/2));
        SERPENT.moveTo(battleField.at(length/2, length - 1));
    }
    public void arrow(BattleField battleField){
        int n = 12;
        int col = 6;
        int cur = 0;
        int length = battleField.length();
        for(int i = 0; i < col; i++){
            minions.get(cur).moveTo(battleField.at(length/2, length/2 + i));
            cur++;
            if(i != 0 && i <= col/2){
                minions.get(cur).moveTo(battleField.at(length/2 - i, length/2 + i));
                cur++;
                minions.get(cur).moveTo(battleField.at(length/2 + i, length/2 + i));
            }
        }
        SCORPION.moveTo(battleField.at(length/2, length - 2));
        SERPENT.moveTo(battleField.at(length/2, length - 1));
    }
}