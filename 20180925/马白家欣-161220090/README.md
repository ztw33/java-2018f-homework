# 迭代3(2018.10.24)

## 版本说明

经过2018.10.23 java课上各位大佬的精彩展示，对我产生了巨大启（刺）迪（激），因此觉得翻天覆地彻底修改迭代2的版本正是时候了！

实际上，功能上没有任何增加，只是：

|          将7个类扩展到了35个，并参考了SOLID设计原则          |
| :----------------------------------------------------------: |
| **为每个类添加了文档注释，并且为一些复杂函数也添加了文档注释** |
|            **优化了代码结构，尤其是类之间的关系**            |
| **将类的职责划分的更为清晰，类中不包含不属于自己职责的方法和成员** |
| **有许多的类尚未包含任何变量和方法，只作为基类被继承，增加了可扩展性** |
| **更加清晰详尽的Markdown，包含了版本说明，UML类视图，类说明，亮点，个人思考** |

类文档注释截图：

<div>
    <img src = "image\comment1.jpg">
</div>

<div>
    <img src = "image\comment2.jpg">
</div>


方法文档注释截图：

<div align="center">
    <img src = "image\comment4.jpg">
</div>

其他说明，尽管Author名为LUCUS BAI看起来跟我一点关系也没有（毕竟我既不姓白，又不叫卢卡斯），但那确实是我的别名，童叟无欺

## UML类图(只展示部分包)

#### being包

|                  being包是包含所有生物的包                   |
| :----------------------------------------------------------: |
|  **CartoonCharacter直接继承自Being，是所有卡通人物的基类**   |
| **Justice、Evil为正义邪恶阵营，用来在生成阵型时区分向战场单元格(BattleFieldLattice)填充的对象** |
| **Fighting、CheerUp接口尚未有具体实现(调用触发AssertException)，用于后期扩展** |

<div>
    <img src = "image\UML1.JPG">
</div>
#### formation包

| 抽象类Formation，其中包含阵型改变的public函数，传入BattleField对象后可以利用它的public方法修改BattleFieldLatticeArray，此函数待override，为了安全，如果直接调用将AssertException |
| :----------------------------------------------------------: |
| **createRandomFormationObject方法可以生成随机阵型，实现很简单，formationArray包含了各种阵型的对象，之后只要生成随机数r，return formationArray[r]即可** |
| **Formation的子类并不做任何有关display的工作（实际上显示是output包中的BattleFieldDisplay类负责），只是调用BattleField的public方法来设置战场中的角色** |

<div>
    <img src = "image\UML2.JPG">
</div>
#### common包

|            顾名思义，全部都是一些通用类和通用方法            |
| :----------------------------------------------------------: |
|                                                              |
| **用来生成随机阵型的CreateRandomFormationObject类，用来生成双方随机坐标的CreateRandomPosition（格外注意，生成的坐标不仅是随机的而且还是不交叠的），以及生成用于将对象转化为GUI和ANSI字符显示的CartoonTransition函数（大量使用了instance of）** |

## 类说明

#### battle包

|        类名        |                             描述                             |  基类  |
| :----------------: | :----------------------------------------------------------: | :----: |
| BattleCoordinator  |                万物始祖，一切战斗情节的控制器                | Object |
|    BattleField     | 战场，包含了战场方格二维数组battleFieldLatticeArray，主要职责是操纵battleFieldLatticeArray | Object |
| BattleFieldLattice | 战场方格，每个方格都含有一个CartoonCharacter角色，注意什么都没有也是一种特殊的CartoonCharacter | Object |

#### being包

