import Attributes.Color;
import Creatures.Grandfather;
import Creatures.CalabashBrother;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Heros {
    /*
    private CalabashBrother[] calabashBrothers={new CalabashBrother(Color.RED),new CalabashBrother(Color.ORANGE),
            new CalabashBrother(Color.YELLOW), new CalabashBrother(Color.GREEN),new CalabashBrother(Color.BLUE),
            new CalabashBrother(Color.CYAN),new CalabashBrother(Color.PURPLE),};
            */
    private ArrayList<CalabashBrother> calabashBrothers = new ArrayList<>();
    private Grandfather grandfather = new Grandfather();

    public Heros() {
        calabashBrothers.addAll(Arrays.asList(new CalabashBrother(Color.RED),new CalabashBrother(Color.ORANGE),
                new CalabashBrother(Color.YELLOW), new CalabashBrother(Color.GREEN),new CalabashBrother(Color.BLUE),
                new CalabashBrother(Color.CYAN),new CalabashBrother(Color.PURPLE)));
    }
    /*shuffle randomly*/
    public void shuffle() {
        Collections.shuffle(calabashBrothers);
    }

    /*line up */
    public void lineUp() {
        shuffle();
        System.out.print("葫芦娃初始状态：");
        for(CalabashBrother x:calabashBrothers){
            System.out.print(x.getColor().getName()+" ");
        }
        System.out.println("\n准备列队");
        //Mysort.myBubbleSort(calabashBrothers);
        Collections.sort(calabashBrothers);

        System.out.print("葫芦娃列队完毕：");
        for(CalabashBrother x:calabashBrothers){
            System.out.print(x.getColor().getName()+" ");
        }
        System.out.println();
    }

    public Grandfather getGrandfather() {
        return grandfather;
    }

    public ArrayList<CalabashBrother> getCalabashBrothers() {
        return calabashBrothers;
    }
}

//用持有类型重写后，排序采用Collections.sort, 不再使用Mysort
class Mysort {
    /*Swap two elements*/
    private static void swap(CalabashBrother[] brothers, int index1, int index2) {
        //System.out.println();
        CalabashBrother temp = brothers[index1];
        brothers[index1] = brothers[index2];
        brothers[index2] = temp;
    }

    /*bubble sort based on ranking*/
    public static void myBubbleSort(CalabashBrother[] brothers) {
        for(int i = 0;i < 6;i++) {
            for(int j = 0;j < 6-i;j++) {
                if(brothers[j].getColor().ordinal() > brothers[j+1].getColor().ordinal())
                    swap(brothers,j,j+1);
            }
        }
    }
}
