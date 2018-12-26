import java.util.ArrayList;
import java.util.Random;


public class Instructor {
    public static void bubbleSort(ArrayList<GourdBrothers> gourdBrothersList) {
        int size = gourdBrothersList.size();
        for(int i = 0; i < size - 1; i++){
            for(int j = i + 1; j < size; j++){
                if(gourdBrothersList.get(i).tellRank() > gourdBrothersList.get(j).tellRank()){
                    //report
                    gourdBrothersList.get(i).report(i, j);
                    gourdBrothersList.get(j).report(j, i);
                    //swap
                    GourdBrothers temp = gourdBrothersList.get(i);
                    gourdBrothersList.set(i,gourdBrothersList.get(j));
                    gourdBrothersList.set(j,temp);
                    //displayInRank(gourdBrothersList);
                }
            }
        }
    }
    public static void merge(ArrayList <GourdBrothers> list1, int left, int mid, int right) {
        ArrayList<GourdBrothers> list2 = new ArrayList<>(right - left + 1);
        //copy list1 to list2, not reference
        list2.addAll(list1);
        int s1 = left, s2 = mid + 1, t = left;
        while (s1 <= mid && s2 <= right) {
            if (list2.get(s1).tellRank() <= list2.get(s2).tellRank()) {
                //report
                list2.get(s1).report(s1, t);
                //insert
                list1.set(t, list2.get(s1));
                s1++;
            } else {
                //report
                list2.get(s2).report(s2, t);
                //insert
                list1.set(t, list2.get(s2));
                s2++;
            }
            t++;
        }

        while(s1 <= mid) {
            //report
            list2.get(s1).report(s1, t);
            //insert
            list1.set(t, list2.get(s1));
            t++;
            s1++;
        }
        while(s2<=right) {
            //report
            list2.get(s2).report(s2, t);
            //insert
            list1.set(t, list2.get(s2));
            t++;
            s2++;
        }
    }
    public static void mergeSort(ArrayList <GourdBrothers> A, int left, int right){
        if(left >= right)   return;
        int mid =  (left+right) / 2;
        mergeSort(A, left, mid);
        mergeSort(A,mid + 1,right);
        merge(A, left, mid, right);
    }
    //randomize the order in gourdBrothersList
    public static void randomize(ArrayList <GourdBrothers> gourdBrothersList) {
        Random r = new Random();
        final int trials = 100;
        int ra, rb;
        //Trials = 100
        for(int i = 0; i < trials; i++) {
            ra = r.nextInt(6);
            rb = r.nextInt(6);
            //swap gourdBrothersList[ra] and gourdBrothersList[rb]
            GourdBrothers temp = gourdBrothersList.get(ra);
            gourdBrothersList.set(ra, gourdBrothersList.get(rb));
            gourdBrothersList.set(rb, temp);
        }
    }
    //print in rank
    public static void displayInRank(ArrayList <GourdBrothers> gourdBrothersList) {
        for(GourdBrothers i: gourdBrothersList) {
            System.out.println(i.tellName());
        }
    }

    //print in color
    public static void displayInColor(ArrayList <GourdBrothers> gourdBrothersList) {
        for(GourdBrothers i: gourdBrothersList) {
            System.out.println(i.tellColor());
        }
    }
}
