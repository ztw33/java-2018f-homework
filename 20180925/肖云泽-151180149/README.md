# 第一次修改说明

## 概述

和version1.0相比，整体设计思想保持不变，改动了一些类的结构和成员函数；对成员变量实施了一定的保护，有setter和getter的存在；对一些异常进行处理

## 主要修改的类

### Creature

增加了camp的成员变量，代表阵营

### Formation

将枚举类型Formation改为抽象类，具体的阵型类继承Formation类，更容易添加新阵型；去除了原来用于保持阵型信息的Array类，信息保存在相应的类中

### Queue

表示可以放在战场的生物序列，添加了addQueue(),addCreature()函数，增加了判断同一个Queue非相同阵营的异常处理

### Unit

仅在初始化时可以改变Position，即保证Position不会变，而其上的Creature可以任意改变

### Battlefield

changeFormation()不会自动添加或削减至阵型数量上限的小喽啰，需要手动处理




# 说明

## 概述

程序分为三个package及一个start类：

- start包含main函数

- battlefield主要是战场和阵型的设置

- creature包含所有生物的信息

- infos包含一些必须的常量设置

## 设计思想

- Creature是所有生物的基类，包含生物的名字和位置信息，其中CalabashBrother类的建立需要枚举类型CalabashBrotherMask作为模板。
- Battlefield代表战场，由`N*N`个Unit组成，有放置生物、变换阵型、清除战场、打印输出的功能。枚举类型Formation包含固定的三个阵型，其中具体阵型的定义在Array，Queue为一个生物序列，用以生成阵型及排序。
- infos的信息包含战场大小、葫芦娃生成信息、妖怪生成信息

## 输出示例
![](https://github.com/DarkMagicXYZ/Java-2018f-pics/blob/master/Outputv1.1.png)