package wcr;

public class SortController {

    public static void main(String[] args) {
        new SortController().sort();
    }

    public void sort() {
        CalabashBrother[] huluwa1 = {
                new CalabashBrother(0),
                new CalabashBrother(4),
                new CalabashBrother(6),
                new CalabashBrother(2),
                new CalabashBrother(1),
                new CalabashBrother(3),
                new CalabashBrother(5),
        };
        CalabashBrother[] huluwa2 = huluwa1.clone();

        sortByAge(huluwa1);
        sortByColor(huluwa2);
    }

    //Sort Calabash Brothers by bubble-sort Algorithm
    private void sortByAge(CalabashBrother[] huluwa) {
        for (int i = 0; i < huluwa.length - 1; ++i) {
            for (int j = 0; j < huluwa.length - 1 - i; ++j) {
                if (huluwa[j].compareAge(huluwa[j + 1]) > 0) {
                    CalabashBrother obj1 = huluwa[j];
                    CalabashBrother obj2 = huluwa[j + 1];
                    obj1.displayMov(j, j + 1);
                    obj2.displayMov(j + 1, j);
                    obj1.moveTo(huluwa, j + 1);
                    obj2.moveTo(huluwa, j);
                }
            }
        }

        for (CalabashBrother it : huluwa) {
            it.printAge();
        }
        System.out.print('\n');
    }

    //Sort Calabash Brothers by quick-sort Algorithm
    private void sortByColor(CalabashBrother[] huluwa){
        quickSort(huluwa, 0, huluwa.length - 1);

        for (CalabashBrother it : huluwa) {
            it.printCol();
        }
        System.out.print('\n');
    }

    //Execute a recursion process
    private void quickSort(CalabashBrother[] huluwa, int start, int end) {
        if (start >= end) return;

        int pivot = start;
        int mid = start;
        for (int i = start + 1; i <= end; ++i) {
            if (huluwa[i].compareCol(huluwa[pivot]) < 0) {
                mid++;
                if (mid == i) continue;

                CalabashBrother obj1 = huluwa[i];
                CalabashBrother obj2 = huluwa[mid];
                obj1.displayMov(i, mid);
                obj2.displayMov(mid, i);
                obj1.moveTo(huluwa, mid);
                obj2.moveTo(huluwa, i);
            }
        }

        if (mid != pivot) {
            CalabashBrother obj1 = huluwa[pivot];
            CalabashBrother obj2 = huluwa[mid];
            obj1.displayMov(pivot, mid);
            obj2.displayMov(mid, pivot);
            obj1.moveTo(huluwa, mid);
            obj2.moveTo(huluwa, pivot);
        }

        quickSort(huluwa, start, mid - 1);
        quickSort(huluwa, mid + 1, end);
    }
}
