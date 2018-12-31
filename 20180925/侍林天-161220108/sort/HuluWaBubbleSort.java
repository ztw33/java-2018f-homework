package sort;

import creature.HuluWa;

public class HuluWaBubbleSort implements Sort {
    @Override
    public void sort(HuluWa[] brothers) {
        for (int i = 0; i < brothers.length; i++) {
            for (int j = 0; j < brothers.length-i-1; j++) {
                if (!brothers[j].comparePriority(brothers[j+1])) {
                    brothers[j].swapHuluWa(brothers[j+1], j,j+1);
                    HuluWa temp = brothers[j+1];
                    brothers[j+1] = brothers[j];
                    brothers[j] = temp;
                }
            }
        }
    }
}
