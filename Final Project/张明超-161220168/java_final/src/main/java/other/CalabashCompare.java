package other;

import beings.CalabashBrother;

import java.util.Comparator;

public class CalabashCompare implements Comparator<CalabashBrother> {
    public int compare(CalabashBrother a, CalabashBrother b){
        return a.getRank()-b.getRank();
    }
}
