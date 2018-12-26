public class Main {

    public static void main(String[] args) {
	// write your code here
        CalabashBrothers calabashBrothers = new CalabashBrothers();

        System.out.println("初始化后：");
        calabashBrothers.reportRanking();
        calabashBrothers.reportColor();
        System.out.println();

        System.out.println("随机化后：");
        calabashBrothers.randomSort();
        calabashBrothers.reportRanking();
        calabashBrothers.reportColor();
        System.out.println();

        System.out.println("冒泡排序：");
        calabashBrothers.bubbleSort();
        calabashBrothers.reportRanking();
        System.out.println();

        System.out.println("再次随机化后：");
        calabashBrothers.randomSort();
        calabashBrothers.reportRanking();
        calabashBrothers.reportColor();
        System.out.println();

        System.out.println("二分排序：");
        calabashBrothers.binarySort();
        calabashBrothers.reportColor();
        System.out.println();
    }
}
