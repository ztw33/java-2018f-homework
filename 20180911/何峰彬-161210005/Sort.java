package mysort;

public class Sort {
    public static void main(String[] args){
        int[] numbers = {53, 22, 37, 46, 14, 99, 74};
        for(int i = numbers.length - 1; i > 0; i --){
            for(int j = 0; j < i; j ++){
                if(numbers[j] > numbers[j + 1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        for(int i = 0; i < numbers.length; i ++){
            System.out.print(numbers[i] + " ");
        }
    }
}
