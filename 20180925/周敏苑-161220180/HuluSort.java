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
        return series;
    }

    static void Sort_Scheduler() {
        Huluhulu[] Huluquene = {Huluhulu.Red,Huluhulu.Orange,Huluhulu.Yellow,Huluhulu.Green,Huluhulu.Cyan,Huluhulu.Blue,Huluhulu.Purple};
        Huluhulu[] Huluquene1 = new Huluhulu[7];
        int initial_sort[] = HuluSort.get_random_hulu();
        System.out.println("initial random order:");
        for(int i = 0;i<7;i++){
            for(int j = 0;j<7;j++) {
                if (Huluquene[j].GetNo() == initial_sort[i] + 1) {
                    Huluquene1[i] = Huluquene[j];
                    System.out.print(Huluquene1[i].GetName() + " ");
                }
            }
        }                                          //随机排列七兄弟
        System.out.println();
        System.out.println("sort by rank:");
        HuluSort.SortbyRank(Huluquene1);
        int initial_sort1[] = HuluSort.get_random_hulu();
        System.out.println("second time random order:");
        for(int i = 0;i<7;i++){
            for(int j = 0;j<7;j++)
                if(Huluquene[j].GetNo() == initial_sort1[i] + 1){
                    Huluquene1[i] = Huluquene[j];
                    System.out.print(Huluquene1[i].GetName() + " ");
                }
        }
        System.out.println();
        System.out.println("sort by color");
        HuluSort.SortbyColor(Huluquene1);
    }

    static void SortbyRank(Huluhulu order[]){
        Sort.Bubblesort(order);
    }

    static void SortbyColor(Huluhulu order[]){
        Sort.Sorting(order);
    }
}
