import java.util.Scanner;

public class huluwa {
    public int []sort;
    huluwa(){
        sort = new int[7];
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入葫芦娃的随机排序，1代表老大，7代表老七，以此类推，比如7 6 5 4 3 2 1 代表老七排第一位");
        for(int i = 0;i<7;++i) {

            sort[i] = scan.nextInt();

        }
        //scan.close();

    }

    public void rank()
    {
        for(int i = 0;i<7;++i)
            for(int j = 0;j<6;++j)
                if(sort[j] > sort[j+1])
                    swap(j);
        String []name = {"老大","老二","老三","老四","老五","老六","老七"};
        for(int i:sort)
            System.out.println(name[i-1]);
    }

    public void swap(int num)
    {
        int temp = sort[num];
        sort[num] = sort[num+1];
        sort[num+1] = temp;
        String []name = {"老大","老二","老三","老四","老五","老六","老七"};
        System.out.println(name[temp-1]+":"+num +"->"+ (num+1));
        System.out.println(name[sort[num]-1]+":"+(num+1) +"->"+ num);
    }

    public void midrank()
    {
        String []name = {"老大","老二","老三","老四","老五","老六","老七"};
        for(int i = 1;i<sort.length;++i)
        {
            int min = 0,max =i-1,mid;
            while(min<=max)
            {
                mid = (min+max)/2;
                if(color(sort[i] ,sort[mid]))
                    min = mid+1;
                else
                    max = mid-1;
            }
            int temp = sort[i];
            for(int j=i-1; j>=min; j--) {
                sort[j + 1] = sort[j];
                System.out.println(name[sort[j+1]-1]+":"+j+"->"+(j+1));
            }

            sort[min] = temp;
            System.out.println(name[temp-1]+":"+i+"->"+min);
        }

        String []col = {"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
        for(int i:sort)
            System.out.println(col[i-1]);
    }

    public boolean color(int c1,int c2)
    {
        String []col = {"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
        return c1>c2;
    }
    public static void main(String []args)
    {
        huluwa h1 = new huluwa();
        h1.rank();

        huluwa h2 = new huluwa();
        h2.midrank();

    }
}
