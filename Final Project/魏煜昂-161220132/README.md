
# 葫芦娃大战妖精V1
* 161220132 魏煜昂
## 开发环境
* IntelliJ IDEA 2018.2.3
* Java版本 1.8.0_192
## 项目简介
* 简单模拟葫芦娃与妖精的对战，在开始前玩家可以选择葫芦娃的阵列，开始后自动战斗。
## 目录
* java/creature：所有与生物有关的类
* java/gui：游戏主界面的显示
* resources：相关的图片、文件资源
## 代码结构
gui
* Main为整个程序的主入口，Controller控制程序事件处理，界面刷新等
* BattleGround为一个21×10的GrinPane，用以表示战场

creature
* creature有姓名name，阵营camp，状态state，位置Position等基本属性，由此派生出不同的生物体葫芦娃CalaBash，Grandpa，Snake，Scorpion和Toad。
* creature有移动，战斗等函数，用于在界面上行走和攻击

 List
* List是生物体的集合
* HeroList放置所有己方阵营的人物，MonsterList放置所有敌方阵营的人物
* List有排布阵营等函数，用以在战斗开始时初始化阵型
## To be continued