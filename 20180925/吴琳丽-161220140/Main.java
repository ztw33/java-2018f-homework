package com.company;
import java.util.*;

import com.company.BattleField.BattleField;
import com.company.Creature.*;
import com.company.Formation.*;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        BattleField BF=new BattleField();//创建战场
        HuluBrothers HuluFamily = new HuluBrothers();//产生葫芦娃兄弟
        Sort.RandomChange(HuluFamily.Hulu);//乱序排列
        Monsters LouluoMonsters= new Monsters();//产生妖怪们
        Grandpa Yeye=new Grandpa();//产生爷爷
        SheJing she=new SheJing();//产生蛇精
        Sort.BubbleSort(HuluFamily.Hulu);//葫芦兄弟按名字排好序
        ChangShe HuluChangShe=new ChangShe();//产生长蛇队形
        HeYi louluoHeYi = new HeYi();//产生鹤翼队形
        YanXing louluoYanXing = new YanXing();//产生雁行队形
        HengE louluoHengE = new HengE();//产生衡轭队形
        YuLin louluoYuLin = new YuLin();//产生鱼鳞队形
        FangYuan louluoFangYuan = new FangYuan();//产生方円队形
        YanYue louluoYanYue = new YanYue();//产生偃月队形
        FengShi louluoFengShi = new FengShi();//产生锋失队形
        System.out.println("请输入要进行战斗的次数: ");
        int Bnum=in.nextInt();
        for(int i=0;i<Bnum;i++){
            System.out.println("第 "+(i+1)+"次战斗：");
            System.out.println("请输入葫芦娃蛇形队列领头的横坐标(x<=8): ");
            int Hulux=in.nextInt();
            System.out.println("请输入葫芦娃蛇形队列领头的纵坐标:  ");
            int Huluy=in.nextInt();
            HuluChangShe.Setcreatures(BF.Field,Hulux,Huluy,HuluFamily.Hulu);//将葫芦娃设置为长蛇队形
            System.out.println("接下来向战场中加入蝎子精和小喽啰 ：");
            System.out.println("请输入要妖怪们选择的队形: " +"\n"+
                    " 0:鹤翼 (x<=10 &&y <=6)" +"\n"+
                    " 1:雁行 (x>=6 && y<=8)" +"\n"+
                    " 2:衡轭 (x<=7 && y<=13)" +"\n"+
                    " 3:鱼鳞 (x>=2 && x<=13 && y<=8)" +"\n"+
                    " 4:方円 (x>=2 && x<=12 && y<=10)" +"\n"+
                    " 5:偃月 (x>=4 && x<=10 && y<=10)" +"\n"+
                    " 6:锋失 (x>=3 && x<=12 && y<=8)");
            int num=in.nextInt();
            System.out.println("请输入蝎子精的横坐标: ");
            int XieZix=in.nextInt();
            System.out.println("请输入蝎子精的纵坐标:  ");
            int XieZiy=in.nextInt();
            switch (num){
                case 0: louluoHeYi.Setcreatures(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成鹤翼类型
                case 1: louluoYanXing.Setcreatures(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成雁行类型
                case 2: louluoHengE.Setcreatures(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成衡轭类型
                case 3: louluoYuLin.Setcreatures(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成鱼鳞类型
                case 4: louluoFangYuan.Setcreatures(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成方円类型
                case 5: louluoYanYue.Setcreatures(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成偃月类型
                case 6: louluoFengShi.Setcreatures(BF.Field,XieZix,XieZiy,LouluoMonsters.monsters);break;//将妖怪们设置成锋失类型
                default: System.out.println("请输入正确选项");
            }
            System.out.println("显示此时的战场情况为:  ");
            BF.DisplayField();//显示战场
            System.out.println("接下来加入啦啦队: ");
            System.out.println("请输入爷爷的横坐标: ");
            int Yeyex=in.nextInt();
            System.out.println("请输入爷爷的纵坐标:  ");
            int Yeyey=in.nextInt();
            Yeye.CreatureCheer(BF.Field,Yeyex,Yeyey);
            System.out.println("请输入蛇精的横坐标: ");
            int Shex=in.nextInt();
            System.out.println("请输入蛇精的纵坐标:  ");
            int Shey=in.nextInt();
            she.CreatureCheer(BF.Field,Shex,Shey);
            System.out.println("显示此时的战场情况为:  ");
            BF.DisplayField();//显示战场
            System.out.println("清空战场");
            BF.ClearField();
        }
    }
}
