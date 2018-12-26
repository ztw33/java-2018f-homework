#  代码说明 
## 面向对象的机制 
* **继承**
    * **Interface**
    
        我定义了一些Interface：Compareble,Sorter,Space,MBuilder,MPoint.

        MPoint顾名思义用来表示一个点。由于点有1维，2维，3维之分，所以我设立了MPoint1D,MPoint2D实现了这个接口。对于位置Position来说，它不用考虑它处于哪一个维度，用什么样的方式来找到它，这些任务可以通过MPoint来完成。

        Space定义了一些与空间相关的接口。譬如第二次作业中一维的Queue,以及这次作业中的Matrix都实现了这些接口。对于Space来说，它只要知道它包含了一定数量的Pos，以及能够将自己完整地展现出来即可。至于将葫芦娃，妖怪等安排进space的功能，则由builder实现。

        MBuilder主要是用来联系空间Space与生物Creature的。创建这些接口主要是希望space只专注于存储的功能，至于如何存储由builder实现。

        总的来说，将这些设置为Interface的原因是因为在一维，二维，甚至以后可能的三维的条件下，实现方法都不同，但是功能类似。

        Creature,Comparable,Sorter与老师的代码中类似，不再赘述。

    * **abstract class**

        我设置了两个抽象类：Creature,MFormation

        将Creature 设置为abstract class的原因是它有很大一部分函数的实现方法大都类似。葫芦娃，爷爷，蝎子精，蛇精等等都继承自这个类。

        MFormation代表着一个阵型类，因为无论是在二维还是三维空间中，阵型所包含的元素很简单，一个起点，一个点集合，而且对外的接口都是一致的(比如返回点集等),因此我设置成抽象类。M2DFormation继承自这个类，将来可能会有M3DFormation。

* **多态**
    
    多态的实现主要依赖于类的继承与接口实现。
        
    譬如在第二次和第三次作业中都有一个让葫芦娃随机站位的要求，一个是在一维空间，一个是在二维空间。但是对于一个**builder**实例来说，只需这样即可
    ```
            //第二次
            Space queue = new Queue(HuluBrothers.length);
            MBuilder builder = new M1DBuilder();
            builder.randomBuild(queue,HuluBrothers);
    ```

     ```
            //第三次
            Space matrix = new Matrix2D(15,15); 
            MBuilder builder = new M2DBuilder();
            builder.randomBuild(matrix,HuluBrothers);
    ```


## 设计理念

* SRP 单一职责原则

    对于每个类，我希望简化它的功能。譬如阵型独立成类，与空间分开。而建立他们之间的联系的功能也独立出来，放在新的类里。

* LOD  迪米特法则

    弱化类与类之间的耦合性，尽量通过接口来建立类与类之间的联系。



        

    
    

    
