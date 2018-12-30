import java.util.Random;
import java.util.concurrent.Callable;

class Calabash {
    int id;
    String Name;
    String Color;
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
                if (brothers[j].id > brothers[j+1].id) {
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
                if(brothers[i].id < brothers[mid].id)
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
                    new Calabash(0,"老大","赤"),
                    new Calabash(1,"老二","橙"),
                    new Calabash(2,"老三","黄"),
                    new Calabash(3,"老四","绿"),
                    new Calabash(4,"老五","青"),
                    new Calabash(5,"老六","蓝"),
                    new Calabash(6,"老七","紫"),
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






