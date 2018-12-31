# 代码说明

## 符号说明
- ABCDEFG：葫芦娃老大到老七  
- Y：老爷爷（助威）  
- &：蝎子精  
- o：小喽啰  
- S：蛇精（助威）  

## 效果演示

<img src="img_readme/0.png" width=45%>
<img src="img_readme/1.png" width=85%>
<img src="img_readme/2.png" width=45%>
<img src="img_readme/3.png" width=45%>
<img src="img_readme/4.png" width=85%>
<img src="img_readme/5.png" width=45%>
<img src="img_readme/6.png" width=45%>

## 类图

<img src="img_readme/Main.jpg" width=100%>

## Point
点类型，属性为行和列，能够进行简单的显示行列、判断是否相等、移动等操作。  

## Type
enum 类型，为各阵型的名字：  
HY("鹤翼阵"), YX("雁行阵"), CE("冲轭阵"), CS("长蛇阵"), YL("鱼鳞阵"),
FY("方円阵"), YY("偃月阵"), FS("锋矢阵");  

## Creature
属性有：名字 String name，打印符号 char symbol  
根据行为方式的不同，被继承为3类：  
- 葫芦娃：Brothers  
  - 内部类 enum Members，规定了7个葫芦娃的名字，排行，颜色  
- 妖怪：Monsters  
  - 从“小喽啰”中继承出“首领”蝎子精：Scorpion
- 啦啦队：Mascot
  - 被“老爷爷” Elder 与”蛇精“ Snake 继承  

## Formation
其属性包括：  
- 阵型种类 Types type  
- 阵型行数 int formRangeRow  
- 阵型列数 int formRangeCol  
- 阵型图 Creature[][] creatureMap （没有人的位置为 null）
- 阵型的中心点 Point formCenter （用来定位）  

其方法包括：  
- Point center() // 得到阵型中心坐标  
- Types getType() // 得到阵型类型  
- int getRowNum() // 得到阵型行数  
- int getColNum() // 得到阵型列数  
- boolean isEmpty(int r, int c) // 某处是否有人  
- char[][] getFormMap() // 得到阵型打印效果  

子类就是八种阵型:  
（鹤翼阵 HeYi，雁行阵 YanXing，冲轭阵 ChongE，长蛇阵 ChangShe，鱼鳞阵 YuLin，方円阵 FangYuan，偃月阵 YanYue，锋矢阵 FengShi）  
它们的不同之处在于构造函数。

## WorldMap
将各个 Formation 固定到世界当中。  
WorldMap 在定义了地图的行列数 rangeRow, rangeCol 之后，仅仅保留各个阵型的对象以及该阵型在地图中应该在的位置（Point 类型，指示该阵型中心点坐标）。  
移动阵型的操作只需要改变该阵型的中心点定位；  
改变妖怪阵型的操作只需要改变妖怪阵型所引用的对象（如从雁行阵改为鱼鳞阵，则原来的 monForm = yxForm 变为 monForm = ylForm，其中 monForm 是 Formation 类型，yxForm/ylForm 是 YanXing/YuLin 类型）。  
而打印世界地图，即 showWorld() 的过程，才是把各个阵型正式“空降”到世界地图上，其过程是：  
- 建立一个行列为 rangeRow, rangeCol 的地图 char[][] map  
- 初始化，使 map 的每个元素都为 ' '（空格）  
- 通过 Formation 的行为 char[][] getFormMap()，得到葫芦娃和妖怪阵型局部的显示图  
- 通过葫芦娃阵型和妖怪阵型的中心点定位，将这两个局部小图的内容覆盖到世界地图 map 上  
- 通过啦啦队老爷爷和蛇精的定位点，将老爷爷和蛇精的符号覆盖到世界地图 map 上  
- 打印世界地图

## Observer
main 函数所在的类。
形成一个类似于mud游戏的效果，可以供使用者做出选择，以控制 WorldMap 的行为。
