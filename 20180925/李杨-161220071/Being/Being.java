package com.company.Being;

/**
 * @Description 便于加入非生物对象，如物体
 */
public class Being {
    public String name;
    public Being(){
        this.name="";
    }
    public Being(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void tellName(){
        System.out.print(getName());
    }
}
