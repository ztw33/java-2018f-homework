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
![](https://github.com/DarkMagicXYZ/Java-2018f-pics/blob/master/Output.png)