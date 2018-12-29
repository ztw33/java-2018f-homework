/************************The number of Calabashboys is 1-7 in the matrix***************************************/

package com.CalabashBoys;
import java.util.Random;

enum CalabashBoys{
    FIRST("红色", "老大",1), SECOND("橙色", "老二", 2), THIRD("黄色", "老三", 3), FOURTH("绿色", "老四", 4),  FIFTH("青色", "老五", 5), SIXTH("蓝色", "老六", 6),SEVENTH("紫色", "老七", 7);
    private String color;
    private String name;
    private int index;
    private CalabashBoys(String color, String name, int index) {
        this.name = name;
        this.color = color;
        this.index = index;
    }
    public String getColor(){
        return color;
    }
    public String getName(){
        return name;
    }
    public int getIndex(){
        return index;
    }
}

public class Calabash {
        CalabashBoys[] Babys = CalabashBoys.values();   // member variable
        public Calabash(){}
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
                if (Babys[i].getIndex() > Babys[j].getIndex()){
                    //RemoveReport(Babys[i], j, i);       //Count off
                    //RemoveReport(Babys[j], i, j);       //Count off
                    CalabashBoys temp = Babys[i];
                    Babys[i] = Babys[j];
                    Babys[j] = temp;
                }
            }
        }
    }
        public void printb(){                   // print calabashbabys
        for (int i = 0; i < Babys.length; i++)
            System.out.print(Babys[i].getName() + " " + Babys[i].getColor() + " " + Babys[i].getIndex() + "\n");
        }
        public int IndexOfBabys(int n){
            return Babys[n].getIndex();
        }
        public int NumOfBabys(){
            return Babys.length;
        }
}
