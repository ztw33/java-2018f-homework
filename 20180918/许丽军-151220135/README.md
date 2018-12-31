## 根据**面向对象**原则修改代码

- 将葫芦兄弟(`CalabashBrother`)的类型从`class`变为`enum`，理由是：葫芦兄弟是固定的7个，常量对象更能体现实际 
- 将原来的葫芦兄弟队列(`CalabashBrotherQueue`)中的排序方法抽象为一个类，该类的抽象类为`AbstractSorter`，其子类有两个：`BubbleSorter`,`QuickSorter`；此队列的method有shuffle（乱序），sort（排序），tellOrderly（报数），（maybe 可以抽象为一个`interface`
- 在排序方法中添加参数`Comparator`，从而可以根据实际需要定制比较器，比较器也是对象

## 其他修改

- 利用`package`机制对代码文件结构进行了组织

