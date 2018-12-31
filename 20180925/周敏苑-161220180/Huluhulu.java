enum Rank {
    First, Second, Third, Forth, Fifth, Sixth, Seventh
}

enum Color {
    Red, Orange, Yellow, Green, Cyan, Blue, Purple
}

public enum Huluhulu {
    // static protected String[] Color ={"Red","Orange","Yellow","Green","Cyan","Blue","Purple"};
    //static protected String[] Name = {"老大","老二","老三","老四","老四","老六","老七"};
    Red(Color.Red,Rank.First,1,"老大"),Orange(Color.Orange,Rank.Second,2,"老二"),Yellow(Color.Yellow,Rank.Third,3,"老三"),
    Green(Color.Green,Rank.Forth,4,"老四"),Cyan(Color.Cyan,Rank.Fifth,5,"老五"),Blue(Color.Blue,Rank.Sixth,6,"老六"),
    Purple(Color.Purple,Rank.Seventh,7,"老七");
    private Color color;
    private Rank rank;
    private int no;
    private String name;
    Huluhulu(Color color, Rank rank,int No,String Name) {
        this.color = color;
        this.rank = rank;
        this.no = No;
        this.name = Name;
    }
    public Color GetColor(){
        return color;
    }
    public Rank GetRank() {
        return rank;
    }
    public int GetNo(){
        return no;
    }
    public String GetName(){
        return name;
    }
}
