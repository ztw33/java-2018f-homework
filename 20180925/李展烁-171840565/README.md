#作业三

##Creature接口
###包含print方法，用一个中文字符表示自身。<br>
###Air类实现该接口。BadFollower接口，GoodFollower接口与Leader接口继承该接口。

##BadFollower接口与GoodFollower接口
###继承自Creature接口。
###增加move方法与setMoveDevice方法。每个类中包含一个moveDevice方法为move方法提供支持，四个参数为源x，y坐标与目标x，y坐标。接口名字不同是为了后面展示阵型时能够判断类型。
###GourdBoys类实现GoodFollower接口，Scorpion类与Goblins类实现BadFollower接口。

##Leader接口
###继承自Creature接口。
###除了Follower接口中的方法外，还有order方法与view方法，用setOrderDevice方法与setViewDevice方法提供支持。还包括一个greet方法，以待扩展使用。
###Grandpa类与Snake类实现该接口。

##MoveDevice接口
###包含moveMethod方法。四个参数为源x，y坐标与目标x，y坐标。
###Ground类实现该接口。

##OrderDevice接口
###包含orderMethod方法。参数为一个阵型的枚举类型FormationType变量。
###Formation类实现该接口

##ViewDevice接口
###包含viewMethod方法。
###Ground类实现该接口。


##third类
###只包含一个main函数。初始化一个Ground对象与一个Formation对象。并从Ground对象中获取Grandpa对象与Snake对象，调用其order方法与view方法，使葫芦娃、妖精列阵并查看。

##Ground类
###构造函数。需要地图的长度与宽度参数。并初始化7个葫芦娃，7个妖精，1个蝎子精，1个蛇精，1个老爷爷，其他用空气填充（实现要求length大于17）。并调用randomArrange方法随机初始化位置。
###moveMethod方法。本质上是一个swap。
###viewMethod与show方法。完全相同。打印地图。
###fallIn方法。把老爷爷和蛇精找出来（用到了反射），移到正确的位置上。
###getCreature方法。返回参数坐标位置的对象。
###getSnake与getGrandpa方法。返回老爷爷与蛇精的正确位置处的对象。只有在fallIn方法执行后才能得到正确结果。

##Formation类
###orderMethod方法。实现阵型变换的方法。用count计数要操纵的生物个数。两个数组记录对应下标生物的位置。使用反射判断生物类型，是否是目标生物（长蛇阵找葫芦娃，其他找小喽啰与蝎子精。并没有区分蝎子精与小喽啰）。switch中实现对每个阵营的处理。遍历目标生物数组进行处理。每次处理前用一个循环判断是否会发生冲突，进行额外处理。**这里效率较慢。**值得一提的是，使用数学公式完成了除方円阵外其他阵型，不依赖count，width，length，。因此可扩展性较好。**问题在于：时间紧。冗余代码较多。有时间可能要重构。**

##Air类
###print方法在地图上输出两个空格占位。

##Goblins类
###print方法在地图上输出“喽”。

##Scorpion类
###print方法在地图上输出“蝎”。

##GourdBoys类
###print方法在地图上输出自身位次。

##Grandpa类
###print方法在地图上输出“爷”。

##Snake类
###print方法在地图上输出“蛇”。

##其他
###Creature，Leader，Goodfollower，BadFollower可能实现为抽象类更好一点。每个类大都有因为有相应的Device支持。不过葫芦娃类为枚举类，无法继承。因此不好声明为抽象类。