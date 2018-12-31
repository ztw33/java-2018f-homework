package Battle;

public class BattleField {
    LifeEntity[][] ground=new LifeEntity[17][17];   //二维空间
    CalabashBrother[] cb=new CalabashBrother[7];    //葫芦娃队列
    Grandpa gp=Grandpa.gp_birth();                  //老爷爷
    Snake se=Snake.se_birth();                      //蛇精
    Scorpion sp=Scorpion.sp_birth();                //蝎子精
    Little[] lm=new Little[12];                     //12只小喽啰

    //初始化战场信息,加入各个生命体
    BattleField(){
        for(int i=0;i<7;i++)
            cb[i]=CalabashBrother.cb_birth();
        for(int i=0;i<12;i++)
            lm[i]=new Little();

        //将老爷爷和蛇精分别置于二维空间的左上角和右上角
        gp.twomove(ground,0,0);
        se.twomove(ground,0,16);
    }

    //打印输出对峙局面
    public void showfield(){
        for(int i=0;i<17;i++){
            for(int j=0;j<17;j++){
                if(ground[i][j]==null)
                    System.out.print("     ");
                else {
                    System.out.print(ground[i][j].label);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //作业要求的步骤
    public void demonstration(){
        System.out.println("葫芦娃:乱序长蛇阵    妖精:鹤翼阵");
        gp.randomsort(cb);
        gp.snaketeam(ground,cb);
        se.cranewing(ground,sp,lm);
        showfield();

        System.out.println("葫芦娃:长蛇阵    妖精:鹤翼阵");
        gp.bubblesort(cb);
        gp.snaketeam(ground,cb);
        showfield();

        System.out.println("葫芦娃:长蛇阵    妖精:锋矢阵");
        se.arrow(ground,sp,lm);
        showfield();
    }
}
