# 葫芦娃第三次修改#

### 此次更新说明:###

- 主要实现了葫芦娃与Javafx框架的结合，实现战场的图形界面。

![ui](https://github.com/turncoat54/java-2018f-homework/blob/master/20180925/images/ui.png)



### 此次思考的核心问题：###

- **如何实现****后台数据**与**GUI界面**的分离？

  - 先用java写成后台的整体布局数据，再通过Javafx调用的方式，根据Position\[\]\[\]信息导入到GUI的Pane中实现后台数据的导入。

- **为什么要实现**后台数据与GUI界面的分离？

  - 便于框架的修改，不必从复杂的代码中剥离；
  - GUI布局与后台数据分离，各自分工明显，便于维护和修改。

- 实现代码：

  ```Java
  //实例化Space，获取后台的Position布局
  Space space = new Space();
  Position[][] positions = space.randomFormation(randomNumber);
  ```





### 设计思路：###

1. GUI和后台两部分：后台为backstage，其余部分均为javafx前台布局。

   ![twoParts](https://github.com/turncoat54/java-2018f-homework/blob/master/20180925/images/twoParts.png)

   后台类型：分为**生物**和**阵型**两大类，在Space空间中初始化Position，每个生物只能站在一个Position上。

   ![backstage](https://github.com/turncoat54/java-2018f-homework/blob/master/20180925/images/backstage.png)

   ​

2. Creature（生物），Space（空间），Formation（阵型），分类等，均在上次的报告中写到，此不再赘述。

![class](https://github.com/turncoat54/java-2018f-homework/blob/master/20180925/images/class.png)





3. GUI界面，在生成的javafx工程中，利用SceneBuilder对界面实现布局，绑定相应函数。![img](https://github.com/turncoat54/java-2018f-homework/blob/master/20180925/images/gui.png)







### 面向对象思想:###

1. 类的继承：在父类中定义共有的属性，子类的编写更简洁，并且易看懂。
2. 不同类之间的关系：每个Creature的派生类都可以站在Position上，Position又属于Space的空间。
3. 代码复用：将一些通用的工具函数，例如比较大小，获取时间等，可以放在uilt下进行调用，实现代码复用而不用在每个需要的类中再重复编写。