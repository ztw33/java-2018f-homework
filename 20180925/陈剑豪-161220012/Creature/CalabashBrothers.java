package Creature;

import BattleField.Existance;
import BattleField.Space;

/**
 * @ Author     ：cjh
 * @ Description：葫芦娃
 */

public class CalabashBrothers extends Creature{
    String color;// 葫芦娃的颜色
    int rank;// 葫芦娃中的排行
    CalabashBrothers(int i)
    {
        init();
        this.color = CalabashEnum.values()[i].getColor();
        this.name =CalabashEnum.values()[i].getName();
        this.rank = CalabashEnum.values()[i].getRank();
        list.add(this);
    }
    @Override
    public void standOnMap(int i,int j)
    {
        row=i;
        column=j;
        switch(rank)
        {
            case 1:
                Space.space[i][j]= Existance.bigbrother;
                break;
            case 2:
                Space.space[i][j]=Existance.secondbrother;
                break;
            case 3:
                Space.space[i][j]=Existance.thirdbrother;
                break;
            case 4:
                Space.space[i][j]=Existance.fourthbrother;
                break;
            case 5:
                Space.space[i][j]=Existance.fifthbrother;
                break;
            case 6:
                Space.space[i][j]=Existance.sixthbrother;
                break;
            case 7:
                Space.space[i][j]=Existance.seventhbrother;
                break;
        }
    }

    public static void swapPosition(CalabashBrothers[] brothers,int i,int j)/**两个葫芦娃交换位置*/
    {
        CalabashBrothers temp;
        temp=brothers[i];
        brothers[i]=brothers[j];
        brothers[j]=temp;
    }

    public void reportColor()/**报颜色*/
    {
        System.out.print(color+"  ");
    }
    public void reportSwap(int i,int j)/**报位置改变*/
    {
        System.out.println(name + ":" + i + "->" + j);
    }
    public static CalabashBrothers[] birth()/**葫芦娃出生（随机顺序）*/
    {
        CalabashBrothers[] brothers=new CalabashBrothers[7];
        for(int i=0;i<7;i++)
        {
            brothers[i]=new CalabashBrothers(i);
        }
        for(int i=0;i<7;i++)
        {
            int num1 = (int) (Math.random() * 7);
            int num2 = (int) (Math.random() * 7);
            CalabashBrothers.swapPosition(brothers,num1,num2);
        }
        return brothers;
    }
    public static void main(String[] args)/**程序测试入口*/
    {
        // 让葫芦娃随便站队
        CalabashBrothers[] brothers=CalabashBrothers.birth();
        // 冒泡法以姓名排序
        System.out.println("排序中报告位置改变:");
        CalabashBrothersSort.sortByName(brothers);
        System.out.println("排序后按姓名报数：");
        for(CalabashBrothers s:brothers)
            s.reportName();

        // 再次让葫芦娃打乱位置
        brothers=CalabashBrothers.birth();
        /*
        for(int i=0;i<7;i++) {
            int num1 = (int) (Math.random() * 7);
            int num2 = (int) (Math.random() * 7);
            CalabashBrothers.swapPosition(brothers,num1,num2);
        }*/
        System.out.println();
        System.out.println("再次随机后位置：");
        for(CalabashBrothers s:brothers)
            s.reportName();
        System.out.println();
        // 二分法以颜色排序
        System.out.println("排序中报告位置改变:");
        CalabashBrothersSort.sortByColor(brothers);
        System.out.println("排序后按颜色报数：");
        for(CalabashBrothers s:brothers)
            s.reportColor();
    }
}
