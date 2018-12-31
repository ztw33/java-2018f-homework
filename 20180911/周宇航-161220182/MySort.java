public class MySort {
    int []myarray;
    public MySort(int []array)
    {
        myarray = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            myarray[i] = array[i];
        }
    }
    public void bubblesort()
    {
        for(int i = 0; i < myarray.length - 1; i++)
        {
            for(int j = i + 1; j < myarray.length; j++)
            {
                if(myarray[i] > myarray[j])
                {
                    int temp = myarray[j];
                    myarray[j] = myarray[i];
                    myarray[i] = temp;
                }
            }
        }
    }
    public void printarray()
    {
        for (int i = 0; i < myarray.length; i++) {
            System.out.print(myarray[i] + " ");
        }
    }
    public static void main(String []args) {
        int []array = {1, 3, 5, 6, 9, 0, 2, 4, 7, 8};
        MySort mysort = new MySort(array);
        mysort.bubblesort();
        mysort.printarray();
    }
}
