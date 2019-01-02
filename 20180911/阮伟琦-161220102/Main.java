public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        int array[] =  new int[]{10, 21, 8, 22, 3,15,7,20,9,17};
        int smallest = 0;
        //int sortedarray[] = new int[10];
        for(int i = 0; i < 10; i++)
        {
            smallest = i;
            for(int j = i; j < 10; j++) {
                //int temp = 0;
                if (array[j] < array[smallest])
                    smallest = j;
            }
            int temp;
            temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;
        }
        for(int i = 0; i < 10; i++)
            System.out.println(array[i]);
    }
}
