# 第三次作业简介

## 1.面向对象的概念：父类、子类、接口 
## 2.面向对象的机制：继承、重写、多态 
## 3.设计理念：
* interface Comparable :提供compareTO方法，用于比较大小。implement : Huluwa，依据排行摆长蛇阵时用到
* 父类 Creature :暂时只提供对象命名。implement: Grandpa（爷爷）、Scorpion（蝎子精）、Snake（蛇精）、Lesser（小喽啰）
* 类 Scorpion：蝎子精,提供召唤小喽啰，带领小喽啰摆雁行阵、方円阵等方法
* 类 Snake: 蛇精，用寻找蝎子精位置、跟随蝎子精的方法
* 类 Grandpa: 爷爷，有种葫芦藤、呼叫葫芦娃、让葫芦娃摆长蛇阵，走到葫芦娃中间为其加油等方法
* 类Position: 位置，包含坐标，其上放置的物体等信息
* 类 Land: 有长和宽，区域内的元素为Position类，提供展示土地上的活动等方法
* 类Reporter: 神秘记者，为现场活动拍照(输出画面)。
* 输出Position上的物体的信息时用到了多态，Position上放置的物体为Object类型，输出信息时即调用该Object的toString方法，各个进入Position的类通过重写toString方法实现了多态。 

## 4.好处:
* (1) 提高代码的可读性，逻辑更清晰，代码更生动，使人看到代码能想象出画面
* (2) 提高了代码的复用性
* (3) 类封装使得成员变量的使用更加安全
