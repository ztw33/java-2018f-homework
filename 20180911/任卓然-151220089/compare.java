public class compare {
    public static int[] swap(int a,int b)
    {
        int temp = a;
        a = b;
        b = temp;
        return new int[]{a,b};
    }
    public static void main(String []args)
    {
        int[] num = {9,8,7,6,5,4,3,2,1,0};
        for(int i = 0;i<num.length;++i)
            for(int j = 0;j<num.length-1;++j)
                if(num[j]>num[j+1])
                {
                    int[] ex = swap(num[j], num[j + 1]);
                    num[j] = ex[0];
                    num[j+1] = ex[1];
                }

        for(int array:num)
            System.out.println(array);
    }
}
