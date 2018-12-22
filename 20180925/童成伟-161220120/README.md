作业3说明
========
一、类详解
--------
>Creature类：<br>
>>包含了生物的名字，在战场中的坐标x和y（默认初始化为-1）<br>
>>包含返回相应或设置坐标的函数<br>
>>Gobattle和Leavebattle表示Creature的动作（进入或离开战场，改变战场中对应位置状态）<br>
>>Calabash，Grandpa，Snake，Scorpion和Minion均继承Creature类, 包含的带参数的构造函数<br>
>>葫芦娃中新加了一个变量rank,，其值从enum CalaRank中获得，用于记录排名<br>

>CalabashBro类：<br>
>>表示葫芦兄弟，包含葫芦娃数组bro[]（初始化为7个）<br>
>>messbro：对葫芦兄弟随机排序<br>
>>CalabashBubbl：对葫芦兄弟进行冒泡排序<br>

>Space类：<br>
>>表示战场中的各个空间位置，包括是否为empty，位置坐标posx和posy，位置上的的生物Creature<br>
>>Space的动作：<br>
>>isEmpty：判断该位置是否为空<br>
>>getCreature:返回该位置的生物<br>
>>setcreature：将该space上放置一个生物<br>
>>removecreature：清除space上存在生物<br>

>Formation类：<br>
>>包含各种阵型供选择<br>
>>initformation:<br>
>>根据参数name选择对应的阵型<br>
>>生物start为每个阵型的起始位置，cre[]依据start在周围摆出所选的阵型, 放置在battle中ground[][]上的相应位置<br>

>Battleground类：<br>
>>作为战场，包含了战场的size，Space型的二维数组ground[][]表示战场中的空间位置，葫芦兄弟、蛇精、蝎子精、爷爷和小喽啰们<br>
>>战场中的动作有<br>
>>printbattle：对ground[][]进行遍历，打印出战场边界、非空位置上的生物<br>
>>clearbattle：清理ground[][]，将每个位置置空。<br>

在main中初始化battle和formation，选择formation的阵型<br>
通过initformation对battle中ground[][]的各个位置选择性放置生物<br>
通过printbattle打印出战场中的对战情况<br>

二、实现效果
----------
以长蛇，鹤翼，鱼鳞，锋矢这四个阵型为例：<br>
初始化，葫芦娃进入战场：<br>
![image text](https://github.com/NJUTto/java-2018f-homework/blob/master/20180925/童成伟-161220120/1.png)
妖怪们进入战场：<br>
![image text](https://github.com/NJUTto/java-2018f-homework/blob/master/20180925/童成伟-161220120/2.png)
葫芦兄弟重排，妖怪变阵：
![image text](https://github.com/NJUTto/java-2018f-homework/blob/master/20180925/童成伟-161220120/3.png)
妖怪再次变阵：
![image text](https://github.com/NJUTto/java-2018f-homework/blob/master/20180925/童成伟-161220120/4.png)
