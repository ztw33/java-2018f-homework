public class Sort {

    public int[] Array=null;
    public static void main(String[] args) {
	// write your code here
        Sort sort=new Sort(new int[]{3,6,5,9,2,7,4,1,10,8});
        sort.sortArray();
        sort.print();
    }
    public Sort(int[] Array)
    {
        this.Array=Array;
    }
    protected void sortArray()
    {
        if(Array==null)
            return;
        for(int i=0;i<Array.length-1;i++)
        {
            int Max=i;
            for(int j=i+1;j<Array.length;j++)
            {
                if(Array[j]>Array[Max])
                    Max=j;
            }
            int tmp=Array[Max];
            Array[Max]=Array[i];
            Array[i]=tmp;
        }
    }
    protected void print()
    {
        if(Array==null)
            System.out.println("Array is empty!");
        else
        {
            for(int i=0;i<Array.length;i++)
                System.out.print(Array[i]+" ");
        }
    }
}