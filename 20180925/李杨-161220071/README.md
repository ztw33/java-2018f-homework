# java_homework3 #
## 结构说明
类结构图  
![being class](https://github.com/Chrisleeyang/java-2018f-homework/blob/master/20180925/李杨-161220071/image/being.png)  

being类 考虑后续可以表示生物或者物体  
* Creature类，用于表示各种生物  
    * Hero类，用于表示爷爷
        * grandpa 爷爷
    * CalabashBrother类 用于表示七个葫芦娃，内部使用枚举类型申明
    * Monster类 用于表示邪恶势力  
        * minion类 由于表示小喽喽
        * snake 表示蛇精
        * Scorpion 表示蝎子   
  
``` 
public class Being{...}  
public class Creature extends Being{...}  
public class Hero extends Creature{...}  
public class Grandpa extends Hero implements Cheer{...}  
public class CalabashBrother extends Creature{...}  
public class Monster extends Creature{...}  
public class Minion extends Monster{...}  
public class Scorpion extends Monster{...}  
public class Snake extends Monster implements Cheer{...}
```  
___
Battlefield类，里面包含了Coordinatel类型的N*N的二维数组，用于存放每个生物，包含displayfield（展现战场）和clearfield （清空战场）功能  
Coordinatel类，包含了x,y坐标，isempty判断该位置是否空闲，以及being用来在该坐标处安置一个being类型的生物  
```
public class BattleField {
    public Coordinate[][] battlefield;
    public void displayBattleField(){...}
    public void clearBattleField(){...}
}
public class Coordinate {
    public int x;
    public int y;
    public boolean isEmpty;
    public Being being;
    ...
}
```
___
formation接口，根据传入参数进行判断是葫芦娃还是喽喽，从而决定在战场左侧还是右侧进行布阵，然后对于八个针，使用formation接口对具体的排阵进行实施，以右上角为坐标原定，根据阵型在具体位置安排具体的creature。
```
public interface Formation {
    void setBeing(BattleField field, CalabashBrother[] brother);
    void setBeing(BattleField field,Minion[] minion);
}
public class ChangShe implements Formation{...}
public class FangYuan implements Formation{...}
public class FengShi implements Formation{...}
public class HeYi implements Formation{...}
public class HengE implements Formation{...}
public class YanXing implements Formation{...}
public class YanYue implements Formation{...}
public class YuLin implements Formation{...}
```
考虑到爷爷，蝎子，蛇精的位置是由用户自由决定，所以单独写了一个setbeing函数，用于安置这三个creature，具体实现为先判断该坐标是否为空，如果是空，则直接安置，否则则需要用户重新输入新的坐标。  
![formation class](https://github.com/Chrisleeyang/java-2018f-homework/blob/master/20180925/%E6%9D%8E%E6%9D%A8-161220071/image/formation.png)  
___
最终实现图如下  
![battle 1](https://github.com/Chrisleeyang/java-2018f-homework/blob/master/20180925/%E6%9D%8E%E6%9D%A8-161220071/image/battle1.png)  
![battle 2](https://github.com/Chrisleeyang/java-2018f-homework/blob/master/20180925/%E6%9D%8E%E6%9D%A8-161220071/image/battle2.png)  