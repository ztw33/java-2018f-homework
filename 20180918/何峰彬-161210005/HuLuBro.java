package homework2;

public enum HuLuBro {
    ELDEST("老大", 1,"红色",1), SECOND("老二", 2,"橙色",2), THIRD("老三", 3,"黄色",3), FOURTH("老四", 4,"绿色",4), FIFTH("老五",5, "青色",5),
    SIXTH("老六", 6,"蓝色",6), YOUNGEST("老七",7, "紫色",7);

    private int nameOrder, colorOrder;
    private String name, color;

    private HuLuBro(String name, int nameOrder, String color, int colorOrder){
        this.name = name;
        this.nameOrder = nameOrder;
        this.color = color;
        this.colorOrder = colorOrder;
    }

    public void tellName(){
        System.out.print(name);
    }

    public void tellColor(){
        System.out.print(color);
    }

    public int compareNameTo(HuLuBro e){
        return this.nameOrder - e.nameOrder;
    }

    public int compareColorTo(HuLuBro e){
        return this.colorOrder - e.colorOrder;
    }
}
