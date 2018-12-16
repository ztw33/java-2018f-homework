# World v4.1 版

- 当前版本
- 新实现的要求和功能有：
  - 线程同步机制解决同阵营可能进入同一个“格子”导致重叠的问题
  - 增加 start() 向敌方前进的随机性
  - 使得最终只剩下一方阵营
  - 使用 JavaFX 改写
  - 添加动画
  - 自动保存战斗过程到默认xml文件

- 下一阶段目标：
  - 按L键显示文件对话框让用户选择一个文件，读取战斗过程
  - 战斗过程另存为指定名称的文件



## 类与包

本版本由于使用JavaFX改写并实现动画效果，对代码进行了大量的重构

- package world
  - class **Global**
  - class **Main**
  - class **CoreWorld**
  - class **Entity** 
- package world.creatures
  - ……
- package world.formations
  - ……
- package world.util
  - ……
  - enum **EntityState**

- package world.gui
  - class **GUIBorder**
  - class **GUIWindow**

- package world.xml
  - class **XMLRecordStructure**
  - class **XMLRecordWriter** extends  XMLRecordStructure
  - class **XMLRecordReader** extends  XMLRecordStructure



## 修改说明

### （一）package world

- 删除 **GUIWindow**、**GUIPanel**、**GUICell**，在新的包 **world.gui** 中使用 **JavaFX** 进行重构；

#### 1. class Main

 **JavaFX** 应用

```java
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 初始化 CoreWorld 和 GUI 相关，并显示 GUI
    }
    public static void main(String[] args) {
		launch(args);
	}
}
```



#### 2. class CoreWorld

即 **CharWindow**  类，改了类名



#### 3. class Entity

原先的 **world.entities** 包删除了，**Entity** 类直接调到 **world** 包



#### 4. class Global

全局常量变量和方法，例如：

行列数，窗口/图片的位置/宽高/布局；葫芦娃/妖怪胜率；动画持续时间；

回合数，战斗是否开始/结束；默认保存文件名； ……



### （二）package world.util

#### enum EntityState

把原先 **Entity** 类的内部 **enum** 换到包 **world.util** 中，包括 **LIVE**, **DEAD**, **OUT** 三种状态



### （三）package world.gui

- 原先的 **java.awt** 以及 **javax.swing** 全都抛弃
- 新的 **GUI** 模块采用 **JavaFX**，并在 **SceneBuilder** 中设定界面的 **FXML** 文件
  - **GUIBorder** 类对应于文件 **WorldBorder.fxml**
    其主要作用是，定义了菜单栏/菜单项，和与菜单相关的操作/行为
  - **GUIWindow** 类对应于文件 **WorldWindow.fxml**
    其主要作用有：
    - 定义界面的背景图片 —— 最底层 **Pane** 上的 **Label**
    - 操纵无动画的“人物层” —— 次底层 **GridPane (18×17)** 上放置 **18×17**  个**固定的 Label**
    - 操纵“动画层” —— 次顶层 **GridPane (1×1)**  上放置与**人物实体数**相等的**可移动 Label**
    - 最顶层**接收键盘输入**，并执行对应的行为



#### 1. class GUIBorder

以菜单项中的“**重置**”和“**显示动画**”为例：

```java
	@FXML
    private MenuItem menuItReset; // 重置
	@FXML
	private CheckMenuItem menuCheckAnim; // 是否显示动画
	...
	/**	初始化GUIBorder.
     *	在加载WorldBorder.fxml完成后自动调用	*/
    @FXML
    private void initialize() {
    	menuItReset.setOnAction((ActionEvent t) -> {
    		handleReset();
        });
    	menuCheckAnim.setOnAction((ActionEvent t) -> {
    		handleSetAnim();
        });
        ...
    }
	/**	菜单项 —— 重置	*/
	private void handleReset() { ... }
	
	private GUIWindow gWin = null; // GUIWindow 指针
	/**	菜单项（可选） —— 显示动画	*/
	private void handleSetAnim() {
		if (menuCheckAnim.isSelected()) {
			gWin.animLayer.setVisible(true); // 动画层可见
			gWin.entityLayer.setVisible(false); // 人物层不可见
		} else {
			gWin.animLayer.setVisible(false); // 动画层不可见
			gWin.entityLayer.setVisible(true); // 人物层可见
		}
	}
```



