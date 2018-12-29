public class snake extends creatures{
    snake(){
        name=new String("S");
        x=y=0;
    }
    snake(int get_x,int get_y){
        name=new String("S");
        x=get_x;y=get_y;
    }
    public void report_name(){//打印名字
        System.out.print(name+"  ");
    }
}