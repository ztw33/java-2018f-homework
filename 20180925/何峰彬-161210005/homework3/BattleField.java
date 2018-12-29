package homework3;

import homework3.creature.*;
import homework3.formation.*;
import homework3.position.Position;

import java.util.*;

public class BattleField {
    private static final int N = 20;
    private static final int NR_MONSTER = 20;

    List<List<Position<Creature>>> positions = new ArrayList<>();
    private List<HuLuWa> huLuwas;
    private List<Monster> monsters = new ArrayList<>();

    public BattleField(){
        for(int i = 0; i < N; i ++){
            List<Position<Creature>> row = new ArrayList<>();
            for(int j = 0; j < N; j ++){
                row.add(new Position<>(i, j));
            }
            positions.add(row);
        }
        huLuwas = HuLuWa.getNewInstances();

        /**monster.get(0) is scorpion as leader*/
        monsters.add(Scorpion.getInstance());
        for(int i = 0; i < NR_MONSTER;i ++){
            monsters.add(new Nobody());
        }

        Creature snake = Snake.getInstance();
        Creature grandPa = GrandPa.getInstance();
        positions.get(9).get(1).setObject(grandPa);
        positions.get(9).get(18).setObject(snake);
        changShe(4, 6);
    }

    public void setCreatureAt(int x, int y, Creature c){
        positions.get(x).get(y).setObject(c);
    }

    private void clearMonsters(){
        for(int i = 0 ; i < N; i ++){
            for(int j = 0; j < N; j ++){
                Creature creature = positions.get(i).get(j).getObject();
                if(creature != null
                        && !creature.getClass().equals(Snake.class)
                        &&creature.getClass().getSuperclass().equals(Monster.class))
                    positions.get(i).get(j).clear();
            }
        }
    }

    /** Formation for HuLuWa*/
    private void changShe(int leaderX, int leaderY){
        for(int i = 0; i < huLuwas.size(); i ++){
            positions.get(leaderY + i).get(leaderX).setObject(huLuwas.get(i));
        }
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j ++){
                str+=positions.get(i).get(j);
            }
            str+="\n";
        }
        return str;
    }

    private List<Monster> getMonsters(){
        return monsters;
    }

    public static void main(String[] args){
        BattleField battleField = new BattleField();
        List<Monster> monsters = battleField.getMonsters();
        List<Formation<Monster>> formations = new ArrayList<>();
        formations.add(new Heyi());
        formations.add(new Yanxing());
        formations.add(new Chonge());
        formations.add(new Yulin());
        formations.add(new Fangyuan());
        formations.add(new Yanyue());
        formations.add(new Fengshi());

        System.out.print(battleField);
        System.out.println("敵軍還有30秒到達戰場");
        Scanner in = new Scanner(System.in);
        System.out.println("1.鶴翼 2.雁行 3.衝軛 4.魚鱗 5.方円 6.偃月 7.鋒矢");
        System.out.print("請輸入您的選擇(-1退出):");
        do{
            int choice = in.nextInt();
            if(choice == -1)
                break;
            try {
                battleField.clearMonsters();
                formations.get(choice - 1).arrange(battleField, monsters.toArray(new Monster[0]));
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("糟糕的选择！怪物被吸入异空间了...");
            }
            System.out.print(battleField);
            System.out.println("1.鶴翼 2.雁行 3.衝軛 4.魚鱗 5.方円 6.偃月 7.鋒矢");
            System.out.print("請輸入您的選擇(-1退出):");
        }while(in.hasNext());
    }
}
