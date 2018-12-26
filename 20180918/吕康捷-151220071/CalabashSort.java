package Calabash;

public class CalabashSort{//包含两种排序算法及交换位置方法、按特征值需求输出数组特征
    private static void Swap(Calabash[]brothers, int src, int dest, String Identifier)
    {
        Calabash temp = brothers[src];
        brothers[src] = brothers[dest];
        brothers[dest].Print(src, dest, brothers[dest], Identifier);
        brothers[dest] = temp;
        brothers[src].Print(dest, src, brothers[dest], Identifier);
        System.out.println();
    }
    
    private static void Print(Calabash []brothers, String Identifier) {
    	//输出姓名
    	if ("name" == Identifier) {
            for (int i = 0; i < brothers.length; i++) {
                if (i == brothers[i].get_rank())
                    System.out.print(brothers[i].get_name() + " ");
            }
            System.out.print("\n");
        }
    	//输出颜色
        else if("color" == Identifier)
        {
            for (int i = 0; i < brothers.length; i++) {
                if (i == brothers[i].get_rank())
                    System.out.print(brothers[i].get_color() + " ");
            }
            System.out.print("\n");
        }
    }

    public static void BubbleSort(Calabash []brothers)
    {
        for(int i=0;i<brothers.length;i++)
        {
            for(int j=brothers.length-1;j>=1;j--)
            {
                if(brothers[j].get_rank() < brothers[j-1].get_rank()) {
                    Swap(brothers,j,j-1, "name");
                }
            }
        }
        Print(brothers,"name");
    }

    public static void BinarySort(Calabash []brothers)
    {
        int count = 0;
        for(int i=1;i < brothers.length;i++)
        {
            Calabash temp = brothers[i];
            int left = 0;
            int right = i-1;
            while(left<=right)
            {
                int mid = (left+right)/2;
                if(brothers[mid].get_rank()>temp.get_rank())
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            for(int j=i - 1;j>=left;j--) {
                brothers[j + 1] = brothers[j];
                brothers[j + 1].Print(j + 1, j, brothers[j], "color");
                count++;
                if(0 == count%2)
                    System.out.println();
            }
            brothers[left] = temp;
            brothers[left].Print(left, i, brothers[left], "color");
            count++;
            if(0 == count%2)
                System.out.println();
        }
        Print(brothers,"color");
    }
}