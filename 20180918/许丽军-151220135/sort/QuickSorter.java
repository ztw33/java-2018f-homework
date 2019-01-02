package sort;

import java.util.Comparator;

public class QuickSorter extends AbstractSorter {
    @Override
    public void sort(Object[] array, Comparator cmp) {
        quickSort(array, 0, array.length-1, cmp);
    }
    private void quickSort(Object[] array, int left, int right, Comparator cmp){
        if(left >= right)
            return;

        // partition
        int pivot = right;
        int i=left, j = left;
        while(j < pivot){
            if(cmp.compare(array[j], array[pivot]) < 0){
                if(i != j) {
                    swap(array, i, j);
                }
                i++;
            }
            j++;
        }

        if(i != pivot){
            swap(array, i, pivot);
        }

        pivot = i;
        quickSort(array, left, pivot-1, cmp);
        quickSort(array, pivot+1, right, cmp);
    }
}
