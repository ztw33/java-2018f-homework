package sort;


public class QuickSort {
    private static int Partition(int[]data, int begin, int end)
    {
        int pivot = data[end];
        int i = begin - 1;
        for(int j = begin;j <= end-1;j++)
        {
            if(data[j] < pivot)
            {
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        int temp = data[i+1];
        data[i+1] = data[end];
        data[end] = temp;
        return i+1;
    }
    private static void QuickSort(int[]data,int begin,int end)
    {
        if(begin < end)
        {
            int temp = Partition(data,begin,end);
            QuickSort(data,begin,temp-1);
            QuickSort(data,temp+1,end);
        }
    }
    public static void main(String []args)
    {
        //动态数组输入
        /*
        Scanner scan = new Scanner(System.in);
        String length = scan.nextLine();
        int l = Integer.parseInt(length);
        int[] data = new int[l];
        for(int i = 0; i < l;i++)
        {
            Scanner s = new Scanner(System.in);
            String d = s.nextLine();
            data[i] = Integer.parseInt(d);
        }
        */
        //给定数组
        int[] data = {3,4,7,4,2,5,8,7,4,3};
        int l = 10;
        QuickSort(data,0,l-1);
        for(int i = 0;i < l;i++)
            System.out.println(data[i]);
    }
}
