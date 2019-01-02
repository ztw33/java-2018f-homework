# add GUI with javafx
## 增加了一个GUI的类Main
![avatar](https://github.com/LintianShi/java-2018f-homework/blob/master/20180925/%E4%BE%8D%E6%9E%97%E5%A4%A9-161220108/image/gui1.png)
* Main继承于javafx的Application类
* 这里使用了Scene builder进行UI的可见化设置。在start函数里通过加载FXML文件进行控件的布局。
<pre>
<code>
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
</code>
</pre>
## GameController类
* 在Scene builder的设计里，控件的控制和监听事件注册由GameController类里的函数完成。
* GameController类有以下数据成员。BattleField battle含有整个对战所有的生物体，和对战的二维平面。Image background作为对战的背景图片。Creature selected是当前选择的生物体。
<pre>
<code>
    private BattleField battle;
    private Image background;
    private Creature selected;
</code>
</pre>
* GameController类里有以下控件。Button用于控制双方阵营变换阵型。Canvas canvas作为画布用于显示对战场面。Label info用于显示当前选取的对象的名称。ImageView用于显示当前选择的对象的图片。
<pre>
<code>
    @FXML private Canvas canvas;
    @FXML private Button yanhangHulu;
    @FXML private Button changsheHulu;
    @FXML private Button fangmenHulu;
    @FXML private Button yulinHulu;
    @FXML private Button fengshiHulu;
    @FXML private Button heyiHulu;
    @FXML private Button hengeHulu;
    @FXML private Button yanhangDemon;
    @FXML private Button changsheDemon;
    @FXML private Button fangmenDemon;
    @FXML private Button yulinDemon;
    @FXML private Button fengshiDemon;
    @FXML private Button heyiDemon;
    @FXML private Button hengeDemon;
    @FXML private Label info;
    @FXML private ImageView head;
</code>
</pre>
* 在GameController类里有函数void canvasClick(MouseEvent event)，通过Scene builder注册到了canvas的鼠标点击事件上。当鼠标在画布canvas上点击时，就会通过坐标的换算找到Battlefield类space成员对应位置上的生物体，然后显示该生物体的图片和名称。
<pre>
<code>
@FXML private void canvasClick(MouseEvent event) {
        int x = (int)event.getX() - 60;
        int y = (int)event.getY();
        x = x / 30;
        y = y / 30;
        if (battle.space.getCreature(y, x) != null) {
            selected = battle.space.getCreature(y, x);
            head.setImage(selected.getImage());
            info.setText(selected.getName());
        }
    }
</code>
</pre>
![avatar](https://github.com/LintianShi/java-2018f-homework/blob/master/20180925/%E4%BE%8D%E6%9E%97%E5%A4%A9-161220108/image/gui2.png)
* 在GameController类里有函数void canvasDrag(MouseEvent event)，通过Scene builder注册到了canvas的鼠标拖拽事件上。当鼠标在画布canvas上拖拽时，就会通过坐标的换算找到Battlefield类space成员对应的位置，然后让已选择的生物体移动到该位置，从而实现拖动效果。
<pre>
<code>
@FXML private void canvasDrag(MouseEvent event) {
        int x = (int)event.getX() - 60;
        int y = (int)event.getY();
        x = x / 30;
        y = y / 30;
        if (selected != null) {
            selected.moveTo(battle.space, y, x);
        }
        display();
    }
</code>
</pre>
# add gui with Swing
## 增加了一个gui
![avatar](https://github.com/LintianShi/java-2018f-homework/blob/master/20180925/%E4%BE%8D%E6%9E%97%E5%A4%A9-161220108/gui/show.png)
### MainWindow类
* 继承于JFrame，有成员JLabel[][]，通过GridLayout布局。
* refresh()接口：当二维空间上有Creature的时候就显示Creature对应的图片，没有的时候就显示background的图片。
# rewrite with generics
## 改写Tile类
* public class Tile<T extends Creature> {
    private T creatureStandOnTile;
}
## 改写TwoDimensionSpace类
* public class TwoDimensionSpace<T extends Creature> {
    private Tile<T> space[][];
}

# 面向葫芦娃编程3：阵型
***
## 需求分析
* 我们要实现葫芦娃和妖怪在一个二维平面上不停变换阵型进行对阵。
* 需要一个二维平面，该二维平面由一个NxN的砖块组成。砖块上可以站立一个生物体。

## 设计分析

### Tile类
* Tile是构成一个二维空间的基本单位。拥有X坐标，Y坐标，砖块上站立的生物体等属性。
* Tile有boolean isEmpty()，void removeCreatureStandOnTile()，void setCreatureStandOnTile(Creature x)，String getCreatureName()等接口供外部调用。
* boolean isEmpty()可以判断该砖块上是否有生物体
* void removeCreatureStandOnTile()可以将砖块上的生物体移除
* void setCreatureStandOnTile(Creature x)可以添加一个站在该砖块上的生物体
* String getCreatureName()可以获得站在该砖块上生物体的名字

### TwoDimensionSpace类
* TwoDimensionSpace类由一个N*N的Tile类的矩阵构造。TwoDimensionSpace可以通过Tile类提供的原子操作，为生物体提供更高级的接口，让生物体在二维空间里自由地移动。
* boolean setSpace(int x, int y, Creature p)会在坐标(x, y)不越界且坐标(x, y)为空的情况下将生物体p放置在坐标(x, y)上。
* void cleanSpace(int x, int y)在坐标(x, y)不越界的情况下会将坐标(x, y)清空。
* void displaySpace()提供接口将二维空间的情况打印出来。

### Creature类
* Creature作为基础的生物体拥有名称，坐标等属性。
* 拥有接口可以获得当前属性，坐标。
* 拥有方法public boolean moveTo(TwoDimensionSpace space, int x, int y)，可以让该生物体移动到给定二维空间的指定坐标。
* 拥有方法public void removeFrom(TwoDimensionSpace space)，可以让该生物体离开给定二维空间。

### HuluWa类
* HuluWa类从Creature类继承而来，在Creature类的基础上多了排行、颜色等属性。并提供了葫芦娃之间基于颜色、排序进行大小比较的接口。

### Formation类
* Formation类用于排阵。它有一系列的接口例如void generateChangsheFormation(TwoDimensionSpace space, Creature beings[], int x, int y, int direction)，可以让给定的一组Creature类的对象在给定二维空间里，以（x，y）为中心点进行排阵，direction用来控制朝向。

### Team类
* 考虑到葫芦娃阵营和妖怪阵营要摆出不同的阵型，所以设计来Team类来协调多个生物体之间的协作。
* Team类有一个Creature组合的数组作为战斗人员，并有成员observer留给爷爷和蛇精作为啦啦队。
* Team类拥有一系列名为generateXX(TwoDimensionSpace space, int x, int y, int direction)的接口。该接口实例化一个Formation类，然后调用Formation类的方法，让战斗人员在给定二维空间以某一坐标为中心点进行排阵，direction用来标识方向。
* Team类还有一个接口void setObserver(TwoDimensionSpace space, int x, int y)用来放置加油的拉拉队员。

### HuluBrothers类
* HuluBrothers类由Team类继承而来。用HuluWa类的数组覆盖了Team类里Creature类的数组。并增加了一些葫芦娃之间排序的接口。
* 同时重写覆盖了排阵接口，以方便对HuluWa类的对象进行排阵。

### BattleField类
* BattleField类里有一个TwoDimensionSpace类space，一个Team类monsters，一个HuluBrothers类huluBrothers。在main函数里通过操控monsters和huluBrothers来进行阵型变换，形成对峙局面。