import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class God {
    Huluwa[] huluwas;

    public static void main(String[] args) {
        God me = new God();   // I AM GOD
        me.randomQueue();
        me.letReportName();
        me.bubbleSort();
        me.letReportName();
        me.randomQueue();
        me.letReportName();
        me.quickSort();
        me.letReportColor();
    }

    God() {
        createHuluwas();     // when God is born, he creates 7 huluwas
    }

    void createHuluwas() {
        huluwas = new Huluwa[7];
    }

    void randomQueue() {
        System.out.println("---------- 随机站队 ----------");
        Random random = new Random();
        List list = new ArrayList();

        /* generate a list of 7 unrepeated random numbers */
        while (list.size() != 7) {
            int num = random.nextInt(7);
            if (!list.contains(num)) {
                list.add(num);
            }
        }

        /* for each position, use the random list to decide which huluwa will be placed */
        for (int i = 0; i < list.size(); i++) {
            int index = (int)list.get(i);
            huluwas[i] = Huluwa.values()[index];
        }
    }

    private void swap(int i, int j) {
        Huluwa tmp = huluwas[i];
        huluwas[i] = huluwas[j];
        huluwas[j] = tmp;
        System.out.println(huluwas[j].reportName() + ": "+ i + "->" + j);
    }

    void bubbleSort() {
        System.out.println("---------- 冒泡排序 ----------");
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                if (huluwas[i].ordinal() > huluwas[j].ordinal()) {
                    swap(i, j);
                }
            }
        }
    }

    private int partition(int begin, int end) {
        Huluwa pivot = huluwas[begin];
        int pivotpos = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (huluwas[i].ordinal() < pivot.ordinal()) {
                pivotpos++;
                if (pivotpos != i)
                    swap(pivotpos, i);
            }
        }
        if(begin != pivotpos) {
            System.out.println(huluwas[begin].reportName() + ": " + begin + "->" + pivotpos);
            huluwas[begin] = huluwas[pivotpos];
            huluwas[pivotpos] = pivot;
        }
        return pivotpos;
    }

    void quickSort() {
        System.out.println("---------- 二分排序 ----------");
        qSort(0, 6);
    }

    private void qSort(int begin, int end) {
        if (begin <= end) {
            int pivot = partition(begin, end);
            qSort(0, pivot - 1);
            qSort(pivot + 1, end);
        }
    }

    void letReportName() {
        System.out.println("---------- 依次报数 ----------");
        for (Huluwa i: huluwas)
            System.out.print(i.reportName() + " ");
        System.out.println();
    }

    void letReportColor() {
        System.out.println("---------- 依次报颜色 ----------");
        for (Huluwa i : huluwas)
            System.out.print(i.reportColor() + " ");
        System.out.println();
    }

}
