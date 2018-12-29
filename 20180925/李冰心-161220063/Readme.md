# 设计说明
用markdown语法以文字说明所写代码中用到哪些面向对象的概念、机制、设计理念等，并阐述这样做的好处。

## 角色
- 根据题目要求，我先定义了一个类 lives，这个类中定义了两个属性，name 和位置 pos；同时，定义了角色位置改变的方法 set、角色报位置的方法 tell、角色返回名称 name、打印图标 print。其次，我使用 huluwa（葫芦娃）、boss（蝎子精）、mst（小喽啰）、cheer（爷爷和蛇精）分别继承父类 lives

## 空间
- 在类 where 中，定义坐标x，y，以及存在的角色 on，定义了角色变动的方法set,cleanOn;
- 在类 tree 中，定义了 col,row 限制空间大小、以及二维数组 where[ ][ ] space。

## 阵法
- 在类list 中，只定义了static 的方法changshe、heyi、yanxing 等阵法。可以直接调用方法。
