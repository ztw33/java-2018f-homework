package bjy.SevenChairs;

import java.lang.String;
public class Brother {
    private int rank;
    private String color;
    private int chair_number;
    private String name;
    public Brother (int ranking,int chair){
        this.rank=ranking;
        this.chair_number=chair;
        switch (ranking)
        {
            case 0:this.name=new String ("老大");this.color=new String("红");break;
            case 1:this.name=new String ("老二");this.color=new String("橙");break;
            case 2:this.name=new String ("老三");this.color=new String("黄");break;
            case 3:this.name=new String ("老四");this.color=new String("绿");break;
            case 4:this.name=new String ("老五");this.color=new String("青");break;
            case 5:this.name=new String ("老六");this.color=new String("蓝");break;
            case 6:this.name=new String ("老七");this.color=new String("紫");break;
        }
    }

    public int GetRank(){
        return this.rank;
    }
    public int GetPlace(){
        return this.chair_number;
    }
    public String GetName(){
        return this.name;
    }
    public String GetColor(){
        return this.color;
    }
    //交换两个位置
    public void ExchangeBrother(Brother bro){
        System.out.println(this.name+":"+this.chair_number+"->"+bro.GetPlace());
        System.out.println(bro.GetName()+":"+bro.GetPlace()+"->"+this.chair_number);
        String tmp=this.name;
        this.name=bro.GetName();
        bro.SetName(tmp);
        tmp=this.color;
        this.color=bro.GetColor();
        bro.SetColor(tmp);
        int tp=this.rank;
        this.rank=bro.GetRank();
        bro.SetRank(tp);
    }
    //比自己排位小返回false；否则返回true
    public boolean CompareBrother(Brother bro){
        if(bro.GetRank() > this.rank)
            return false;
        else
            return true;
    }
    //与前面相邻的兄弟比较
    public void compare_brother(Brother bro){
        if(bro.GetRank() > this.rank){
            /*int tmp=bro.GetPlace();
            bro.ChangePlace(this.chair_number);
            System.out.println(this.name+":"+this.chair_number+"->"+tmp);
            this.chair_number=tmp;*/
            ExchangeBrother(bro);
            //tp=this.chair_number;
            //this.chair_number=bro.GetPlace();
            //bro.SetPlace(tp);
        }
    }
    //设置颜色
    public void SetColor(String color) {
        this.color = color;
    }
    //设置名字
    public void SetName(String nm) {
        this.name = nm;
    }
    //设置大小
    public void SetRank(int rk) {
        this.rank = rk;
    }
    //交换位置
    public void SetPlace(int position) {
        //System.out.println(name+":"+this.chair_number+"->"+position);
        this.chair_number=position;
    }
    //打印状态
    public void Display(){
        System.out.println("这是"+this.name+"  颜色是"+this.color+"    排在位置第"+this.chair_number);
    }
    public void DisplayAge(){
        System.out.println("这是"+this.name);
    }
    public void DisplayColor(){
        System.out.println("颜色是"+this.color);
    }
}
