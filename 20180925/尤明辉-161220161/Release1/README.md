# 设计理念

## 对象的继承和复用
- 战场上的所有单位都是生物体，使用Being对象描述它们，再使用不同的子对象继承Being
- 双方的阵容都可以抽象为一群soldier和一个leader，用BattleArray表示这种结构
- 用Being类型的矩阵表示战场，每一个矩阵内的空格可以为空，也可以有一个Being

## 变阵的实现
- 假想每个阵容中有一个指挥官，它负责统领全局，对阵型的变化作出指示
- 阵型的变化反映为战场上某一个方格上一个Being离开或是到来，指挥官指定一个空格，然后就会将一个Being放置在该位置上

# 不同对象的概念

## 战场（BattleField）
```java
    class BattleField{
        private Being[][] ground;
        private final int N;
        ... ...
    }
```
战场能够记载每一个Being的当前站位，并在变阵时记录Being的离开和到来

## 双方阵容（BattleArray）
```java
    class BattleArray {
        protected Being[] soldiers;
        protected Being leader;
    }
```
- 每个阵容都有一个精神领袖（葫芦娃一方的老爷爷，妖怪一方的蛇精），用该对象描述双方阵容框架
- 由于双方会使用不同的阵法，用CalabashSide和MonsterSide两个对象继承BattleArray来描述各自的阵容
```java
    class CalabashSide extends BattleArray {
        CalabashSide() {
            leader = new Grandfather();
            soldiers = new Calabash[7];
            for (int i = 0; i < 7; ++i) {
                soldiers[i] = new Calabash(i);
            }
        }
        ... ...
    }
    
    
    class MonsterSide extends BattleArray {
        private final int N;
        MonsterSide(int n) {
            N = n;
            leader = new Snake();
            soldiers = new Being[n];
            soldiers[0] = new Crab();
            for (int i = 1; i < n; ++i)
                soldiers[i] = new Devil();
        }
        ... ...
    }
```
可以想象在CalabashSide和MonsterSide中各有一位指挥官，它们是战场上统帅全局的存在，指挥变阵，以葫芦娃一方为例：
```java
    class CalabashSide extends BattleArray {
        public void snakeArray(BattleField battleField);    //一字长蛇阵
        ... ...
    }
```

## 描述整个战争的对象（War）
```java
    public class War {
        BattleField warField;           //战场
        CalabashSide calabashSide;      //葫芦娃一方
        MonsterSide monsterSide;        //妖怪一方
        ... ...
    }
```
这就像一个创世纪的过程，我们布置了战场，召唤了交战双方，然后让他们战斗

# 优点
- 保证了内部数据的安全性
- 合理的继承有助于多态的实现
- 有助于程序在日后进一步完善
