public class Huluhulu {
    static String Color[] ={"Red","Orange","Yellow","Green","Cyan","Blue","purple"};
    static String Name[] = {"老大","老二","老三","老四","老五","老六","老七"};
    int rank;
    String color;
    String name ;


    Huluhulu(int n){
        this.rank = n;
        this.name = Name[n];
        this.color = Color[n];
    }
}
