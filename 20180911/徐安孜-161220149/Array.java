package firstJavaProgram;

public class Array {
    int[] array={4,0,32,1,33,21,5,8,23,53};
    void QuickSort(int start, int end) {
        if (!(start <= end))
            return;
        int index;
        index = start;
        int value = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < value) {
                index++;
                if (index != i) {
                    int temp = array[i];
                    array[i] = array[index];
                    array[index] = temp;
                }
            }
        }
        array[start] = array[index];
        array[index] = value;
        QuickSort( index + 1, end);
        QuickSort(start, index - 1);
    }
    void Print(){
        for(int i:array)
            System.out.print(i+" ");
        System.out.println();
    }
    public static void main(String[] args){
        Array a = new Array();
        System.out.println("Before:");
        a.Print();
        a.QuickSort(0,9);
        System.out.println("After:");
        a.Print();

    }
}
