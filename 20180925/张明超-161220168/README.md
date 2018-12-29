# v2说明
## 上版本代码缺陷分析
1.Formation类 仅有将所有的阵法用数组形式存储在该类中，而阵法应该可以扩展  
2.EnemyGroup将蝎子精和小喽啰放在一块进行处理  
3.没有考虑非生物的存在，没有Creature没有从Being类继承  
4.未使用RTTI,添加额外的判断，来识别葫芦娃一方与蛇精一方  
## 本版本UML类图(显示了dependence)
1.beings包和calabashGroup和CalabashCompare类
![Image text](https://raw.githubusercontent.com/cockroach20168/java-2018f-homework/master/20180925/%E5%BC%A0%E6%98%8E%E8%B6%85-161220168/img/modified2.png)
  
2.formations包
![Image text](https://raw.githubusercontent.com/cockroach20168/java-2018f-homework/master/20180925/%E5%BC%A0%E6%98%8E%E8%B6%85-161220168/img/modified3.png)
## 类说明
### beings包
类名 | 描述 | 父类      
--------|--------|---------
Beings|存在（某种存在）具有位置属性|Object
Creature|生物（后续可能添加血量等属性）|Beings
NonCreature|非生物|Beings
JustParty|正义方|Creature
EvilParty|邪恶方|Creature
CalabashBrother|葫芦娃，具有独有的Color属性|JustParty
Grandfather|老爷爷，实现Cheer接口|JustParty
LittleMonster|小喽啰|EvilParty
Scorpion|蝎子精（作为大boss应该后续应该有区别于小怪之处）|EvilParty
Snake|蛇精，实现Cheer接口|EvilParty

### formation包
类名 | 描述 | 父类      
--------|--------|---------
Battlefield|由Being类型二维数组构成，存储该位置上的物体（生物或非生物）|Object
Formation|阵型由cheerPoint和阵型的点组成|Object
FormationType|enum类，记录所有阵型名|Object
BowandArrow|锋矢|Formation
CraneWing|鹤翼|Formation
CrescentMoon|偃月|Formation
FishSquama|鱼鳞|Formation
GeeseFlyShape|燕行|Formation
LongSnake|长蛇|Formation
SquareCircle|方円|Formation
XShape|冲轭|Formation

### CalabashGroup类，CalabashCompare类与World类
类名 | 描述 | 父类      
--------|--------|---------
CalabashGroup|由ArrayList<CalabashBrother>组成，具有shuffle和sort方法|Object
CalabashCompare|实现Comparator<CalabashBrother>接口|Object
World|main函数所在，负责创建所有的对象|Object

## 改进
1.使用ArrayList<CalabashBrother>来构建CalabashGroup类，通过实现Comparator 接口来完成排序(可以支持后续不同的关键字来进行排序)，符合SOLID原则  
2.改变原来的阵型存储仅存储方式，试图将阵型和Battlefield解耦合(阵型和场地大小没有绝对关系，应当可以在场地的合理位置都可以布置阵型)  
阵型存储和布阵生物解耦合(生物和阵型也没有联系)  
3.阵型改为继承Formation的方式实现，可以支持扩展  
4.添加了JustParty和EvilParty两个类，利用RTTI实现布阵时两方阵营的判断  
5.允许非生物的出现，后续可以添加障碍或者各种其它非生物  

## 设计思路
1.所有生物（非生物）由World创造  
2.Being是所有事物的基础，从其延伸出Creature和NonCreature，再继承Creatrue得到双方阵营，然后是各种生物  
3.葫芦娃作为一个团体可以支持排序，随机排列  
4.Battlefield存储战场上的现状,每个位置上存储了Being对象的引用，方便后续战斗时血量的增减
5.阵型中存储可以cheer的生物的位置和其它人的位置  
6.在一方阵营变换阵型时另一方并不需要移动，也不应当清除整个Battlefield上的数据，这里采用一个生物要被设置为新位置时将旧位置置为空的方式  

## 面向对象特性
1.继承 Creatrue继承Being, Grandfather继承JustParty  
2.组合 formation 由FormationType和Pos组成  
3.多态 不同的生物重写不同的toldname  

## 一些思考
1.在后续要实现图形界面的情况下，显然每个葫芦娃需要一个或多个图片，可以考虑创建一个CalabashBrotherWithImage继承CalabashBrother，在创建CalabashGroup时将CalabashBrotherWithImage数组直接传入其中进行初始化，而Battlefield显然支持存储新类型的引用，这样在Battlefield显示时，使用CalabashBrotherWithImage的show方法可以做到从控制台的输出改为在图形界面上的显示  