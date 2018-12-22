# README

## 代码内容
```
package calabashworld//葫芦娃世界的基础：场地类Field、格子类Cell、物/生物类Thing
package creatures//葫芦娃世界的所有生物：abstract类Creature、继承自Creature的具体生物类
package formation//阵法：abstract类Formation、继承自Formation的具体阵法类
package groups//生物群：abstract类Groups、继承自Groups的具体葫芦娃群类和妖怪群类
package output//包含用于输出的类
package picture//绘制2d图像：读入图片、图片缩放并拼接、绘制背景、绘制角色
```
## 面向对象
### composition
`Field.java`
```
public class Field{
    ...
    final Cell[][][] cells;
    cells(...){...}
    ...
}
```
### 继承:
`Thing <- Creature <- CalabashMan/Spirit/Snake/Oldman`
代码复用、is-a关系清晰显示，对于不同生物有共性的地方可以相同处理（例如可以按阵法排序）。
### 多态:
`CalabashMan.printme()/Spirit.printme()/Snake.printme()/Oldman.printme()`
`zhen.sort()`
`Snake.cheer()/Oldman.cheer()`
不同子类实例有不同行为，方便继承自同一父类的类的不同之处进行差异化的处理，在对一组父类引用指向不同子类进行处理时不需要分开考虑具体是哪个子类。
### 封装:
Groups.sort() 
`Groups.java`
```
public abstract class Groups implements Group{
    ...
    public void sort(){
    formation.sortTeam(creatures);
    }
    ...
}
```
Groups隐藏了按阵法站队的具体实现，想让生物群按阵法排序只需要调用sort()函数就可以。无法直接操作Groups中的成员，也无需了解Groups中的成员。
### association:
`Groups.java`
```
class Groups{
    ...
    Formation formation;
    ...
}
```
### aggregation:
`Thing.java`
```
class Thing{
    ...
    Position position = new Position();
    ...
    }
```
### delegating:
`Groups.java`
`sort();`
### 接口:
`Printable` `Sortable` `Cheerable`
规定可输出的接口，必须要实现print(Field field);同类功能用相同接口，相似类的行为在外界看来是统一的。
### srp:
	Thing只负责坐标
	
	代码更加清晰，写一个类的时候只需要考虑一个功能，不需要考虑无关的内容。
### ocp:
	Print实现了输出，但可以implements Printable实现另一种输出
	
	随时可以通过implements Printable实现自己想要的输出，而且不需要改变现有代码来实现，实现新的输出方法时只需要考虑新的问题，不需要考虑是否会破坏已经实现的功能。
### lsp:
	Spirit实例可以替换所有Thing的位置
	
	在对很多不同的Thing进行操作时，不需要考虑他具体是哪类Thing，只关注Thing可以做什么就行了。
### dip:
	Groups中的formation对象对应的类是abstract类，不同的阵法从Formation继承。
	
	Groups只需要知道自己有一个formation的实例，formation有排序的接口，那么groups就可以使用这个接口进行排序，不需要知道具体是哪个阵法。Groups和具体的阵法类之间并不会相互影响。
