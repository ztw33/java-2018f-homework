package World;

import creature.CalabashBrother;
import creature.Leader;
import creature.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.Enum;

public class Calabash_Scheduler extends Scheduler<CalabashBrother>{
    private Leader leader;
    private List<CalabashBrother> calabashbrothers = new ArrayList<>();
    public Calabash_Scheduler(Leader x){
        leader = x;
    }

    public void init_Soldiers(){
        calabashbrothers.add(CalabashBrother.RED);
        calabashbrothers.add(CalabashBrother.ORANGE);
        calabashbrothers.add(CalabashBrother.YELLOW);
        calabashbrothers.add(CalabashBrother.GREEN);
        calabashbrothers.add(CalabashBrother.CYAN);
        calabashbrothers.add(CalabashBrother.BLUE);
        calabashbrothers.add(CalabashBrother.PURPLE);              //在葫芦娃调度者中初始化葫芦兄弟
    }

    public List<CalabashBrother> getList (){
        return calabashbrothers;
    }

    public void setFormation(String name){
        leader.check_C_formation(calabashbrothers,name);
    }

    public void shuffle(){
        Collections.shuffle(calabashbrothers);
    }
    
    public void display_name(){
        for (CalabashBrother i: calabashbrothers
             ) {
            System.out.print(i.getName() + " ");
        }
        System.out.println();
    }

    public void display_color(){
        for (CalabashBrother i: calabashbrothers
                ) {
            System.out.print(i.getColour().toString() + " ");
        }
        System.out.println();
    }

    void swapCalabash(int index1,int index2){
        CalabashBrother temp = calabashbrothers.get(index1);
        calabashbrothers.set(index1,calabashbrothers.get(index2));
        calabashbrothers.set(index2,temp);
        System.out.println(calabashbrothers.get(index2).getNo() + ": " + index1 + "->" + index2);
        System.out.println(calabashbrothers.get(index2).getNo() + ": " + index2 + "->" + index1);
    }

    public void sortbyRank(){
        for(int i = 0;i<calabashbrothers.size();i++){
            for(int j = i + 1; j < calabashbrothers.size();j++){
                if(calabashbrothers.get(i).getNo() > calabashbrothers.get(j).getNo())
                    swapCalabash(i,j);
            }
        }
        display_name();
        System.out.println();
    }

    public void sortbyColor(){
        for(int i = 1 ; i<calabashbrothers.size();i++){
            int low = 0, mid, high = i -1;
            while(low <= high){
                mid = (high + low)/2;
                if(calabashbrothers.get(mid).getColour().ordinal() >= calabashbrothers.get(i).getColour().ordinal())
                    high = mid -1;
                else
                    low = mid + 1;
            }
            for(int j = i; j>low;j--)
                swapCalabash(j -1 ,j);
        }
        display_color();
        System.out.println();
    }
}
