
# 作业说明
###类Creature
    最核心的类包含生物的坐标信息，名字，以及移动到某一坐标的命令
###类hulubrothers
    class HuluBrothers extends Creature{}
    class Grandpa extends Creature{}    
    葫芦娃与爷爷都在这个类中
###类Devils
    包含了蛇精和其他妖怪两个类，蛇精拥有唯一的命令changeLine来调整妖怪的队列
    蝎子精由于和普通小喽啰没有其他特殊区别，所以归为和小喽啰一个类，作为整个妖怪数组的第一个元素出现
###类Line
    控制所有生物的站位队列情况
###类BattleField
    整场战斗的主战场，由setupField控制战场的生成，cleanField处理战斗后的战场，以及printField来让我们看到整场战斗的过程
###类Battle
    程序的主函数，控制战斗开始和结束
###优点
    可以灵活的定义，添加每一个对象的参数，为以后的代码修改提供便利
###不足
    葫芦娃进场排序未实现，爷爷和蛇精现在处于固定位置，考虑以后增加选定位置的可能
