public class sort {
    public static void main(String[] args) {
        int arraySize = 10;
        int[] myArray = {23, 8, 13, 70, 123, 4, -12, 19, 0, -7};

        for(int i = 0; i < arraySize - 1; i++) {
            int min = i;
            for(int j = i + 1; j < arraySize; j++) {
                if(myArray[j] < myArray[min])
                    min = j;
            }
            if(min != i) {
                int temp = myArray[min];
                myArray[min] = myArray[i];
                myArray[i] = temp;
            }
        }

        for(int element: myArray)
            System.out.println(element);

    }
}
