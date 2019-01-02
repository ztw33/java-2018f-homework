package group;
import java.util.Random;
import creature.*;
import sort.Sort;
import space.TwoDimensionSpace;
import formation.*;

public class HuluBrothers implements Group{
    private HuluWa member[];
    private Creature observer;
    public HuluBrothers(){
        member = new HuluWa[7];
        for (int i = 0; i < 7; i++){
            member[i] = new HuluWa(i+1);
        }
        //Creature grandpa = new Creature("爷爷");
        observer = new Grandpa();
    }
    public void shoutBrothersName(){
        for (HuluWa h : member){
            h.shoutOutName();
            System.out.print(' ');
        }
        System.out.println();
    }
    public void shoutBrothersColor(){
        for (HuluWa h : member){
            h.shoutOutColor();
            System.out.print(' ');
        }
        System.out.println();
    }
    public void random(){
        Random rand = new Random();
        for (int i = 7; i >= 1; i--){
            int x = rand.nextInt(i);
            HuluWa temp = member[i-1];
            member[i-1] = member[x];
            member[x] = temp;
        }
    }
    /*public void prioritySort(){
        Sort sort = new Sort();
        sort.bubbleSort(member);
    }
    public void colorSort(){
        Sort sort = new Sort();
        sort.biInsertSort(member);
    }*/
    public void sort(Sort sort) {
        sort.sort(member);
    }
    public void generateFormation(Formation formation, TwoDimensionSpace space, int x, int y, int direction)
    {
        formation.generateFormation(space, member, observer, x, y, direction);
    }
}
