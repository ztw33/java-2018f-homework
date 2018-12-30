package homework3.creature;

import java.util.ArrayList;
import java.util.List;

public class HuLuWa extends Justice {
    public final Color color;
    public final Seniority seniority;
    private static List<HuLuWa> instances = new ArrayList<>();
    private static int count = 0;

    private HuLuWa(){
        this.color = Color.values()[count];
        this.seniority = Seniority.values()[count];
        name = seniority.getName();
        count++;
    }

    public static List<HuLuWa> getNewInstances() {
        if(instances.size() == 0){
            for(int i = 0; i < 7; i ++){
                instances.add(new HuLuWa());
            }
        }
        return instances;
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