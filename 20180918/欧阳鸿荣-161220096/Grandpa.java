package calabashBrothers;

import java.util.Random;

/**
 * @ Author     ：Young
 * @ Description：葫芦娃爷爷
 */

public class Grandpa extends Creature{

    private CalabashBoys boys;
    private int boysNumber;

    public Grandpa() {
        super("爷爷",CreatureType.HUMAN_BEING);
        this.findCalabashBrothers();
    }

    private void findCalabashBrothers() {
        boys = new CalabashBoys();
        this.boysNumber = boys.getBoysNumber();
    }

    private void tellBoysSwap(int i, int j) {
        boys.swap(i,j);
    }

    private void tellBoysSwapWithReport(int i, int j) {
        boys.swapWithReport(i,j);
    }

    public void disruptQueue() {
        Random rand = new Random();
        int randTimes = rand.nextInt(100) + 50;
        int m;
        int n;
        for (int i = 0; i < randTimes; i++) {
            m = rand.nextInt(7);
            n = rand.nextInt(7);
//            System.out.println("swap"+boys[m].getName()+boys[n].getName());
            tellBoysSwap(m,n);
        }
    }

    public void calabashBrothersBubbleSort() {
        BubbleSorter sorter = new BubbleSorter() {
            @Override
            void swapWithReport(int i, int j) {
                tellBoysSwapWithReport(i,j);
            }

            @Override
            boolean compareSmaller(int i, int j) {
                return boys.compareSmaller(i,j);
            }
        };
        sorter.sort(boys.getBoysNumber());
    }

    public void calabashBrothersBinarySort() {
        BinarySorter sorter = new BinarySorter() {
            @Override
            void swapWithReport(int i, int j) {
                tellBoysSwapWithReport(i,j);
            }

            @Override
            boolean compareSmaller(int i, int j) {
                return boys.compareSmaller(i,j);
            }
        };
        sorter.sort(boys.getBoysNumber());
    }

    public void testBubbleSort() {
        Random rand = new Random();
        int testTimes = rand.nextInt(20) + 10;
        for (int i = 0; i < testTimes; i++) {
            this.disruptQueue();
            this.calabashBrothersBubbleSort();
            for (int j = 0; j < boysNumber; j++) {
                if (boys.getSomeoneRank(j) != j) {
                    System.out.println("----------------------经过" + testTimes + "次测试冒泡排序测试失败");
                    System.exit(-1);
                }
            }
        }
        System.out.println("----------------------经过" + testTimes + "次测试冒泡排序测试成功");
    }

    public void testBinarySort() {
        Random rand = new Random();
        int testTimes = rand.nextInt(20) + 10;
        for (int i = 0; i < testTimes; i++) {
            this.disruptQueue();
            this.calabashBrothersBinarySort();
            for (int j = 0; j < boysNumber; j++) {
                if (boys.getSomeoneRank(j) != j) {
                    System.out.println("----------------------经过" + testTimes + "次测试二分排序测试失败");
                    System.exit(-1);
                }
            }
        }
        System.out.println("----------------------经过" + testTimes + "次测试二分排序测试成功");
    }

    public void tellBoysReportDetails() {
        boys.selfIntroduction();
        boys.boysReportDetails();
    }

    public void tellBoysReportNames() {
        boys.boysReportNames();
    }

    public void tellBoysReportColors() {
        boys.boysReportColors();
    }


}
