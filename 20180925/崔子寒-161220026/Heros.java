import Attributes.Color;
import Creatures.Grandfather;
import Creatures.CalabashBrother;
import java.util.Random;

public class Heros {
    private CalabashBrother[] calabashBrothers={new CalabashBrother(Color.RED),new CalabashBrother(Color.ORANGE),
            new CalabashBrother(Color.YELLOW), new CalabashBrother(Color.GREEN),new CalabashBrother(Color.BLUE),
            new CalabashBrother(Color.CYAN),new CalabashBrother(Color.PURPLE),};
    private Grandfather grandfather = new Grandfather();

    /*shuffle randomly*/
    public void shuffle() {
        Random rand = new Random() ;
        for(int i = 0;i < 6;i++) {
            int selectPosition = rand.nextInt(7 - i);
            CalabashBrother temp = calabashBrothers[selectPosition];
            calabashBrothers[selectPosition] = calabashBrothers[6 - i];
            calabashBrothers[6 - i] = temp;
        }
    }

    /*line up */
    public void lineUp() {
        shuffle();
        System.out.print("葫芦娃初始状态：");
        for(CalabashBrother x:calabashBrothers){
            System.out.print(x.getColor().getName()+" ");
        }
        System.out.println("\n准备列队");
        Mysort.myBubbleSort(calabashBrothers);

        System.out.print("葫芦娃列队完毕：");
        for(CalabashBrother x:calabashBrothers){
            System.out.print(x.getColor().getName()+" ");
        }
        System.out.println();
    }

    public Grandfather getGrandfather() {
        return grandfather;
    }

    public CalabashBrother[] getCalabashBrothers() {
        return calabashBrothers;
    }
}

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
