public class Sort {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 10, 7, 4, 8, 1, 0, 18, 3, -4, 125};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int swapTemp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = swapTemp;
                }
            }
        }
        System.out.print(numbers[0]);
        for (int i = 1; i < numbers.length; i++)
            System.out.print(" " + numbers[i]);
    }
}
