import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    //initialize the array
        int[] array = {9,7,5,3,1,2,4,6,8,10} ;

        //display the original array
        System.out.println(Arrays.toString(array)) ;

        //bubble sort
        int temp = -1 ;
        for(int i=0 ; i<array.length ; ++i){
            for(int j=i+1 ; j<array.length ; ++j){
                if(array[i]>array[j]){
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        //display the new array
        System.out.println(Arrays.toString(array));
    }
}
