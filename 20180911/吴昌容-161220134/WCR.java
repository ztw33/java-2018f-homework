package wcr;

public class WCR {

    public static void main(String[] args) {

        final int N = 19;
        int array[] = new int[N];

        // Use random method to generate unsorted N integers
        System.out.printf("Before sorting: ");
        for (int i = 0; i < array.length; ++i) {
            array[i] = (int)(Math.random() * 100);
            System.out.printf("%d %c", array[i], ' ');
        }
        System.out.print('\n');

        /* Use inserting sort to sort the array */
        for (int i = 0; i < array.length; ++i) {
            int prev = i - 1;
            int post = i;
            while (prev >= 0 && (array[prev] > array[post])) {
                int temp = array[prev];
                array[prev] = array[post];
                array[post] = temp;
                prev--;
                post--;
            }
        }

        /*
        Print the result of sorting
         */
        System.out.printf("After sorting: ");
        for (int i = 0; i < array.length; ++i) {
            System.out.printf("%d %c", array[i], ' ');
        }
    }
}
