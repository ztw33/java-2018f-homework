import java.lang.Math.*;

class CalabashBrothersSort{
    public static void sortByName(CalabashBrothers[] brothers)/**冒泡法*/
    {
        for(int i = 0; i < brothers.length; i++)
        {
            for(int j = i + 1; j < brothers.length; j++)
            {
                if(brothers[i].rank>brothers[j].rank)
                {
                    brothers[i].reportSwap(i,j);
                    brothers[j].reportSwap(j,i);
                    CalabashBrothers.swapPosition(brothers,i,j);
                }
            }
        }
    }

    public static void sortByColor(CalabashBrothers[] brothers)/**二分法*/
    {
        for(int i=1;i<brothers.length;i++)
        {
            if(brothers[i].rank<brothers[i-1].rank)
            {
                int left=0;
                int right=i-1;
                while (left<=right)
                {
                    int mid = (left + right) / 2;
                    if (brothers[i].rank < brothers[mid].rank)
                    {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                brothers[i].reportSwap(i,left);
                CalabashBrothers temp=brothers[i];
                for(int j = i; j > left; j--)
                {
                brothers[j-1].reportSwap(j-1,j);
                brothers[j]=brothers[j-1];
                }
            brothers[left]=temp;
            }
        }
    }
}
public enum CalabashBrothers {/**创始人：陈剑豪 创建时间：2018.9.18*/
    BigBrother("老大","红色",1),SecondBrother("老二","橙色",2),ThirdBrother("老三","黄色",3),FourthBrother("老四","绿色",4),
    FifthBrother("老五","青色",5), SixthBrother("老六","蓝色",6),SeventhBrother("老七","紫色",7);
    String name;// 葫芦娃的名字
    String color;// 葫芦娃的颜色
    int rank;// 葫芦娃中的排行
    CalabashBrothers(String name,String color,int rank)
    {
        this.name =name;
        this.color=color;
        this.rank=rank;
    }
    public static void swapPosition(CalabashBrothers[] brothers,int i,int j)/**两个葫芦娃交换位置*/
    {

        CalabashBrothers temp=CalabashBrothers.BigBrother;
        temp=brothers[i];
        brothers[i]=brothers[j];
        brothers[j]=temp;
    }

    public void reportName()/**报名字*/
    {
        System.out.println(name);
    }
    public void reportColor()/**报颜色*/
    {
        System.out.println(color);
    }
    public void reportSwap(int i,int j)/**报位置改变*/
    {
        System.out.println(name + ":" + i + "->" + j);
    }
    public static void main(String[] args)/**程序测试入口*/
    {
        // 让葫芦娃随便站队
        CalabashBrothers[] brothers={BigBrother, SeventhBrother,FifthBrother,ThirdBrother,FourthBrother,SecondBrother,
                SixthBrother};
        // 冒泡法以姓名排序
        System.out.println("排序中报告位置改变:");
        CalabashBrothersSort.sortByName(brothers);
        System.out.println("排序后按姓名报数：");
        for(CalabashBrothers s:brothers)
            s.reportName();

        // 再次让葫芦娃打乱位置
        for(int i=0;i<7;i++) {
            int num1 = (int) (Math.random() * 7);
            int num2 = (int) (Math.random() * 7);
            CalabashBrothers.swapPosition(brothers,num1,num2);
        }
        System.out.println("再次随机后位置：");
        for(CalabashBrothers s:brothers)
            s.reportName();

        // 二分法以颜色排序
        System.out.println("排序中报告位置改变:");
        CalabashBrothersSort.sortByColor(brothers);
        System.out.println("排序后按颜色报数：");
        for(CalabashBrothers s:brothers)
            s.reportColor();
    }
}
