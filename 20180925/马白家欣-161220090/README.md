# 迭代6(2018.12.10)

## 版本说明

- 修改了JavaFX的设计：
  - 通过initialize()来进行初始化，替代了上一个版本中点击launch按钮初始化的操作

- maven的使用：
  - 利用了maven进行自动依赖包导入、测试、打包，可通过运行maven clean test package命令进行自动测试打包
  - 对common.CommonSort中的sort方法进行测试随机数组的排序测试

# 迭代5(2018.12.03)

## 版本说明

- 使用了JavaFX框架进行图形界面构建：
  - 用户通过点击按钮切换阵型
  - 使用了FXML对界面框架进行构建
  - 使用了CSS对按钮样式进行设计
  - 进行了一些构建，使得：
    - 背景图片根据画布大小自动改变自己的大小（背景图片自适应画布大小）
    - 方格大小根据背景图片自使用后的大小改变自己的大小
    - 方格的横向数量和纵向数量可以不等
  - 底层逻辑基本上沿用迭代4的版本

## JavaFX的使用

### FXML生成界面框架：

FXML使用XML格式对于界面框架进行描述，下面是我的界面的FXML

#### 1. 主界面Grid Pane

<div align=center>
    <img src = "image\Code2.jpg" width='80%'>
</div>

其中指定了对齐方式，hgap，vgap等参数

#### 2. 主界面画布

<div align=center>
    <img src = "image\Code3.jpg" width='80%'>
</div>

其中指定了画布的id，高度，宽度，在Grid Pane中的位置，其中id是可以直接在.java文件中引用的：

<div align=center>
    <img src = "image\Code4.jpg" width='30%'>
</div>
#### 3. 按钮

<div align=center>
    <img src = "image\Code5.jpg" width='70%'>
</div>

其中指定了按钮的id，onAction，stylesheets等

- onAction指定了按钮被触发时的响应函数，需要在.java中有相应的函数对应：

<div align=center>
    <img src = "image\Code6.jpg" width='50%'>
</div>

- stylesheets指定了按钮的CSS样式，对应于某个CSS文件，添加CSS后的按钮效果为：

<div align=center>
    <img src = "image\picture4.jpg" width='25%'>
</div>

### CSS对按钮样式进行设计：

JavaFX中的CSS格式与Web中的CSS基本相同，下面以开始(Launch)按钮的CSS为例

开始(Launch)按钮的CSS如下：

```css
.button {
    -fx-background-image: url("/IconStart.png");
    -fx-background-repeat: no-repeat;
    -fx-background-size: 100% 100%;
}
```

- -fx-background-image指定了按钮的背景图片的url
- -fx-background-repeat指定了背景填充的重复方式，这是是不重复，也就是如果png的尺寸小于icon是不重复填充
- -fx-background-size指定了背景的尺寸，“100% 100%”表示图片填充占按钮宽和高的100%，也就是实现了背景图片自适应按钮大小

之后需要在FXML中指定按钮与CSS的对应，见“FXML生成界面框架”

这样的按钮效果如下：

<div align=center>
    <img src = "image\picture5.jpg" width='20%'>
</div>

### .java实现后端逻辑：

后端的葫芦娃数组生成的逻辑沿用了上一个版本的内容，后端的背景图片自适应画布和战场方格自适应背景为新增功能：

#### 1. 背景图片自适应画布

背景图片自适应画布是指背景图片根据画布的大小进行伸缩，也就是**同比例放大缩小，并且居中放置**，而不是直接设置为画布的大小，实现思想如下：

- 求出背景图片的长宽与画布长宽的比值的最大值max
- 背景图片的长宽同比例除以max倍
- 背景图片的起始位置为(Canvas.location - backgroundImage.location/max)/2（这里只是示意，不是java代码）

#### 2. 战场方格自适应背景

战场方格自适应的效果和背景图片自适应的效果近似，只是除了**位置居中**，每个**方格尺寸**也会发生变化，实现思想如下：

