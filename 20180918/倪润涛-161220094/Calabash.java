class CalabashSort{
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
        if ("name" == Identifier) {
            for (int i = 0; i < brothers.length; i++) {
                if (i == brothers[i].rank)
                    System.out.print(brothers[i].name + " ");
            }
            System.out.print("\n");
        }
        else if("color" == Identifier)
        {
            for (int i = 0; i < brothers.length; i++) {
                if (i == brothers[i].rank)
                    System.out.print(brothers[i].color + " ");
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
                if(brothers[j].rank < brothers[j-1].rank) {
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
                if(brothers[mid].rank>temp.rank)
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

enum Color{红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色}
enum Name{老大, 老二, 老三, 老四, 老五, 老六, 老七,}
public class Calabash{
    public int rank;
    public Color color;
    public Name name;
    Calabash(int rank)
    {
        this.rank = rank;
        this.color = Color.values()[rank];
        this.name = Name.values()[rank];
    }
    public static void Print(int src, int dest, Calabash brother, String Identifier)
    {
        if("name" == Identifier)
            System.out.print(brother.name+"："+src+"->"+dest +" ");
        else if("color" == Identifier)
            System.out.print(brother.color+"："+src+"->"+dest +" ");
    }

    public static void main(String[] args) {
        int []Rank = {0,3,2,5,1,6,4};
        Calabash []brothers = new Calabash[7];
        for(int i=0;i<7;i++)
        {
            brothers[i] = new Calabash(Rank[i]);
        }
        CalabashSort.BubbleSort(brothers);
        System.out.println();
        for(int i=0;i<7;i++)
        {
            brothers[i] = new Calabash(Rank[i]);
        }
        CalabashSort.BinarySort(brothers);
    }
}