#### 2. class GUIWindow

其中连接 FXML 文件的有：

```java
	@FXML
	private Label background; // 背景图片标签
	@FXML
	public GridPane entityLayer; // 人物层指针
	@FXML
	public GridPane animLayer; // 动画层指针
	@FXML
	private TextField receiver; // 用于设置键盘监听
```

其中，人物层与上一版本 4.0 中的 GUIPanel + GUICell 有着相同的效果，采用一个 Label 的网格结构：

```java
	private Label cells[][] = new Label[Global.rowNum][Global.colNum];
```

例如，当人物从坐标 (9,4) 移动到 (9,5)，则先**清空**标签 **cell\[9\]\[4\]** 的图片，再**绘制**空标签 **cell\[9\]\[5\]** 成该人物的图片。

而动画层的机制则完全不同，它只维护一个与实体对象数量相等元素的  Map，value 为 Label 类型，该 Label 通过改变 TranslateX 和 TranslateY 的值来改变位置，从而实现移动：

```java
	public static Map<Integer, Label> animItems = new HashMap<>();
```

也就是说，人物层实现了 Label 与位置的一一对应，动画层实现了 Label 与人物实体对象的一一对应。

动画层标签的初始化如下：

```java
	public void initAnimItems() {
		// 先移除 animItems 以前的全部 Label
		Iterator<Integer> it = animItems.keySet().iterator();
        while (it.hasNext()) {
            animLayer.getChildren().remove(animItems.get(it.next()));
            it.remove();
        }
		// 根据entities重新写入
		for (Entry<Integer, Entity> item : CoreWorld.entities.entrySet()) {
			Label tmpLab = new Label();
			setEntityImage(tmpLab, item.getValue().creature.getType()); // 添加图片
			tmpLab.setScaleX(Global.span / Global.entityWidth); // 标签整体缩放
			tmpLab.setScaleY(Global.span / Global.entityHeight);
			tmpLab.setTranslateX(Global.marginX + item.getValue().position.col() * Global.span); // 标签位移
			tmpLab.setTranslateY(Global.marginY + item.getValue().position.row() * Global.span);
			animLayer.getChildren().add(tmpLab); // 放置到动画层
			animItems.put(item.getKey(), tmpLab);
		}
	}
```

键盘事件的设置如下：

```java
    @FXML
    private void initialize() {
        ...
		receiver.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE && cWrd != null) {
                	pressKeySpace();
                }
            }
        });
    }
```

每次单击键盘的空格键调用：

```java
	private void pressKeySpace() {
		Global.battleStart = true; // 战斗1开始
		if (!Global.battleEnd) { // 战斗未结束
            ...
	        start(Global.roundNum);
            ...
		}
	}
```

在 **start** 函数中开启所有实体的线程并播放动画

```java
	public void start(int n) {
		for (Entity en: CoreWorld.entities.values()) {
			// 奇数回合葫芦娃动，偶数回合妖怪动
			if (((n % 2 == 1) && (en.creature.getGroup() == GroupType.Bro))
					|| ((n % 2 == 0) && (en.creature.getGroup() == GroupType.Mon))) {
				if (en.state != EntityState.LIVE) continue;
				// 开始移动
            	en.start(); // 开启线程，当前 Entity 可能死亡
				// 添加时间轴
				Timeline timeline = new Timeline(); // 不循环
		        KeyFrame keyFrame = new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {  
		            @Override  
		            public void handle(ActionEvent event) { 
		            	playAnimation(en); // 动画效果
		            }  
		        });  
		        timeline.getKeyFrames().add(keyFrame); 
		        timeline.play(); // 开始播放
			}
		}
	}
```

