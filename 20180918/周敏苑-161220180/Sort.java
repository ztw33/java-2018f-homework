import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void Bubblesort(Huluhulu series[]){
        for (int i = 0; i<7;i++){
            for(int j = i + 1; j<7;j++){
                if(series[j].rank<series[i].rank){
                    Huluhulu temp = series[j];
                    series[j] = series[i];
                    series[i] =temp;
                    System.out.println(series[i].name + ':'+j+"->"+i);
                    System.out.println(series[j].name + ':'+i+"->"+j);
                }
            }
        }
        for (int i = 0; i<7;i++){
            System.out.print(series[i].name+ " ");
        }
        System.out.println();
    }

    public static void Sorting(Huluhulu series[]){
        for(int i = 0; i<7;i++){
            Huluhulu temp = series[i];
            int left = 0;
            int right = i -1;
            int middle = 0;
            while(left <= right){
                middle = (left + right)/2;
                if(temp.rank < series[middle].rank)
                    right = middle -1;
                else
                    left = middle + 1;
            }
            for(int j = i -1;j>=left;j--){
                series[j +1] = series[j];
                int k = j +1;
                System.out.println(series[j].color + ':'+j+"->"+k);
            }
            if(left != i) {
                series[left] = temp;
                System.out.println(temp.color + ':' + i + "->" + left);
            }
        }
        for (int i = 0; i<7;i++){
            System.out.print(series[i].color+ " ");
        }
        System.out.println();
    }
}




