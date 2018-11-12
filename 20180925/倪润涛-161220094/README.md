#本次作业中用到的类

##葫芦娃类  //Calabash

...

```
class Calabash{
    public int rank;
    public Color color;
    public CalabashName name;
    Calabash(int rank)
    {
        this.rank = rank;
        this.color = Color.values()[rank];
        this.name = CalabashName.values()[rank];
    }
}
```

...

##爷爷类      //Grandpa

...

```
class Grandpa{
    public String name;
    Grandpa()
    {
        this.name = "爷爷";
    }
}
```

...

##妖精类      //Goblin

```
class Goblin{
    public int rank;
    public GoblinName name;
    Goblin(int rank)
    {
        this.rank = rank;
        this.name = GoblinName.values()[rank];
    }
}
```

##阵型类      //Formation

葫芦娃类用来初始化葫芦娃的属性，爷爷类用来初始化爷爷的“属性”，妖精类用来初始化妖精的属性。

阵型类作为一个控制台，控制葫芦娃和妖精们排列阵型并且打印输出



## 最终实现

最终仅实现了基本功能，以print的方式打印出两种葫芦娃与妖精对峙的阵型。在此基础上仅添加了葫芦娃的颜色作为拓展。

