import java.util.*;
public class Sort {
    public static void main(String[] args) {
        // Merge sort
        int n = 10;
        ArrayList<Integer> A = new ArrayList<>(n);
        //initialize
        for (int i = 0; i < n; i++) {
            A.add(n - i);
        }
        // System.out.println(A);
        Sort(A, n);
    }

    static void merge(ArrayList<Integer>list1, int left, int mid, int right) {
        ArrayList<Integer> list2 = new ArrayList<>(right - left + 1);
        // copy list1 to list2, not reference
        list2.addAll(list1);
        int s1 = left, s2 = mid + 1, t = left;
        while(s1 <= mid && s2 <=right) {
            if(list2.get(s1) <= list2.get(s2)) {
                list1.set(t, list2.get(s1));
                s1++;
            } else {
                list1.set(t, list2.get(s2));
                s2++;
            }
            t++;
        }
        while(s1 <= mid) {
            list1.set(t, list2.get(s1));
            t++;
            s1++;
        }
        while(s2 <= right) {
            list1.set(t, list2.get(s2));
            t++;
            s2++;
        }
    }
    static void mergeSort(ArrayList<Integer> A, int left, int right) {
        if(left >= right)   return;
        int mid = (left + right) / 2;
        mergeSort(A, left, mid);
        mergeSort(A, mid+1, right);
        merge(A, left, mid, right);

    }
    static void Sort(ArrayList<Integer> A, int n) {
        //mergeSort
        mergeSort(A, 0, n-1);
        System.out.println(A);

    }

}