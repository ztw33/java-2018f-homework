public class test {
    public static void main(String[] args){
        CalabashBrothers calabashBrothers1 = new CalabashBrothers();
        Sorter sorter = new Sorter();
        sorter.CBBubbleSort(calabashBrothers1);
        CalabashBrothers calabashBrothers2 = new CalabashBrothers();
        sorter.CBBinSearch(calabashBrothers2);
    }
}
