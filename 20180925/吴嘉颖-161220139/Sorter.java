import java.util.*;

abstract class SortAlg {
    public abstract void sort(List<CalabashBro> array, int n);
}

class BubbleSort extends SortAlg {
    public void sort(List<CalabashBro> array, int n){
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array.get(j).getSeq() > array.get(j+1).getSeq()) {
                    CalabashBro temp = array.get(j);
                    array.set(j, array.get(j+1));
                    array.get(j).changePlaceInQue(j, true); // here... changePlace ... need to improve...->Object Oriented
                    array.set(j+1, temp);
                    array.get(j+1).changePlaceInQue(j+1, true);
                }
            }
        }
    }
}

class BiSort extends SortAlg {
    public void sort(List<CalabashBro> array, int n){
        for (int i = 0; i < n; i++) {
            CalabashBro current = array.get(i);
            int hd = 0, tl = i-1, mid = 0;
            while (hd <= tl) {
                mid = (hd + tl) / 2;
                if (current.getColor().ordinal() < array.get(mid).getColor().ordinal())     //mid!!!not hd!!!
                    tl = mid - 1;
                else
                    hd = mid + 1;
            }
            for (int j = i; j > hd; j--){
                array.set(j, array.get(j-1));
                array.get(j).changePlaceInQue(j, true);
            }
            if (hd != i) {
                array.set(hd, current);
                array.get(hd).changePlaceInQue(hd, true);
            }
        }
    }
}

class Sorter {
    private SortAlg alg;

    void SortByName(CBQueue cbq) {
        alg = new BubbleSort();
        alg.sort(cbq.broQueue, 7);
    }

    void SortByColor(CBQueue cbq) {
        alg = new BiSort();
        alg.sort(cbq.broQueue, 7);
    }
}