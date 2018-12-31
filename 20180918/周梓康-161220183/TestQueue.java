public class TestQueue {

    public static void main(String[] args) {

        Queue calabashQueue = new Queue();

        calabashQueue.enqueue(CalabashBrother.RED);
        calabashQueue.enqueue(CalabashBrother.ORANGE);
        calabashQueue.enqueue(CalabashBrother.YELLOW);
        calabashQueue.enqueue(CalabashBrother.GREEN);
        calabashQueue.enqueue(CalabashBrother.CYAN);
        calabashQueue.enqueue(CalabashBrother.BLUE);
        calabashQueue.enqueue(CalabashBrother.PURPLE);

        calabashQueue.shuffle();
        calabashQueue.sortByRank();
        calabashQueue.numberOffByRank();

        calabashQueue.shuffle();
        calabashQueue.sortByColor();
        calabashQueue.numberOffByColor();
    }
}
