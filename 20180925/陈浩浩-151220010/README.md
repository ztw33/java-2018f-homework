面向葫芦娃编程  
===
使用对象而不是数据结构  
---
**Calabash类**  
葫芦娃的类，提供了初始化方法（乱序）、排序方法（冒泡）、打印方法。  
```java
public class Calabash {  
    CalabashBoys[] Babys = CalabashBoys.values();  
    public Calabash(){}  
    public void Init(){}// init calabashbabys  
    public void BubbleSort(){}//冒泡排序  
    public void printb(){}
}  
```
爷爷、蝎子精、蛇精、蛤蟆精均都是一个对象，各自有一个类。  
**dimension类**  
二维矩阵的类，葫芦娃和妖怪战斗的战场。提供了创建战场的方法、放进实体的方法及打印方法等。  
```java
public class dimension {  
    final static int COL = 25, ROW = 15;  
    int mat[][] = new int[ROW][COL];  
    public dimension(){}  
    public void Init(){}  
    public void Clear(){}  
    public void ValuationMonster(Scorpion Scor, Frog[] frog){}//蝎子精和蛤蟆精放进矩阵  
    public void ValuationSnake(Snake Snak){}//蛇精放进矩阵  
    public void ValuationGrandfather(Grandfather Gran){}//爷爷放进矩阵  
    public void ValuationCalabash(Calabash Cala){}//葫芦娃放进矩阵  
    public void printMatrix(){}//打印矩阵  
}  
```
**优点**  
将数据及其操作进行封装，避免了对于数据随意更改，保障了数据的安全性，同时对于代码的抽象程度提高使得编程更易于理解。  
## 复用  
```java
public void ValuationMonster(Scorpion Scor, Frog[] frog){}//蝎子精和蛤蟆精放进矩阵  
```
只需传递蝎子精和蛤蟆精这两个对象，对于阵型则通过一个随机生成的数决定调用何种阵型方法。  
```java
Random r = new Random();  
int formation = r.nextInt(7);  
```
**优点**  
有效实现代码的复用，减轻编程工作量。  
