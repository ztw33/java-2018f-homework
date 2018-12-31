最终大作业
==
#### 效果预览:

![avatar](https://github.com/161220012/cjh-house/blob/master/menu.png)

![avatar](https://github.com/161220012/cjh-house/blob/master/init.png)

![avatar](https://github.com/161220012/cjh-house/blob/master/battle.png)

![avatar](https://github.com/161220012/cjh-house/blob/master/gameover.png)

一些简单的说明:

葫芦娃阵营排成长蛇阵，妖怪阵营采用的是方円阵，地图大小为12*8的二维地图，每一格大小是80**80像素，游戏采用纯随机的方式，所有生物的移动都是纯随机的，当两个生物遭遇时（坐标差小于1），会各有50%的获胜几率，失败方将从地图上消失，胜利方继续战斗。另外，程序BGM为葫芦娃主题曲《葫芦娃》o(∩_∩)o 。

#### 程序架构如图：

程序共分为4个包：Existence，Creature，Formation，UI

![avatar](https://github.com/161220012/cjh-house/blob/master/structure.png)

其中Creature包包含各个生物类，Formation包含各个阵法类，Existence包含二维地图、坐标类，UI包含了各种Javafx Application类

程序入口为Main类，在UI包中，程序打开后在初始界面，有两个选项，一个是新的游戏，一个是读取存档。以任意一种方式进入游戏后，会来到游戏界面。

#### 关于多线程：

所有生物均实现为一个线程，并override他们的run方法。

在按下空格后，所有生物线程均start，生物们开始战斗,再次按下空格可以暂停：

```
((Grandparent) grandparent).start();
            for(int i=0;i<7;i++)
            brothers[i].start();
            ((ScorpionMonster) scorpion).start();
            ((SnakeMonster) snake).start();
            for(int i=0;i<6;i++)
            {
                ((Underlings) underlings[i]).start();
            }
```

所有线程完成RUNNABLE接口，重写run方法如下：

```
try {

            while (SScreen.getmGameState()!= SScreen.GameState.GAME_END&&Creature.ListCalabash.contains(this)) {
                if(SScreen.getmGameState()!=SScreen.GameState.GAME_PAUSE) {
                    int oldCol=column;
                    int oldRow=row;
                    int temp = (int) (Math.random() * 4);
                    switch (temp) {
                        case 0:
                            //left
                        case 1:
                            //right
                        case 2:
                            //up
                        case 3:
                            //down
                        ……
                        代码过长就不全放了
                        /*
                        
```



避免所有生物站上同一个区域,多线程间的协同问题：

```
for(int i=0;i<ListCalabash.indexOf(this);i++)
                    {
                        if(ListCalabash.get(i).row==this.row&&ListCalabash.get(i).column==this.column)
                        {
                            row=oldRow;
                            column=oldCol;
                        }
                    }
```

以葫芦娃为例，根据线程的开始顺序和调度顺序，每次取检测已经调度的线程的生物有没有站在这个位置上的，若有，则本次移动作废。



#### 录像回放：

首先在游戏结束时，会自动将该局录像保存到录像命名以时间为名自动生成。

记录格式，会记录下当前生物的编号和位置，生物每移动一次就会记录一次，所有记录都会存在records中：

```
public class Record {
    public int index;
    public int row;
    public int col;
    public static LinkedList<Record> records = new LinkedList<Record>();
    public Record(int i, int r,int c)
    {
            index=i;
            row=r;
            col=c;
    }
}
```

在gameover时，会将所有记录写入txt（即所谓的录像文件）。

##### 文件输出：

```
FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
            File f=new File(df.format(new Date())+".txt");
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        //pw.println(Record.records.size()+" "+Record.records.get(Record.records.size()-1).col);

        for(int i=0;i<Record.records.size();i++) {
            System.out.println(i+" "+Record.records.get(i).index);
                //pw.print(i+Record.records.get(i).index);
                pw.print(Record.records.get(i).index+" "+Record.records.get(i).row+" "+Record.records.get(i).col);
                pw.println();
            pw.flush();
        }

        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

在开始界面选择读入文档。

##### 文件输入：

```
FileChooser fileChooser = new FileChooser();
fileChooser.setTitle("选择一个录像txt");
File file=fileChooser.showOpenDialog(null);
……
```

但遗憾的是由于我设计的游戏机制，读入录像文件后，录像回放时有些问题未能解决，所以录像系统没能完成。

#### 相关知识点在程序中的体现：

##### 泛型：

阵法的实现运用了泛型：

```
public class ChangsheBattleArray<T extends Creature> {
    public void form(T[] brothers, int row, int column)
    {
        for(int i=row;i<row+7;i++)
        {
            brothers[i-row].standOnMap(i,column);
        }
    }
}
```

##### 异常处理：

文件io，线程等都用到了异常处理。

##### 注解：

使用了@override，@param，@Deprecated等注解

##### 封装、继承和多态：

举个简单的例子，生物类封装了他们的坐标，各子类又继承了坐标，并重写了显示方法：

```
public class Creature extends SObject{
    protected int row;//生物在地图上的纵坐标
    protected int column;//生物在地图上的横坐标
    ……
    }
    
public class Grandparent extends Creature implements Runnable{
	……
	@Override
    public void standOnMap(int i,int j)
    {
        Space.space[i][j]=Existance.grandparent;

    }
}
```

#### 一些感受：

由于学了两年的C/C++，且这学期也同步在上高级程序设计（C++面向对象程序设计），对面向对象有较为深刻的体悟，对于继承机制带来的代码复用性和多态性感悟最深，在大规模程序开发时带来的便利是难以估量的。同时java相比于C/C++在编写多线程程序时显得方便许多，且简单易懂，并且JAVA完全面向对象的代码风格让我觉得更为纯粹，C++保留了C的部分可能会使程序变得有些不伦不类。



## 以往改动

>#4.0改进概要
+ 根据泛型程序设计将阵型的接口都修改为一个继承自Creature类的泛型
>#3.0改进概要
+ 根据继承思想将阵法的接口修改为基类Creature而不再是特定的子类 
+ 根据集合框架所学内容增加了linkedlist用以管理生物类，在Creature的所有子类构造时都添加到基类的静态linkedlist中 ,方便后续生物类对象的统一化管理
+ 修复了Creature中name为static导致测试时所有生物姓名一样的bug
>#2.0改进概要
+ 完善包管理机制，让整个项目结构更加清晰
+ 解决了enum无法继承的问题，现在所有生物均继承自Creature
+ 阵法不再由space提供而是独立成单独的类
+ space显示地图信息不再通过调用每个对象的成员函数来实现
+ 新增加爷爷和蛇精cheer的接口（视以后要求实现）
+ 增加了图片素材，由于老师说不用swing改用别的，还未实现具体图形界面
+ 增加了所有阵法的实现
+ 引入生物对象枚举类来代替原来用整型加注释标记生物类型的方法，增加程序可读性

>#对象

首先所有生物体，包括葫芦娃，爷爷，蝎子精，蛇精，小喽啰都继承自生物体对象，生物体对象共同属性为他们的名字，坐标，此外像葫芦娃还单独拥有颜色等属性，封装在一个Creature包中。

其中由于上一次将葫芦娃设计成枚举类，为了解决枚举类无法继承的问题，又重新将葫芦娃的各种属性设计成枚举类，在葫芦娃构造函数了调用这些枚举类型：

    public enum CalabashEnum {
    BigBrother("老大","红色",1),SecondBrother("老二","橙色",2),ThirdBrother("老三","黄色",3),FourthBrother("老四","绿色",4),
    FifthBrother("老五","青色",5), SixthBrother("老六","蓝色",6),SeventhBrother("老七","紫色",7);
    String name;// 葫芦娃的名字
    String color;// 葫芦娃的颜色
    int rank;// 葫芦娃中的排行
    CalabashEnum(String name,String color,int rank)
    {
        this.name =name;
        this.color=color;
        this.rank=rank;
    }
    ………
    ｝
    public class CalabashBrothers extends Creature{
    String name;// 葫芦娃的名字
    String color;// 葫芦娃的颜色
    int rank;// 葫芦娃中的排行
    CalabashBrothers(int i)
    {
        this.color = CalabashEnum.values()[i].getColor();
        this.name =CalabashEnum.values()[i].getName();
        this.rank = CalabashEnum.values()[i].getRank();
    
    }
    ……
    ｝

接着本次由于引入了一个二维空间的概念，所以直接将二维空间看做一个对象Space，它拥有固有属性空间的大小，空间的内容（二维数组实现），并设计为静态成员，对应现实中空间唯一的概念，使所有生物处于同一维度。例如：
​    
​    public class Space{
​    private static Existance[][] space;
​    private int sizeofspace;
​    ……
​    }

Existance为一个枚举类，里面枚举了一个空间中可能存在的所有种类：

    public enum Existance｛
        bounder,nothing,grandparent,snake,scorpion,underlings,bigbrother,secondbrother,thirdbrother,fourthbrother,fifthbrother,sixthbrother,seventhbrother;}


对应地，为每个生物体对象添加了对应于空间中坐标的属性，即二维坐标，所以生物继承这个属性：

    public class Creature{
    protected int row;
    protected int column;
    ……
    }


​    
>#方法

在保留了上一次作业葫芦娃的设计以及排序方法基础上，添加了其他生物对象，并且这些生物对象都有一种站在二维空间上某一处的行为standOnMap，即更新自身的二维坐标属性，并将对应的二维空间中的位置填充为自身对应编号。例如：

    public void standOnMap(int i,int j)
    {
        row=i;
        column=j;
        Space.space[i][j]=Existance.scorpion;
    }

Space类，提供三个个方法：

1.重置空间remove，即简单地将空间中所有位置的信息清零。

2.指定位置摆放爷爷和蛇精，直接调用生物行为standOnMap即可。

3.展示地图上站位情况display，根据Space中记录的枚举类型进行显示，目前暂时使用字符串输出，后期会改用GUI输出图像。例如：
​    
​    switch(space[i][j]) {
​    case socrpion:
​              System.print("蝎子");
​              break;
​    ……
​    ｝

Formation包中共包含八个类，分别对应雁行，鹤翼，长蛇，衝轭，方円，锋矢，鱼鳞，偃月阵法，具体实现就不赘述，具体效果见最后图片。
>#优点

通过将Space看成一个对象，所有的二维空间中的点都是对象的属性，并利用所有生物与地图的交互接口，使得阵法的排列几乎只需要关心Space类本身即可，避免了繁杂的细节和生物间的差异性。

>#最终效果展现

雁行
![avatar](https://github.com/161220012/cjh-house/blob/master/Yanxing.jpg)

鹤翼
![avatar](https://github.com/161220012/cjh-house/blob/master/Heyi.jpg)

衝轭
![avatar](https://github.com/161220012/cjh-house/blob/master/Chonge.jpg)

方円
![avatar](https://github.com/161220012/cjh-house/blob/master/Fangyuan.jpg)

锋矢
![avatar](https://github.com/161220012/cjh-house/blob/master/Fengshi.jpg)

偃月
![avatar](https://github.com/161220012/cjh-house/blob/master/Yanyue.jpg)

鱼鳞
![avatar](https://github.com/161220012/cjh-house/blob/master/Yulin.jpg)

















