import java.util.*;
public class Main {
    public static void main(String[] args){
        HuluBrothers Queue=new HuluBrothers();
        Queue.Initialize();
        System.out.println("-------冒泡排序-------");
        Queue.Shuffle();//所输入的这一串序列即为 七兄弟站队所排成的一列（数字即为排行）
        Queue.bubbleSort();
        System.out.print("冒泡排序结束（按排行报数）：");
        for(int i=0;i<7;i++)
        System.out.print(Queue.BrothersArray[i].order+" ");
        System.out.println() ;
        HuluBrothers Queue1=new HuluBrothers();
        Queue1.Initialize();
        System.out.println("-------二分法排序-------");
        Queue1.Shuffle();
        Queue1.quickSort();
        System.out.print("二分法排序结束（按颜色报数）：");
        for(int i=0;i<7;i++)
            System.out.print(Queue.BrothersArray[i].color+" ");
        System.out.println() ;
    }
}
