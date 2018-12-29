import java.util.*;

enum CalabashBrother {
    One("红", "老大", 1), Two("橙","老二", 2), Three("黄","老三", 3), Four("绿","老四", 4), Five("青","小五", 5), Six("蓝","小六", 6), Seven("紫","小七", 7);
    private String color;
    private String myName;
    private int rank;
    CalabashBrother(String color, String myName, int rank) {
        this.color = color;
        this.myName = myName;
        this.rank = rank;
    }
    public void reportColor() {
        System.out.print(color);
    }
    public void reportName() {
        System.out.print(myName);
    }
    public int getRank() {
        return rank;
    }
    public int compareByRank(CalabashBrother brother) {
        if(rank < brother.getRank())
            return 1;
        else
            return 0;
    }
    public int compareByColor(CalabashBrother brother) {
        if (this.ordinal() < brother.ordinal())
            return 1;
        else
            return 0;
    }
    public void reportSwap(int oldPlace, int newPlace) {
        System.out.println(myName + ":" + (oldPlace+1) + "->" + (newPlace+1));
    }
}

class SortWays {
    protected CalabashBrother[] brothers;
    SortWays() {
        this.brothers = null;
    }
    public void sort() {

    }
}
class BubbleSort extends SortWays {
    BubbleSort(CalabashBrother[] brothers) {
        this.brothers = brothers;
    }
    @Override
    public void sort() {
        for (int i = 0; i < brothers.length; i++) {
            for (int j = 0; j < brothers.length - 1 - i; j++) {
                if (brothers[j].compareByRank(brothers[j+1]) == 1) {
                    brothers[j].reportSwap(j,(j+1));
                    brothers[j+1].reportSwap((j+1),j);
                    CalabashBrother temp = brothers[j];
                    brothers[j] = brothers[j+1];
                    brothers[j+1] = temp;
                }
            }
        }
    }
}
class BinarySort extends SortWays {
    BinarySort(CalabashBrother[] brothers) {
        this.brothers = brothers;
    }
    @Override
    public void sort() {
        int low = 0, high = 0, mid = 0;
        int now = 0;
        for (int i = 0; i < brothers.length; i++) {
            now = i;
            low = 0;
            high = i - 1;
            while (low <= high) {
                mid = (low + high)/2;
                if(brothers[mid].compareByColor(brothers[now]) == 1)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            CalabashBrother temp = brothers[now];
            for (int j = i - 1; j >= low; j--) {
                temp.reportSwap((j+1), j);
                brothers[j].reportSwap(j, (j+1));
                brothers[j+1] = brothers[j];
            }
            brothers[low] = temp;
        }
    }
}
public class Grandpa {
    private static CalabashBrother[] grandpaGetBrothers() {
        CalabashBrother[] brothers = new CalabashBrother[7];
        brothers[0] = CalabashBrother.One;
        brothers[1] = CalabashBrother.Two;
        brothers[2] = CalabashBrother.Three;
        brothers[3] = CalabashBrother.Four;
        brothers[4] = CalabashBrother.Five;
        brothers[5] = CalabashBrother.Six;
        brothers[6] = CalabashBrother.Seven;
        return brothers;
    }
    private static void standInLine(CalabashBrother[] brothers) {
        Random rand  = new Random();
        int lengh = brothers.length;
        for (int i = 0; i < lengh - 1; i++) {
            int pos = rand.nextInt(lengh - i);
            CalabashBrother temp = brothers[pos];
            brothers[pos] = brothers[lengh-1-i];
            brothers[lengh-1-i] = temp;
        }
    }
    private static void reportLineByName(CalabashBrother[] brothers) {
        for (int i = 0; i < brothers.length; i++) {
            brothers[i].reportName();
            System.out.print(" ");
        }
        System.out.print("\n");
    }
    private static void reportLineByColor(CalabashBrother[] brothers) {
        for (int i = 0; i < brothers.length; i++) {
            brothers[i].reportColor();
            System.out.print(" ");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        CalabashBrother[] brothers = grandpaGetBrothers();
        standInLine(brothers);
        System.out.println("第一次站队:");
        reportLineByName(brothers);
        SortWays sort = new BinarySort(brothers);
        System.out.println("开始按排行排序:");
        sort.sort();
        System.out.println("按排行排序后");
        reportLineByName(brothers);
        standInLine(brothers);
        System.out.println("第二次站队后");
        reportLineByName(brothers);
        System.out.println("开始按颜色排序:");
        sort = new BinarySort(brothers);
        sort.sort();
        System.out.println("按颜色排序后:");
        reportLineByColor(brothers);
    }
}