import java.util.Random;

public class Calabash {
    // main controller in the program
    /*
    * god class
    * function:
    * 1. create objects, including calabash_brother, grandpa, serpent and scorpion
    * 2. join the objects in certain formation, a formation is also considered as an object
    * 3. put objects in the battle field*/
    public static boolean[] FormationUsed = new boolean[3];
    public static char[][] battlefield = new char[20][20];


    public static void PrintField(){
        for(int i = 0; i < 20; i++) {
            System.out.printf("%2d",i + 1);
            for(int j = 0; j < 20; j++) {
                System.out.print(' ');
                System.out.print(battlefield[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initialize(grandpa pa, Serpent ser) {
        for(int i = 0; i < 20; i++)
            for(int j = 0; j < 20; j++)
                Calabash.battlefield[i][j] = '-';
        for(int i = 0; i < 3; i++)
            FormationUsed[i] = false;
        pa.set_position(10,0);
        Calabash.battlefield[10][0] = pa.return_symbol();
        ser.set_position(10,19);
        Calabash.battlefield[10][19] = ser.return_symbol();
    }
    public static void PutCbField(Brother[] list_0) {
        for(int i = 0; i < list_0.length; i++){
            int temp_x = list_0[i].get_x();
            int temp_y = list_0[i].get_y();
            Calabash.battlefield[temp_x][temp_y] = list_0[i].get_symbol();
        }
    }
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
        a.XieZiJing.StandToField();
        int i = 0;
        while(i < a.louluo.size()) {
            a.louluo.get(i).StandToField();
            i++;
        }
        return a;
    }
    public static void CleanField(Formation a) {
        battlefield[a.XieZiJing.GetX()][a.XieZiJing.GetY()] = '-';
        int i = 0;
        while(i < a.louluo.size()) {
            battlefield[a.louluo.get(i).getX()][a.louluo.get(i).getY()] = '-';
            i++;
        }
    }
    public static void main(String []argv) {
        grandpa Pa = new grandpa();
        Serpent Ser = new Serpent();
        initialize(Pa, Ser);
        CbFormation cbfor = new CbFormation();
        cbfor.CbSetLongLineArray();
        PutCbField(cbfor.CbList);
        int i = 1;
        while(i <= 3) {

            System.out.println("Changing formation, waiting");
            Formation forNow = PutEnemyField();
            PrintField();

            CleanField(forNow);
            i++;
            try {
                Thread.currentThread().sleep(1000);
            }catch(InterruptedException e) {
            }
        }
        return;

    }
}

