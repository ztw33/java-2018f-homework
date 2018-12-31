import java.util.Arrays;
import java.util.List;
import java.util.Collections;


public class CalabashBrotherSort {
    //private final CalabashBrother[] brothers;
    private List<CalabashBrother> brothersList;

    private CalabashBrotherSort() {
        final CalabashBrother[] brothers = CalabashBrother.values();
        brothersList = Arrays.asList(brothers);
    }

    private void ShuffleList() {
        Collections.shuffle(brothersList);
    }

    private void reportEveryOrder() {
        for (CalabashBrother i : brothersList)
            i.reportOrder();
        System.out.println();
    }

    private void reportEveryColor() {
        for (CalabashBrother i : brothersList)
            i.reportColor();
        System.out.println();
    }

    private void printChange(int pos1, int pos2) {
        brothersList.get(pos1).reportChange(pos1, pos2);
        brothersList.get(pos2).reportChange(pos2, pos1);
    }

    private void bubbleSort() {
        //Collections.swap(brothersList,1,2);
        for (int i = 0; i < brothersList.size() - 1; ++i)
            for (int j = 0; j < brothersList.size() - i - 1; ++j)
                if (brothersList.get(j).order > brothersList.get(j + 1).order) {
                    printChange(j, j + 1);
                    Collections.swap(brothersList, j, j + 1);
                }
    }

    private void binarySort() {
        for (int i = 1; i < brothersList.size(); ++i) {
            int low = 0, high = i - 1, mid;
            CalabashBrother tmp = brothersList.get(i);
            while (low <= high) {
                mid = (low + high) >> 1;
                if (tmp.order < brothersList.get(mid).order) high = mid - 1;
                else low = mid + 1;
            }
            for (int j = i - 1; j >= low; --j) {
                printChange(j, j + 1);
                //brothersList.set(j + 1, brothersList.get(j));
                Collections.swap(brothersList, j, j + 1);
            }
            //printChange(low, low + 1);
            //brothersList.set(low, tmp);
        }
    }

    public static void main(String[] args) {
        CalabashBrotherSort brothersSort = new CalabashBrotherSort();
        //brothersSort.reportEveryOrder();
        System.out.println("打乱队列：");
        brothersSort.ShuffleList();
        brothersSort.reportEveryOrder();
        System.out.println();

        System.out.println("冒泡排序：");
        brothersSort.bubbleSort();
        brothersSort.reportEveryOrder();
        System.out.println();

        System.out.println("打乱队列：");
        brothersSort.ShuffleList();
        brothersSort.reportEveryColor();
        System.out.println();

        System.out.println("二分排序：");
        brothersSort.binarySort();
        brothersSort.reportEveryColor();
        System.out.println();
    }
}
