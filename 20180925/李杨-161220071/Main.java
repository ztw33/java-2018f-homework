package com.company;
import java.util.*;
import com.company.BattleField.BattleField;
import com.company.Being.*;
import com.company.Formation.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in=new Scanner(System.in);
        BattleField field=new BattleField();
        CalabashBrother[] huluwa=new CalabashBrother[7];
        for(int i=0;i<7;i++)
            huluwa[i]=new CalabashBrother(i+1);
//        for(int i=0;i<7;i++)
  //          huluwa[i].tellColor();
        Minion[] loul =new Minion[20];//create maxsize of loulou
        for(int i=0;i<20;i++)
            loul[i]=new Minion();
        Grandpa yeye =new Grandpa();//create grandpa
        Scorpion sco=new Scorpion();//create sco
        Snake sna=new Snake();//create snake
        ChangShe changshezhen=new ChangShe();//产生长蛇队形
        HeYi heyizhen = new HeYi();//产生鹤翼队形
        YanXing yanxingzhen = new YanXing();//产生雁行队形
        HengE hengezhen = new HengE();//产生衡轭队形
        YuLin yulinzhen = new YuLin();//产生鱼鳞队形
        FangYuan fangyuanzhen = new FangYuan();//产生方円队形
        YanYue yanyuezhen = new YanYue();//产生偃月队形
        FengShi fengshizhen = new FengShi();//产生锋失队形
        setBeing setboss = new setBeing();
        System.out.println("请输入变换阵法的次数");
        int time=in.nextInt();
        while(time>=0){
            System.out.println("请输入葫芦娃的阵型： 0:鹤翼，1:雁行，2:衡轭，3:鱼鳞，4:方円" +
                "，5:偃月，6:锋失，7：长蛇");
            int num0 =in.nextInt();
            switch(num0){
                case 0:heyizhen.setBeing(field,huluwa);break;
                case 1:yanxingzhen.setBeing(field,huluwa);break;
                case 2:hengezhen.setBeing(field,huluwa);break;
                case 3:yulinzhen.setBeing(field,huluwa);break;
                case 4:fangyuanzhen.setBeing(field,huluwa);break;
                case 5:yanyuezhen.setBeing(field,huluwa);break;
                case 6:fengshizhen.setBeing(field,huluwa);break;
                case 7:changshezhen.setBeing(field,huluwa);break;
            }
             System.out.println("请输入喽喽的阵型： 0:鹤翼，1:雁行，2:衡轭，3:鱼鳞，4:方円" +
                "，5:偃月，6:锋失");
            int num=in.nextInt();
            switch(num){
                case 0:heyizhen.setBeing(field,loul);break;
                case 1:yanxingzhen.setBeing(field,loul);break;
                case 2:hengezhen.setBeing(field,loul);break;
                case 3:yulinzhen.setBeing(field,loul);break;
                case 4:fangyuanzhen.setBeing(field,loul);break;
                case 5:yanyuezhen.setBeing(field,loul);break;
                case 6:fengshizhen.setBeing(field,loul);break;
            }
            System.out.println("显示此时的战场情况为:  ");
            field.displayBattleField();//显示战场
            System.out.println("请输入爷爷的横坐标（在0-24之间）: ");
            int gpx=in.nextInt();
            System.out.println("请输入爷爷的纵坐标（在0-24之间）:  ");
            int gpy=in.nextInt();
            setboss.setBeing(field,gpx,gpy,yeye);
            System.out.println("显示此时的战场情况为:  ");
            field.displayBattleField();//显示战场
            System.out.println("请输入蝎子的横坐标（在0-24之间）: ");
            int scox=in.nextInt();
            System.out.println("请输入蝎子的纵坐标（在0-24之间）:  ");
            int scoy=in.nextInt();
            setboss.setBeing(field,scox,scoy,sco);
            System.out.println("显示此时的战场情况为）:  ");
            field.displayBattleField();//显示战场
            System.out.println("请输入蛇精的横坐标（在0-24之间）: ");
            int snax=in.nextInt();
            System.out.println("请输入蛇精的纵坐标（在0-24之间）:  ");
            int snay=in.nextInt();
            setboss.setBeing(field,snax,snay,sna);
            System.out.println("显示此时的战场情况为:  ");
            field.displayBattleField();
            System.out.println("清空战场 ");
            field.clearBattleField();
            time--;
    }
}
}
