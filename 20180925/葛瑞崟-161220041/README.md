# 代码说明
## 代码思路
+ 共分四大类：main函数所在公共类CalabashBrotherBattle，生物体类Creature，阵型类Formation，战场类BattleGround
+ 生物体在main函数中实例化，以数组下标（记为id）区分个体，以Creature数组类型保存
+ 阵型在main函数中实例化，实质为固定大小的二维数组，共创建两个阵型（分别为葫芦娃阵营和怪物阵营），通过特定函数`void changeFormation(Name name)`来改变阵型
+ 战场在main函数中实例化，实质为大小为N的二维数组，通过特定函数`void deploy(Formation formation, int camp)`来将指定阵型放置于战场上
+ 战场和阵型中的二维数组均保存int值，-1为空，其余值根据id区分各个生物体

## 代码分析

### Creature父类
+ 下有id和symbol两个属性，id为数组下标，symbol为战场最终print出的字符
+ CalabashBrother子类
  + 内含一枚举类，同hw2用以枚举七个葫芦娃的信息
  + 七名葫芦娃id为1-7，symbol也为1-7
+ Grandpa子类 Snake子类 Scorpion子类 Creep子类
  + 基本无实际作用，仅用以区分剩余四种生物体
  + 老爷爷id为0，symbol为G
  + 蛇精id为8，symbol为S
  + 蝎子精id为9， symbol为s
  + 喽啰id为10及以上，symbol为c
  
### Formation父类
+ 下有一枚举类，用以枚举八种不同阵型，并保存阵型的length和width。及`int[][] formation`用以保存具体阵型
+ CalabashFormation子类
  + 同hw2的Sort类，做少许更改，在随机站队和排序后，将最终的数组以长蛇阵记录
+ MonsterFormation子类
  + 仅`void changeFormation(Name name)`一个函数，用以将formation数组变更为传入的name阵型
  + 具体利用`switch(name)`的方式对每个阵型进行各自设置

### BattleGround类
+ 下有一个二维数组`int[][] battleGround`，用以保存战场
+ `void deploy(Formation formation, int camp)`函数根据camp决定阵型朝向和大体位置，

  然后计算阵型大小和战场大小，将formation中的二维数组复制入battleGround二维数组的适当位置
  
  最后将蛇精和老爷爷固定在右上角和左下角
+ `void print()`扫描整个battleGround二维数组将对应id的symbol打印出来
