public class basic {
    public static void main(String args[])
    {
        int array[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        quickSort(array,0,array.length-1);
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]+" ");

    }
    private static void quickSort(int a[], int start, int end)
    {
        if(start>=end)
            return;
        int key = a[start];
        int i = start;
        int j = end;
        while(i<j)
        {
            while(a[j] >= key&&i<j)
                j--;
            while(a[i] <= key&&i<j)
                i++;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        if(i!=start) {
            a[start] = a[i];
            a[i] = key;
        }
        quickSort(a, start, i-1);
        quickSort(a, i+1, end);
    }
}
