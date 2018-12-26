1. 整体构建
	1. CalabashBrother.java
		1. 用于声明葫芦娃的种类，这个部分和延用了上一个作业的枚举变量，作为葫芦娃的种类存在，并可之后修改
	2. Coordinate.java
		1. 用于产生坐标相关信息
		2. hashLoc() 生成哈希的对应地址
	3. Battlefield.java
		1. 给出一个战场的基本类型
		2. Map battleState 记录对应位置上存放的个体
		3. boolean[][] vacuumState 位置是否被占用
		4. clearBattlefield() 清空战场
		5. addIndividual(Individual newComer, Coordinate pos) 初始化时添加新成员
		6. outputBattlefield 输出战场信息
	4. Individual.java
		1. 用于各种生物体的类型并可继承为具体个体
		2. Coordinate pos  个体坐标
		3. boolean side   好坏两方
		4. char symbol   代表的符号(暂时使用，后期便于替换)
		5. 在Individual的基础上继承产生Calabash, Grandpa, Scorpion, Snake, Goblin 并各自具有特征
	5. Test.java
		1. 目前的测试函数
		2. putCalabashOnBattle 将葫芦娃排序摆上战场
		3. putMonsterOnBattle 将怪物按指定阵型摆上战场
		4. enum Formation  阵型枚举变量，以这种方式暂时存放便于以后利用
2. 其他思路
	由于当前的步骤没有涉及到很具体的变化，所以各个特征都设计为便于修改和重利用的方式，
	比如putMonsterOnBattle是一个选择阵型排兵布阵的函数，后续可以整合成初始化战场等功能。

