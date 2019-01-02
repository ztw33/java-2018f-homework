package com.javapr;
import java.util.Random;

public class CalabashBoys_1 {

    public enum CalabashBoys {
        FIRST("红色", "老大",1), SECOND("橙色", "老二", 2), THIRD("黄色", "老三", 3), FOURTH("绿色", "老四", 4),  FIFTH("青色", "老五", 5), SIXTH("蓝色", "老六", 6),SEVENTH("紫色", "老七", 7);
    //   FIRST("red", 1), SECOND("orange", 2), THIRD("yellow", 3), FOURTH("green", 4),  FIFTH("cyan", 5), SIXTH("blue", 6),SEVENTH("violet", 7);
        private String color;
        private String name;
        private int index;

        private CalabashBoys(String color, String name, int index){
            this.name = name;
            this.color = color;
            this.index = index;
        }
    }

    public static class CalaBashBabys{
        CalabashBoys[] Babys = CalabashBoys.values();   // member variable
        CalaBashBabys(){
            ;
        }
        public void Init(){          // init calabashbabys
            //CalabashBoys[] Babys = CalabashBoys.values();
            Random r = new Random();
            int rand = r.nextInt(Babys.length);
            // pseudo-random numbers
            Babys[rand % Babys.length] = CalabashBoys.SECOND;
            Babys[(rand + 1) % Babys.length] = CalabashBoys.SIXTH;
            Babys[(rand + 2) % Babys.length] = CalabashBoys.THIRD;
            Babys[(rand + 3) % Babys.length] = CalabashBoys.FIFTH;
            Babys[(rand + 4) % Babys.length] = CalabashBoys.FIRST;
            Babys[(rand + 5) % Babys.length] = CalabashBoys.SEVENTH;
            Babys[(rand + 6) % Babys.length] = CalabashBoys.FOURTH;
        }
        public void BubbleSort(){               // bubble sort
            for (int i = 0; i < Babys.length; i++){
                int j = i;
                for (; j < Babys.length; j++){
                    if (Babys[i].index > Babys[j].index){
                        RemoveReport(Babys[i], j, i);       //Count off
                        RemoveReport(Babys[j], i, j);       //Count off
                        CalabashBoys temp = Babys[i];
                        Babys[i] = Babys[j];
                        Babys[j] = temp;
                    }
                }
            }
        }
        public void BinarySort(){                //binary sort
            int left = 0, right = Babys.length - 1, low, high, middle, k, i;
            for (i = left + 1; i <= right; i++){
                CalabashBoys temp = Babys[i];
                low = left;
                high = i - 1;
                while (low <= high){                       // Search location by half search
                    middle = (low + high) / 2;             //Midpoint
                    if (temp.index < Babys[middle].index)  //The insertion value is less than the median value
                        high = middle - 1;                 //Narrowing to the left
                    else
                        low = middle + 1;                  //Else,narrowing to the right
                }
                for (k = i - 1; k >= low; k--) {           //Block movement
                    RemoveReport(Babys[k], k + 1, k);// Count off
                    Babys[k + 1] = Babys[k];
                }
                RemoveReport(Babys[i], low, i);            //Count off
                Babys[low] = temp;                         //Insert
            }
        }
        public void RemoveReport(CalabashBoys b, int move_after, int move_before){ // Count off
            System.out.print(b.name + ":" + move_before + "->" + move_after + "\n");
        }
        public void printColor(){                // print color
            for (int i = 0; i < Babys.length; i++){
                System.out.print(Babys[i].color + "\n");
            }
        }
        public void printName(){                // print name
            for (int i = 0; i < Babys.length; i++){
                System.out.print(Babys[i].name + "\n");
            }
        }
        public void printb(){                   // print calabashbabys
            for (int i = 0; i < Babys.length; i++)
                System.out.print(Babys[i].name + " " + Babys[i].color + " " + Babys[i].index + "\n");
        }
    }
    public static void main(String[] args){
        CalaBashBabys bb = new CalaBashBabys();
        bb.Init();
        System.out.print("befor bubble sort:\n");
        bb.printb();          // before bubble sort
        bb.BubbleSort();
        System.out.print("after bubble sort:\n");
        bb.printName();       //after bubble sort
        bb.Init();            //init again
        System.out.print("before binary sort:\n");
        bb.printb();          //before binary sort
        bb.BinarySort();      //binary sort
        System.out.print("after binary sort:\n");
        bb.printColor();      //after binary sort
    }
}