动画效果的设置如下：

```java
	private void playAnimation(Entity en) {
		if (!en.position.equals(new Point(0, 0))) {
			// 移动动画 tt
			TranslateTransition tt = new TranslateTransition(Duration.millis(Global.durTime));
	        tt.setByX(en.direction.col() * Global.span); // x位移
	        tt.setByY(en.direction.row() * Global.span); // y位移
	        ParallelTransition animMov = new ParallelTransition(animItems.get(en.id), tt);
        	animMov.play(); // 移动
		}
        // 消失动画 ft
        FadeTransition ft = new FadeTransition(Duration.millis(Global.durTime));
        ft.setToValue(0);
        ParallelTransition animFade = null;
        // 自己在这一回合死掉了
		if (en.state == EntityState.DEAD) { // 给自己一个消失动画
			animFade = new ParallelTransition(animItems.get(en.id), ft);
			animFade.play();
		}
		// 在这一回合击败了敌人
		if (en.hasWined) { // 给敌人一个消失动画
			animFade = new ParallelTransition(animItems.get(en.target.id), ft);
			animFade.play();
		}
	}
```



## 演示

![4.1](img_readme/4.1.GIF)





# World v4.0 版

- 按照新的要求进行重构
- 目前实现的要求有：
  - N*M 的二维空间（GUICell cells\[]\[] in class GUIPanel）
  - 七个兄弟和老爷爷以某种阵型在左侧战队
  - 蛇精、蝎子精、小喽啰以某种阵型在右侧战队
  - 各生物体均实现为一个线程（新的类 class Entity）；线程同步机制解决多个生物同时杀死某个生物的问题（Entity 的所有实例任意两个都不能同时执行）
  - 按空格键时所有生物体线程执行 start()，向敌方前进
  - 当某个生物体于敌方相遇时，选取一个概率决定双方生死

- 下一阶段目标
  - 解决同阵营可能进入同一个“格子”导致重叠的问题
  - 增加 start() 向敌方前进的随机性
  - 使得最终只剩下一方阵营并判定胜利方
  - 使用 JavaFX 改写



## 类与包

- package world
  - class **Global**
  - class **Main**
  - class **CharWindow**
  - class **GUIWindow** extends JFrame
  - class **GUIPanel** extends JPanel
  - class **GUICell**
- package world.creatures
  - class **Creature**
  - class **Brothers** extends Creature
  - class **Elder** extends Creature
  - class **Monsters** extends Creature
  - class **Scorpion** extends Creature
  - class **Snake** extends Creature
- package world.entities
  - class **Entity** implements Runnable
- package world.formations
  - class **Formation**
  - class **HeYi** extends Formation
  - class **YanXing** extends Formation
  - class **ChongE** extends Formation
  - class **ChangShe** extends Formation
  - class **YuLin** extends Formation
  - class **FangYuan** extends Formation
  - class **YanYue** extends Formation
  - class **FengShi** extends Formation
- package world.util
  - enum **CreatureType**
  - enum **FormationType**
  - enum **GroupType**
  - class **Point**



## 详细说明

### （一）package world

#### 1. class Main

- main 函数 —— 世界的构建

```java
public final class Main {
	public static void main(String[] args) {
		CharWindow cWin = new CharWindow();
		new GUIWindow(cWin);
	}
}
```

#### 2. class CharWindow

- 里世界 —— 世界的基石

- 同时在终端使用字符显示整个世界以及人物符号

##### (1) 重要属性

```java
	/**	定义葫芦娃阵型对象 */
	public Formation broForm;
	/**	定义妖怪阵型对象 */
	public Formation monForm;
	/**	当前世界上的所有实体，每个都是生物+位置+线程，是一切行为的发起者 */
	public static Set<Entity> entities = new HashSet<>();
```

