#代码说明

##思路

首先创建生物类Creature，之后所有生物，葫芦娃、爷爷、妖怪等都是其派生类，分别给定属性和代号。之后再建立battle类，其中包含葫芦娃顺序变换和妖怪们队形变换，建立二维数组[][]map表示当前地图所有位置，根据数值判断是否打印。

##具体实现

###Creature类及其派生类


```
public class Creature {
    
    private String name;
    private String type;

    // 构造函数
    Creature(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    
    public String getType() { return type; }
}

```
之后的生物体均继承Creature类，例如爷爷
```
public class Grandpa extends Creature {
    Grandpa() {
        super("爷爷", "人类");
    }
}
```
其中葫芦娃运用了枚举类型来表示颜色和名字
```
enum HuluwaNames {
    大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃
}

enum HuluwaColors {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}
```

###Battle类

实现了打印、葫芦娃随机排列、清空并重新初始化（用于每次变换队形前）以及鹤翼雁行等八个阵法，battle类创建某一阵法的对象，设置对应位置信息，根据map值进行打印
```
// 打印
    void print() 
// 葫芦娃 随机排列
    void huluwaRandom()
// 清空并且重新初始化
    private void clearAndSet() 
```