#关于本次作业的思考
##使用到的面向对象的概念
1. 接口  
设计了两个接口：Creature、Holder  
两个枚举类实现了接口Creture，分别是GoodPeople、Demon  
两个普通类实现了接口Holder，分别是GoodPeopleHolder、DemonHolder  
对于Holder类本来打算使用继承机制，但是感觉继承的使用破坏了一定的封装性，于是就改成了接口

##使用到的面向对象的机制
1. 多态性  
接口实现式多态，在Map中是使用了Creature[]数组，该数组既可以存放GoodPeople类型，也可以存放Demon类型  
2. 封装性  
将实现和内部数据隐藏  
对于GoodPeople、GoodPeopleHolder、Demon、DemonHolder只给外部类提供了接口，将内部的实现隐藏起来了  
对于Map类也是如此，只对外部提供可用的接口  

##使用到的面向对象的设计理念
1. 单一职责原则  
使用Holder类来专门实现对象的排序、存储功能  
使用Map类来专门实现对象的队列排列、显示  
使用Game类来作为整个程序的入口
2. 针对接口编程  
针对接口编程，而不是针对实现编程。这样即使改变了内部实现，只要保证接口没有改变，就不需要进行大规模的修改