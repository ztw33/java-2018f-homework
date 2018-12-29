package items.calabash;

public class CalabashDict {
    private static final String[] map = {"Red","Orange","Yellow","Green","Cyan","Blue","Purple"};
    public static String getNameFromRank(int rank){
        return map[rank-1];
    }
}
