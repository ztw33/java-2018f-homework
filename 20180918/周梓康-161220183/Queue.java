import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Queue {

    private List<CalabashBrother> calabashQueue;

    Queue() {
        calabashQueue = new ArrayList<>();
    }

    public void enqueue(CalabashBrother brother) {
        calabashQueue.add(brother);
    }

    public void shuffle() {
        Collections.shuffle(calabashQueue);
    }

    public void numberOffByRank() {
        for (CalabashBrother brother : calabashQueue) {
            System.out.println(brother.getRank().getName());
        }
    }

    public void numberOffByColor() {
        for (CalabashBrother brother : calabashQueue) {
            System.out.println(brother.getColor().getName());
        }
    }

    public void sortByRank() {
        for (int i = 0; i < calabashQueue.size() - 1; ++i)
            for (int j = 0; j < calabashQueue.size() - 1 - i; ++j)
                if (calabashQueue.get(j).getRank().ordinal() > calabashQueue.get(j + 1).getRank().ordinal())
                    swapCalabash(j, j + 1);
    }

    public void sortByColor() {
        for (int i = 1; i < calabashQueue.size(); ++i) {
            int low = 0, high = i - 1, mid;
            while (low <= high) {
                mid = (low + high) / 2;
                if (calabashQueue.get(mid).getColor().ordinal() >= calabashQueue.get(i).getColor().ordinal())
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (int j = i; j > low; --j)
                swapCalabash(j - 1, j);
        }
    }

    private void swapCalabash(int index1, int index2) {
        CalabashBrother tmp = calabashQueue.get(index1);
        calabashQueue.set(index1, calabashQueue.get(index2));
        calabashQueue.set(index2, tmp);
        System.out.println(calabashQueue.get(index2).getRank().getName() + ": " + index1 + "->" + index2);
        System.out.println(calabashQueue.get(index1).getRank().getName() + ": " + index2 + "->" + index1);
    }
}
