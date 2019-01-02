public enum CalabashBro {
    FIRST(1,"大娃","红色"),SECOND(2,"二娃","橙色"),THIRD(3,"三娃","黄色"),FOURTH(4,"四娃","绿色"),FIFTH(5,"五娃","青色"),SIXTH(6,"六娃","蓝色"),SEVENTH(7,"七娃","紫色");

    public final int priority;
    private int location;
    private final String name;
    private final String color;
    private CalabashBro(int priority, String name, String color){
        this.color=color;
        this.name=name;
        this.priority=priority;
        location=-1;
    }
    public int getLocation(){
        return location;
    }
    public void reportName(){
        System.out.println(name);
    }
    public void reportColor(){
        System.out.print(color + " ");
    }
    public boolean comparePriority(CalabashBro bro){
        if(this.priority>bro.priority)
            return true;
        return false;
    }
    public void reportLocationChange(int newlocation){
        if(location!=-1 && newlocation!=-1 && location != newlocation){
            System.out.println(name+": "+location+"->"+newlocation);
        }
    }
    public void changeLocation(int location){
        reportLocationChange(location);
        this.location=location;
    }
}




