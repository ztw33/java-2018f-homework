package sort;

import java.util.Comparator;

public class BubbleSorter extends AbstractSorter {
    @Override
    public void sort(Object[] array, Comparator cmp){
        final int NUM = array.length;
        for(int i = 0; i < NUM -1 ; i++){
            for(int j = 0; j < NUM - 1 - i; j++){
                if(cmp.compare(array[j], array[j+1]) > 0){
                    swap(array, j, j+1);
                }
            }
        }
    }
}
