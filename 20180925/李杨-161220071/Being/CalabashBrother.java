package com.company.Being;

import java.awt.*;

enum Brother{
    RED("红",1,"red"),ORANGE("橙",2,"orange"),YELLOW("黄",3,"yellow"),GREEN("绿",4,"green"),CYAN("青",5,"cyan"),
    BLUE("蓝",6,"blue"),VIOLET("紫",7,"violet");

    private String name;
    private  int rank;
    private String color;

    private Brother(String name, int rank,String color){
        this.name=name;
        this.rank=rank;
        this.color=color;
    }
    public String getName(){
        return this.name;
    }
    public String getColor(){
        return this.color;
    }
    public int getRank(){
        return this.rank;
    }
}
public class CalabashBrother extends Creature{
    public Brother hulu;
    public String Color;
    public int Rank;
    public CalabashBrother(){
        hulu=Brother.RED;
        super.name=(hulu.getName());
        Color=hulu.getColor();
        Rank=hulu.getRank();
    }
    public CalabashBrother(int i){
        for(Brother c:Brother.values()){
            if(c.getRank() == i){
                hulu = c;
            }
        }
        super.name=hulu.getName();
        Color=hulu.getColor();
        Rank=hulu.getRank();
    }
    public int tellRank(){
        return hulu.getRank();
    }
    public void tellColor(){
        System.out.println(hulu.getColor());
    }
}
