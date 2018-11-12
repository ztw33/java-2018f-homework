package homework3.creature;


public class HuLuWa extends Creature {
    public final Color color;
    public final Seniority seniority;
    static int count = 0;

    private HuLuWa(){
        super();
        this.color = Color.values()[count];
        this.seniority = Seniority.values()[count];
        name = seniority.getName();
        count ++;
    }

    public static HuLuWa getNewInstance(){
        if(count == 7){
            return null;
        }
        else{
            return new HuLuWa();
        }
    }
}

enum Color{
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
}

enum Seniority{
    ELDEST("一"),
    SECOND("二"),
    THIRD("三"),
    FOURTH("四"),
    FIFTH("五"),
    SIXTH("六"),
    YOUNGEST("七");

    private String name;

    Seniority(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}