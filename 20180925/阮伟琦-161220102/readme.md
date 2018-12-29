# hw3 girls und panzer--war

## 前言
这次的更新我是从对solid原则的检查开始的，看了下srp原则没啥问题，然后在对ocp原则的检查中发现所有人物有关的类都没有构造函数这个比较大的问题，于是添加了构造函数。再者，发现所有类当中的变量都基本没有加上private，protected等限制，于是添加上。然后又觉得说oral gray和别的stggc的成员有一个有没有颜色上的区别，所以又把stggc_student和seggc_teammember做了区别，让后者继承前者。做了这些之后突然觉得自己的整个结构都有问题，于是重新写了一下。因为还有其他事务的缘故，所以荣在下日后再做修改。

## package & class

<div>
    <img src="pictures\package & class.png" width=30%>
</div>

如图，在设计的时候觉得说这个企划的关键应该是一个战场battlefield，然后field上面有一个一个的格子，格子里可能有各种各样的character。所以unit这个class便应运而生，battlefield主要的功能就是承载一个class unit的二维数组作为真正的field所在。然后我想来想去，还是觉得站队形应该是character自己的本领，所以便还是把各个type的队形作为了class human的function，同理cheer也应该是如此。
部分UML如下：
<hr/>
gup:
<div>
    <img src="pictures\UML of gup.png" width=70%>
</div>
character:
<div>
    <img src="pictures\UML of character.png" width=90%>
</div>
stggc_teammember:
<div>
    <img src="pictures\UML of stggc_teammember.png" width=90%>
</div>
shimada_alice:
<div>
    <img src="pictures\UML of shimada_alice.png" width=90%>
</div>

## function
主要的function除去初始化不说，比较关键的function就是各个formation以及cheer的function。我觉得formation和cheer因为不是所有class human的对象都具有的function，而且其中formation的实现还有跨类的现象，所以决定把它们作为一个interface来看待，现在想想其实也没什么不妥当的地方。实现如下（formation只贴了两种不同的snaketype作为例子）：
```java
public void snaketype(int x, int y, int num, battlefield field, human leader, human character[])
{
    clear(field);
    field.getfield()[x][y].setcharacter(leader);
    for (int i = 1; i < num; i++) {
        field.getfield()[x + i][y].setcharacter(character[i - 1]);
    }
}
```
```java
public void snaketype(int x, int y, int num, battlefield field, human character[]) {
    //field.getfield()[x][y].setcharacter(this);
    for (int i = 0; i < num; i++) {
        field.getfield()[x + i][y].setcharacter(character[i]);
    }
}
```
想法就是每次变阵前首先要清理掉原有的在战场上留下的痕迹（这其实不是特别合理后面会提到），然后在有必要的位置放上character就ok了。这里用到的setcharacter function是一个unit的function，作用就是在某个给定的位置set character：
```java
public void setcharacter(human character)
{
    this.is_occupied = true;
    this.people = character;
}
```
值得一提的是，实现clear的时候用到了类型检查的方法。
```java
private void clear(battlefield field)
{
    for(int i = 0; i < 17; i++)
        for(int j = 0; j < 17; j++)
            if(field.getfield()[i][j].get_is_occupied())
                if(university_student.class.isInstance(field.getfield()[i][j].gethuman()))
                    field.getfield()[i][j].setfree();
}
```
关于cheer，暂时只是set character了而已，并没有什么其他的操作。如下：
```java
public void cheer(battlefield field, int x, int y, human character)
{
    field.getfield()[x][y].setcharacter(character);
}
```

## outcome

<div>
    <img src="pictures\outcome1.png" width=20%>
 	<hr/>
    <img src="pictures\outcome2.png" width=20%>
</div>

## 后续思考
关于上面说到的clear的问题，其实我想象当中最棒的实现办法应该是突出变换这个概念的，也就是从哪里到哪里的感觉，但是暂时还没有很好的实现方法。再者，虽然这次用到了interface，但是interface中，一个class如果implement了一个interface就必须提到这个interface里面的所有函数这一点让我感觉有点不是很方便。
