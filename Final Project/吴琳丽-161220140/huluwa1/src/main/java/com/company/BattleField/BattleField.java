package com.company.BattleField;

import com.company.Creature.Creature;
import java.io.Serializable;

public class BattleField implements Serializable {
    private Position[][] Field;
    private int M = 10;
    private int N = 18;
    private int goodnum;
    private int badnum;
    public BattleField(){
        Field = new Position[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Field[i][j] = new Position(i,j);
            }
        }
    }//创建一个全为空的战场
    public BattleField(BattleField bf) {
        Field = new Position[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Field[i][j] = new Position(i,j);
                Field[i][j].creature=new Creature(bf.Field[i][j].creature);
            }
        }
        goodnum=bf.goodnum;
        badnum=bf.badnum;
        M=bf.M;
        N=bf.N;
    }
    public void clearField(){
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Field[i][j] = new Position(i,j);
            }
        }
    }
    public void displayField(){
        for(int i = 0;i < M; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < N; j++) {
                Field[i][j].printpositionName();
            }
            System.out.println();
        }
    }

    public int getgoodnum() {
        return goodnum;
    }

    public int getbadnum() {
        return badnum;
    }

    public Position[][] getField() {
        return Field;
    }

    public void setgoodnumminus() {
        goodnum--;
    }

    public void setbadnumminus() {
        badnum--;
    }

    public void setgoodnum(int i) {
        goodnum=i;
    }
    public void setbadnum(int i) {
        badnum=i;
    }
}
