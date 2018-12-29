# 葫芦娃实验用泛型重构

用一个接口封装泛型

```java
interface InterFactory<T> {
    T createO();
    T []createN(int n);
    T [][]createNN(int n);
}
```

该泛型封装了Beings，每个Beings都用该泛型生成