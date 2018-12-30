package Field;

public class BattleField {
    public static char[][] battlefield = new char[20][20];
    public BattleField() {
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 20; j++)
                battlefield[i][j] = '-';

    }
    public char[][] getBattlefield() {
        return battlefield;
    }
    public void printField() {
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
}
