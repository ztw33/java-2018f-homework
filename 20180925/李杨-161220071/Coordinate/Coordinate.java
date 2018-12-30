package com.company.Coordinate;
import com.company.Being.Being;
public class Coordinate {
    public int x;
    public int y;
    public boolean isEmpty;
    public Being being;
    public Coordinate(){
        this.x=0;
        this.y=0;
        this.isEmpty=true;
        being = new Being();
    }
    public Coordinate(int x,int y){
        this.x=x;
        this.y=y;
        this.isEmpty=true;
        being = new Being();
    }
    public void printBeingName(){
        being.tellName();
    }
}
