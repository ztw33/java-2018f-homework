# Java程序设计 第2次作业

###### 161220153 许翔

相比于第一次上传的代码，这次主要做了如下的改动：

1. 对类进行了重新命名，更能表达出类的抽象含义；将“葫芦娃”类改为了枚举类型。

```java
public class Coordinator { ... } \\协调者 
public enum CalabashBros { ... } \\葫芦娃
```

2. 增加了一个排序的接口类，提高了抽象层次

```java
public interface Sort {
    public void binarySort(Object[] array);
    public void bubbleSort(Object[] array);
}
```

由协调者负责具体实现葫芦娃的排序功能。

```java
public class Coordinator {
    class CalabashSort implements Sort{
        @Override
        public void binarySort(Object[] array) { ... }

        @Override
        public void bubbleSort(Object[] array) { ... }
    }
```

在我的设计中，葫芦娃“知道”自己在家族中排序、自己的名字、颜色以及自己站的位置。这样，由协调者根据自己实现的排序函数对葫芦娃进行排序，要求某个葫芦娃更换自己站的位置，就可以通知该葫芦娃他应该去到的位置，葫芦娃就会修改他自己所站的位置，并按照要求报告这一次位置交换。
