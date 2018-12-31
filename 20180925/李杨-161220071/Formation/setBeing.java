package com.company.Formation;
import com.company.BattleField.BattleField;
import com.company.Being.*;
import java.util.Scanner;
public class setBeing {
    public void setBeing(BattleField field,int x,int y,Being be){
        if(field.battlefield[x][y].isEmpty==true){
            field.battlefield[x][y].being=be;
            field.battlefield[x][y].isEmpty=false;
        }
        else
        {
            Scanner in=new Scanner(System.in);
            System.out.println("所需要坐标已被占用");
            System.out.println("请重新输入横坐标: ");
            x=in.nextInt();
            System.out.println("请重新输入纵坐标:  ");
            y=in.nextInt();
        }
    }
}
