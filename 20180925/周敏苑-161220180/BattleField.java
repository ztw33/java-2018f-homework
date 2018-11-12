public class BattleField {
    static char field[][] = new char[20][20];
    static void InitField(){                             //初始化战场
        for (int i =0 ;i<20;i++){
            for(int j = 0; j<20;j++){
                field[i][j] = '*';
            }
        }
    }

    boolean Isempty(int i, int j){
        if(field[i][j] == '*')
            return true;
        else
            return false;
    }

    static void Print_Battle(){
        field[Creature.grand_pa.Getx()][Creature.grand_pa.Gety()] = Creature.grand_pa.GetName();
        field[Creature.crab.Getx()][Creature.crab.Gety()] = Creature.crab.GetName();
        field[Creature.snaker_.Getx()][Creature.snaker_.Gety()] = Creature.snaker_.GetName();
        for(int i = 0 ;i < Creature.num; i++){
            field[Creature.soldier[i].Getx()][Creature.soldier[i].Gety()] = Creature.soldier[i].GetName();
        }
        for(int i = 0 ;i < 7; i++){
            field[Creature.calabash[i].Getx()][Creature.calabash[i].Gety()] = Creature.calabash[i].GetName();
        }
        for(int i = 0;i <20;i++){
            for(int j = 0; j<20;j++){
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    static void  Battle_Scheduler(){
        InitField();
        Creature.grand_pa.Lead_calabash();
        Creature.snaker_.Lead_soldier("arrow");
        Print_Battle();
        InitField();
        Creature.snaker_.Lead_soldier("goose");
        Print_Battle();
    }
}
