import java.util.Random;
public class HuluSort {
    static int [] get_random_hulu(){
        Random num = new Random();
        int[] series = new int[7];
        for(int i = 0;i<7;i++){
            series[i] = num.nextInt(7);
            for(int j = 0;j<i;j++){
                if(series[j] == series[i]){
                    series[i] = num.nextInt(7);
                    j = -1;
                }
            }
        }
       // for(int i = 0; i<7;i++)
       //     System.out.print(series[i] + " ");
        return series;
    }

    static void SortbyRank(Huluhulu order[]){
        Sort.Bubblesort(order);
    }

    static void SortbyColor(Huluhulu order[]){
        Sort.Sorting(order);
    }

    public static void main(String args[]){
        Huluhulu[] Huluquene = new Huluhulu[7];
        int initial_sort[] = HuluSort.get_random_hulu();
        System.out.println("initial random order:");
        for(int i = 0;i<7;i++){
            Huluquene[i] = new Huluhulu(initial_sort[i]);
            System.out.print(Huluquene[i].name + " ");
        }
        System.out.println();
        System.out.println("sort by rank:");
        SortbyRank(Huluquene);
        int initial_sort1[] = HuluSort.get_random_hulu();
        System.out.println("second time random order:");
        for(int i = 0;i<7;i++){
            Huluquene[i] = new Huluhulu(initial_sort1[i]);
            System.out.print(Huluquene[i].color + " ");
        }
        System.out.println();
        System.out.println("sort by color");
        SortbyColor(Huluquene);
    }
}
