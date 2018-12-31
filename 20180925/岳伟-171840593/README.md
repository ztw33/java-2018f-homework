
# 葫芦娃系列二设计说明
1. 为提高代码的复用性，这次仍是使用了之前CalabashBrothers的主类；
2.用不同的标志代表不同的生物体：
（1）Grandpa：@
（2）Snake：#
（3）Scorpion：$
（4）Underling：*
（5）葫芦娃老大到老二：1-7
3.针对这次新加入的蝎子精、蛇精等生物体，因为他们具有一些共同的性质，比如identity，name，position（他们在空间中所处的位置），所以设置了Biosome这个父类，然后他们依次去继承Biosome这个父类。至于他们不同的identity，name则分别在他们的构造函数里进行初始化；
4.程序中创建了一个position类用来存储控制台每个位置的x坐标和y坐标，并且创建了一个space类，包含了N*N（N为奇数）个position，最后所有生物体就在这个space里排列；
5.Formations这个类是一个队列类，里面有实现不同队列的函数，当要按某一种队列站队时就调用相应的函数，Formations里面给出了两个队列函数，一个是鹤翼（first_queue），一个是雁行（second_queue）。
