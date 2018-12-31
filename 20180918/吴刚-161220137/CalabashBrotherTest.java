public class CalabashBrotherTest {
    public static CalabashBrother[] init(){
        return new CalabashBrother[]{
                new CalabashBrother(2),
                new CalabashBrother(1),
                new CalabashBrother(3),
                new CalabashBrother(7),
                new CalabashBrother(4),
                new CalabashBrother(6),
                new CalabashBrother(5)
        };
    }

    public static void main(String[] args) {
        CalabashBrother[] calabashBrothers = init();
        System.out.println("冒泡排序前报数:");
        CalabashBrother.numberOffName(calabashBrothers);
        System.out.println("");
        Sort.bubbleSort(calabashBrothers);
        System.out.println("冒泡排序后报数:");
        CalabashBrother.numberOffName(calabashBrothers);

        System.out.println("\n");

        calabashBrothers = init();
        System.out.println("二分法排序前报数:");
        CalabashBrother.numberOffColor(calabashBrothers);
        System.out.println("");
        Sort.binarySort(calabashBrothers);
        System.out.println("二分法排序后报数:");
        CalabashBrother.numberOffColor(calabashBrothers);
    }
}
