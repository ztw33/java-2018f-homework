package sort;

import java.util.Comparator;

abstract class AbstractSorter {
    abstract public void sort(Object[] array, Comparator cmp);

    public void swap(Object[] array, int i, int j){
        System.out.printf("%s: %d -> %d\n", array[i],i,j);
        System.out.printf("%s: %d -> %d\n", array[j],j,i);

        Object t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