- 计算每个**正方形**方格的边长latticeSize：
  - 获得背景图片width和height
  - length = min(width/横向方格数, height/纵向方格数)
- 计算边界冗余，即如果方格无法铺满整个背景时的左右上下预留空间widthRedundancy和heightRedundancy
- 双层for循环绘制方格，第(row, col)个方格的位置是：
  - 横坐标 = widthRedundancy + backgroundImage.getX() + col * latticeSize
  - 纵坐标 = heightRedundancy + backgroundImage.getY() + row * latticeSize

## 效果展示

<div align=center>
    <img src = "image\show.gif" width='60%'>
    <div>gif动图</div>
</div>
<div align=center>
    <img src = "image\picture3.jpg" width='60%'>
    <div>效果展示</div>
</div>


- 主打卡通风
- 界面背景和半透明方格配合，这样可以清楚的展示卡通角色的相对位置而且还可以显示出背景，增加美观度
- 左侧按键表示开始游戏（上）和随机产生阵型（下），右侧点击阵型按钮则生成相应阵型
- 文件夹中有相应.gif文件展示使用的动画效果

# 迭代4(2018.11.22)

## 版本说明

- 加入了Collection
  - 战场方格BattleFieldLattice使用ArrayList组织
  - 创建随机阵型时，一次生成一个List<Formation>，里面是8种阵型经过Collections.shuffle后的结果
  - 创建阵型时，先将阵型需要的点坐标填入List<Position>中，之后利用for循环自动生成Map<Position, T>，其中键为Position，值为某个卡通角色(Class CartoonCharacter)的对象(后续会有更详细的介绍)
- 加入了泛型
  - Formation <T extends Being>，即泛型化的阵型类，并且Formation的所有子类均变成了擦除到CartoonCharacter的泛型
  - IFactory <T>泛型接口类，其中的create方法使得可以生成泛型对象
- 进一步优化了代码，并增加了一些额外的包和类
  - factory包：用来生成泛型对象
    - factory.IFactory：泛型化的接口类，factory包内的所有方法都要implement它
    - factory.EvilFactory：implement IFactory，可以生成Evil类对象
    - factory.JusticeFactory：implement IFactory，可以生成Justice类对象
  - formation包：泛型化的“阵型”
    - formation.fillFormation：向formationMap中填入<Point, CartoonCharacter>，之后可以通过查询formationMap生成战场阵型
  - common包：通用类和方法
    - common.CreateRandomFormationArray：由“迭代3”中的CreateRandomFormationObject“进化而来”，生成一个List<Formation>，是8种阵型经过Collections.shuffle后的结果，也意味着每轮都会以随机顺序显示8种阵型

## Collection的使用

#### 随机阵型的生成

随机阵型的生成使用了：

```java
List<Formation> formationArray
```

##### 1. 随机阵型数组的产生

上一版本中随机阵型的生成依赖于common.CreateRandomFormationObject中的静态方法，顾名思义，产生一个随机的阵型，不过这有一些问题：

- 效果不佳：经常会发生相同的阵型重复出现的情况，使得有时候感觉阵型不够随机。

- 难以调试：每种阵型随机产生，如果某种阵型出现了问题需要对它进行调试，但它何时出现并不确定，这就导致调试难度增加。

基于以上思考，那么可以考虑在一轮中以随机顺序产生8种阵型，于是需要对CreateRandomFormationObject进行改造：

CreateRandomFormationObject  ==>  CreateRandomFormationArray

common.CreateRandomFormationArray中只含有一个静态方法，其实现如下

```java
static public <T extends CartoonCharacter> List<Formation> createRandomFormationArray(IFactory<T> factory) {
    List<Formation> formationArray = new ArrayList<>();
    //填入8种阵型
    formationArray.add(new HeYi<>(factory.create()));
    formationArray.add(new YanXing<>(factory.create()));
    formationArray.add(new ChongE<>(factory.create()));
    formationArray.add(new ChangShe<>(factory.create()));
    formationArray.add(new YuLin<>(factory.create()));
    formationArray.add(new FangYuan<>(factory.create()));
    formationArray.add(new YanYue<>(factory.create()));
    formationArray.add(new FengShi<>(factory.create()));
    //随机化8种阵型的顺序
    Collections.shuffle(formationArray);
    return formationArray;
}
```

