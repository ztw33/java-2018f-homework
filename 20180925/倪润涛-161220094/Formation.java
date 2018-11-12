package Formation;

public class Formation {
    private static void Swap(Calabash[]brothers, int src, int dest)
    {
        Calabash temp = brothers[src];
        brothers[src] = brothers[dest];
        brothers[dest] = temp;
    }
    private static void CalabashFormation(Calabash []brothers)
    {
        for(int i=0;i<brothers.length;i++)
        {
            for(int j=brothers.length-1;j>=1;j--)
            {
                if(brothers[j].rank < brothers[j-1].rank) {
                    Swap(brothers,j,j-1);
                }
            }
        }
    }
    public static void SingleLineBattleArray(Calabash []brothers, Grandpa grandpa)
    {
        CalabashFormation(brothers);
        for(int i=0;i<=brothers.length/2;i++)
            System.out.print("    ");
        System.out.println("  "+"\u001b[45m"+grandpa.name+"\u001b[0m");
        System.out.print("\u001b[31m"+brothers[0].name +"\u001b[0m"+"  ");
        System.out.print("\u001b[33m"+brothers[1].name +"\u001b[1m"+"  ");
        System.out.print("\u001b[32m"+brothers[2].name +"\u001b[0m"+"  ");
        System.out.print("\u001b[46m"+brothers[3].name +"\u001b[0m"+"  ");
        System.out.print("\u001b[36m"+brothers[4].name +"\u001b[0m"+"  ");
        System.out.print("\u001b[34m"+brothers[5].name +"\u001b[0m"+"  ");
        System.out.print("\u001b[35m"+brothers[6].name +"\u001b[0m"+"  ");
    }

    public static void GoblinArray1(Goblin []goblins)
    {
        for(int i=0;i<16;i++)
            System.out.print(" ");
        System.out.println("\u001b[32m"+goblins[1].name+"\u001b[0m");
        for(int i=0;i<11;i++)
            System.out.print(" ");
        System.out.print("\u001b[32m"+goblins[2].name+"\u001b[0m");
        System.out.println("    " + "\u001b[32m"+goblins[2].name + "\u001b[0m");
        for(int i=0;i<8;i++)
            System.out.print(" ");
        System.out.print("\u001b[32m"+goblins[2].name+"\u001b[0m");
        System.out.println("          "+"\u001b[32m"+goblins[2].name+"\u001b[0m");
        System.out.print("     "+"\u001b[32m"+goblins[2].name+"\u001b[0m");
        System.out.println("                "+"\u001b[32m"+goblins[2].name+"\u001b[0m");
        System.out.println("                 "+"\u001b[42m"+goblins[0].name+"\u001b[0m");
    }
    public static void GoblinArray2(Goblin []goblins)
    {
        for(int i=0;i<16;i++)
            System.out.print(" ");
        System.out.println("\u001b[34m"+goblins[1].name+"\u001b[0m");
        for(int i=0;i<18;i++)
            System.out.print(" ");
        System.out.println("\u001b[34m"+goblins[2].name+"\u001b[0m");
        for(int i=0;i<9;i++)
            System.out.print(" ");
        for(int i=0;i<3;i++)
            System.out.print("\u001b[34m"+goblins[2].name+" ");
        System.out.println();
        for(int i=0;i<6;i++)
            System.out.print(" ");
        for(int i=0;i<4;i++)
            System.out.print("\u001b[34m"+goblins[2].name+" ");
        System.out.println();
        System.out.print("                 "+"\u001b[44m"+goblins[0].name);
    }
}
