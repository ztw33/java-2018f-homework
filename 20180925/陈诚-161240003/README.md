# 作业三: 面向葫芦娃编程
## 代码解读
### Being类
- 生物的基类，具有名称、位置的属性(尚无需阵营属性)。
- 派生出`Calabash`葫芦娃类，`Grandpa`爷爷类，`Snake`蛇精类，`Scorpion`蝎子精类，`Soldier`喽啰类。  
- 其中蝎子精熟练掌握各种阵型，爷爷和蛇精的位置固定。
### Formation类 && Position类
- 阵型类，由偏移位`Position leader`以及相对位置`Position[] Relpos`组成。  
- 目前蝎子精熟练掌握鶴翼、雁行、長蛇、偃月、衡軛五中阵型。
### Field类 && Square类
- 战场类，长宽确定，由可以放置生物的单位空间方块组成。  
- 方块类的对象有判断是否为空以及清空位置的功能。
### SortCala类
- 乱序排序类，由作业二稍作修改而来。
### AbovaAll类
- 万物主类，创造并娓娓道来葫芦兄弟与妖精们一场战争的故事。
```
private void storyTell() {
    De_sort && Bubblesort;
    ...
    setBrothers(Calabash[] brothers);
    scorpion.setFormation("鶴翼" / "雁行" ...);
    setSoldiers(Soldiers[] soldiers);
    setNPC();
    field.show();
    field.clearfield();
    ...
}
```

## 运行效果
![效果图](https://raw.githubusercontent.com/wiki/Julius-c/java-2018f-homework/sample.jpg)