相应的，使用方法也要发生变化：

对createRandomFormationArray()返回的List<Formation>for循环遍历输出

##### 2.随机阵型数组的使用

上一个迭代版本中，createRandomFormationObject()产生的是一个阵型的枚举值，之后再通过switch语句判断究竟调用哪个阵型，这样的方法显然十分的冗长，而且一旦要加入新的阵型必然要在很多地方进行修改。

新版本中，createRandomFormationArray()生成的不是枚举值而是继承自抽象类Formation对象，之后只需要for循环遍历List即可：

```java
List<Formation> evilFormation = CreateRandomFormationArray.createRandomFormationArray(new EvilFactory());
for (int j = 0; j < evilFormation.size(); j++) {
    //……
    evilFormation.get(j).changeFormation(newPosition.evilPosition, battleField);
    //……
}
```



#### 特定阵型的填充

新版本中特定阵型填充使用了：

```java
List<Position> positionList
```

```java
Map<Position, T> formationMap
```

在上一个版本中，阵型的填充方法是：

每个特定的阵型继承Formation类，并重定义changeFormation()方法

该方法不断地调用battleField.setBattleFieldLattice()方法来对战场格进行设置：

```java
public void changeFormation(Position position, BattleField battleField)
{
    battleField.setBattleFieldLattice(position, new Scorpion());
    //重复上面的操作非常多次填入具体的对象
}
```

这样的问题很显然：

- 妖怪的阵型中小兵出现了非常多次，需要的重复劳动很多
- 频繁的调用setBattleFieldLattice()方法，效率堪忧
- 阵型生成方式混乱，难以debug

所以在新版本中对这里进行了更新，新版本中阵型的填充方式如下(以“雁行阵”为例)：

首先，构造函数中填写positionList，positionList中包含的是当前阵型所需要站位的点

```java
public YanXing(T kind) {
        super(2, 2, 2, 3);
        positionList.add(new Position(0, 0));//center
        positionList.add(new Position(0, 3));
        positionList.add(new Position(-1, 1));
        positionList.add(new Position(-2, 2));
        positionList.add(new Position(1, -1));
        positionList.add(new Position(2, -2));
        this.kind = kind;
    }
```

之后，如果需要调用当前对象的changeFormation()方法，那么先填写formationMap，这需要用到formation.FillFormation中的静态方法fillFormation()

```java
static void fillFormation(Map<Position, CartoonCharacter> formationMap, 
                          List<Position> positionList) {
    //……
    for (int i = 0; i < positionList.size(); i++) {
        //for循环从positionList取出点，与相应的对象构成<Position, CartoonCharacter>
        //元组填入formationMap中
        formationMap.put(positionList.get(i), new LowLevelDemon());
    }
    //……
}
```

这样形成的formationMap可以用做最后的阵型填充

- 如果当前点存在于formationMap，则将相应的对象放入战场方格中
- 否则，这个战场方格不需要赋值

```java
public void setBattleFieldLattice(Map<Position, T> map) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if(map.containsKey(new Position(i, j)))
                {
                    CartoonCharacter cartoonCharacter = map.get(new Position(i, j));
                    this.battleFieldLatticeArray.set((i * FIELD_SIZE + j, 
                                            new BattleFieldLattice(cartoonCharacter));
                }
                else {
                    //DO NOTHING                                     
                }
            }
        }
    }
```

这样只需要将阵型所需的点填入positionList即可，后面的工作都是自动完成的，这样做的好处也十分显然：

- 如果需要加入新的阵型，那么只需要简单的填充positionList即可，改动很小
- 将阵型生成的功能分解，这样更加便于调试



