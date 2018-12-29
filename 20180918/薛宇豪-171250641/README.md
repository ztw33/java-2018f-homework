# 面向葫芦娃编程
## 设计思路

- CalabashBrothers类封装了葫芦娃这个个体，使用枚举类确保七个葫芦娃的属性都是确定的
- Coordinator起到一个指挥员的作用，在进行具体排序的过程中指挥葫芦娃的移动
- SortSet类为两个排序方法（BubbleSort、BinarySort）的接口，定义了必须要实现的sort方法
- 考虑到随机排序并不需要指挥（而是类似于初始化？），所以直接在主类（SortCalabashBrothers）中进行