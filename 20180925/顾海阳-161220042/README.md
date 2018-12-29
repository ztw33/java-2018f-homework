程序说明
====

类的设计
----
### 主类  ```Calabashballlte```类
对葫芦兄弟以及妖精们进行实例化，他们进入战场以及他们各自的阵型变化，战斗场景的展示。

### ```creature```类  
包含生物体的编号NO，打印的sign，当前坐标x,y（为后面做准备）  
#### ```Calabashbrothers```子类  
内含枚举类```enum```表示葫芦兄弟
#### ```grandpa``` ```scropion``` ```followers``` ```snake```子类  
赋予编号和标识

### ```Battleground```类  
定义一个15*15的二维数组作为战场，并包含战场的初始化和打印and清理操作  

### ```Formation```类  
定义了要求的几种阵法的排布方式，以及grandpa和snake的位置

剩下的就是一些打印操作。
