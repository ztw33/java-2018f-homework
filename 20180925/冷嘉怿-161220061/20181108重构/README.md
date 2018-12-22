## 20181108重构

### 重构目的

- 使用MVC模式重新设计数据结构
- 充分利用继承关系
- 使用集合框架

*本次重构完全基于新的框架，原先框架被废弃，因此单独保存在文件夹中*

### 设计思路

#### MVC模型

##### Model

- **Charactor类**
  - Charactor对象具有两个原子变量储存当前的位置信息供View使用。
  - Charactor实现了runnable接口，在线程中等待命令或执行命令。
  - 所有人物都继承自Charactor类，不同的Charactor区别在于姓名和移动速度
  - 蝎子精(Scorpion)由于具有变阵的能力



##### View

- **OutLookManager类**
  - OutLookManager负责处理所有人物贴图的绘制和动画的执行
  - OutLookManager类中使用ArrayList对象储存场景中的所有人物及其贴图，并定期读取所有人物的位置并重绘更新所有人物的位置实现动画。

##### Control

- **CQueue类**
  - CQueue使用一个innerposition数组储存所有人物在队伍中的位置，所有操作都作用于innerposition
  - CQueue利用ArrayList的Sort和Shuffle方法实现队列中人物的排序和随机站队

<br>

*所有数据结构的具体实现见对应代码及注释*