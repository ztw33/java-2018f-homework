## 类及相关说明

主要有如下4个类：

```java
public enum CalabashBoy //代指每个葫芦娃
```

```java
public class CalabashBrothers //包含所有CalabashBoy的数组
```

```java
public interface SortAlgorithm //接口，包含bubbleSort和binaryInsertSort
```

```java
public class SortCoordinator implements SortAlgorithm //包含CalabashBrothers的对象，并通过CalabashBrothers提供的接口控制每个CalabashBoy位置的改变，通过implements SortAlgorithm实现具体的排序函数
```

## 更多说明

我认为CalabashBoy是可以自己移动的实体，因而在CalabashBrothers引入了swap方法，可以实现CalabashBoy的交换，也就是说，没有引入更多的类来负责CalabashBoy的移动