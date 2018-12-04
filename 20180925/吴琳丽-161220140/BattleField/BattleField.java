package com.company.BattleField;

public class BattleField {
    public Coordinate[][] Field;
    final int N = 15;
    public BattleField(){
        Field = new Coordinate[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Field[i][j] = new Coordinate(i,j);
            }
        }
    }//创建一个全为空的战场
    public void ClearField(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Field[i][j] = new Coordinate(i,j);
            }
        }
    }
    public void DisplayField(){
        for(int i = 0;i < N; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < N; j++) {
                Field[i][j].PrintcreatureName();
            }
            System.out.println();
        }
    }

}
