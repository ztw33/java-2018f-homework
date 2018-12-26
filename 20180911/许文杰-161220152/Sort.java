
public class Sort {

    public static int partition(int []a,int p,int q)
    {
        int pivot = a[p];
        int i = p,j = q;
        while(i<j)
        {
            while(i<j && a[j] > pivot)
                j--;
            a[i] = a[j];

            while(i<j && a[i] <= pivot)
                i++;
            a[j] = a[i];
        }
        a[i] = pivot;
        return i;
    }
    public static void quick_sort(int []a,int p,int q)
    {
        if(p>=q)
            return;
        int mid = partition(a,p,q);
        quick_sort(a,p,mid-1);
        quick_sort(a,mid+1,q);
    }

    public static void main(String[] args)
    {
        int []a = {5,7,3,5,7,9,32,4,5,43,55};
        System.out.print("Before sort:");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();

        quick_sort(a,0,a.length-1);
        System.out.print("After sort:");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
}
