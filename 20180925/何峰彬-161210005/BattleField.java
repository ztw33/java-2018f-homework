package homework3;

import homework3.creature.*;
import homework3.position.Position;

import java.util.Scanner;

public class BattleField {
    private static final int N = 20;
    private static final int NR_HULU = 7;
    private static final int NR_MONSTER = 20;

    private Position[][] positions = new Position[N][N];
    private HuLuWa[] huLuwas = new HuLuWa[NR_HULU];
    private Creature[] monsters = new Creature[NR_MONSTER + 1];

    public BattleField(){
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j ++){
                positions[i][j] = new Position(i, j);
            }
        }
        for(int i = 0; i < 7; i ++)
            huLuwas[i] = HuLuWa.getNewInstance();

        /**monster[0] is scorpion as leader*/
        monsters[0] = Scorpion.getInstance();
        for(int i = 1; i < monsters.length;i ++){
            monsters[i] = new Nobody();
        }

        Creature grandPa = GrandPa.getInstance();
        Creature snake = Snake.getInstance();
        positions[9][1].setCreature(grandPa);
        positions[9][18].setCreature(snake);
        changShe(4, 6);
    }

    private void clearMonsters(){
        for(Creature monster:monsters){
            if(monster.getPosition()!=null)
                monster.getPosition().setCreature(null);
            monster.setPosition(null);
        }
    }

    private void leadMonsters(int leaderX, int leaderY){
        clearMonsters();
        positions[leaderY][leaderX].setCreature(monsters[0]);
    }

    /** ZhenFa for HuLuWa*/
    private void changShe(int leaderX, int leaderY){
        for(int i = 0; i < huLuwas.length; i ++){
            positions[leaderY + i][leaderX].setCreature(huLuwas[i]);
        }
    }

    /**ZhenFa for monsters*/
    void heYi(int leaderX, int leaderY){
        leadMonsters(leaderX,leaderY);
        int count = 1;
        for(int i = 1; i < 3; i ++){
            positions[leaderY + i][leaderX + i].setCreature(monsters[count++]);
            positions[leaderY - i][leaderX + i].setCreature(monsters[count++]);
        }
    }

    void yanXing(int leaderX, int leaderY){
        leadMonsters(leaderX,leaderY);
        int count = 1;
        for(int i = 1; i < 4; i ++){
            positions[leaderY + i][leaderX + i].setCreature(monsters[count ++]);
            positions[leaderY - i][leaderX - i].setCreature(monsters[count ++]);
        }
    }

    void chongE(int leaderX, int leaderY){
        leadMonsters(leaderX,leaderY);
        int count = 1;
        for(int i = 1; i < 4; i ++){
            positions[leaderY-i][leaderX + i%2].setCreature(monsters[count ++]);
        }
        for(int i  = 1; i < 3; i ++){
            positions[leaderY+i][leaderX + i%2].setCreature(monsters[count ++]);
        }
    }

    void yuLin(int leaderX, int leaderY){
        leadMonsters(leaderX,leaderY);
        int count = 1;
        positions[leaderY][leaderX+1].setCreature(monsters[count ++]);
        positions[leaderY-1][leaderX+1].setCreature(monsters[count ++]);
        for(int i = 0; i < 5; i ++){
            positions[leaderY+2-i][leaderX+2].setCreature(monsters[count ++]);
        }
        for(int i = 0; i < 7; i ++){
            positions[leaderY+3-i][leaderX+3].setCreature(monsters[count++]);
        }
        positions[leaderY][leaderX+4].setCreature(monsters[count++]);
    }

    void fangYuan(int leaderX, int leaderY){
        leadMonsters(leaderX, leaderY);
        int count = 1;
        for(int i = 1; i < 3; i ++){
            positions[leaderY + i][leaderX+i].setCreature(monsters[count++]);
            positions[leaderY - i][leaderX+i].setCreature(monsters[count++]);
        }
        for(int i = 1; i < 2; i ++){
            positions[leaderY+i][leaderX+4-i].setCreature(monsters[count++]);
            positions[leaderY-i][leaderX+4-i].setCreature(monsters[count++]);
        }

        positions[leaderY][leaderX+4].setCreature(monsters[count++]);
    }

    void yanYue(int leaderX, int leaderY){
        leadMonsters(leaderX, leaderY);
        int count = 1;
        for(int i = 1; i < 5; i ++){
            positions[leaderY+i][leaderX+i].setCreature(monsters[count++]);
            positions[leaderY+i][leaderX+i+1].setCreature(monsters[count++]);
            positions[leaderY-i][leaderX+i].setCreature(monsters[count++]);
            positions[leaderY-i][leaderX+i+1].setCreature(monsters[count++]);
        }
        positions[leaderY+1][leaderX].setCreature(monsters[count++]);
        positions[leaderY-1][leaderX].setCreature(monsters[count++]);
        positions[leaderY][leaderX+1].setCreature(monsters[count++]);
        positions[leaderY][leaderX+2].setCreature(monsters[count++]);
    }

    void fengShi(int leaderX, int leaderY){
        leadMonsters(leaderX, leaderY);
        int count = 1;
        for(int i = 1; i < 7; i ++){
            positions[leaderY][leaderX+i].setCreature(monsters[count++]);
        }
        for(int i = 1; i < 4; i ++){
            positions[leaderY+i][leaderX+i].setCreature(monsters[count++]);
            positions[leaderY-i][leaderX+i].setCreature(monsters[count++]);
        }
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j ++){
                str+=positions[i][j];
            }
            str+="\n";
        }
        return str;
    }

    public static void main(String[] args){
        BattleField battleField = new BattleField();
        System.out.print(battleField);
        System.out.println("敵軍還有30秒到達戰場");
        Scanner in = new Scanner(System.in);
        System.out.println("1.鶴翼 2.雁行 3.衝軛 4.魚鱗 5.方円 6.偃月 7.鋒矢");
        System.out.print("請輸入您的選擇(-1退出):");
        do{
            int choice = in.nextInt();
            if(choice == -1)
                break;
            ZhenFa.values()[choice - 1].arrange(battleField);
            System.out.print(battleField);
            System.out.println("1.鶴翼 2.雁行 3.衝軛 4.魚鱗 5.方円 6.偃月 7.鋒矢");
            System.out.print("請輸入您的選擇(-1退出):");
        }while(in.hasNext());
    }
}
