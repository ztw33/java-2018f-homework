enum COLOR{
    RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE
}

public class Huluwa{
    private int rank;
    private COLOR color;
    private String name;
    private int location;

    public Huluwa(int n){
        this.rank=n;
        location=0;
        switch (n){
            case 1: this.color=COLOR.RED; this.name="老大";break;
            case 2: this.color=COLOR.ORANGE; this.name="老二";break;
            case 3: this.color=COLOR.YELLOW; this.name="老三";break;
            case 4: this.color=COLOR.GREEN; this.name="老四";break;
            case 5: this.color=COLOR.CYAN; this.name="老五";break;
            case 6: this.color=COLOR.BLUE; this.name="老六";break;
            case 7: this.color=COLOR.PURPLE; this.name="老七";break;
        }
    }

    public COLOR tellColor(){
        switch (this.color){
            case RED: System.out.print("红色 ");break;
            case ORANGE: System.out.print("橙色 ");break;
            case YELLOW: System.out.print("黄色 ");break;
            case GREEN: System.out.print("绿色 ");break;
            case CYAN: System.out.print("青色 ");break;
            case BLUE: System.out.print("蓝色 ");break;
            case PURPLE: System.out.print("紫色 ");break;
        }
        return color;
    }

    public int getRank(){
        return this.rank;
    }

    public COLOR getColor(){
        return this.color;
    }
    public String getName(){
        return this.name;
    }

    public int getLocation() {
        return location;
    }

    public int tellLocation(){
        System.out.print(this.location);
        return this.location;
    }

    public  int setLocation(int n) {
        this.location = n;
        return n;
    }

    public void tellChange() {
        System.out.print(this.name + "：" + this.location + " -> ");
    }
}