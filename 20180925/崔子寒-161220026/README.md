## 0.11月22日 更新说明
1. 使用了JavaFx框架替代了原有的Swing框架，在IDEA + Scene Builder的环境下，更新了GUI的实现和设计。
2. 添加了和用户的交互，用户通过按钮来控制阵型的变动。具体效果如下：
![image](https://github.com/czhnju161220026/image/blob/master/res3v4.png?raw=true)
3. 上传了jar包，在Java 10 以下的版本可能无法正常运行。

## 1.设计思路
1. GUI的设计：GUI应该提供和用户的交互，因此需要一个**GameController**类，这个类接受用户的操作（例如点击某个按钮），并调用相关的函数进行处理。GUI窗口在**Main**类中被展示。窗口的设计借助了GUI设计工具**Scene Builder**，窗口的风格通过加载.CSS文件来设定。
2. 出场的人物：出场的人物包括七个葫芦娃，爷爷，小怪，蝎子精，蛇精。它们有一个共同的抽象基类**Creature**。具有公共的属性position指示所在战场中的位置，image属性储存自己的图像素材，同时分别具有各自不同的属性，例如葫芦娃具有颜色属性，蛇精和爷爷具有cheer方法。
3. 阵型的设计：接口**FormationProvider**定义了一个阵型类应该具有**provideFormation**方法，返回一个坐标数组。所有的阵型类都继承自这个接口。
4. 战场的设计：首先需要一个Block类代表单位的空间，Block可以绑定一个生物和解除绑定，来模拟生物进入和离开的过程。战场内部有一个Block矩阵，代表战场的二维空间。可以通过遍历矩阵的方式给出战场的信息。
5. 阵营的设计：**Heros**和**BadGuys**类是战斗中的两大阵营，分别由若干葫芦娃和若干怪物组成，这两大阵营都具有变换阵型的方法。

## 2.模块说明
这次更新依然采用包管理的形式进行管理。
1. guiApp包：guiApp包包含了**GameController**和**Main**两个类，负责和用户进行交互，类视图如下：
![image](https://github.com/czhnju161220026/image/blob/master/Gui.jpg?raw=true)<br>
**GameController**中定义了三个Handler，分别处理开始按钮，变换阵形按钮，和游戏结束按钮的点击事件。还有方法displayBattlefield和clearBattlefield用来展示和清空战场。<br>
**Main**中的start函数设置场景并进行展示。

2. Creatures包： Creatures包包含了抽象类Creature以及其若干派生类。定义了所有的出场人物，类视图如下：
![image](https://github.com/czhnju161220026/image/blob/master/Creature.jpg?raw=true)
其中Creature具有方法setPosition，getPosition提供了对position属性的变异和访问的功能。getImage访问生物所具有的图片。outputInfo用于进行命令行的输出。另外GrandFather和Snake分别继承了接口Cheer，具有cheer方法。

3. Formations包：接口**FormationProvider**定义了一个阵型类应该具有**provideFormation**和**getName**方法。所有的阵型类都继承自这个接口。
**provideFormation**方法返回一个坐标数组，用来描述阵型。**getName**方法返回阵型的名字，为了更好的和用户进行交互。类视图如下：
![image](https://github.com/czhnju161220026/image/blob/master/Formation.jpg?raw=true)

4. Battle包：该包包含了表示战场和对阵双方的类Battlefield、Heros和BadGuys。类视图如下：
![image](https://github.com/czhnju161220026/image/blob/master/Battle.jpg?raw=true)

5. Attributes包：包含了枚举类型的颜色和坐标类Position，类视图如下：<br>
![image](https://github.com/czhnju161220026/image/blob/master/Attribute.jpg?raw=true)


## 3.实现说明
(1) Creature及其派生类:
``` java  
/*输出自身信息，在派生类中被分别覆盖为所需要的方法*/
public void outputInfo(); 
/*给出自己的图片*/
public Image getImage();
```

(2) Block&lt;T extends Creature&gt;:
``` java
//属性
private T creature = null;
private boolean isEmpty = true;
//方法
/*绑定生物*/
public boolean creatureEnter(T creature);
/*生物离开*/
public void creatureLeave();
/*输出信息，直接调用所绑定生物的outputInfo()*/
public void outputInfo();
/*调用creature的getImage方法，若不存在，返回null。*/
public getImage();
```

(3) Battlefield:
``` java
//属性
private ArrayList<ArrayList<Block<Creature>>> battlefield = new ArrayList<>();
//方法
 /*遍历二维空间，打印战场的实时情况*/
 public void print();
 /*向GUI提供访问战场空间的功能*/
 public getBattlefield();
 /*清空战场*/
 public void clear();
 /*生物进入坐标为（i,j）d的空间*/
 public void creatureEnter(Creature creature, Position position);
```

(4) Heros:
``` java
//属性
private ArrayList<Creature> heros;
//方法
/*将阵型变为fp指定的阵型，放置在战场上，然后返回阵型的名字*/
public String changeFormation(FormationProvider fp, Battlefield battlefield);
```
(5) BadGuys:
``` java
//属性
ArrayList<Creature> badGuys;
//方法
/*将阵型变为fp指定的阵型，放置在战场上，然后返回阵型的名字*/
public String changeFormation(FormationProvider fp, Battlefield battlefield);
```

(6) FormationProvider接口
``` java
/*给出一个坐标数组，描述指定的阵型*/
Position[] provideFormation();
/*返回阵型的名字*/
String getName();
```

(7) GameController类：
``` java
//成员变量
@FXML private Button gameStartButton;
@FXML private Button changeFormationButton;
@FXML private Button quitButton;
@FXML private TextArea gameLog;
@FXML private Canvas imageArea;
Image backgroundImage = new Image("resourceFiles/background.jpg");
private Battlefield battlefield = new Battlefield();
private Heros heros = new Heros();
private BadGuys badGuys = new BadGuys();
private ArrayList<FormationProvider> formationProviders = new ArrayList<>();
Integer currentHerosFormation;
Integer currentBadGuysFormation;
boolean isGamming = false;
//方法
/*界面初始化*/
@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO:初始化、读入资源
        gameLog.setText("游戏准备开始！\n");
        gameLog.setEditable(false);
        GraphicsContext gc = imageArea.getGraphicsContext2D();
        gc.drawImage(backgroundImage,0,0);
        formationProviders.addAll(Arrays.asList(new HeYi(),new YanXing(),new ChongE(),
                new ChangShe(),new YuLin(),new Fang(),new YanYue(),new FengShi()));
    }

/*处理“开始按钮”*/
@FXML private void gameStartHandler() {
        if(isGamming) { return; }
        isGamming = true;
        ...
        进入战场并显示
    }

/*处理变阵按钮*/
@FXML private void changeFormationHandler() {
        clearBattlefield();
        ...变阵...
        displayBattlefield();
    }

/*处理结束按钮*/
@FXML private void quitHandler() {
        clearBattlefield();
        isGamming = false;
        gameLog.appendText("本轮游戏结束。\n");
    }
```

## 4.面向对象的思想
1. 继承：CalabashBrother,GrandFahter,Monster继承了基类Creature
2. 组合：Battlefield的成员有Block对象的矩阵，Block的成员中有Creature及其派生类的对象。
3. 多态：在遍历空间，输出战场信息的时候，调用每个Creature对象的outputInfo方法；显示图片时，只要调用每个Creature对象的getImage方法。这些方法会动态绑定到具体的子类中的方法，运用了多态的思想。
4. 泛型：Block类运用了泛型的思想，直观的说明了其可以持有任意的Creature及其派生类。

这些设计思想提高了代码的复用效率，而且和现实世界比较类似，是以后的学习过程中应该多加运用，多多领悟的。
良好的封装和解耦合性可以为后期添加新功能时省却很多麻烦，例如添加GUI显示时