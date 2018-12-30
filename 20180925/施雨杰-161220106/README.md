# 作业:面向葫芦娃编程——阵营对峙
## 对象抽象
根据作业要求，将设计的对象大致分为生物、土地两大类
同时设计阵型Formation，排序Sort等方法类向生物提供一系列可进行的功能

**1.Creature**      
葫芦娃，爷爷，蛇精，蝎子精、喽啰等生物均属于此类
```
public class Creature {
    protected String name; //生物的名称
    private int locationX;
    private int locationY; //生物在战场的坐标
    public Creature();
    public Creature(String creatureName);
    public void tellMyName(); 
    public boolean gotoPlace(Ground space, int X, int Y);  //生物移动函数，移向指定土地的一个坐标处
    public void leavePlace(Ground space); //生物离开函数，离开指定的土地
}
```

**2.Unit**      
广阔土地中的单元格，是构成土地的基本单元，向Ground(土地)提供最基本的操作
```
public class Unit {
    private Creature onGroundCreature;  //此单元上的生物
    public Unit();
    public boolean isEmpty();  
    public void Come(Creature creature);  //原子操作:进入。将生物存入单元中，表示生物已移动至此
    public void Leave();                  //原子操作:离开。将生物从此单元移除，表示生物已离开
    public void showCreature();           //原子操作:显示。打印此单元中生物的名称
}
```

**3.Ground**     
位于战场中的土地类，用于控制生物所站立的广阔土地
将土地的每个单元隐藏于此类中，以此保证土地访问的正确性，生物通过此类和土地进行一系列交互
```
public class Ground {
    private Unit[][] space;  //一个Unit的二维数组，是土地的具体表现形式
    private int bound;       //space的大小，即土地的范围大小
    public Ground(int N);    //通过参数N确定土地的具体大小，并根据此参数创建土地实体
    public boolean isEmpty(int X, int Y);  //检测对应土地单元的位置是否为空，是对土地操作的保护
    public boolean testBound(int X, int Y);//检测对应土地单元是否存在，即坐标是否越界，是对土地操作的保护
    public void gotoUnit(int X, int Y, Creature creature); //通过此函数调用对应Unit的原子操作——进入
    public void leaveUnit(int X, int Y);   //通过此函数调用对应Unit的原子操作——离开
    public int showBound();  //返回土地的具体大小
    public void showCreature(int X, int Y);//通过此函数调用对应Unit的原子操作——显示土地上的生物
}

```

**4.Sort**      
一个方法类，提供一系列为葫芦娃排序的方法
```
public class Sort {
    protected HuluWa[] brothers;  //参与排序的葫芦娃数组
    public  Sort();
    public Sort(HuluWa[] brothers);
    public void sort();           //待具体实现的不同排序函数
}
```

**5.Formation**       
存储生物排列出各个阵型所需要的位置信息，为生物提供排阵的方法
```
public class Formation {
    private FormationType type;  //一个阵型的枚举类型，用于描述此类具体排列出的阵型名称
    private int direction;       //描述阵型的朝向
    private Ground space;        //排阵的地点
    private int midX;
    private int midY;            //阵型的中心点(或者说阵型的排列起始点)
    private Creature[] creatures;//待排阵的生物
    public Formation();
    public Formation(FormationType type, int direction, Ground room, Creature[] creatures, int X, int Y);
    private void HeYiFormation();
    private void YanXingFormation();
    private void HengEFormation();
    private void ChangSheFormation();
    private void YuLinFormation();
    private void FangMenFormation();
    private void YanYueFormation();
    private void FengShiFormation(); //8个阵型函数，用于将生物按照阵型朝向、排阵地点等参数进行排阵
    public void DealFormation();  //根据此类的阵型名称调用相应的阵型函数进行排阵
    public void SetDirection(int direction);
    public void SetFormation(FormationType type);
    public void SetGound(Ground space);
    public void SetCreature(Creature[] creatures);
    public void SetMidPoint(int X, int Y);  //一系列调整此类成员内容的函数
}
```


## 对象继承
仅仅只有上述几个类的实现对于解决此作业是不够的，不同的生物具有不同的功能和特性，执行排序亦有不同算法
为了精确描述同个大类下不同种主体的特性，引入继承机制，扩展上述的几个基本类

**1.Creature**       
将生物分为葫芦娃HuluWa、爷爷Grandpa、妖怪Monster3个子类
对于妖怪类，将其进一步分为蛇精Snake、蝎子精Scorpio、喽啰LittleMonster3个子类
通过这样的继承，进一步理清了各种生物体之间的关系和不同，为后续给各类不同生物添加各异的功能提供了方便


 **·** HuluWa    
葫芦娃类将此前作业2中用enum实现的葫芦娃类作为成员，通过向构造函数提供的排名数字rank实体化一个葫芦娃
对象中对应的葫芦娃enum类。
以这种折中的方式解决了enum类不能再次继承Creature类的问题

 **·** Grandpa    
爷爷在此程序中作为一个指挥者的形象出现，他负责指挥葫芦娃们排出长蛇阵以对抗妖怪的攻势，因此在爷爷的
类中设计了一个Formation类用于对葫芦娃进行阵型安排，midPoint用于存储爷爷想要在某地展开阵型的土地坐标。

实际上，只需要对Formation设置合适的参数即可对目标进行排阵，但由一个未知的力量强行将生物有序的移动太
过突兀，因此将本可以直接在main函数中调用Formation方法的排阵过程以多个函数的方式全部转移到了爷爷类中，
也就是将爷爷看作了一个指挥者。

 ```
        public class Grandpa extends Creature{
            private int[] midPoint;
            private Formation HuluFormation;
            public Grandpa();
	    public void standInLine(HuluWa[] brothers); //安排葫芦娃随机站队
            public void standByOrder(HuluWa[] brothers);//通过Sort方法对葫芦娃进行排序
            public void setMidPoint(int X, int Y);      //确定一个阵型展开点
            public void chooseUnit(Ground space); //在安排完葫芦娃后，爷爷将在土地上找到一个地方站立，为葫芦娃助威
            public void initializeFormation(int direction, Ground space, Creature[] creatures);
                                                  //用输入的参数设置好排阵的参数
            public void commandHuluWa(FormationType type);
                                                  //指挥葫芦娃按阵型进行排列，这实际上通过Formation而非爷爷来完成
            public void waitNewLocation(HuluWa[] creatures, Ground space);
                                                  //命令目标生物暂时离开土地，等待移动到新的目的地
        }
```

**·** Snake    
蛇精和爷爷一样，也作为妖怪的最高指挥者出现，因此不可避免的设计了一些和爷爷类中重复的函数用于指挥妖怪进行排阵

```
public class Snake extends Monster{
    private int[] midPoint;
    private Formation monFormation;
    public Snake();
    public void setMidPoint(int X, int Y);
    public void chooseUnit(Ground space);
    public void initializeFormation(int direction, Ground space, Creature[] creatures);
    public void commandMonsters(FormationType type);
    public void waitNewLocation(Monster[] monsters, Ground space);
}
```

**·** other    
其余的生物暂时没有添加新的功能，因此只有不同的构造函数而没有其余的功能函数

**2.Sort**    
 **·** BubbleSort    
在子类BubbleSort中以冒泡排序算法重写了sort()函数

