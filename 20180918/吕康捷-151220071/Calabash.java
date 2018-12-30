package Calabash;

enum Color{红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色}
enum Name{老大, 老二, 老三, 老四, 老五, 老六, 老七,}



public class Calabash{
    private int rank;
    private Color color;
    private Name name;
    
    public int get_rank()
    {
    	return this.rank;
    }
   public Color get_color()
    {
    	return this.color;
    }
   
   public Name get_name()
   {
	   return this.name;
   }
   
    Calabash(int rank)
    {
        this.rank = rank;
        this.color = Color.values()[rank];
        this.name = Name.values()[rank];
    }
    
    public static void Print( int src, int dest, Calabash brother, String Identifier)
    {
        if("name" == Identifier)
            System.out.print(brother.name+"："+src+"->"+dest +" ");
        else if("color" == Identifier)
            System.out.print(brother.color+"："+src+"->"+dest +" ");
    }

    public static void main(String[] args) {
        int []Rank1 = {0,4,2,6,1,5,3};
        Calabash []brothers = new Calabash[7];
        for(int i=0;i<7;i++)
            brothers[i] = new Calabash(Rank1[i]);
        CalabashSort.BubbleSort(brothers);
       
        System.out.println();
       
        int []Rank2 = {6,2,3,4,5,1,0};
        for(int i=0;i<7;i++)
            brothers[i] = new Calabash(Rank2[i]);
        CalabashSort.BinarySort(brothers);
    }
}