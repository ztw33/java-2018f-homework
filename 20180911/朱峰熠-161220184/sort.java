public class sort {

    public static void main(String[] args){

        int array[] = {11,16,17,52,26,19,35,47,6,40};
        for(int i = 0; i < array.length ; i++) {
            int max = array[i];
            int maxc = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    maxc = j;
                }
            }
            int temp = max;
            array[maxc] = array[i];
            array[i] = temp;
        }
        for(int i = 0;i < array.length ; i++){
            System.out.println(array[i]);
        }
    }
}
