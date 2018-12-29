package com.company.BattleField;
import com.company.Being.*;
import com.company.Coordinate.Coordinate;
public class BattleField {
    public Coordinate[][] battlefield;
    final int N=25;
    public BattleField(){
        battlefield =new Coordinate[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++){
                battlefield[i][j]=new Coordinate(i,j);
            }
        }
    }
    public void clearBattleField(){
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++){
                battlefield[i][j]=new Coordinate(i,j);
            }
        }
    }
    public void displayBattleField(){
        for(int j=0;j<N;j++) {
            System.out.print(j + " ");{
            for(int i=0;i<N;i++){
                if(battlefield[j][i].isEmpty==false)
                     battlefield[j][i].printBeingName();
                else
                    System.out.print(" ");
            }
            }
            System.out.println();
        }
    }
}
