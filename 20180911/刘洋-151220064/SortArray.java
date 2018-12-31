import java.util.Scanner;

public class SortArray {
    static int[] array;
    /*
    public SortArray(){
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        array = new int[length];
        for(int i = 0; i < length ; i++){
         array[i] = scanner.nextInt();
        }
        return;
    }

    */
    public static void sort(int low ,int high){
        if(low >= high)
            return;
        int leftlow = low,lefthigh = (low + high )/ 2,rightlow = lefthigh + 1,righthigh = high;
        if(leftlow < lefthigh){
            sort(leftlow,lefthigh);
        }
        if(rightlow < righthigh){
            sort(rightlow,righthigh);
        }
        int []tempArray = new int [righthigh-leftlow+1];
        int leftcurrent = leftlow , rightcurrent = rightlow;
        for(int i=0;i<tempArray.length;i++){
            if(array[leftcurrent]<=array[rightcurrent]) {
                tempArray[i] = array[leftcurrent];
                leftcurrent ++;
                if(leftcurrent>lefthigh){
                    while(rightcurrent<=righthigh){
                        i++;
                        tempArray[i]= array[rightcurrent];
                        rightcurrent++;
                    }
                    break;
                }
            }
            else {
                tempArray[i] = array[rightcurrent];
                rightcurrent ++;
                if(rightcurrent>righthigh){
                    while(leftcurrent<=lefthigh){
                        i++;
                        tempArray[i]=array[leftcurrent];
                        leftcurrent++;
                    }
                    break;
                }
            }
        }
        for(int i= 0;i<tempArray.length;i++){
            array[leftlow+i] = tempArray[i];
        }
        //printoutArray();
        return ;
    }

   /* public int getArrayLength(){
        return array.length;
    }
    */

    public static void printoutArray(){
        for(int i = 0;i<array.length;i++)
            System.out.print(array[i]);
    }

    public static void main(String[] args){
        System.out.println("Please input the array counts and later members");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        array = new int[length];
        for(int i = 0; i < length ; i++){
            array[i] = scanner.nextInt();
        }
        sort(0, length-1);
        printoutArray();
    }
}
