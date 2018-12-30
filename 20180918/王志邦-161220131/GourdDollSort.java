import java.util.Random;

public class GourdDollSort {
    private static void print(GourdDollColorEnum[] gourdDolls){
        for(GourdDollColorEnum gourdDoll : gourdDolls){
            System.out.print(gourdDoll.getSeq() + " " + gourdDoll.getColor() + "|");
        }
        System.out.println();;
    }

    private static void exchangeQueue(GourdDollColorEnum[] gourdDolls){
        Random ra = new Random();
        for(int i = 0; i < 40; ++i){
            int bro1 = ra.nextInt(7);
            int bro2 = ra.nextInt(7);
            if(bro1 != bro2) {
                GourdDollColorEnum temp = gourdDolls[bro1];
                gourdDolls[bro1] = gourdDolls[bro2];
                gourdDolls[bro2] = temp;
            }
        }
        System.out.print("打乱之后：");
        print(gourdDolls);
    }

    private static void swap(GourdDollColorEnum[] gourdDolls, int i, int j){
        System.out.println(gourdDolls[i].getColor() + " and " + gourdDolls[j].getColor() + "exchange!");
        GourdDollColorEnum temp = gourdDolls[j];
        gourdDolls[j] = gourdDolls[i];
        gourdDolls[i] = temp;
        print(gourdDolls);
    }

    private static void bubbleSort(GourdDollColorEnum[] gourdDolls) {
        System.out.println("bubble sort交换次序：");
        for(int i = 0; i < gourdDolls.length - 1; ++i){
            for(int j = 0; j < gourdDolls.length - 1 - i; ++j){
                if(gourdDolls[j+1].isBigger(gourdDolls[j])){
                    swap(gourdDolls, j, j+1);
                }
            }
        }
        System.out.print("最终结果：");
        print(gourdDolls);
    }

    private static void twoPartSort(GourdDollColorEnum[] gourdDolls, int left, int right){
        if(left >= right)   return;
        GourdDollColorEnum key = gourdDolls[left];
        int keyNum = left;
        left += 1;
        int s1 = left, s2 = right;

        while(s1 < s2){
            while(s1 < s2 && gourdDolls[s1].isBigger(key)){
                s1++;
            }
            while(s1 < s2 && key.isBigger(gourdDolls[s2])){
                s2--;
            }
            if(s1 == s2)
                break;
            swap(gourdDolls, s1, s2);

        }
        if(gourdDolls[s1].isBigger(key)){
            swap(gourdDolls, keyNum, s1);
            twoPartSort(gourdDolls, left - 1, s1 - 1);
            twoPartSort(gourdDolls, s1 + 1, right);
        }
        else {
            swap(gourdDolls, keyNum, s1 - 1);
            twoPartSort(gourdDolls, left - 1, s1 - 2);
            twoPartSort(gourdDolls, s1, right);
        }
    }
    private static boolean judge(GourdDollColorEnum[] gourdDolls){
        GourdDollColorEnum[] standardGourdDolls = GourdDollColorEnum.values();
        for(int i = 0; i < 7; ++i)
            if(gourdDolls[i] != standardGourdDolls[i])
                return false;
        return true;
    }

    public static void main(String[] args){
        GourdDollColorEnum[] gourdDolls = GourdDollColorEnum.values();
        /*for(GourdDollColorEnum gourdDoll : gourdDolls){
            System.out.println(gourdDoll.getSeq() + " " +gourdDoll.getColor());
        }*/

        exchangeQueue(gourdDolls);
        bubbleSort(gourdDolls);
        if(!judge(gourdDolls))
            System.out.println("wrong answer in bubble sort");
        System.out.println("二分排序交换顺序：");
        exchangeQueue(gourdDolls);
        twoPartSort(gourdDolls, 0, 6);
        System.out.print("最终结果：");
        print(gourdDolls);
        if(!judge(gourdDolls))
            System.out.println("wrong answer in quick sort");
    }
}
