/* XuXiang 161220153 2018/9/27 9:30 */

public enum CalabashBros {
    RED(1,"老大","红色",1), ORANGE(2,"老二","橙色",2), YELLOW(3,"老三","黄色",3), GREEN(4,"老四","绿色",4),
    CYAN(5,"老五","青色",5), BLUE(6,"老六","蓝色",6), PURPLE(7,"老七","紫色",7);

    private int number;
    private String name;
    private String color;
    private int order;

    CalabashBros(int number, String name, String color, int order){
        this.number = number;
        this.name = name;
        this.color = color;
        this.order = order;
    }

    public void tellName(){
        System.out.println(name);
    }
    public void tellColor(){
        System.out.println(color);
    }
    public void changeOrder(int newOrder){
        if(newOrder!=order){
            System.out.println(name+'：'+order+"→"+newOrder);
            order = newOrder;
        }
    }
    public int getNumber(){
        return number;
    }
}
