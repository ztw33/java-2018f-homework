package com.company.Creature;

public class Creature {
    public String name;
    public Creature( ){
        name="NULL";
    }
    void setName(String a){
        name = a;
    }
    public void Cheers(){
            System.out.print("Cheers");
    }
    public void CreaturePrintName(){
        System.out.print(name+" ");
    }
}

class HuluBrother extends Creature{
    private Human HumanHulu;
    public Color color;
    HuluBrother(){
        HumanHulu = Human.ONE;
        super.setName( HumanHulu.getName());
        color = HumanHulu.getColor();
    }
    HuluBrother(int i){
        for (Human c : Human.values()) {
            if (c.ordinal() == i) {
                HumanHulu = c;
            }
        }
        super.setName(HumanHulu.getName());
        color = HumanHulu.getColor();
    }
    public int TellOrdinal(){
        return HumanHulu.ordinal();
    }
    public void HuluTellColor(){
        System.out.println(HumanHulu.getColor());
    }//输出颜色
    public void HuluTellName(){
        System.out.println(HumanHulu.getName());
    }//输出名字

}


class LouLuo extends Creature{
    LouLuo(){
        super.setName("小喽啰");
    }
}

class XieZi extends Creature{
    XieZi(){
        super.setName("蝎子精");
    }
}