##### (2) 方法

```java
	/**	返回某位置pos上的实体（没有则返回null） */
	public static Entity getLiveEntityAt(Point pos) { ... }
	/**	根据当前阵型更新实体集合 */
	public void initEntities() { ... }
	/**	开启所有实体的线程：所有葫芦娃向右前进，所有妖怪向左前进 */
	public void start() {
		for (Entity en: entities) {
			en.start();
		}
	}
	/**	改变阵型的同时重置，位置初始化为默认位置 */
	public void changeFormation(FormationType type, GroupType ctype) { ... }
	/**	显示里世界 */
	public void showWorld() { ... }
```

#### 2. class GUIWindow

- 表世界 —— 世界的衍生
- 基于里世界，用图形化界面“包装”
- 相当于：菜单栏 + **GUIPanel**

```java
	/**	构造函数，以char世界为基础，产生GUI世界窗口 */
	public GUIWindow(CharWindow w) {
        ... // 设置标题，菜单栏，窗口大小和位置
		// 设置键盘项监听
		keyMonitor = new KeyMonitor();
        ...
		// 设置菜单项监听
		menuMonitor = new MenuMonitor();
        ...
		// 基于char世界，开始构建和绘制
		cWin = new CharWindow();
		pWin = new GUIPanel(cWin);
		this.add(pWin, BorderLayout.CENTER);
		this.setVisible(true);
		cWin.showWorld(); // 控制台打印世界
		pWin.paintWindow(); // 图形化显示世界
    }
```

#### 3. class GUIPanel

- 包括：背景图 + 所有实体的图像

```java
	/**	每个生物占据一个格子 */
	public GUICell[][] cells;
	/**	背景图片 */
	private JLabel ground;
	/**	擦除所有格子 */
	public void clearWindow() { ... }
	/**	绘制所有格子 */
	public void paintWindow() { ... }
```

#### 4. class GUICell

- 格子，世界地图上放置实体的位置单元

```java
	/**	Cell位置行列，从0开始 */
	private int cRow, cCol;
	/**	Cell图片标签，默认为none.png */
	public JLabel cellLabel;
	/**	为cellLabel设置新图片 */
	public void setImage(CreatureType t) { ... }
	public int x() { ... } // 格子的x坐标
	public int y() { ... } // 格子的y坐标
	public int width() { ... } // 格子的宽
	public int height() { ... } // 格子的长
```

#### 5. class Global

- 全局常量，变量和方法



### （二）package world.creatures

![CreatureUML](.\img_readme\CreatureUML.png)



### （三）package world.formations

#### 1. class Formation

- 重要属性以及方法的目的：记录阵型中人物的“点位置->人物类型”信息

```java
public abstract class Formation {
	/**	阵型内人物的(坐标, 实体)对集合 {@value} */
	public Map<Point, Creature> formMap;
    /**	设置属性值：阵型行数列数以及中心点位置 */
	protected void init(int r, int c, int cr, int cc) {
		formRowNum = r;
		formColNum = c;
		pFormCen = new Point(cr, cc);
	}
}
```



#### 2. class ... （其他）

- 把每个种类的阵型扩展到葫芦娃和妖怪均适用（阵型略有改动）

- 以鱼鳞阵为例：

