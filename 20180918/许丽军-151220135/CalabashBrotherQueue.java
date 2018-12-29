import huluwa.CalabashBrother;
import sort.BubbleSorter;
import sort.QuickSorter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CalabashBrotherQueue {

    private CalabashBrother[] queue = CalabashBrother.values();
    private BubbleSorter bubbleSorter = new BubbleSorter();
    private QuickSorter quickSorter = new QuickSorter();

    public CalabashBrotherQueue() {
    }

    public void shuffle(){
        Collections.shuffle(Arrays.asList(queue));
    }

    public void bubbleSort(Comparator cmp){
        bubbleSorter.sort(queue, cmp);
    }

    public void quickSort(Comparator cmp){
        quickSorter.sort(queue, cmp);
    }


    public void tellRankOrderly(){
        for(CalabashBrother cb : queue) {
            System.out.print(cb.getRank());
            System.out.print("\t");
        }
        System.out.println();
    }
    public void tellColorOrderly(){
        for(CalabashBrother cb : queue){
            System.out.print(cb.getColor());
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        CalabashBrotherQueue calabashBrotherQueue = new CalabashBrotherQueue();
        calabashBrotherQueue.shuffle();
        System.out.print("shuffled:");
        calabashBrotherQueue.tellRankOrderly();
        Comparator rankCmp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                CalabashBrother cb1 = (CalabashBrother)o1;
                CalabashBrother cb2 = (CalabashBrother)o2;
                return cb1.getRank() - cb2.getRank();
            }
        };
        calabashBrotherQueue.bubbleSort(rankCmp);
        System.out.print("sorted by rank:");
        calabashBrotherQueue.tellRankOrderly();

        calabashBrotherQueue.shuffle();
        System.out.print("shuffled:");
        calabashBrotherQueue.tellColorOrderly();
        Comparator colorCmp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                CalabashBrother cb1 = (CalabashBrother)o1;
                CalabashBrother cb2 = (CalabashBrother)o2;
                return cb1.getColorOrdinal() - cb2.getColorOrdinal();
            }
        };
        calabashBrotherQueue.quickSort(colorCmp);
        System.out.print("sorted by color:");
        calabashBrotherQueue.tellColorOrderly();
    }

}
