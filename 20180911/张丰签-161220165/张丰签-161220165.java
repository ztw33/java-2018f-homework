public class quicksort {
    public static void main(String[] args){
        int[] a={10,5,3,2,1,4,6,7,9,8,0};
        System.out.println("Before sort:");
        for(int i:a){
            System.out.print(i);
            System.out.print(" ");
        }
        quickSort(a);
        System.out.println("\nAfter sort:");
        for(int i:a){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void quickSort(int[] a){
        if(a.length>0){
            QuickSort(a,0,a.length-1);
        }
    }

    private static void QuickSort(int[] a,int first,int last){
        if(first>last) {
            return ;
        }
        int i=first;
        int j=last;
        int pivot=a[first];
        while(i<j){
            while(i<j&&a[j]>pivot){
                j--;
            }
            while(i<j&&a[i]<=pivot){
                i++;
            }
            if(i<j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp=a[i];
        a[i]=a[first];
        a[first]=temp;
        QuickSort(a,first,i-1);
        QuickSort(a,i+1,last);
    }
}
