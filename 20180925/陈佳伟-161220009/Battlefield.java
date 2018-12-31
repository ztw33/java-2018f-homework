package Homework.CalabashBrothers_2;

public class Battlefield {
    private final int MAX_LENGTH = 12;
    private final int MAX_WIDTH = 45;
    private char[][] battlefield = new char[MAX_LENGTH][MAX_WIDTH];
    public void init(){
        for(int i = 1; i < MAX_LENGTH-1;i++)
            for(int j = 1; j < MAX_WIDTH-1; j++)
                battlefield[i][j] = '一';
        for(int i = 0; i < MAX_WIDTH; i++){
            battlefield[0][i] = '一';
            battlefield[MAX_LENGTH-1][i] = '一';
        }
        for(int i = 0; i < MAX_LENGTH; i++){
            battlefield[i][0] = '卜';
            battlefield[i][MAX_WIDTH-1] = '卜';
        }
    }
    void showBattlefield(){
        for(int i = 0; i < MAX_LENGTH; i++)
            System.out.println(battlefield[i]);
        System.out.println();
        System.out.println();
    }

    void setFormation(int row, int col, FormationMaker formationMaker){
        for(int i = row; i < formationMaker.getLength()+row;i++){
            for(int j = col; j < formationMaker.getWidth()+col;j++){
                battlefield[i][j] = formationMaker.getFormation()[i-row][j-col];
            }
        }
    }

    void setFormation(int row, int col, char[] roleName){
        System.arraycopy(roleName, 0, battlefield[row], col, roleName.length);
    }

}
