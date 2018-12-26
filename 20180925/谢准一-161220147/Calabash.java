import java.util.*;
import Being.*;
import Field.*;

public class Calabash {
    // main controller in the program
    /*
    * god class
    * function:
    * 1. create objects, including calabash_brother, grandpa, serpent and scorpion
    * 2. join the objects in certain formation, a formation is also considered as an object
    * 3. put objects in the battle field*/
    public static boolean[] FormationUsed = new boolean[3];


    public static Formation PutEnemyField() {
        Formation a = Formation.YanXing;
        Random ra = new Random();
        int temp = ra.nextInt(3);
        while(FormationUsed[temp] == true) {
            temp = ra.nextInt(3);
        }
        FormationUsed[temp] = true;
        Formation[] value = Formation.values();
        for(Formation formation:value) {
            temp--;
            if(temp < 0) {
                a = formation;
                break;
            }
        }
        BattleField.battlefield[a.XieZiJing.getX()][a.XieZiJing.getY()] = a.XieZiJing.getSymbol();
        int i = 0;
        while(i < a.louluo.size()) {
            int x = a.louluo.get(i).getX();
            int y = a.louluo.get(i).getY();
            BattleField.battlefield[x][y] = a.louluo.get(i).getSymbol();
            i++;
        }
        return a;
    }
    public static void CleanField(Formation a) {
        BattleField.battlefield[a.XieZiJing.getX()][a.XieZiJing.getY()] = '-';
        int i = 0;
        while(i < a.louluo.size()) {
            BattleField.battlefield[a.louluo.get(i).getX()][a.louluo.get(i).getY()] = '-';
            i++;
        }
    }
    public static void main(String []argv) {
        grandpa Pa = new grandpa(10, 0);
        Serpent Ser = new Serpent(10, 19);
        BattleField field = new BattleField();
        CbFormation cbfor = new CbFormation();

        PlaceObjToField.PutToField(Pa);
        PlaceObjToField.PutToField(Ser);
        cbfor.CbSetLongLineArray();

        for(int i = 0; i < cbfor.CbList.size(); i++)
            PlaceObjToField.PutToField(cbfor.CbList.get(i));

        int i = 1;
        while(i <= 3) {

            System.out.println("Changing formation, waiting");
            Formation forNow = PutEnemyField();
            field.printField();

            CleanField(forNow);
            i++;
            try {
                Thread.currentThread().sleep(1000);
            }catch(InterruptedException e) {}
        }
        return;

    }
}

