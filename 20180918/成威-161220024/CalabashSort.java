package Calabash;

import java.util.Random;

public class CalabashSort {
    //枚举类
    public enum CalabashBrother {
        RED("红色", "老大", 1), ORANGE("橙色", "老二", 2), YELLOW("黄色", "老三", 3), GREEN("绿色", "老四", 4), CYAN("青色", "老五", 5), BLUE("蓝色", "老六", 6), PURPLE("紫色", "老七", 7);
        String color;   //颜色
        String rank;    //排行
        int index;      //用于排序

        CalabashBrother(String str1, String str2, int r) {
            this.color = str1;
            this.rank = str2;
            this.index = r;
        }

        //把葫芦娃移动到队列queue中的位置destination
        void move(CalabashBrother[] queue,int destination){
            queue[destination]=this;
        }
    }

    //用于排序的类
    static class CbSort{

        CalabashBrother[] brothers;

        CbSort(){
            /*
            brothers=new CalabashBrother[7];    //7个葫芦娃
            //用枚举类赋值七个不同的葫芦娃
            int i=0;
            for (CalabashBrother c : CalabashBrother.values()){
                brothers[i++]=c;
            }
            */
            brothers=CalabashBrother.values();
        }

        //从第一个到最后一个报颜色
        void printcolor(){
            for(int i=0;i<7;i++){
                System.out.print(brothers[i].color+" ");
            }
            System.out.println();
        }

        //从第一个到最后一个报数
        void printrank(){
            for(int i=0;i<7;i++){
                System.out.print(brothers[i].rank+" ");
            }
            System.out.println();
        }

        //让七个葫芦娃随意站队
        void randomsort(){
            System.out.println("random sort!");

            Random random=new Random();
            for(int i=1;i<7;i++){
                int p=random.nextInt(i+1);
                CalabashBrother temp=brothers[i];
                brothers[p].move(brothers,i);
                temp.move(brothers,p);
                /*
                brothers[i]=brothers[p];
                brothers[p]=temp;
                */
            }
        }

        //冒泡排序：排序前报数 + 报告交换动作 + 排序后报数
        void bubblesort(){
            printrank();
            System.out.println("bubble sort:");
            for(int i=0;i<6;i++){
                for(int j=0;j<7-i-1;j++){
                    if(brothers[j].index>brothers[j+1].index){
                        CalabashBrother temp=brothers[j];
                        brothers[j+1].move(brothers,j);
                        report(brothers[j],j+1,j);
                        temp.move(brothers,j+1);
                        report(brothers[j+1],j,j+1);
                    }
                }
            }
            printrank();
        }

        //二分插入排序：排序前报颜色 + 报告交换动作 + 排序后报颜色
        void binaryorder(){
            printcolor();
            System.out.println("binary order:");
            for(int i=1;i<7;i++){
                int left=0,right=i-1;
                int mid;
                while(left<=right){
                    mid=(left+right)/2;
                    if(brothers[i].index>=brothers[mid].index){
                        left=mid+1;
                    }
                    else{
                        right=mid-1;
                    }
                }
                CalabashBrother temp=brothers[i];
                for(int j=i-1;j>=left;j--) {
                    brothers[j].move(brothers, j+1);
                    report(brothers[j+1], j, j+1);
                }
                temp.move(brothers,left);
                report(temp,i,left);
            }
            printcolor();
        }

        void report(CalabashBrother cb,int s,int d){
            System.out.println(cb.rank + ": " + (s + 1) + "->" + (d + 1));
        }

        /*
        //将p位置的葫芦娃插入到q位置，报告交换动作
        void move(int p,int q){
            if(p!=q) {
                CalabashBrother temp = brothers[p];
                for (int i = p - 1; i >= q; i--) {
                    brothers[i + 1] = brothers[i];
                    System.out.println(brothers[i].rank + ": " + (i + 1) + "->" + (i + 2));
                }
                brothers[q] = temp;
                System.out.println(temp.rank + ": " + (p + 1) + "->" + (q + 1));
            }
        }

        //交换p位置和q位置的葫芦娃，报告交换动作
        void swap(int p,int q){
            System.out.println(brothers[p].rank+": "+(p+1)+"->"+(q+1));
            System.out.println(brothers[q].rank+": "+(q+1)+"->"+(p+1));
            CalabashBrother temp=brothers[p];
            brothers[p]=brothers[q];
            brothers[q]=temp;
        }
        */
    }

    public static void main(String args[]) {
        CbSort win=new CbSort();
        win.randomsort();
        win.bubblesort();
        win.randomsort();
        win.binaryorder();
    }
}
