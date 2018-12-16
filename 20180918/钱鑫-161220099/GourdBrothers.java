enum Brothers {
    Red(1, "老大", "红色"), Orange(2, "老二", "橙色"), Yellow(3, "老三", "黄色"), Green(4, "老四", "绿色"), Cyan(5, "老五", "青色"), Blue(6, "老六", "蓝色"), Purple(7, "老七", "紫色");
    private int rank;
    private String name;
    private String color;

    private Brothers(int rank, String name, String color) {
        this.rank = rank;
        this.name = name;
        this.color = color;
    }
    public int getRank()
    {
        return rank;
    }

    public String getName()
    {
        return name;
    }

    public String getColor()
    {
        return color;
    }
}

public class GourdBrothers {
    public static void BubbleSort(Brothers[] brothers)
    {
        for(int i=0;i<brothers.length-1;i++)
        {
            for(int j=0;j<brothers.length-1-i;j++)
            {
                if(brothers[j].getRank()>brothers[j+1].getRank())
                {
                    System.out.print(brothers[j].getName()+":"+j+"->"+(j+1)+" ");
                    System.out.print(brothers[j+1].getName()+":"+(j+1)+"->"+j);
                    System.out.print("\n");
                    Brothers b=brothers[j];
                    brothers[j]=brothers[j+1];
                    brothers[j+1]=b;
                }
            }
        }
    }
    public static void BinaryInsertSort(Brothers[] brothers)
    {
        for(int i=1;i<brothers.length;i++)
        {
            Brothers b=brothers[i];
            int min=0,max=i-1,mid=-1;
            while(min<=max)
            {
                mid=(min+max)/2;
                if(brothers[mid].getRank()>b.getRank())
                {
                    max=mid-1;
                }
                else
                {
                    min=mid+1;
                }
            }
            for(int j=i-1;j>=min;j--)
            {
                System.out.print(brothers[j].getName()+":"+j+"->"+(j+1));
                System.out.print("\n");
                brothers[j+1]=brothers[j];
            }
            if(brothers[min].getRank()!=b.getRank())
            {
                System.out.print(b.getName()+":"+i+"->"+min);
                System.out.print("\n");
            }
            brothers[min]=b;
        }
    }
    public static void main(String[] args)
    {
        Brothers[] brothers1={Brothers.Green,Brothers.Purple,Brothers.Orange,Brothers.Red,Brothers.Blue,Brothers.Yellow,Brothers.Cyan};
        System.out.print("冒泡排序：\n");
        BubbleSort(brothers1);
        for(int i=0;i<brothers1.length;i++)
        {
            System.out.print(brothers1[i].getName()+" ");
        }
        System.out.print("\n");
        System.out.print("二分法排序:\n");
        Brothers[] brothers2={Brothers.Green,Brothers.Purple,Brothers.Orange,Brothers.Red,Brothers.Blue,Brothers.Yellow,Brothers.Cyan};
        BinaryInsertSort(brothers2);
        for(int i=0;i<brothers2.length;i++)
        {
            System.out.print(brothers2[i].getColor()+" ");
        }
        System.out.print("\n");
    }
}
