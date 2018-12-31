# 设计说明
- 将葫芦娃和妖怪分为两个阵营，葫芦娃阵营有爷爷和葫芦兄弟，妖怪阵营有众喽啰，蛇精，蝎精。  
- 两个阵营在一个地图上展开各自阵型。  
- 所有葫芦娃，妖怪以及蛇精蝎精爷爷都属于生物，生物有自己的名字并且可以站在地图上的某个位置

## 生物体
```*/creature        //含所有生物体或生物体群的package```   

生物体有自己的名字，可以站在地图上的某一位置；
```
public class Creature{
  protect String name;

  public void standOn(Map map,int x, int y){...}
}
```
生物体中包含：  
- 葫芦娃
- 喽啰
- 爷爷
- 蛇精
- 蝎精
- 葫芦兄弟
- 众喽啰

其中，其中每个单个生物可以定义自己的名字，葫芦兄弟和众喽啰作为一个整体，
可以站成不同的队列 `queue`。

## 地图
```*/map        //含地图，以及位于地图上的葫芦阵营和妖怪阵营```  
地图上包含：
- 地图本身 `class Map{...}`
- 葫芦阵营  `clsss HuluCamp{...}`
- 妖怪阵营  `class MonsterCamp{...}`

每个阵营有自己的所属成员和可用阵型：
```
public class HuluCamp{
    private CalaBrother calaBrother;    //葫芦兄弟
    private GrandFather grandFather;    //爷爷

    public void queue(Map map){...}
}
```
```
public class MonsterCamp{
    private MonsterQue monsterQue;      //众喽啰
    private Scorpion scorpion;          //蝎精
    private  Snake snake;               //蛇精

    public void queue(Map map){...}
}
```
地图有固定的大小 `col*row`,有二维数组存储其上生物位置。当所有生物在地图上站定后(阵容确定阵型)，map打印其上生物位置信息。  
```
public class Map {
    private static int rows,cols;
    static{
        rows = 10;  cols = 20;
    }
    private Creature[][] creatures;

    public void printMap(){...}
}    
```

## 用户设计
在 `main`函数中提供给用户选择双方阵型的功能  
```
Scanner src = new Scanner(System.in);
System.out.println("请选择葫芦娃的阵型：");
System.out.println("1.鹤翼 \n2.雁行 \n3.衡轭 \n4：长蛇 \n5.鱼鳞 \n6.方门 \n7.偃月 \n8.锋矢");
int n = src.nextInt();
switch(n){...}

System.out.println("请选择妖怪的阵型：");
System.out.println("1.鹤翼 \n2.雁行 \n3.衡轭 \n4：长蛇 \n5.鱼鳞 \n6.方门 \n7.偃月 \n8.锋矢");
int m = src.nextInt();
switch(m){...}
```
