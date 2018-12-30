package com.Matrix;
import com.CalabashBoys.*;
import com.Monster.*;
import com.Grandfather.*;
import java.util.Random;

public class dimension {
    final static int COL = 25, ROW = 15;
    final static int Grand = 50, Scorp = 100, Snakk = 80, Frogg = 30;
    final static int Calab_1 = 1, Calab_2 = 2, Calab_3 = 3, Calab_4 = 4, Calab_5 = 5, Calab_6 = 6, Calab_7 = 7;
    int mat[][] = new int[ROW][COL];
    public dimension(){}
    public void Init(){
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                mat[i][j] = -1;              //init matrix
            }
        }
    }
    public void Clear(){
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                mat[i][j] = -1;             //clear matrix
            }
        }
    }

    public void ValuationMonster(Scorpion Scor, Frog[] frog){
        Random r = new Random();
        int formation = r.nextInt(7);
        //VECTOR(Scor, frog);
        //HOOKEDSPEAR(Scor, frog);
        //YUAN(Scor, frog);
        //SCALE(Scor, frog);
        //CHONEE(Scor, frog);
        //ECHELON(Scor, frog);
        switch (formation){
            case 0:
                ECD(Scor, frog);
                break;
            case 1:
                ECHELON(Scor, frog);
                break;
            case 2:
                CHONEE(Scor, frog);
                break;
            case 3:
                SCALE(Scor, frog);
                break;
            case 4:
                YUAN(Scor, frog);
                break;
            case 5:
                HOOKEDSPEAR(Scor, frog);
                break;
            case 6:
                VECTOR(Scor, frog);
                break;
            default:
                System.out.println("default");
                break;
        }
    }
    public void VECTOR(Scorpion Scor, Frog[] frog){
        Random r = new Random();
        int row = r.nextInt(ROW - 1);
        int col = r.nextInt(COL / 2 - 1);
        if (row < 2)
            row += 2;
        col += COL / 2;
        mat[row][col] = Scor.getIndex();
        mat[row - 1][col + 1] = Frogg;
        mat[row][col + 1] = Frogg;
        mat[row + 1][col + 1] = Frogg;
        mat[row - 2][col + 2] = Frogg;
        mat[row][col + 2] = Frogg;
     }
    public void HOOKEDSPEAR(Scorpion Scor, Frog[] frog){
        Random r = new Random();
        int row = r.nextInt(ROW - 2);
        int col = r.nextInt(COL / 2);
        if (row < 1)
            row += 1;
        col += COL / 2;
        mat[row][col] = Scor.getIndex();
        mat[row + 1][col] = Frogg;
        mat[row - 1][col + 1] = Frogg;
        mat[row][col + 1] = Frogg;
        mat[row + 1][col + 1] = Frogg;
        mat[row + 2][col + 1] = Frogg;
    }
    public void YUAN(Scorpion Scor, Frog[] frog){
        Random r = new Random();
        int row = r.nextInt(ROW - 2);
        int col = r.nextInt(COL / 2 - 2);
        if (row < 2)
            row += 2;
        col += COL / 2;
        mat[row][col] = Scor.getIndex();
        mat[row - 1][col + 1] = Frogg;
        mat[row + 1][col + 1] = Frogg;
        mat[row - 2][col + 2] = Frogg;
        mat[row + 2][col + 2] = Frogg;
        mat[row][col + 3] = Frogg;
    }
    public void SCALE(Scorpion Scor, Frog[] frog){
        Random r = new Random();
        int row = r.nextInt(ROW - 2);
        int col = r.nextInt(COL / 2 - 1);
        if (row < 2)
            row += 2;
        col += COL / 2;
        mat[row][col] = Scor.getIndex();
        mat[row - 1][col + 1] = Frogg;
        mat[row + 1][col + 1] = Frogg;
        mat[row - 2][col + 2] = Frogg;
        mat[row + 2][col + 2] = Frogg;
        mat[row][col + 2] = Frogg;
    }
    public void CHONEE(Scorpion Scor, Frog[] frog){
        Random r = new Random();
        int row = r.nextInt(ROW - 1);
        int col = r.nextInt(COL / 2 - 4);
        col += COL / 2;
        mat[row][col] = Scor.getIndex();
        mat[row + 1][col + 1] = Frogg;
        mat[row][col + 2] = Frogg;
        mat[row + 1][col + 3] = Frogg;
        mat[row][col + 4] = Frogg;
        mat[row + 1][col + 5] = Frogg;
    }
    public void ECHELON(Scorpion Scor, Frog[] frog){
        Random r = new Random();
        int row = r.nextInt(ROW);
        int col = r.nextInt(COL / 2 - 4);      //
        if (row < 5)
            row += 5;
        col += COL / 2;
        mat[row][col] = Scor.getIndex();
        mat[row - 1][col + 1] = Frogg;
        mat[row - 2][col + 2] = Frogg;
        mat[row - 3][col + 3] = Frogg;
        mat[row - 4][col + 4] = Frogg;
        mat[row - 5][col + 5] = Frogg;
    }
    public void ECD(Scorpion Scor, Frog[] frog){              //ECD
        Random r = new Random();
        int row = r.nextInt(ROW - 2);
        int col = r.nextInt(COL / 2 - 2);
        if (row < 3)
            row += 3;
        col += COL / 2;                         //another side
        mat[row][col] = Scor.getIndex();
        //int len = frog.length;
        //int value = frog[0].getIndex();
        mat[row - 1][col + 1] = Frogg;
        mat[row + 1][col + 1] = Frogg;
        mat[row - 2][col + 2] = Frogg;
        mat[row + 2][col + 2] = Frogg;
        mat[row - 3][col + 3] = Frogg;
     }
    public void ValuationSnake(Snake Snak){
        Random r = new Random();
        while(true){
            int row = r.nextInt(ROW);
            int col = r.nextInt(COL / 2);
            col += COL / 2;
            if (IsEmpty(row, col)){
                mat[row][col] = Snak.getIndex();
                break;
            }
        }
    }
    public void ValuationGrandfather(Grandfather Gran){
        Random r = new Random();
        while(true){
            int row = r.nextInt(ROW);
            int col = r.nextInt(COL / 2);
            if (IsEmpty(row, col)){
                mat[row][col] = Gran.getIndex();
                break;
            }
        }
    }
    public void ValuationCalabash(Calabash Cala){              //init calabashboys
        Random r = new Random();
        int row = r.nextInt(ROW);                     //random row
        int col = r.nextInt(COL / 4);        //random col
        for (int i = 0; i < Cala.NumOfBabys(); i++){
            mat[row][col] = Cala.IndexOfBabys(Cala.NumOfBabys() - i - 1); //
            col++;
        }
    }
    public void printMatrix(){
        System.out.println("The CalashBoys is NUMBER.");
        System.out.println("The Grandfather is G.");
        System.out.println("The Scorpion is D.");
        System.out.println("The Snake is S.");
        System.out.println("The Frog is F.");
        System.out.println("Input 5 to continue the next circulation.");
        System.out.println("Input 0 to kill the program.");
        for (int i = 0; i < ROW; i ++){
            for (int j = 0; j < COL; j++){
                switch(mat[i][j]){
                    case -1:
                        System.out.print("· ");
                        break;
                    case Calab_1:
                        System.out.print("1  ");
                        break;
                    case Calab_2:
                        System.out.print("2  ");
                        break;
                    case Calab_3:
                        System.out.print("3  ");
                        break;
                    case Calab_4:
                        System.out.print("4  ");
                        break;
                    case Calab_5:
                        System.out.print("5  ");
                        break;
                    case Calab_6:
                        System.out.print("6  ");
                        break;
                    case Calab_7:
                        System.out.print("7  ");
                        break;
                    case Grand:
                        System.out.print("G  ");
                        break;
                    case Scorp:
                        System.out.print("D  ");
                        break;
                    case Snakk:
                        System.out.print("S  ");
                        break;
                    case Frogg:
                        System.out.print("F  ");
                        break;
                    default:
                        System.out.print("default");
                        break;
                }
            }
            System.out.println("");
        }
    }
    public boolean IsEmpty(int X, int Y){                  //return true while mat[X][Y] == -1
        if (mat[X][Y] == -1)
            return true;
        else
            return false;
    }
    public void ValuationXY(int X, int Y, int value){   //mat[X][Y] = value
        mat[X][Y] = value;
    }
}
