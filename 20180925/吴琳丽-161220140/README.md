# 0925作业说明

## 代码的说明
### 关于战场的类
    BattleField BF = new BattleField();//创建战场
**BattleField**是一个类，里面包含了N*N个坐标对象，具有显示战场、清空战场的功能。

**Coordinate**是一个类，里面包含了X,Y坐标，以及一个Tite对象和empty标志着此坐标是否为空。

### 关于人物的类
    HuluBrothers HuluFamily = new HuluBrothers();//产生葫芦娃兄弟
    Sort.RandomChange(HuluFamily.Hulu);//乱序排列
**HuluBrothers**是一个类，里面包含了7个葫芦娃HuluBrother的类，具有报名字、报颜色的功能。

    Monsters LouluoMonsters = new Monsters();//产生妖怪们
**Monsters**是一个类，里面包含了蝎子精XieZi和若干个小喽啰LouLuo。

    Grandpa Yeye = new Grandpa();//产生爷爷
    SheJing she = new SheJing();//产生蛇精
**Tite**是一个类，代表人物，有姓名的属性。

**Grandpa、SheJing**是Tite的两个继承类，增加了助威的功能。

**LouLuo、XieZi**是Tite的另外两个继承类。

**HuluBrother**也是Tite的一个继承类，其中增加了Human、Color的枚举类型，并且可以输出名字和颜色。
###关于队形的类
    public interface Formation {
    	boolean IfEmpty(Coordinate[][] Field,int x,int y);
    	void SetTites(Coordinate[][] Field,int x,int y, Tite[] tites);
	}
**Formation**是一个接口，不同的八个队形用不同的方式实现了接口里面的方法。 

    public class ChangShe implements Formation{...}
	public class FangYuan implements Formation{...}
	public class FengShi implements Formation{...}
	public class HengE implements Formation{...}
	public class HeYi implements Formation{...}
	public class YanXing implements Formation{...}
	public class YanYue implements Formation{...}
	public class YuLin implements Formation{...}
分别实现了八个队形的类，有判断位置是否为空以及放置人物的功能。

## 设计理念
1. 因为有五种人物，所以就设置五种人物分别为Tite类的继承，这样他们都会有相同的属性，也属于同一大类里面，即有面向对象的理念。
2. 创建一个战场，里面有若干个坐标，每个坐标都可以放置一个人物，战场的功能只是显示和清空，坐标可以打印自己位置上人物的名字。
3. 变换队形，在main函数里面可以进行选择需要的队形，并输入蝎子精的坐标，对应的队形就队形相应的对象里面实现相应的操作，即可不断的变化小喽啰的队形。

    	switch (num){
                case 0: louluoHeYi.SetTites(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成鹤翼类型
                case 1: louluoYanXing.SetTites(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成雁行类型
                case 2: louluoHengE.SetTites(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成衡轭类型
                case 3: louluoYuLin.SetTites(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成鱼鳞类型
                case 4: louluoFangYuan.SetTites(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成方円类型
                case 5: louluoYanYue.SetTites(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成偃月类型
                case 6: louluoFengShi.SetTites(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成锋失类型
                default: System.out.println("请输入正确选项");
            }
## 程序操作
按程序中所给提示，依次输入战斗次数、葫芦娃领队坐标、选择小喽啰队形、蝎子精坐标、爷爷坐标、蛇精坐标即可进行一轮战斗。

下一次战斗即从葫芦娃领队坐标重新进行输入。

