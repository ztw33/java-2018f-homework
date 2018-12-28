package Homework.CalabashBrothers_2;

public class FormationMaker {

    private char[][] formation;
    private int length;
    private int width;
    //private final int MAX_CALABASH_BOYS_COUNT = 7;

    public void singleLineBattleArray(CalabashBoy[] calabashBoysArray){
        length = 7; width = 2;
        formation = new char[length][width];
        for(int i = 0; i < length; i++)
            formation[i] = calabashBoysArray[i].name.toCharArray();
    }

    private static void dogFaceName(char[][] f,int  i, int j){
        if(j%3==0)
            f[i][j] = '小';
        else if(j%3==1)
            f[i][j] = '喽';
        else
            f[i][j] = '啰';
    }

    public void crescentMoonArray(){
        length = 9; width = 12;
        formation = new char[length][width];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++) {
                if ((i == 0 || i == 8) && j > width - 4)
                    dogFaceName(formation, i, j);
                else if ((i == 1 || i == 7) && (j > width - 7 && j < width - 3))
                    dogFaceName(formation, i, j);
                else if ((i == 2 || i == 6) && (j > width - 10 && j < width - 3))
                    dogFaceName(formation, i, j);
                else if ((i == 3 || i == 5) && j < width - 6)
                    dogFaceName(formation, i, j);
                else if(i==4&&(j > width - 10 && j < width - 6))
                    dogFaceName(formation, i, j);
                else
                    formation[i][j] = '一';
            }
        }
        formation[4][0] = '蝎';
        formation[4][1] = '子';
        formation[4][2] = '精';
    }

    public void fangRArray(){
        length = 5; width = 15;
        formation = new char[length][width];
        for(int i = 0; i < length; i++){
            for(int j = 0; j<width;j++){
                if((i==0||i==4)&&(j>width-10&&j<width-6))
                    dogFaceName(formation, i, j);
                else if((i==1||i==3)&&((j>width-13&&j<width-9)||(j>width-7&&j<width-3)))
                    dogFaceName(formation, i, j);
                else if(i==2&&j>width-4)
                    dogFaceName(formation, i, j);
                else
                    formation[i][j] = '一';
            }
        }
        formation[2][0] = '蝎';
        formation[2][1] = '子';
        formation[2][2] = '精';
    }

    public char[][] getFormation(){
        return formation;
    }

    public int getLength(){
        return length;
    }

    public int getWidth(){
        return width;
    }

}
