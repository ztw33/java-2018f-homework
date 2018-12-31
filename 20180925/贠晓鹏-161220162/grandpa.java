public class grandpa extends creatures{
    grandpa(){
        name=new String("G");
        x=y=0;
    }
    grandpa(int get_x,int get_y){
        name=new String("G");
        x=get_x;y=get_y;
    }
    public void report_name(){//打印名字
        System.out.print(name+"  ");
    }
}