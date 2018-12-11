public class Sort {
    protected HuluWa[] brothers;
    public  Sort() {
        this.brothers = null;
    }
    public Sort(HuluWa[] brothers) {
        this.brothers = brothers;
    }
    public void sort() {
    }
}
class BubbleSort extends Sort{
    public BubbleSort(HuluWa[] brothers) {
        this.brothers = brothers;
    }
    @Override
    public void sort() {
        for (int i = 0; i < brothers.length; i++) {
            for (int j = 0; j < brothers.length - 1 - i; j++) {
                if (brothers[j].compareByRank(brothers[j+1].getRank()) == 1) {
                    HuluWa temp = brothers[j];
                    brothers[j] = brothers[j+1];
                    brothers[j+1] = temp;
                }
            }
        }
    }
}