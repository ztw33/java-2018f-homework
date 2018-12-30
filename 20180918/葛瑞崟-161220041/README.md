# 代码说明
## 代码分析

### CalabashBrother类
+ 将葫芦娃定义为枚举类，并保存对应的称呼和颜色
+ setPos函数用于更改位置时葫芦娃喊话
+ 两个Numberoff函数用于排序号后根据称呼或颜色报数

### CalabashQueue类
+ 属性
  
  ```
    private final static int NUM = 7;
    private CalabashBrother[] brothers;
    private int[] line;
    CalabashQueue() {
        brothers = CalabashBrother.values();
        line = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            line[i] = -1;
        }
    }
    ```
    
  + brothers数组保存枚举类中七个葫芦娃
  + line数组以int值0\~6来代指老大\~老七，会在random函数中赋值（达到随机站队的目的）
  
+ 排序过程

  ```
  void bubbleSort() {
        for (int i = 0; i < NUM - 1; i++){
            for (int j = 0; j < NUM - i - 1; j++){
                if (line[j] > line[j + 1]) {
                    brothers[line[j]].setPos(j,j + 1);
                    brothers[line[j + 1]].setPos(j + 1, j);
                    System.out.println();
                    int temp = line[j];
                    line[j] = line[j + 1];
                    line[j + 1] = temp;
                }
            }
        }
        numberOffByName();
    }
  ```
  
  + 两个排序函数正常对line数组进行排序
  + 交换两个元素时，除了使用一个临时变量进行交换外，还需调用setPos函数完成喊话
  + 最后调用本类中的numberoff函数完成报数
  
### CalabashBrotherSort类
+ 包含main函数进行CalabashQueue的实例化和响应函数的调用

```
public class CalabashBrotherSort {
    public static void main(String[] args) {
        CalabashQueue q = new CalabashQueue();
        q.random();
        q.bubbleSort();
        q.random();
        q.binaryInsertSort();
    }
}
```

## 设计思想
+ CalabashBrother类型的brothers数组不做变动
+ int类型的line数组以int值0\~6代表七个葫芦娃进行排序，

  在过程中和完成后调用brothers数组中相应函数完成喊话和报数的要求