|       类名       |                             描述                             |       基类       |   接口   |
| :--------------: | :----------------------------------------------------------: | :--------------: | :------: |
|      Being       | 存在，可以是任何有生命或无生命的类的基类，为了便于拓展，或许以后会加入非CartoonCharacter的类，那就必须要继承自Being |      Object      |          |
| CartoonCharacter |                  卡通人物（而不是卡通字符）                  |      Being       |          |
|       Evil       | 邪恶阵营，可以在填充BattleField的时候指示填充对象（葫芦娃系列还是妖精系列） | CartoonCharacter |          |
|     Justice      | 正义阵营，可以在填充BattleField的时候指示填充对象（葫芦娃系列还是妖精系列） | CartoonCharacter |          |
|     Scorpion     |                            蝎子精                            |       Evil       | Fighting |
|      Snake       |                             蛇精                             |       Evil       | CheerUp  |
|  LowLevelDemon   |                             小怪                             |       Evil       | Fighting |
|   Grandfather    |                             爷爷                             |     Justice      | CheerUp  |
| CalabashBrothers |               葫芦兄弟，也是所有葫芦boys的父类               |     Justice      | Fighting |
|       Red        |                          红葫芦boy                           | CalabashBrothers |          |
|      Orange      |                          橙葫芦boy                           | CalabashBrothers |          |
|      Yellow      |                          黄葫芦boy                           | CalabashBrothers |          |
|      Green       |                          绿葫芦boy                           | CalabashBrothers |          |
|       Cyan       |  青葫芦boy<br>(青 == Cyan？不过这是我能找到的最接近的词汇)   | CalabashBrothers |          |
|       Blue       |                          蓝葫芦boy                           | CalabashBrothers |          |
|      Purple      |                          紫葫芦boy                           | CalabashBrothers |          |
|     CheerUp      | [interface]助威，尚不知有什么功能，向下implement时没有功能，调用报AssertException |                  |          |
|     Fighting     | [interface]战斗，尚不知有什么功能，向下implement时没有功能，调用报AssertException |                  |          |

#### common包

|            类名             |                             描述                             |  基类  |
| :-------------------------: | :----------------------------------------------------------: | :----: |
|      CartoonTransition      | 一些CartoonCharacter的转化函数，包含静态方法cartoonCharacterToANSI和cartoonCharacterToImage | Object |
| CreateRandomFormationObject |    创建随机阵型，包含静态方法createRandomFormationObject     | Object |
|    CreateRandomPosition     | 创建正义阵营和邪恶阵营随机坐标，关键在于两者不能交叠，包含静态方法createRandomPosition | Object |

#### coordinate包

包含一些与坐标有关的类

|          类名          |                             描述                             |  基类  |
| :--------------------: | :----------------------------------------------------------: | :----: |
|        Position        |                           点的坐标                           | Object |
| JusticeAndEvilPosition | 构建这个类的直接原因是：我们需要一次性生成evil和justice阵营的两个阵型的坐标，用来放置两个阵型交叠 | Object |

#### formation包

|   类名    |                             描述                             |   基类    |
| :-------: | :----------------------------------------------------------: | :-------: |
| Formation | 阵型，向下重载changeFormation方法后可以实现各种阵型的打印，直接调用Formation的hangeFormation会AssertException |  Object   |
| ChangShe  |                             长蛇                             | Formation |
|  ChongE   |                             冲轭                             | Formation |
| FangYuan  |                             方圆                             | Formation |
|  FengShi  |                             锋矢                             | Formation |
|   HeYi    |                             鹤翼                             | Formation |
|  YanXing  |                             雁行                             | Formation |
|  YanYue   |                             偃月                             | Formation |
|   YuLin   |                             鱼鳞                             | Formation |

#### output包

|        类名        |                 描述                  |  基类  |
| :----------------: | :-----------------------------------: | :----: |
| BattleFieldDisplay | 基本输出函数，包括控制台输出和GUI输出 | Object |

## 其它说明

- 有个问题我尚在考虑：有一些不需要的属性是否需要现在就加在类中，比如string name，string property这样的对象，实际上对于这个阶段没有太大作用（但或许更容易debug）。目前的想法仍然是，不添加这些字段，待以后需要再添加，这样或许便于**拓展**，比如这里已经将葫芦娃property定义为了"CalabashBoys"，那么万一以后需要使用的property是"CB"呢，这或许将带来大量的更改

- 当然↑中的决策引来了一个问题：

  <div align="center">
      <img src = "image\Code1.JPG" width="20%">
  </div>

  产生了一些没有任何属性和任何方法的类，但我仍坚持认为这在以后的**拓展**中是必须的（比如要加入Superman？那只能继承自Being）