```java
public final class YuLin extends Formation {
	public YuLin(GroupType ct) { // 阵营
		super(FormationType.YL); // 构建
		if (ct == GroupType.Bro) {
			init(5, 4, 2, 1); // 阵型图所占行列
			// 葫芦娃的位置
			formMap.put(new Point(2, 0), new Elder()); // 老爷爷
			formMap.put(new Point(0, 1), new Brothers(0));
			formMap.put(new Point(1, 1), new Brothers(1));
			formMap.put(new Point(2, 1), new Brothers(2));
			formMap.put(new Point(3, 1), new Brothers(3));
			formMap.put(new Point(4, 1), new Brothers(4));
			formMap.put(new Point(3, 2), new Brothers(5));
			formMap.put(new Point(2, 3), new Brothers(6));
		}
		else {
			init(7, 5, 3, 2); // 阵型图所占行列
			// 妖怪的位置
			formMap.put(new Point(0, 3), new Monsters());
			formMap.put(new Point(1, 2), new Monsters());
			formMap.put(new Point(2, 1), new Monsters());
			formMap.put(new Point(2, 3), new Monsters());
			formMap.put(new Point(3, 0), new Monsters());
			formMap.put(new Point(3, 2), new Scorpion()); // 蝎子精
			formMap.put(new Point(3, 4), new Snake()); // 蛇精
			formMap.put(new Point(4, 3), new Monsters());
			formMap.put(new Point(5, 2), new Monsters());
			formMap.put(new Point(6, 3), new Monsters());
		}
	}
}
```



### （四）package world.entities

#### class Entity

- 生物实体类，是本版本相对以前版本的最大改变
 - 生物 + 位置 + 线程（行为），世界的每个生物都有其对应的实体
 - 使用接口 Runnable
 - 部分代码：

```java
public class Entity implements Runnable {
	public enum EntityState {
		LIVE, // 活着
		DEAD, // 死了
		OUT; // 超出世界范围
	}
	private EntityState state; // 状态
	private Creature creature; // 生物
	private Point position; // 位置
	private Thread thread; // 线程
	/**	自己死亡 */
	public void die() {
		state = EntityState.DEAD;
	}
	/**	自己出界 */
	public void out() {
		state = EntityState.OUT;
	}
    ...
	/**	向右下移动Entity
	 *	限制Entity类的所有实例的访问
	 */
	public void move(Point d) {
		synchronized (this) {
			// 若本次移动目标位置在世界范围之内且本实体是LIVE的
			if ((state == EntityState.LIVE) && (Global.inWorld(position.mov(d)))) {
				Entity target = CharWindow.getLiveEntityAt(position.mov(d));
				if (target != null) { // 与另一个实体相遇了
					// 同阵营则暂时重叠，反正到target的线程之后可以错开
					if (target.creature().getGroup() == creature.getGroup()) {
						position.reset(position.mov(d));
					}
					else { // 敌人决生死
						if (Global.win(creature.getGroup())) {
							target.die();
							position.reset(position.mov(d));
						}
						else this.die();
					}
				}
				else // 前面是空地，正常前进
					position.reset(position.mov(d));
			}
			else { // 本次移动目标位置超出世界范围
				position.reset(position.mov(d));
				out();
			}
		}
	}
	@Override
	public void run() {
		if (creature.getGroup() == GroupType.Bro)
			move(new Point(0, 1));
		else move(new Point(0, -1));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**	创建线程 */
	public void start() {
    	  thread = new Thread(this);
    	  thread.start();
	   }
}
```



### （五）package world.util

- 常用工具和类型声明

#### 1. enum CreatureType

- 生物的最细类别划分

- 成员：**Bro1**, **Bro2**, **Bro3**, **Bro4**, **Bro5**, **Bro6**, **Bro7**, **Eld**, **Scorp**, **Mons**, **Snk**



#### 2. enum FormationType

- 阵型类型（共8种）
- 成员：**HY**("鹤翼阵"), **YX**("雁行阵"), **CE**("冲轭阵"), **CS**("长蛇阵"), **YL**("鱼鳞阵"), **FY**("方円阵"), **YY**("偃月阵"), **FS**("锋矢阵")



#### 3. enum GroupType

- 阵营类型（葫芦娃，妖怪）
- 成员：**Bro**("葫芦娃"), **Mon**("妖怪")



#### 4. Point

- 点类型
- 包含的属性有：行，列
- 包含的方法有：得到点坐标，重设点坐标，复制点，反向点，移动点等



## 演示

![4.0](img_readme/4.0.gif)

