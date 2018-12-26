package common;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/12/2
 */
public class CommonMath {

    public static <T extends Comparable<? super T>> T max(T a, T b) {
        if (a == null) {
            if (b == null) return a;
            else return b;
        }
        if (b == null)
            return a;
        return a.compareTo(b) > 0 ? a : b;
    }

    public static <T extends Comparable<? super T>> T min(T a, T b) {
        if (a == null) {
            if (b == null) return a;
            else return b;
        }
        if (b == null)
            return a;
        return a.compareTo(b) < 0 ? a : b;
    }
}