## Generics的使用

#### 泛型化阵型：class Formation<T extends Being>

<div align=center>
    <img src = "image\UML2.JPG" width='60%'>
</div>

formation包中的结构如上，class Formation是所有其余类的父类，所以如果将其泛型化，那么意味着该包中的所有类都面临着修改

##### 1.class Formation引入泛型的意义

- “阵型”中所放入的对象不止一种类型，使用泛型扩展避免了类型转化等问题
- “阵型”当前只有CartoonCharacter类的对象，但是不排除未来引入其它类的对象(花草鱼虫什么的)，泛型化阵型便于未来扩展

##### 2.formation包中泛型的使用

- 泛型化的Collection：

```java
protected Map<Position, T> formationMap
protected List<Position> positionList
```

- 子类泛型化：

如果只有formation.Formation泛型化，那么意义不是很大的，因为不能直接创建Formation类的对象，而具体的阵型显示都要依赖于Formation的各个子类的对象，所以Formation的子类必须要泛型化(以“雁行阵”为例)：

```java
public class YanXing <T extends CartoonCharacter> extends Formation<CartoonCharacter>
```

这里“雁行阵”的擦除边界为CartoonCharacter，这里认为当前的这8种阵型所“容纳”的对象均为CartoonCharacter (如果未来需要让花草鱼虫加入这8种阵型的话需要额外的修改)

#### 泛型化的随机阵型生成：createRandomFormationArray()方法

既然阵型已经泛型化了，那么自然引出了随机阵型生成函数的也要泛型化

createRandomFormationArray为泛型方法，擦除到CartoonCharacter，可以生成任何CartoonCharacter或其子类的随机阵型

#### 泛型化下的对象生成

##### 1.直接需求

formation.Formation的所有子类的构造函数都需要一个泛型化的参数(以“雁行阵”为例)：

```java
public YanXing(T kind) {
    //……
}
```

这意味着在createRandomFormationArray()方法产生List<Formation>时需要传入一个泛型化的对象：

```java
formationArray.add(new YanXing<>(/*一个泛型化的对象*/));
```

由于“擦除”，无法直接利用泛型化参数T生成对象：

```java
formationArray.add(new YanXing<>(new T()));//报错！擦除的力量……
```

那如果使用newInstance()呢？例如：

```java
T obj;
ArrayList<Formation> formationArray = new ArrayList<>();
try{
    obj = kind.newInstance();
    formationArray.add(new YanXing<>(obj));
    //……
}catch (Exception e){
    e.printStackTrace();
}
```

并不是不可以，但是个人认为有如下问题：

- 在IDEA中，newInstance()方法已经不建议使用了：

<div align=center>
    <img src = "image\Unrecommended1.jpg" width='40%'>
</div>

- 代码不够简洁

- 有抛出异常而无法产生对象的可能性

这时需要一些其它的手段生成泛型化对象——也就是IFactory

##### 2.泛型化对象生成器接口类：IFactory

IFactory的定义如下：

```java
public interface IFactory <T> {
    T create();//create()方法将返回一个泛型对象的对象
}
```

之后，想要生成某种类型的对象就定义一个xxxFactory并实现IFactory，例如想产生一个Evil类型的对象：

```java
public class EvilFactory implements IFactory<Evil> {
    public Evil create() {
        return new Evil();
    }
}
```

这时，createRandomFormationArray()变成了：

```java
ArrayList<Formation> formationArray = new ArrayList<>();
formationArray.add(new YanXing<>(factory.create()));
//加入另外7种阵型
Collections.shuffle(formationArray);
return formationArray;
```

这样实现代码表意能力没有降低但是更加简洁，而且没有使用那些不建议使用的方法

## 总结

- 迭代4主要是加入了Collection和Generics
- Generics的使用还是有一些美中不足的地方（有待后期改进）：
  - 一些类的擦除边界也需并不是最合适的？
  - 一些类的泛型化设计的不够好？是否有更多的类需要泛型化？



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