import java.util.Comparator;
import beings.CalabashBrother;
import beings.Creature;

public class CalabashCompare implements Comparator<CalabashBrother> {
    @Override
    public int compare(CalabashBrother a, CalabashBrother b){
        return a.getRank()-b.getRank();
    }
}
