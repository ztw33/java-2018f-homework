# 第二次作业分析

标签（空格分隔）： JavaHw

---
##类的建立
本次作业根据需求建立两个类，分别为Cala（存储葫芦娃数据），Grandfather(作为控制端)。
###Cala类
分析得到葫芦娃的特征是绑定且静态的，故采取枚举类对建立Cala类，参数为位置，名称，颜色。
并且建立一个方法，使得葫芦娃本身具有移动到某位置的能力
```java
enum Cala {
    Red(0, "老大","红色"), Orange(1, "老二","绿色"), Yellow(2, "老三","黄色"),Green(3,"老四","绿色"),Cyan(4,"老五","青色"),Blue(5,"老六","蓝色"),Violet(6,"老七","紫色");
    int symbol;
    private String name;
    private String color;
    private Cala(int symbol, String name, String color) {
        this.symbol = symbol;
        this.name = name;
        this.color = color;
    }//这里是葫芦的构造函数
    
    void ChangePos(int goal) {
        System.out.println(this.name + "：" + this.symbol + "->" + goal+" ");
        this.symbol = goal;
    }//葫芦娃向目标地址移动并报数}
}

```
###Grandfather类
由于葫芦娃并不能知道整体的排序，故建立Grandfather类，类中含一个int list[7]记录葫芦顺序，并且依次为基础对葫芦进行排序

```Java
class Grandfather {
    String name;
    static int[] list = new int[7];//一个数组记录葫芦们的顺序,list[i]的值表示不同的葫芦

    Grandfather(String name, Cala[] boys) {
        this.name = name;
        for (int i = 0; i < 7; i++)//让爷爷知道葫芦的序列
            list[boys[i].symbol] = boys[i].ordinal();//根据葫芦的位置，存入记录序列中
    }
}
```
##关于面向对象的疑惑
本次作业中，抽象出了葫芦与控制器两个对象，控制器对葫芦们进行控制，这二者之间的数据交流通过一个Cala[]数组传递，这样好吗？
控制器是对葫芦特化的，有什么更好的方法建立他们之间的联系？





