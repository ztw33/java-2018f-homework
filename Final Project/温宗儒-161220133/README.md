## 葫芦娃大战妖怪(Final Project)

![show](https://github.com/turncoat54/java-2018f-homework/blob/master/Final%20Project/%E6%B8%A9%E5%AE%97%E5%84%92-161220133/image_readme/show.gif)





##### 游戏介绍：

- 由大娃带领的葫芦娃战队和蝎子精带领的喽罗战队展开激战， 首先由大娃和蝎子精solo，solo结束后葫芦娃战队和喽啰战队开打，最终被消灭的一方失败。



##### 游戏说明：

- 由于与设计思路不符，此游戏最终删除了阵型实现等代码，此次实验的目的是为了熟悉java语言的特性、语法等，所以有小的偏差。


- 战队头领默认为大娃和蝎子精；
- 葫芦娃战队只能选择三名，确保大娃的安全；喽罗战队可以设置不同种类妖怪的数量，范围在1~200之间；
- 伤害计算：伤害值=攻击力-防御力；
- 各种葫芦娃和妖怪的属性如下：

|  角色  |         描述         | 攻击力  | 是否远程攻击 |  血量  | 防御力  |
| :--: | :----------------: | :--: | :----: | :--: | :--: |
|  大娃  |    本领力大无穷、身体变大。    | 380  |   否    | 2300 |  80  |
| 蝎子精  |  从葫芦山中逃出的妖怪，作恶多端。  | 400  |   否    | 1700 |  70  |
|  二娃  |   本领千里眼、顺风耳、轻功。    | 330  |   否    | 2000 |  40  |
|  三娃  | 本领铜头铁臂、钢筋铁骨、十八般武艺。 | 300  |   否    | 2000 |  70  |
|  四娃  |  本领吞吐烈火、霹雳、身体耐火。   | 330  |   是    | 2000 |  40  |
|  五娃  |  本领吞吐河水、霹雳、酒量很大。   | 330  |   是    | 2000 |  40  |
|  六娃  |  本领隐身、穿过物体、空中移动。   | 300  |   否    | 2000 |  60  |
|  七娃  |     本领宝葫芦、离心咒。     | 330  |   是    | 2000 |  40  |
| 蝙蝠精  |        小喽啰。        |  12  |   是    |  23  |  30  |
| 蜈蚣精  |        小喽啰。        |  11  |   否    |  33  |  40  |
| 蛤蟆精  |        小喽啰。        |  10  |   否    |  43  |  40  |



#### 设计思路：

![class](https://github.com/turncoat54/java-2018f-homework/blob/master/Final%20Project/%E6%B8%A9%E5%AE%97%E5%84%92-161220133/image_readme/class.png)



- 所有生物的最基本类是Creature类，继承关系如图所示，每种生物都用使用单例模式进行编写，防止出现多个“大娃”、“二娃”等情况。会攻击的对象还包括原形状、攻击时的形状等。
- 游戏创建过程：

```java
public void initialize(GameType gameType) {
    if(gameType == GameType.CREATE) {
        createFile();
    }
    positionInit();   //初始化二维战场
    audienceInit();   //爷爷和蛇精就位
    gourdBoysInit();  //葫芦娃就位
    monsterInit(GourdboysController.getBatNumber(),GourdboysController.getCentipedeNumber(),GourdboysController.getToadNumber());    //怪物就位
    gameStart();

}
```

首先初始化战场，创建二维的棋局，用来放置各种生物。

接着初始化观众（爷爷和蛇精)、葫芦娃、怪物，将它们的参数依据输入生成各种生物。

最后将各种生物的线程开启，战斗开始。

gameStart()函数：

```java
firstChild.start();
scorpion.start();
minions.start();
gourdBoys.start();
```



- 生物打斗过程：

  此游戏借鉴了QQ空间“胡莱三国"游戏思路，游戏分为四个线程，大娃、蝎子精、葫芦娃战队、喽啰战队。

  大娃和蝎子精逻辑类似，互相攻击，以蝎子精为例：

  ```java
  while (notDead() && !Space.isSoloEnd()) {//自己没死，且solo没有结束时
      synchronized (FirstChild.class) {
          attackFirstChild(Space.getFirstChild());//攻击葫芦娃
          if (!Space.getFirstChild().notDead()) break;
          setImageBack();
          Thread.sleep(1000);
      }
  }//solo结束
  if(notDead()) {                //如果没死，退后到后方，战队战斗开始
      for (int i = 0; i < 14; i++) {
          move(Space.getPosition(), 15, 21 + i);
          Thread.sleep(500);
      }
      Space.setSoloEnd(true);
  }else {
      cleanImageView();
      Space.setSoloEnd(true);
  }
  ```

  ​

  葫芦娃战队和喽罗战队类似，以喽罗战队为例：

  首先，战队包含三个种类，蝙蝠精、蜈蚣精和蛤蟆精：

  ```java
  private Bat bat;
  private Centipede centipede;
  private Toad toad;
  ```

  ```java
  while (!Space.isWarEnd()) {//当战斗没有结束
      while (Space.isSoloEnd()) { //如果solo结束了，战队战斗开始
          synchronized (GourdBoys.class) {
              Thread.sleep(1000);
              if (bat.getLocationY() > 20) {
                //三个生物开始移动
                  Position[][] position = Space.getPosition();
                  bat.move(position, bat.getLocationX(), bat.getLocationY() - 4);
                  centipede.move(position, centipede.getLocationX(), centipede.getLocationY() - 4);
                  toad.move(position, toad.getLocationX(), toad.getLocationY() - 4);
              }
            //如果它们没被消灭完，则攻击葫芦娃
              if (bat.getNumber() > 0) {
                  bat.attackGourdBoys(Space.getGourdBoys());
              } else {
                  bat.cleanImageView();
              }
              if (centipede.getNumber() > 0) {
                  centipede.attackGourdBoys(Space.getGourdBoys());
              } else {
                  centipede.cleanImageView();
              }
              if (toad.getNumber() > 0) {
                  toad.attackGourdBoys(Space.getGourdBoys());
              } else {
                  toad.cleanImageView();
              }

              if (bat.getNumber() <= 0 && centipede.getNumber() <= 0 && toad.getNumber() <= 0) {
                  Space.setWarEnd(true);
                  break;
              }
              bat.setImageBack();
              ;
              centipede.setImageBack();
              toad.setImageBack();
          }
      }
      Thread.sleep(100);
  }
  ```



- 战斗结束：

  当葫芦娃阵营全部阵亡时，显示蝎子精的邪恶图片，表明蝎子精胜利。

  当喽啰战队全部阵亡时，显示七个葫芦娃的正义图片，表明葫芦娃胜利。



##### 单元测试：

实验中的方法多无返回值，我测试了生物被攻击后是否存活。

```java
@BeforeClass
public static void before(){
    new JFXPanel();
}
@Test
public void firstChildTest(){
    FirstChild firstChild = new FirstChild();
    firstChild.beAttacked(2300);
    Assert.assertTrue(firstChild.notDead());
    firstChild.beAttacked(170);
    Assert.assertFalse(firstChild.notDead());
}
```



## 总结：

#### 设计原则：

SRP单一职责原则：每种生物都有自己独特的功能，相应类有相应的，对应自己的方法。

OCP开放封闭原则：创建ImageSetter、Cheer接口，并在需要的类中实现。

LSP LISKOV替换法则：所有Creature的派生类都可以替换为Creature类。

ISP接口隔离原则：ImageSetter接口中的方法均需要实现的类全部实现，没有多余的方法。

CARP合成/聚合复用原则：在Minions和GourdBoys类中包含了Bat、Centipede、Toad等类。



**个人体会：**

之前总是凭借自己的想法，按照自认为对的方式去编程，以为只要实现各种功能，就是成功的代码，后来在不断的学习，发现更好、更规范的方法后，不断改进自己的代码，才发现，之前写的代码一团糟，改正后的代码才是思路清晰，一目了然。

这次的大作业的目的并不只是在于写葫芦娃，而是借助葫芦娃这个“载体”，熟悉各种编程方法、习惯，尝试使用各种功能，提高编程能力。