## 效果展示

长蛇VS偃月

<div align="center">
    <img src = "image\picture1.JPG" width="60%">
</div>

长蛇VS鹤翼

<div align="center">
    <img src = "image\picture2.JPG" width="60%">
</div>

#### 设计亮点

功能方面：

- 界面简洁明了，角色图案十分可爱；ANSI彩色控制台显示配合GUI显示，前者便于debug，后者便于展示
- 阵型位置可动态变化，而且阵型间不会交叠

面向对象：

- 尽可能利用了面向对象思想，并且使用了一定的SOLID原则
- 做到了复杂模块分解，模块功能明确且单一，模块间解耦合
- 充分利用了继承、接口等java语言特点
- 代码中尽量考虑了后期扩展

#### 一些思考

- assert的使用：这的确是一种C/C++语言的常用技巧，但是在Java中呢？我并不确定好的Java设计是否要包含很多assert使得程序发生的问题尽可能早的暴露（或许有更好的实现方法？）但由于我个人编程习惯**继承**自C/C++，所以大量使用了assert（当然最终提交版本不会assert fail，因为我去除了-ea选项，毕竟提交上去不是为了让老师 or 助教帮我debug的）
- common包的使用：实际上在C/C++的编程中，总是有一个文件夹名叫common(第一次接触common是PA，其中包含了一些条件编译下的通用的数据结构和函数)，由于我个人编程习惯**继承**自C/C++，所以也引入了common包，其中包含一些通用类，其中的方法大多是static方法，但是这是否是好的Java编程习惯呢？谷歌后尚未知

# 迭代2(2018.10.07)

## 新增功能

1. CartoonCharacter的显示变成了图形显示
2. 保留迭代1“功能2”，可通过改变public class BattleField中的GRAPHICAL_DISPLAY变量选择是否进行图形化显示，非图形化显示只用于debug

## 其它说明

1.   *.jar文件直接运行可看到程序运行效果

## 效果展示

<div align="center">
    <img src = "image\picture1.JPG" width="60%">
</div>



<div align="center">
    <img src = "image\picture2.JPG" width="60%">
</div>


# 迭代1(2018.09.27)

## 注意

1. 如果需要在命令行运行，需要加上参数 -ea，用来启用assert，当然如果你希望一些能发现重要错误的assert无效的话以此使得程序能不受中断持续运行，那么可以不添加这个参数
2. 蛇精代表字母是s，蝎子精代表字母是S，并且他们的底色都是灰色，区别仅在大小写

## 一些功能

1. 正义阵营和邪恶阵营的阵型不会彼此交叠，也不会越过边界
2. 使用了ANSI转义字符，因而不同的CartoonCharacter具有不同的底色

## 类及相关说明

#### CartoonCharacter相关

```Java
public class CartoonCharacter //用来描述某个卡通角色的具体情况，包含toString方法的重载来实现ANSI转义字符打印
```

```Java
public enum CartoonCharacterInfo //用来记录CartoonCharacter的具体信息的枚举类，包含了label、ANSIColorPrefix等成员，可在toString方法下形成直接可输出的ANSI转移字符串
```

#### CartoonCharacter在BattleField上的移动相关

```Java
public class BattleCoordinator //主类，用来控制战局的推进（生成随机位置、生成随机阵型、生成新阵型）
```

```Java
public class BattleField //控制整个战场，具体来说，包含一个BattleFieldLattice类型数组，并调用BattleFieldLattice的方法来操作具体的每个战场格的行为
```

```Java
public class BattleFieldLattice //记录一个位于本方格的CartoonCharacter和当前坐标
```

```Java
public enum Formation //枚举类，枚举出各种阵型以及阵型所占的尺寸，包含一些static方法用来改变BattleField上的CartoonCharacter分布
```

#### 其它

```Java
public class Position //记录一个坐标，由(row, col)组成，用途广泛
```

## 其它说明

1. 对“请选择合适位置将老爷爷和蛇精放置于空间中，为各自一方加油助威”的要求真的不能完全的理解，所以目前的实现是，老爷爷和蛇精虽然不在阵中，但是位于阵型旁边的确定位置