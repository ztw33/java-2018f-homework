# 说明

## Class

### CalabashBrothers 

枚举类型，包含7个葫芦娃以及各自的排名、颜色信息。

### CalabashBrothersSorter

葫芦娃队列的sorter，内含一个队列，可以进行队列的一系列操作

#### 成员变量

- private CalabashBrothers[ ] Queue 定义一个葫芦娃的序列

#### 成员函数

- public CalabashBrothers[] randomOrder() 将当前的Queue随机排列
- public CalabashBrothers[] bubbleSort() 冒泡排序
- public CalabashBrothers[] binaryInsertSort() 二分插入排序
- public void checkQueue() 打印当前序列
- public void swapPosition(int index1, int index2) 交换序列两个元素的位置并打印输出