package MotherEarthPack.Entity;

import HuluPack.Grandpa;
import HuluPack.SingleHuluBrother;
import MonsterPack.Goblin;
import MonsterPack.Scorpion;
import MonsterPack.Serpent;
import MotherEarthPack.Scientific.Coordinate;
import MotherEarthPack.Scientific.Creature;

public class Battlefield
{
    private static final int minBattleFieldSize = 10;  // 战场规模的最小值
    private int N;                                     // 战场规模
    private Creature[][] battleFieldMatrix;            // 战场矩阵

    public Battlefield(int N)
    {
        if( N < minBattleFieldSize )
        {
            System.out.println("剧本错误，战场规模太小，无法创建\n");
            return;
        }
        this.N = N;
        battleFieldMatrix = new Creature[N][N];
    }

    public int getN() {                                            // 获取战场规模
        return N;
    }

    public boolean haveCreature(Coordinate coordinate) {
        if(battleFieldMatrix[coordinate.getR()][coordinate.getC()] != null)
            return true;
        return false;
    }

    public boolean placeACreature(Creature creature, Coordinate coordinate)
    {
        if(haveCreature(coordinate))
            return false;
        battleFieldMatrix[coordinate.getR()][coordinate.getC()] = creature;
        return true;
    }

    public void ShowBattleField() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(battleFieldMatrix[i][j] == null) {
                    System.out.print("_     ");
                }
                else {
                    System.out.print(battleFieldMatrix[i][j].getName() + "  ");
                }
            }
            System.out.println();
        }
    }

}
