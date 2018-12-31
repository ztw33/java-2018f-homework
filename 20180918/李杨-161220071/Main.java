package com.company;
    enum Brother{
        RED("老大",1,"red"),ORANGE("老二",2,"orange"),YELLOW("老三",3,"yellow"),GREEN("老四",4,"green"),CYAN("老五",5,"cyan"),
        BLUE("老六",6,"blue"),VIOLET("老七",7,"violet");

        private String name;
        private  int rank;
        private String color;

        private Brother(String name, int rank,String color){
            this.name=name;
            this.rank=rank;
            this.color=color;
        }
        public String getName(){
            return this.name;
        }
        public String getColor(){
            return this.color;
        }
        public int getRank(){
            return this.rank;
        }
    }
    class Report{
         public void ChangeReport(Brother start,int Place_start,int Place_end){
             System.out.println(start.getName()+':'+Place_start+'-'+'>'+Place_end);
         }
         public void FinishReport(Brother arr[]){
             for(int i=0;i<arr.length;i++)
                 System.out.println(arr[i].getName()+"在此！");
         }
         public void ColorReport(Brother arr[]){
             for(int i=0;i<arr.length;i++)
                 System.out.println(arr[i].getColor());
         }
    }
    class CalabashBrother{//create  init and sort the array
        public static final int MAX_NUM=7;
        Report TellMe=new Report();
        Brother CalabashBrotherArray[] =Brother.values();
        public void RandomSort(){
            for(int i=0;i<CalabashBrotherArray.length;i++)
            {
                int seed=(int)(Math.random()*7);
                Brother temp=CalabashBrotherArray[i];
                CalabashBrotherArray[i]=CalabashBrotherArray[seed];
                CalabashBrotherArray[seed]=temp;
            }
            for(int i=0;i<CalabashBrotherArray.length;i++)
                System.out.println(CalabashBrotherArray[i]);
        }

        public void BubbleSort(){
            for(int i=0;i<CalabashBrotherArray.length;i++)
            {
                for(int j=i+1;j<CalabashBrotherArray.length;j++)
                {
                    if(CalabashBrotherArray[i].getRank() > CalabashBrotherArray[j].getRank() ) {
                        TellMe.ChangeReport(CalabashBrotherArray[i],i,j);
                        TellMe.ChangeReport(CalabashBrotherArray[j],j,i);
                        Brother temp = CalabashBrotherArray[i];
                        CalabashBrotherArray[i] = CalabashBrotherArray[j];
                        CalabashBrotherArray[j] = temp;
                       // TellMe.ChangeReport(CalabashBrotherArray[i],i,j);
                        //TellMe.ChangeReport(CalabashBrotherArray[j],j,i);
                    }
                }
            }
            TellMe.FinishReport(CalabashBrotherArray);
//            for(int i=0;i<CalabashBrotherArray.length;i++)
  //              System.out.println(CalabashBrotherArray[i]);
        }

        public void BinarySort(){
            for(int i=1;i<CalabashBrotherArray.length;i++){
                Brother temp =CalabashBrotherArray[i];
                int low=0,high=i-1;
                int mid=-1;
                while(low<=high){
                    mid=low+(high-low)/2;
                    if(CalabashBrotherArray[mid].getRank()>temp.getRank())
                        high=mid-1;
                    else
                        low=mid+1;
                }
                for(int j=i-1;j>=low;j--)
                {
                    TellMe.ChangeReport(CalabashBrotherArray[j],j,j+1);
                    CalabashBrotherArray[j+1]=CalabashBrotherArray[j];
                }
                {
                    TellMe.ChangeReport(CalabashBrotherArray[i],i,low);
                    CalabashBrotherArray[low]=temp;
                }
            }
            TellMe.ColorReport(CalabashBrotherArray);
        }
    }
    public class Main {
    public static void main(String[] args) {
	// write your code here
        CalabashBrother huluwa0=new CalabashBrother();
        huluwa0.RandomSort();
        huluwa0.BubbleSort();
        CalabashBrother huluwa1=new CalabashBrother();
        huluwa1.RandomSort();
        huluwa1.BinarySort();

}}
