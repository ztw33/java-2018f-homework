public class monsters extends creatures {
    int flag;
    monsters()
    {
        name=new String("M");
        flag=0;
        x=y=0;
    }
    monsters(int get_flag){
        flag=get_flag;
        if(flag==1)
            name=new String("BM");
        else
            name=new String("M");
    }
    public void report_name(){//打印名字
        System.out.print(name+"  ");
    }
}