package njucs.java2018;

import java.util.Random;

public class AboveAll {
    private Calabash[] brothers = new Calabash[7];

    private AboveAll() {
        for(int i = 0; i < 7; i ++) {
            brothers[i] = new Calabash(i + 1);
        }
    }

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

    private void De_sort(Calabash[] brothers) {
        Random rand = new Random();
        for(int i = 6; i > 0; i --) {
            int p = rand.nextInt(i);
            Calabash tmp = brothers[i];
            brothers[i] = brothers[p];
            brothers[p] = tmp;
        }
    }

    private void BubbleSort_byName(Calabash[] brothers) {
        for(int i = 0; i < brothers.length - 1; i ++) {
            for (int j = 0; j < brothers.length - 1 - i; j++) {
                if (brothers[j].getRank() > brothers[j + 1].getRank()) {
                    System.out.printf("%s:%d -> %d\n", brothers[j].getName(), j, j + 1);
                    System.out.printf("%s:%d -> %d\n", brothers[j + 1].getName(), j + 1, j);
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
                System.out.printf("%s:%d -> %d\n", brothers[j].getName(), j, j + 1);
                brothers[j + 1] = brothers[j];
            }
            if(left != i) {
                System.out.printf("%s:%d -> %d\n", temp.getName(), i, left);
                brothers[left] = temp;
            }
        }
    }

    public static void main(String[] args) {
        AboveAll OAA = new AboveAll();

        //冒泡排序
        OAA.De_sort(OAA.brothers);
        System.out.println("Before BubbleSort.");
        OAA.RollCall_byName(OAA.brothers);
        System.out.println("During BubbleSort.");
        OAA.BubbleSort_byName(OAA.brothers);
        System.out.println("After BubbleSort.");
        OAA.RollCall_byName(OAA.brothers);

        //二分插入排序
        OAA.De_sort(OAA.brothers);
        System.out.println("Before BinaryInsertSort.");
        OAA.RollCall_byColor(OAA.brothers);
        System.out.println("During BinaryInsertSort.");
        OAA.BinarySort_byColor(OAA.brothers);
        System.out.println("After BinaryInsertSort.");
        OAA.RollCall_byColor(OAA.brothers);
    }
}
