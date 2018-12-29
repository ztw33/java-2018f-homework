
public class Huluwa {
    private int location;
    private COLOR color;
    private int num;
    private String name;

    public Huluwa(int n){
        if(n < 0){
            System.out.print("葫芦娃编号不能为负！\n");
        }
        else if(n > 6) {
            System.out.print("没有这么多的葫芦娃！\n");
        }
        else{
            switch(n){
                case 0: this.color = COLOR.RED; this.name = "老大";   break;
                case 1: this.color = COLOR.ORANGE;  this.name = "老二";   break;
                case 2: this.color = COLOR.YELLO;   this.name = "老三";   break;
                case 3: this.color = COLOR.GREEN;   this.name = "老四";   break;
                case 4: this.color = COLOR.CYAN;    this.name = "老五";   break;
                case 5: this.color = COLOR.BLUE;    this.name = "老六";   break;
                case 6: this.color = COLOR.PURPLE;  this.name = "老七";   break;
                default:   System.out.print(n); break;
            }
        }
        this.num = n;
    }
    public String getName(){
        return this.name;
    }
    public COLOR getColor(){
        return this.color;
    }
    public int getLocation(){
        return this.location;
    }
    public int getNum(){
        return this.num;
    }
    public void setLocation(int n){
        this.location = n;
    }
    public void tellName(){
        System.out.println(this.name);
    }
    public void tellColor(){
        switch (this.color){
            case RED: System.out.println("红色");break;
            case ORANGE: System.out.println("橙色");break;
            case YELLO: System.out.println("黄色");break;
            case GREEN: System.out.println("绿色");break;
            case CYAN:  System.out.println("青色");break;
            case BLUE:  System.out.println("蓝色");break;
            case PURPLE: System.out.println("紫色");break;
            default:    System.out.println("wrong color");break;
        }
    }

    //交换位置时报告交换动作，排序时在每次调用setLocation函数前调用该函数
    public void tellChangeLoc(int newLoc) { System.out.println(this.name + ":" + this.location + "->" + newLoc); }
    // public void tellLocation(){ System.out.println(this.location); }
}

//七个葫芦娃的颜色
enum COLOR{
    RED,ORANGE,YELLO,GREEN,CYAN,BLUE,PURPLE
}
