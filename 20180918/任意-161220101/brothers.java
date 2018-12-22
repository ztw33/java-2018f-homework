public enum brothers{
    RedBro("老大","红色",1),OrangeBro("老二","橙色",2),YellowBro("老三","黄色",3),GreenBro("老四","绿色",4),
    CyanBro("老五","青色",5),BlueBro("老六","蓝色",6),PurpleBro("老七","紫色",7);
    private String name;
    private String color;
    private int rank;
    private brothers(String name, String color, int rank) {
        this.name = name;
        this.color = color;
        this.rank = rank;
    }

    public static void bubbleSort(brothers[] buf)
    {
        for(int i=0;i<buf.length;i++)
        {
            brothers temp;
            for(int j=i+1;j<buf.length;j++)
            {
                if(buf[i].rank>buf[j].rank)
                {
                    temp=buf[i];
                    buf[i]=buf[j];
                    buf[j]=temp;
                    System.out.println(buf[i].name+":"+i+"->"+j);
                }
            }
        }
        for(int i=0;i<buf.length;i++)
            System.out.println(buf[i].name);
    }

    public static void binaryInsertSort(brothers[] buf)
    {
        for(int i=1;i<buf.length;i++)
        {
            brothers temp=buf[i];
            int mid;
            int end=i-1;
            int start=0;
            while(start<=end)
            {
                mid=(start+end)/2;
                if(buf[mid].rank>temp.rank)
                    end=mid-1;
                else if(buf[mid].rank<temp.rank)
                    start=mid+1;
            }
            for(int j=i;j>start;j--)
                buf[j]=buf[j-1];
            buf[start++]=temp;
            System.out.println(temp.name+":"+(i+1)+"->"+start);
        }
        for(int i=0;i<buf.length;i++)
            System.out.println(buf[i].color);
    }
    public static void main(String[] args)
    {
        brothers[] buf1={BlueBro,YellowBro,OrangeBro,CyanBro,PurpleBro,RedBro,GreenBro};
        System.out.println("冒泡排序准备:");
        for(int i=0;i<buf1.length;i++)
            System.out.println(buf1[i].name);
        System.out.println("冒泡排序开始:");
        brothers.bubbleSort(buf1);
        System.out.println("冒泡排序结束:");

        brothers[] buf2={BlueBro,YellowBro,OrangeBro,CyanBro,PurpleBro,RedBro,GreenBro};
        System.out.println("二分法排序准备:");
        for(int i=0;i<buf2.length;i++)
            System.out.println(buf2[i].name);
        System.out.println("二分法排序开始:");
        brothers.binaryInsertSort(buf2);
        System.out.println("二分法排序结束:");
    }
}


