package Battle;

import java.util.Random;

class Position<T extends Creatures>{
    private T body;
    Position(){
        body=null;
    }

    T getBody(){
        return body;
    }

    void setBody(T a){
        body=a;
    }
}

public class BattleField {
    public static final int raw=17;
    public static final int col=17;
    public static Position<Creatures>[][] field=new Position[raw][col];     //定义为透明的战场

    private CbBrother[] cbBrothers=new CbBrother[7];
    private Soldier[] soldiers=new Soldier[Soldier.max];
    private Scorpion scorpion;
    private GrandPa grandPa;
    private Snake snake;

    BattleField(){
        try{
            for(int i=0;i<raw;i++){
                for(int j=0;j<col;j++){
                    field[i][j]=new Position<Creatures>();
                }
            }

            for(int i=0;i<7;i++){
                cbBrothers[i]=new CbBrother();
            }
            for(int i=0;i<Soldier.max;i++){
                soldiers[i]=new Soldier();
            }
            scorpion=new Scorpion();
            grandPa=new GrandPa();
            snake=new Snake();

            grandPa.moveto(0,0);
            snake.moveto(0,16);
        }catch (createException e){
            System.out.println("不能创建当前指定的生物体。");
        }
    }

    //葫芦娃队列的随机排序
    public void randomsort() {
        Random random = new Random();
        for (int i = 1; i < 7; i++) {
            int p = random.nextInt(i + 1);
            CbBrother temp = cbBrothers[i];
            cbBrothers[p].queueMove(cbBrothers,i);
            temp.queueMove(cbBrothers, p);
        }
    }

    //葫芦娃队列冒泡排序
    public void bubblesort() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7 - i - 1; j++) {
                if (cbBrothers[j].me.index > cbBrothers[j + 1].me.index) {
                    CbBrother temp = cbBrothers[j];
                    cbBrothers[j + 1].queueMove(cbBrothers, j);
                    temp.queueMove(cbBrothers, j + 1);
                }
            }
        }
    }

    //将当前葫芦娃队列在二维空间内摆成长蛇阵
    public void snaketeam(){
        for(int i=0;i<7;i++)
            cbBrothers[i].moveto(5+i,6);
    }

    //鹤翼阵
    public void cranewing(){
        scorpion.moveto(8,16);
        int i=0;
        for(int j=1;j<=6;j++) {
            soldiers[i++].moveto(8 - j, 16 - j);
            soldiers[i++].moveto( 8 + j, 16 - j);
        }
    }

    //锋矢阵
    public void arrow(){
        scorpion.moveto(8,10);
        int i=0;
        for(int j=1;j<=6;j++)
            soldiers[i++].moveto(8,10+j);
        for(int j=1;j<=3;j++){
            soldiers[i++].moveto(8-j,10+j);
            soldiers[i++].moveto(8+j,10+j);
        }
    }

    public void showField(){
        for(int i=0;i<raw;i++){
            for(int j=0;j<col;j++){
                if(field[i][j].getBody()==null){
                    System.out.print("     ");
                }
                else {
                    System.out.print(field[i][j].getBody().name);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //演示对峙过程
    public void demo(){
        System.out.println("葫芦娃:乱序长蛇阵    妖精:鹤翼阵");
        randomsort();
        snaketeam();
        cranewing();
        showField();

        System.out.println("葫芦娃:长蛇阵    妖精:鹤翼阵");
        bubblesort();
        snaketeam();
        showField();

        System.out.println("葫芦娃:长蛇阵    妖精:锋矢阵");
        arrow();
        showField();
    }
}
