package Huluwa;

public class God {

    Huluwa []HuluBrothers;
    Creature []monsters;
    Snake snake;
//    Scorpion scorpion;
    GrandFather grandfather;


    public God(){
    }

    void initialize() {

        //初始化葫芦娃
        Huluwa daWa = new Huluwa(1, "老大", "红色",COLOR.RED);
        Huluwa erWa = new Huluwa(2, "老二", "橙色",COLOR.ORANGE);
        Huluwa sanWa = new Huluwa(3, "老三", "黄色",COLOR.YELLOW);
        Huluwa siWa = new Huluwa(4, "老四", "绿色",COLOR.GREEN);
        Huluwa wuWa = new Huluwa(5, "老五", "青色",COLOR.QING);
        Huluwa liuWa = new Huluwa(6, "老六", "蓝色",COLOR.BLUE);
        Huluwa qiWa = new Huluwa(7, "老七", "紫色",COLOR.PURPLE);

        HuluBrothers = new Huluwa[7];
        HuluBrothers[0] = daWa;
        HuluBrothers[1] = erWa;
        HuluBrothers[2] = sanWa;
        HuluBrothers[3] = siWa;
        HuluBrothers[4] = wuWa;
        HuluBrothers[5] = liuWa;
        HuluBrothers[6] = qiWa;

        monsters = new Creature[8];
        monsters[0] = new Scorpion("蝎子精");
        for(int i = 1;i < monsters.length;i++)
        {
            monsters[i] = new Monster("小妖");
        }   //初始化妖怪

        snake = new Snake("蛇精");
        grandfather = new GrandFather("爷爷");

    }

    public void lineUp(){
        initialize();
        Space queue = new Queue(HuluBrothers.length);
        MBuilder builder = new M1DBuilder();
        Sorter sorter = new BubbleSorter();
        Sorter sorter1 = new QuickSorter();


        builder.randomBuild(queue,HuluBrothers);
        ((Queue)queue).showName();
        sorter.sort((Queue)queue,PROPERTY.LEVEL);
        ((Queue)queue).showName();

        builder.clearPos(queue);
        builder.randomBuild(queue,HuluBrothers);
        ((Queue)queue).showColor();
        sorter1.sort((Queue)queue,PROPERTY.COLOR);
        ((Queue)queue).showColor();


    }

    public void carryOut()
    {
        initialize();//初始化生物

        Space matrix = new Matrix2D(15,15); //生成一个15*15的矩阵
        MBuilder builder = new M2DBuilder();
        builder.randomBuild(matrix,HuluBrothers);//随机安排

        MPoint startPoint1 = new MPoint2D(0,4);
        MFormation changShe = new M2DFormation((MPoint2D)startPoint1,HuluBrothers.length);
        ((M2DFormation)changShe).generateChangSheFormation();//生成长蛇阵
        builder.buildSpaceInForamtion(changShe,matrix,HuluBrothers);//建立阵型


        MPoint startPoint2 = new MPoint2D(8,4);
        MFormation fangYuan = new M2DFormation((MPoint2D)startPoint2,monsters.length);
        ((M2DFormation)fangYuan).generateFangYuanFormation();
        builder.buildSpaceInForamtion(fangYuan,matrix,monsters);//建立方圆阵

        ((Matrix2D)matrix).getPoisition(10,7).SetPeople(snake);
        ((Matrix2D)matrix).getPoisition(4,5).SetPeople(grandfather);//将蛇精和爷爷安排进去

        matrix.show();//展示

        System.out.println("--------------------------------------------------------------------------------------------");

        MPoint startPoint3 = new MPoint2D(14,4);
        MFormation heYi = new M2DFormation((MPoint2D)startPoint3,monsters.length);
        ((M2DFormation)heYi).generateHeYiFormation();
        builder.buildSpaceInForamtion(heYi,matrix,monsters);//建立鹤翼阵

        snake.getPosition().LetPeopleLeave();
        ((Matrix2D)matrix).getPoisition(14,6).SetPeople(snake);
        grandfather.getPosition().LetPeopleLeave();
        ((Matrix2D)matrix).getPoisition(4,5).SetPeople(grandfather);//安排蛇精和爷爷

        matrix.show();//展示

    }
}
