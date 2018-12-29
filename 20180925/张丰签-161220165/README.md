1.本次作业共由8个.java文件构成，其中main函数包含在BattleField.java文件中

2.本次作业中，将所有生物体当作了一个对象（包含某些共有的属性和行为），特殊的生物体（葫芦娃、老爷爷、蛇精、蝎子等，因其每个角色均有自己的特有属性和行为）均是Creature这个父类的继承；BattleField和Formation分别作为单独的类

3.文件BattleField.java：

	(1)构造函数为BattleField(int N),N作为整个棋盘的大小的参数,由此构建整个棋盘，若N<=10，则会默认为N=11	
	(2)该类中每个函数的具体功能：
		void show_all():打印整个棋盘
		void clear_all():将整个棋盘清空
		void clear_one(int x,int y):将坐标(x,y)位置清空
		boolean set_one(int x,int y,int num):将坐标(x,y)位置放置编号为num的生物，成功返回true，否则返回false
		boolean move(int x,int y,int to_x,int to_y):将坐标(x,y)的生物移动到坐标为(to_x,to_y)的位置，若(x,y)没有生物，或者(to_x,to_y)越界均会返回false
		int isWho(int x,int y):返回坐标(x,y)的生物的编号，若(x,y)越界或者没有生物均会返回0
		
4.文件Creature.java:

	(1)成员变量:
		int x,y 表示生物体二维坐标
		int number 表示生物体编号（0号不代表生物体，1-7号代表7个葫芦娃，8号代表老爷爷，10号代表蛇精，11号代表蝎子精，12号及以后均代表蝎子）
		int party 表示生物体阵营（老爷爷和葫芦娃为0，蛇精、蝎子精以及蝎子均为1）		
	(2)构造函数初始化以上成员变量	
	(3)该类中每个函数的具体功能：	
		int report_number():返回生物体编号
		int report_party():返回生物体阵营
		void show_pos():打印生物体当前坐标
		void move(int to_x,int to_y):生物体进行移动，并打印移动信息，参照上一次实验的功能
		
5.文件Formation.java:

	(1)保存的阵型，其构造函数为	
		Formation(int N,int team,int number,BattleField x) N为棋盘大小,team为蝎子数量,number为阵型号,以及BattleField类的对象x		
	(2)该类中每个函数的具体功能：	
		void change_formaion():根据构造函数获得的number调用不同的函数进行阵型构造
		void formaion1();void formaion2();……;
		对于不同阵型的函数
		
6.文件Snake.java、Grandpa.java、Soldiers.java、Brother.java、BrotherAct.java：

	分别为特殊生物：蛇精、老爷爷、蝎子以及蝎子精、葫芦娃、初始化葫芦娃颜色名字以及编号
	其中功能基本相同，可以打印名字、葫芦娃具有打印颜色的功能，蛇精和老爷爷具有打印“加油”的功能
	
7.程序运行情况：

	(1)首先由用户输入参数N，然后创建BattleField的对象，进行棋盘的创建和初始化；
	(2)进行n次循环，每次打印一种阵型（暂时共6种阵型，后续可继续增加其数量），蝎子数量为定值7（后续考虑由用户输入，暂未实现此功能），葫芦娃均设置为长蛇阵型，老爷爷和蛇精坐标分别位于(N/2,2)和(N/2,N/2)位置（暂时这样实现）；
	(3)循环开始，首先调用clear_all()清理棋盘，然后分别对每个类产生特定的对象并对其初始化，并按照自己应该站的位置，将相应参数修改，最后打印整个棋盘情况即完成一次循环
	(4)部分功能未使用，且未全部验证未使用功能的正确性，已使用的功能均未出现异常
	
8.实现思路

	将所有的功能均封装为不同的类，main函数并未执行过多的操作，仅进行初始化以及告知每个类应该执行什么功能
