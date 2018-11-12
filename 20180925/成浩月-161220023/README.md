# 葫芦娃大战妖精

---

## 用简单图形界面展现葫芦娃与妖精的对战

> * 涉及到三种类：生物、阵列和界面
>
> * 生物包括葫芦娃、爷爷、蛇精、蝎子精、小喽啰，他们有其共性，且为了便于其他类对生物进行统一处理，定义基类Creature，各生物继承该类。
> * 阵列有且仅有8种，用二维字符矩阵表示阵列，不同的字符代表不同的生物。除了8种阵列名字是枚举的，8种二维矩阵也应该是枚举的。仿照各种生物，将各种二维矩阵定义成一个基类和8个继承类的关系。基类Stance含有一个全为0的二维矩阵，不用来实际创建对象，定义为抽象类。用枚举类型Formation将阵列名字和各阵列对象绑定在一起。
> * 界面用一个窗体承载，将窗体中的内容划分成二维矩阵，可以将生物放到指定位置
> * 不直接使用界面类、阵列类，而是将其聚合在另一个类中提供给用户使用



### 类介绍

#### * Creature

数据成员

- [x] 图片对象
- [x] 在阵列上所代表的字符
- [x] 读取图片的路径字符串

```java
char symbol;
Image image;
String wholepath;
```

方法

- [x] 构造函数读取工程目录
- [x] talk()方法播放音乐(函数体为空，不是每一种生物都需要播放音乐)



#### * CalabashBrother

数据成员

- [x] 内部定义枚举类型，枚举排行所对应的相对图片路径

- [x] 固定的不可更改的葫芦兄弟的数量
- [x] 音乐文件的路径
- [x] 音乐文件
- [x] 播放音乐的对象(类似于生物的声带)

```java
enum CalabashRank{
    FIRST("\\c1.jpg")\\...SEVENTH("\\c7.jpg");
    String imagepath;
}
static final int number=7;
private CalabashRank status;
private static String musicpath;       //
private static File musicfile;         //
private static AudioClip ac;           //一个类的所有对象只需要一个
```

方法

- [x] 构造函数    //读取音乐文件、图片
- [x] 重载talk()   //播放音乐



##### 其余生物类Human, Serpent, Scorpion, Toad与CalabashBrother类似，但只有CalabashBrother和Scorpion类可以播放音乐





#### * Stance类及其派生类

```java
static final int dimension = 13;  //矩阵宽度(高度)
char [][] station;                //各个位置存储相应的生物所代表的符号
```

派生类为**CraneWing**, **WildGooseRow**, **CrossBar**, **SerpentArray**, **FishScale**, **SquareCircle**, **CrescentMoon**, **Arrow**



#### * enum Formation

```java
CRANEWING("鹤翼阵",new CraneWing())//...ARROW("锋矢阵",new Arrow());
String name;
Stance stance;
static final int number=8;
Formation()                    //存储name和Stance
public String toString()       //将阵列名转换成中文名字
```



#### * FrameShow

成员

- [x] 窗体
- [x] 窗体标题
- [x] 窗体图标
- [x] 面板
- [x] 在窗体标题上显示的阵列名字
- [x] N*N个标签(用来承载生物图标)
- [x] N*N个生物图标
- [x] GridLayout布局
- [x] 空白格子图片
- [x] 各种图标图片的路径
- [x] 窗体的宽度、长度、行数、列数

方法

```java
FrameShow();  //进行初始化工作
void setformationname(String formationname);   //设置在窗体标题中出现的阵列名
void place(Image img, int row, int col);       //把指定图片放到指定位置
void clearout();                               //清空所有生物
```



#### * Array

成员

- [x] FrameShow对象fs
- [x] Formation对象form
- [x] 矩阵宽度(高度)

方法

```java
Array();                              //构造函数,初始化fs
Array(Formation form);                //构造函数初始化fs,设置阵列,在窗体中显示阵列名
void resetformation(Formation form);  //设置Formation,在窗体中显示阵列名
void addcreatures(Creature... c);     //将生物一个个添加到阵列中应该出现的位置上,并且在添加第一个生物时，调用其talk()播放音乐
Formation setrandomplace();           //返回一个除了长蛇阵列外的其他阵列    
```



![avatar](calabashbrothersVSmonsters/additions/classreview.jpg)



