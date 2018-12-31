import java.util.Random;


enum Calabash {
    FIRST(1,"老大","赤"),
    SECOND(2,"老二","橙"),
    THIRD(3,"老三","黄"),
    FORTH(4,"老四","绿"),
    FIFTH(5,"老五","青"),
    SIXTH(6,"老六","蓝"),
    SEVENTH(7,"老七","紫");
    private  int id;
    private  String Name;
    private  String Color;
    Calabash(int i,String name,String color){
        id=i;
        Name=name;
        Color = color;
    }
    void ReportName(){
        System.out.print(Name+' ');
    }
    void ReportColor(){
        System.out.print(Color+' ');
    }
    void ReportLocation(int src,int dst){
        ReportName();
        System.out.println(":"+src+"->"+dst);
    }
}

class Sorter{

    void RandomSort(Calabash[] brothers) {
        Random random=new Random();
        for (int i = 0; i < 7; i++) {
            int p = random.nextInt(i + 1);
            Calabash tmp = brothers[i];
            brothers[i] = brothers[p];
            brothers[p] = tmp;

        }
    }
    void Swap(Calabash[] brothers,int i,int j){
        Calabash temp = brothers[i];
        brothers[i].ReportLocation(i,j);
        brothers[j].ReportLocation(j,i);
        brothers[i]=brothers[j];
        brothers[j]=temp;
    }
    void BubbleSort(Calabash[] brothers){
        for(int i=0;i<brothers.length-1;i++)
            for(int j=0;j<brothers.length-1-i;j++) {
                if (brothers[j].ordinal() > brothers[j+1].ordinal()) {
                    Swap(brothers,j, j+1);
                }
            }

    }
    void BinarySort(Calabash[] brothers){
        int left,right,mid;
        for(int i=1;i<brothers.length;i++){
            left=0;right=i-1;
            while(left<=right){
                mid=(left+right)/2;
                if(brothers[i].ordinal() < brothers[mid].ordinal())
                    right=mid-1;
                else
                    left=mid+1;
            }

            Calabash temp=brothers[i];
            for(int j=i;j>left;j--) {
                brothers[j - 1].ReportLocation(j - 1, j);
                brothers[j] = brothers[j - 1];
            }
            if(left!=i)
                temp.ReportLocation(i,left);
            brothers[left]=temp;
        }
    }

}

public class CalabashSort{

        public static void main(String[] args){
            Calabash[] brothers={
                    Calabash.FIRST,
                    Calabash.SECOND,
                    Calabash.THIRD,
                    Calabash.FORTH,
                    Calabash.FIFTH,
                    Calabash.SIXTH,
                    Calabash.SEVENTH,
            };
            Sorter grandpa=new Sorter();
           grandpa.RandomSort(brothers);
           System.out.println("排序前：");
           for(Calabash t:brothers)
               t.ReportName();
           System.out.println();
           grandpa.BubbleSort(brothers);
           for(Calabash t:brothers)
                t.ReportName();
           System.out.println();


           grandpa.RandomSort(brothers);
           System.out.println("排序前：");
            for(Calabash t:brothers)
                t.ReportColor();
            System.out.println();
           grandpa.BinarySort(brothers);
            for(Calabash t:brothers)
                t.ReportColor();
            System.out.println();
        }
}






