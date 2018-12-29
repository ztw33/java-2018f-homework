import java.util.Random;

enum Color {
    RED("红色"), ORANGE("橙色"),YELLOW("黄色"),
    GREEN("绿色"), CYAN("青色"), BLUE("蓝色"), VIOLET("紫色");

    String CName;
    Color(String CName) {
        this.CName = CName;
    }
}

enum CalabashBro {
    BRO1("老大",Color.RED), BRO2("老二",Color.ORANGE), BRO3("老三",Color.YELLOW),
    BRO4("老四",Color.GREEN), BRO5("老五",Color.CYAN), BRO6("老六",Color.BLUE), BRO7("老七",Color.VIOLET);

    // name-seq
    private String ownName;
    private Color color;
    private int place;

    CalabashBro(String ownName, Color color) {
        this.ownName = ownName;
        this.color = color;
    }

    public String getName() {
        return ownName;
    }

    public Color getColor() {
        return color;
    }

    public void setPlace(int place) {
        this.place = place;
    }
    public void changePlace(int idx) {
        int oldPlace = place;
        place = idx;
        System.out.println(ownName + ": " + oldPlace + " -> " + place);
    }
}

class CBQueue {
    CalabashBro[] broQueue;

    CBQueue() {
        broQueue = CalabashBro.values();
    }

    void randomQueue() {
        // generate random number ( place of CalabashBro )
        Random rd = new Random();
        boolean []setDown = new boolean[7];
        for (int i = 0; i < 7; i++) {
            setDown[i] = false;
        }

        int idx;
        for (int i = 0; i < 7; i++) {
            // avoid collision
            do {
                idx = rd.nextInt(7);
            }while(setDown[idx]);
            setDown[idx] = true;
            broQueue[i] = CalabashBro.values()[idx];
            broQueue[i].setPlace(i);
        }
    }

    void countOffAcName() {
        for (int i = 0; i < 6; i++) {
            System.out.print(broQueue[i].getName()+" ");
        }
        System.out.println(broQueue[6].getName());
    }

    void countOffAcColor() {
        for (int i = 0; i < 6; i++) {
            System.out.print(broQueue[i].getColor().CName+" ");
        }
        System.out.println(broQueue[6].getColor().CName);
    }
}

// SortAlg - BubbleSort & BiSort
abstract class SortAlg {
    public abstract void sort(CalabashBro array[], int n);
}

class BubbleSort extends SortAlg {
    public void sort(CalabashBro array[], int n){
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].ordinal() > array[j+1].ordinal()) {
                    CalabashBro temp = array[j];
                    array[j] = array[j+1];
                    array[j].changePlace(j); // here... changePlace ... need to improve...->Object Oriented
                    array[j+1] = temp;
                    array[j+1].changePlace(j+1);
                }
            }
        }
    }
}

class BiSort extends SortAlg {
    public void sort(CalabashBro array[], int n){
        for (int i = 0; i < n; i++) {
            CalabashBro current = array[i];
            int hd = 0, tl = i-1, mid = 0;
            while (hd <= tl) {
                mid = (hd + tl) / 2;
                if (current.getColor().ordinal() < array[mid].getColor().ordinal())     //mid!!!not hd!!!
                    tl = mid - 1;
                else
                    hd = mid + 1;
            }
            for (int j = i; j > hd; j--){
                array[j] = array[j-1];
                array[j].changePlace(j);
            }
            if (hd != i) {
                array[hd] = current;
                array[hd].changePlace(hd);
            }
        }
    }
}

public class SortAndCount {
    private static SortAlg alg;

    private static void SortByName(CBQueue cbq) {
        alg = new BubbleSort();
        alg.sort(cbq.broQueue, 7);
    }

    private static void SortByColor(CBQueue cbq) {
        alg = new BiSort();
        alg.sort(cbq.broQueue, 7);
    }

    public static void main(String[] args) {
        CBQueue cbqueue = new CBQueue();

        cbqueue.randomQueue();
        System.out.println("Before sorting by name:");
        cbqueue.countOffAcName();
        SortByName(cbqueue);
        System.out.println("After sorting by name:");
        cbqueue.countOffAcName();

        System.out.println();

        cbqueue.randomQueue();
        System.out.println("Before sorting by color:");
        cbqueue.countOffAcName();
        cbqueue.countOffAcColor();
        SortByColor(cbqueue);
        System.out.println("After sorting by color:");
        cbqueue.countOffAcName();
        cbqueue.countOffAcColor();
    }
}