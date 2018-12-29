package njucs.java2018;

import java.util.Random;

public class SortCala {
    private void RollCall_byName(Calabash[] brothers) {
        for(Calabash b : brothers)
            System.out.print(b.getName() + ' ');
        System.out.println();
    }

    private void RollCall_byColor(Calabash[] brothers) {
        for(Calabash b : brothers)
            System.out.print(b.getColor().color +  ' ');
        System.out.println();
    }

    public void De_sort(Calabash[] brothers) {
        Random rand = new Random();
        for(int i = 6; i > 0; i --) {
            int p = rand.nextInt(i);
            Calabash tmp = brothers[i];
            brothers[i] = brothers[p];
            brothers[p] = tmp;
        }
    }

    public void BubbleSort_byName(Calabash[] brothers) {
        for(int i = 0; i < brothers.length - 1; i ++) {
            for (int j = 0; j < brothers.length - 1 - i; j++) {
                if (brothers[j].getRank() > brothers[j + 1].getRank()) {
                    Calabash temp = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = temp;
                }
            }
        }
    }

    private void BinarySort_byColor(Calabash[] brothers) {
        for(int i = 0; i < brothers.length; i ++) {
            Calabash temp = brothers[i];
            int left = 0;
            int right = i - 1;
            while(left <= right) {
                int middle = (left + right) / 2;
                if(temp.getColor().ordinal() > brothers[middle].getColor().ordinal())
                    left = middle + 1;
                else
                    right = middle - 1;
            }
            for(int j = i - 1; j >= left; j --) {
                brothers[j + 1] = brothers[j];
            }
            if(left != i) {
                brothers[left] = temp;
            }
        }
    }
}
