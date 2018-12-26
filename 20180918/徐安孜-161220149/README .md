#第二次作业说明
此次作业中共定义了三个类：
```
enum Calabash{
FIRST(1,"老大","赤"),
    SECOND(2,"老二","橙"),
    THIRD(3,"老三","黄"),
    FORTH(4,"老四","绿"),
    FIFTH(5,"老五","青"),
    SIXTH(6,"老六","蓝"),
    SEVENTH(7,"老七","紫");
    private  int id;
    private  String Name;
    private  String Color;
    Calabash(int i,String name,String color){
        id=i;
        Name=name;
        Color = color;
    }
    void ReportName(){...}
    void ReportColor(){...}
    void ReportLocation(int src,int dst){...}
}
```
枚举类Calabash用于描述葫芦娃，每个葫芦娃都有排行（id）、名字（name）、颜色（color）这些属性，并且可以报告自己的姓名、颜色、位置移动

```
class Sorter{

    void RandomSort(Calabash[] brothers) {...}
    void Swap(Calabash[] brothers,int i,int j){...}
    void BubbleSort(Calabash[] brothers){...}
    void BinarySort(Calabash[] brothers){...}
}
```
Sorter类是排序器，其中定义了各种排序方法
```
public class CalabashSort{

        public static void main(String[] args){
            Calabash[] brothers={
                    Calabash.FIRST,
                    Calabash.SECOND,
                    Calabash.THIRD,
                    Calabash.FORTH,
                    Calabash.FIFTH,
                    Calabash.SIXTH,
                    Calabash.SEVENTH,
            };
            Sorter grandpa=new Sorter();
           grandpa.RandomSort(brothers);
           System.out.println("排序前：");
           for(Calabash t:brothers)
               t.ReportName();
           System.out.println();
           grandpa.BubbleSort(brothers);
           for(Calabash t:brothers)
                t.ReportName();
           System.out.println();


           grandpa.RandomSort(brothers);
           System.out.println("排序前：");
            for(Calabash t:brothers)
                t.ReportColor();
            System.out.println();
           grandpa.BinarySort(brothers);
            for(Calabash t:brothers)
                t.ReportColor();
            System.out.println();
        }
}
```

主类CalabashSort中，创建了成员Calabash类型的数组描述葫芦七兄弟，实例化Sorter为grandpa，在此程序中，葫芦兄弟不会自己移动，排序器（grandpa）根据不同的算法对葫芦娃兄弟进行排序，并在适当的时候通知葫芦娃报告自己的信息
