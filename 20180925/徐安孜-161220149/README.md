#第三次作业说明

###Creature类
空间中每个坐标处都可以存在一个生命体，葫芦娃、爷爷、蝎子、蛇精、小喽啰都属于生命体，因此可以让他们分别继承Creature类
```
class Creature{...}
class Calabash extends Creature{...}
class LittleMonster extends Creature{...}
class Scorpion extends Creature{...}
```
考虑到爷爷和蛇精都有加油这个方法，但各自加油方式不同，编写CanCheer接口
```
interface CanCheer(){...}
class Grandpa extends Creature
    implements CanCheer{...}
class Snake extends Creature
    implements CanCheer{...}
```


###Formation枚举类
Formation类中记录了阵型长、宽、组成阵型所需实体数量，并用数组形式记录了阵型式样（即各实体成员的相对位置），同时还包含一个由组成该阵型成员构成的动态数组
操控者在在放置阵型时，根据阵型的绝对位置和其中成员的相对位置，将实体放置于空间特定坐标处



###Manipulator类
操控者，负责各个生物体的创造、排序、放置、移除
```
class Manipulator {
    Scorpion CreateScorpion(){...}
    LittleMonster CreateLittleMonster(){...}
    Grandpa CreateGoodBoss(){...}
    Snake CreateBadBoss(){...}
    Calabash[] CreateCalabashBrothers(){...}

    void Swap(Calabash[] brothers,int i,int j){...}
    void CalabashSort(Calabash[] brothers){...}
    void PlaceCharacter(Space bf, Creature c, int x, int y){...}
    void RemoveCharacter(Space bf, Creature c){...}
    void PlaceFormation(Space bf,Formation f,int x,int y){...}
    void RemoveFormation(Space bf, Formation f){...}
}
```


###Space类
其中包含了二位数组map记录地图信息
Display()方法输出地图信息






