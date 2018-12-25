# Java 期末大作业

邓开圣 161220031

## 效果展示

**注：由于葫芦娃素材相对较为缺乏，为提高游戏的可玩性，本次作业未使用葫芦娃素材（在作业开始前已经询问并征得曹老师同意）**

<img src="https://github.com/KSDeng/pictures/blob/master/pictures/java%E5%A4%A7%E4%BD%9C%E4%B8%9A/java%E5%A4%A7%E4%BD%9C%E4%B8%9A%E6%95%88%E6%9E%9C%E5%B1%95%E7%A4%BA1.gif?raw=true">

## 整体结构

程序共计27个类，它们之间的关系图如下：

<img src="https://github.com/KSDeng/pictures/blob/master/pictures/java%E5%A4%A7%E4%BD%9C%E4%B8%9A/Classes%20Relationship%20Diagram.png?raw=true">

其中GameObject 是游戏中所有实体的父类，提供相关的基本数据（如坐标、阵营标记等）和公共操作。

GameScreen 是游戏屏幕的父类，提供与屏幕刷新、事件监听和增/减实体的接口。

GameApplication 是应用程序启动类，声明加载画面前/后所进行的操作的方法，并提供获取整个场景和排布的接口。

<img src="https://github.com/KSDeng/pictures/blob/master/pictures/java%E5%A4%A7%E4%BD%9C%E4%B8%9A/%E5%9F%BA%E6%9C%AC%E6%A1%86%E6%9E%B6%E5%8F%8A%E5%85%B6%E6%8E%A5%E5%8F%A3.png?raw=true">



## 原理分析

<img src="https://github.com/KSDeng/pictures/blob/master/pictures/java%E5%A4%A7%E4%BD%9C%E4%B8%9A/GameObject%E7%B3%BB.png?raw=true">

GameObject子类包括IceHit、BloodMedicine、IceWave、Character、Weapon、Shield、FireSphere和FireExplode，分别表示冰光受击效果、体力恢复药水、冰光发出效果、人物、武器、护盾、火球和火球爆炸效果

<img src="https://github.com/KSDeng/pictures/blob/master/pictures/java%E5%A4%A7%E4%BD%9C%E4%B8%9A/MyAudio%E7%B3%BB.png?raw=true">

MyAudio的子类包括ShieldAudio、IceAudio、ExplodeAudio和WinAudio，分别对应光盾音效、冰光音效、爆炸音效和胜利音效。

MyAnimation的两个子类RoleAnimation和WeaponAnimation分别表示人物动画和武器动画，这两个类用于实现游戏画面中的动画效果。

Main为程序入口类，GameAdmin为管理员类，管理游戏中所有实体并定义事件监听方法。

AnimationThread类用于实现动画的并行播放。

Direction和Status为枚举类，分别表示游戏实体的方向和状态。



## 游戏指南

> 1. 游戏开始后你就可以自由移动，W、S、A、D分别对应上、下、左、右四个方向，但此时你还没有佩戴武器。你可以使用I键佩戴武器（是一把很酷的“青龙偃月刀”），**戴上武器之后你的移动速度将变慢，不过同时你获得了发动攻击的能力!** 按K键发出攻击。当你希望以更快的速度移动时，你可以再次按下I键卸下武器，这时候你将再次变得身轻如燕。之后你会发现，快速的移动对于拾取物品是非常有必要的。
> 2. 每个人物（包括怪物，是一条蛇）头上都有一个红色的长条，那表示这个人物的生命值。**请尽量躲开火球，那将对你造成一定的伤害，若你的血条变为0，则游戏失败!** 当然，如果一个怪物的血条变为0，那意味着你成功击杀了它。同时你还拥有魔法值，这个值会随着时间的推移自动增加（那是对你在险恶环境下存活的奖赏，当然了，加满之后就不再加了），魔法值用于发动技能。
> 3. 当魔法值达到一定值后，**屏幕下方会出现一个护盾的标志，这表示你可以按下L键发动技能了（"金钟护体"）**。这将产生一个很酷的光影效果。它将吸收所有进入的火球，以免你受到伤害。你可以选择走出这个范围（当你捕捉到更好的攻击角度）或者待在其中。技能效果将在一定时间后消失，并且短时间内你将不再能再次发动技能，所以，请在适当且有必要的时候释放技能。
> 4. 当你杀死一个蛇怪后，将有一定概率掉落物品，是一个红色瓶子，**你可以去拾取它，这将为你恢复一定的体力值**。一段时间后物品将自动消失，同时，若物品被蛇怪获取，也会消失（但蛇怪不会恢复体力，放心）。
> 5. 当你杀死所有怪物，游戏胜利；或者你被怪物杀死，游戏结束。



