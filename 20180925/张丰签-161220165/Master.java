import java.awt.*;
import java.util.*;

public class Master {
    private int size;
    private int soldier_num;
    private BattleField battleField;
    private Formation formation;
    private BrotherAct brotherAct;
    private Snake snake;
    private Grandpa grandpa;
    private Soldier[] soldiers;
    private Leader leader;
    Master(){
        System.out.println("请输入N（N>20，否则N默认为20）");
        Scanner sc = new Scanner(System.in);
        size=sc.nextInt();
        System.out.println("请蝎子小兵的个数");
        sc = new Scanner(System.in);
        soldier_num=sc.nextInt();
        sc.close();

        battleField=new BattleField(size);
        brotherAct=new BrotherAct();
        snake=new Snake();
        grandpa=new Grandpa();
        leader=new Leader();
        soldiers=new Soldier[soldier_num];
        for(int i=0;i<soldier_num;i++){
            soldiers[i]=new Soldier(11+i);
        }
    }
    public void change_formation(){
        for(int i=1;i<=6;i++){
            battleField.clear_all();
            formation=new Formation(i,battleField,size,soldier_num);
            for(int m=0;m<size;m++){
                for(int n=0;n<size;n++){
                    int cur_num=battleField.show_one(m,n);
                    if(cur_num>=1&&cur_num<=7){
                        brotherAct.brother_move(cur_num,m,n);
                        System.out.print(brotherAct.brother_name(cur_num)+"  ");
                    }
                    else if(cur_num==8){
                        grandpa.move(m,n);
                        System.out.print(grandpa.get_name()+"  ");
                    }
                    else if(cur_num==9){
                        leader.move(m,n);
                        System.out.print(leader.get_name()+"  ");
                    }
                    else if(cur_num==10){
                        snake.move(m,n);
                        System.out.print(snake.get_name()+"  ");
                    }
                    else if(cur_num>10){
                        soldiers[cur_num-11].move(m,n);
                        System.out.print(soldiers[cur_num-11].get_name()+"  ");
                    }
                    else{
                        System.out.print("空    ");
                    }
                }
                System.out.println();
            }
            System.out.println("-------------------------------------------");
        }
    }
}

