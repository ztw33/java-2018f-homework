public enum Calabash_Brothers {
    Red(1,"red","大娃"),Orange(2,"orange","二娃"),
    Yellow(3,"yellow","三娃"),Green(4,"green","四娃"),
    Cyan(5,"cyan","五娃"),Blue(6,"blue","六娃"),
    Purple(7,"purple","七娃");
    private final int rank;
    private final String color;
    private final String name;
    public int site;

    public int GetRank() {
        return this.rank;
    }

    public void Number_Off(Calabash_Brothers bro){
        System.out.print(this.name);
        System.out.print(this.site);
        System.out.print("->");
        System.out.println(bro.site);
    }

    public void Color_Call(){
        System.out.println(this.color);
    }

    public void Name_Call(){
        System.out.println(this.name);
    }
    Calabash_Brothers(int rank,String color,String name) {
        this.rank = rank;
        this.color = color;
        this.name = name;
    }
}
