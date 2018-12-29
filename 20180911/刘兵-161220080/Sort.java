/*
public class Sort {
    public static void main(String [] args) {
        System.out.print("原始数组:");
        int []member={11,36,7,0,52,-3,-8,64};
        int len=8;
        for(int i=0;i<len;i++)
            System.out.print(member[i] + " ");
        mergesort(member,0,len-1);
        System.out.print("排序后:");
        for(int i=0;i<len;i++)
            System.out.print(member[i] + " ");
    }
    public static void merge(int []arr,int l1,int r1,int l2,int r2){
        int len=r1-l1+1+r2-l2+1;
        int i=l1;
        int j=l2;
        int[] temp=new int[len];
        int k=0;
        while(i<=r1&&j<=r2)
        {
            if(arr[i]<arr[j])
            {    temp[k++]=arr[i++];
            }
            else
            {    temp[k++]=arr[j++];
            }
        }
        while(i<=r1)
            temp[k++]=arr[i++];
        while(j<=r2)
            temp[k++]=arr[j++];
        for(int t=0;t<len;t++)
        {
            arr[t+l1]=temp[t];
        }
    }
    public static void mergesort(int []arr,int first,int last)
    {
        if(first<last)
        {
            int mid=(first+last)/2;
            mergesort(arr,first,mid);
            mergesort(arr,mid+1,last);
            merge(arr,first,mid,mid+1,last);
        }
    }
}
*/
import java.util.Scanner;
public class Sort {
    public static void main(String [] args) {
        System.out.print("输入数组长度:");
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) 
        {
        int len=sc.nextInt();
        int[] member=new int[len];
        System.out.print("原始数组:");
        for(int i=0;i<len;i++)
        {   member[i]=sc.nextInt();
        }
        mergesort(member,0,len-1);
        System.out.print("排序后:");
        for(int i=0;i<len;i++)
            System.out.print(member[i] + " ");
        System.out.print('\n'+"输入数组长度:");
        }
        sc.close();
    }
    public static void merge(int []arr,int l1,int r1,int l2,int r2){
        int len=r1-l1+1+r2-l2+1;
        int i=l1;
        int j=l2;
        int[] temp=new int[len];
        int k=0;
        while(i<=r1&&j<=r2)
        {
            if(arr[i]<arr[j])
            {    temp[k++]=arr[i++];
            }
            else
            {    temp[k++]=arr[j++];
            }
        }
        while(i<=r1)
            temp[k++]=arr[i++];
        while(j<=r2)
            temp[k++]=arr[j++];
        for(int t=0;t<len;t++)
        {
            arr[t+l1]=temp[t];
        }
    }
    public static void mergesort(int []arr,int first,int last)
    {
        if(first<last)
        {
            int mid=(first+last)/2;
            mergesort(arr,first,mid);
            mergesort(arr,mid+1,last);
            merge(arr,first,mid,mid+1,last);
        }
    }
}
