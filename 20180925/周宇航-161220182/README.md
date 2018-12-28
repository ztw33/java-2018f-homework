


> # Java第三次作业
> ## 面向葫芦娃编程
> ### 步骤
> 1. **设计思路**
> 2. **实现步骤**
> 3. **实现结果**
***
**设计思路**
本次实验包括以下几个Java类:
* BattleField：此类为战场，包含一个20*20的char数组，用于输出每种生物的具体位置。
* Grandpa：爷爷，暂时无具体功能，仅站在左侧加油助威，可获取坐标和改变坐标。
* Snake：蛇精，功能同爷爷，站在右侧。
* Scorpion：蝎子精，目前能获取坐标和改变坐标，站在喽啰等下属前。
* Sprite：喽啰个体，能获取坐标和改变坐标，通过在部队中的序号来辨别。
* Underlyings：蝎子精下属，由若干Sprite个体组成的数组，根据不同阵法序号来设置喽啰个数，并设置每个喽啰的坐标站成阵型。
* CalabashBrothers：葫芦兄弟阵营，内容基本同上次实验，增加在战场上标注各个葫芦娃坐标相关内容。
* CalabashBoy：葫芦娃个体，内容同上次实验
* Color：颜色
***
**运行步骤**
***
在此叙述程序运行基本步骤：
1. 在BattleField.java文件中有main函数，依次创建了蝎子精、蛇精、爷爷、打乱顺序的葫芦兄弟阵营以及阵型1即长蛇阵的喽啰部队，在此基础上创建战场，并通过displayBattle函数输出初始状态下的战场，然后clearBattle函数打扫战场。
2. 随后葫芦兄弟们通过BubbleSort函数排序，随后updateBattle函数更新战场，输出排序后的葫芦兄弟和长蛇阵的蝎子精和喽啰们，之后打扫战场。
3. 改变阵型编号num，然后创建新的喽啰部队，更新战场，输出对应的阵型战场，依次为鹤翼阵、雁行阵、冲轭阵、方门阵、鱼鳞阵、锋矢阵、偃月阵。至此程序结束。
***
**实现结果**
***
![初始状态，葫芦娃乱序站长蛇阵，蝎子精小喽啰长蛇阵](https://lh3.googleusercontent.com/AW5AMm2IyYOo1rfcQDOTlvAknoe0PKb2UXwSsu39lsMpINJmElRFqqDXkRZQgWTrhONE8jNYXMY "初始状态")
初始状态，葫芦娃乱序站长蛇阵，蝎子精小喽啰站长蛇阵
***
![长蛇阵：葫芦娃按序站长蛇阵，蝎子精小喽啰长蛇阵](https://lh3.googleusercontent.com/l4FKimhGvMPpQR1hLzrTA5QI6hp5amAbl8J6uCWpFmwro7MPuxGbHFwLHJ32ON3wwMDIKhd0Hek "长蛇阵")
长蛇阵：葫芦娃按序站长蛇阵，蝎子精小喽啰站长蛇阵
***
![鹤翼阵：葫芦娃按序站长蛇阵，蝎子精小喽啰鹤翼阵](https://lh3.googleusercontent.com/eaSSVIk-naUDd9VqgUe-0oNcKq_79qxeIDBDqneVz2eshAUEa_AlNuA71vwPlx-aYZtNNQLoSwM "鹤翼阵")
鹤翼阵：葫芦娃按序站长蛇阵，蝎子精小喽啰站鹤翼阵
***
![雁行阵：葫芦娃按序站长蛇阵，蝎子精小喽啰雁行阵](https://lh3.googleusercontent.com/tk1HmCh2iGBapO5ihJPZOZSPljoCr2jDTzDcLKiV_7z0ciIGZ2NRQpqTR8QIc2dC56anQW6xG1w "雁行阵")
雁行阵：葫芦娃按序站长蛇阵，蝎子精小喽啰站雁行阵
***
![冲轭阵：葫芦娃按序站长蛇阵，蝎子精小喽啰冲轭阵](https://lh3.googleusercontent.com/glvvRR1eeZPmlosTrYwPHUWQZw_D5MZfQX7t0MnSBP8HbypTuWeFgQvAKRsV8Ggds-Pmn84quoo "冲轭阵")
冲轭阵：葫芦娃按序站长蛇阵，蝎子精小喽啰站冲轭阵
***
![方门阵：葫芦娃按序站长蛇阵，蝎子精小喽啰方门阵](https://lh3.googleusercontent.com/jHYLlLwryKpMho1ptoP72iLpkM1JdnTyV4X3znCnttEyeFFp7SKhB0gLHAbxqQ0U5_jic7rqH7c "方门阵")
方门阵：葫芦娃按序站长蛇阵，蝎子精小喽啰站方门阵
***
![鱼鳞阵：葫芦娃按序站长蛇阵，蝎子精小喽啰鱼鳞阵](https://lh3.googleusercontent.com/iV0snblEw7IOZdNHp92RuBzeDAlsnXpl7Q977kDT-85CgtG7Q_10x-NYxfZcmmuvNZBV5asQKSU "鱼鳞阵")
鱼鳞阵：葫芦娃按序站长蛇阵，蝎子精小喽啰站鱼鳞阵
***
![锋矢阵：葫芦娃按序站长蛇阵，蝎子精小喽啰锋矢阵](https://lh3.googleusercontent.com/I3eosK1S04sHSS5RzH_PK_Sw4KTWDNebg4xgajGMAjNSp4THH1ELIL2IXtnpsCXFP2IV4iPAouU "锋矢阵")
锋矢阵：葫芦娃按序站长蛇阵，蝎子精小喽啰站锋矢阵
***
![偃月阵：葫芦娃按序站长蛇阵，蝎子精小喽啰偃月阵](https://lh3.googleusercontent.com/uJKl5GcIywlH8FETi8mkEGpEgy7KpzjfY2GUztLEJnXbz6Db0AtX64aiHx-Gm87M3EP9SEdSrrg "偃月阵")
偃月阵：葫芦娃按序站长蛇阵，蝎子精小喽啰站偃月阵
***



