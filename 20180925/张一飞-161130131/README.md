# java Hw 3 设计思路

标签（空格分隔）： JavaHw

---
##类的建立
本次作业根据需求建立不同的类别。
###creature包
    creature包下属一个父类Creature:
```java
public class Creature {
    protected int coorX;//坐标表示
    protected int coorY;
    protected String name;
    /**
     * 用来标示生物属性，true为好，false为坏
     */
    protected boolean kind;
    /**
     * char用来在控制台等地表示属性，也可以用来做标示
     */
    protected char symbolForCrea;
    /**
    * 设置坐标函数
    */
    public void moveToGoal(int coorX, int coorY);
```   
    后有不同的类，继承Creature为子类
| 所属包 | 类名 |
| ------: | :------: |
| justice | Calabashs |
| |GrandFather |
|devil|Mobs|
||Snake|
||Scorpion|

在子类中（以GrandFather为例），利用allNum标识，防止过度初始化
```java
 private static int allNum = 0;
 public class Grandfather extends Creature {
    public Grandfather() {
        if (allNum != 0) {
            System.out.println("出事了，爷爷有了");
        } else {
            allNum++;
            coorX = coorY = -1;//初始坐标制定为-1
            name = this.getClass().getName();
            symbolForCrea = '8';
            kind = true;
            System.out.println(this.getName() + " success");
        }
    }
}
```
###field包
在战场部分设置两个类BattleField和Control，主体设计思想为：Control类用来控制成员的排布，而BattleFiled用来控制战场输出等（后续扩展战局判断）。
两个类成员分别如下：
```java
public class BattleField{
    private int N;
    private Creature[][] creatures;
    }
    
public class Control {
    private int N;
    int JleaderX,JleaderY,DleaderX,DleaderY;
    //用于设定双方队列领头人
    private Creature[][] creatures;
    }
```
二者拥有同样的一个Creature数组（这里没想到如何抽象使得数据传递完善），
二者中拥有相似的函数用来传递数组。
```java
    public Creature[][] getCreatures() {
        return creatures;
    }
```

但不同类的初始化方式不同：
BattleField：
```java
    public BattleField() {
        N = 20;
        creatures = new Creature[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                creatures[i][j] = null;
            }
    }
```

Control:
```java
    public Control() {
        N = 20;
        creatures = new Creature[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                creatures[i][j] = null;
            }
        JleaderX = 9;
        JleaderY = 9;
        DleaderX = 9;
        DleaderY = 10;
    }
```

具体的生物设置位置以如下函数实现：
```java
    private void setCreatureToPositon(Creature creature, int inputX, int inputY) {
        if (isPositionEmpty(inputX, inputY)) {
            creatures[inputX][inputY] = creature;
            creature.moveToGoal(inputX, inputY);
        } else {
            System.out.println("thispersion Have a PeoPLE");
        }
    }
```

生物位置清理以如下函数实现：
```java
    public void clearBattleField() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                try {
                    moveCreatureOut(creatures[i][j]);
                } catch (Exception e) {//用来debug。
                    System.out.println(i);
                    System.out.println(j);
                }
        }
    }
    private void moveCreatureOut(Creature creature) {
        if (creature != null) {
            creatures[creature.getCoorX()][creature.getCoorY()] = null;
            creature.moveToGoal(-1, -1);
        }
    }
```

以鹤翼阵为例，葫芦娃一方实现方式如下：
```java
    public void makeJusticeHeyi(Creature[] calas) {
        setCreatureToPositon(calas[0], JleaderX, JleaderY);
        setCreatureToPositon(calas[1], JleaderX - 1, JleaderY - 1);
        setCreatureToPositon(calas[2], JleaderX - 2, JleaderY - 2);
        setCreatureToPositon(calas[3], JleaderX - 3, JleaderY - 3);
        setCreatureToPositon(calas[4], JleaderX + 1, JleaderY - 1);
        setCreatureToPositon(calas[5], JleaderX + 2, JleaderY - 2);
        setCreatureToPositon(calas[6], JleaderX + 3, JleaderY - 3);
    }
```
其余阵型相似。

在BattleField中，打印战场的函数为：
```java
    public void printBattleFieldStatues() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isPositionEmpty(i, j))
                    System.out.print("- ");
                else
                    System.out.print(creatures[i][j].getSymbolForCrea() + " ");
                //System.out.println();
            }
            System.out.println();
        }
    }
```

##输出的结果（以偃月阵为例）
```java
- - - - - - - - - - - - - - - - - - - - 
- - - - - - - - - - - - - - - - - - s - 
- - - - - - - - - - - - - - - - - - - - 
- - - - - - - - - - - - - - - - - - - - 
- - - - - - - - - - - - - - - - - - - - 
- - - - - - - - - - - - - - - - - - - - 
- - - - - - - 7 - - - - m - - - - - - - 
- - - - - - - - 5 3 m m - - - - - - - - 
- - - - - - - - - 1 x - - - - - - - - - 
- - - - - - - - 4 2 m m - - - - - - - - 
- - - - - - - 6 - - - - m - - - - - - - 
- - - - - - - - - - - - - - - - - - - - 
- - - - - - - - - - - - - - - - - - - - 
- - - - - - - - - - - - - - - - - - - - 
- - - - - - - - - - - - - - - - - - - - 
- - - - - - - - - - - - - - - - - - - - 
- - - - - - - - - - - - - - - - - - - - 
- - - - - - - - 8 - - - - - - - - - - - 
- - - - - - - - - - - - - - - - - - - - 
//x表示蝎子，8表示爷爷，1-7表示葫芦1-7，s表示蛇，m表示小怪
```