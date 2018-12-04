public enum CalabashBrothers {
    First("大娃","红色"),
    Second("二娃","橙色"),
    Third("三娃","黄色"),
    Fourth("四娃","绿色"),
    Fifth("五娃","青色"),
    Sixth("六娃","蓝色"),
    Seventh("七娃","紫色");

    private String name;
    private String color;

    CalabashBrothers(String name, String color){
        this.name=name;
        this.color=color;
    }

    public void move(CalabashBrothers[] queue,int destination){
        queue[destination]=this;
    }

    public void numberOffByName(){
        System.out.print(this.name+" ");
    }

    public void numberOffByColor(){
        System.out.print(this.color+" ");
    }

    public void tellTheMove(int start,int end){
        System.out.println(this.name+": "+start+"->"+end);
    }

}