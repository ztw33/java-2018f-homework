import java.util.ArrayList;
import java.util.List;

public class CalabashBrother {
    private int rankings;
    private String name;
    private Color color;

    final String[] calabashBrotherNames = {"老大", "老二", "老三", "老四", "老五", "老六", "老七" };

    public int getRankings() {
        return rankings;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public CalabashBrother(int rankings) {
        this.rankings = rankings;
        this.name = calabashBrotherNames[rankings - 1];
        this.color = Color.getColorAccordingToIndex(rankings);
    }

    public void sayName(){
        System.out.print(name + " ");
    }

    public void sayColor(){
        System.out.print(color.getName() + " ");
    }

    /*报数，名字*/
    public static void numberOffName(CalabashBrother[] calabashBrothers){
        for (CalabashBrother each: calabashBrothers){
            each.sayName();
        }
    }

    /*报数，颜色*/
    public static void numberOffColor(CalabashBrother[] calabashBrothers){
        for (CalabashBrother each: calabashBrothers){
            each.sayColor();
        }
    }

}
