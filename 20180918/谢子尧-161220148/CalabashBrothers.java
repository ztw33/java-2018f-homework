import java.util.Random;

//构造葫芦兄弟颜色和排行的枚举类型
enum Color { red, orange, yellow, green, cyan, blue, purple }
enum Ranking { first, second, third, fourth, fifth, sixth, seventh }

//以单个葫芦兄弟为对象，构造Java类
class CalabashBrother {
    private Color color;
    private Ranking ranking;

    CalabashBrother(int myRanking) {    //当myRanking=0,表示老大
        this.color = Color.values()[myRanking];
        this.ranking = Ranking.values()[myRanking];
    }

    public Color color() { return this.color; }
    public Ranking ranking() { return this.ranking; }
}

//以所有葫芦兄弟的整体为对象，构造Java类
public class CalabashBrothers {
    private Random random = new Random();
    private static final int SIZE = 7;
    private CalabashBrother[] brothers;

    //构造函数初始化按照排行从大到小排列葫芦兄弟
    CalabashBrothers() {
        this.brothers = new CalabashBrother[SIZE];
        for (int i = 0; i <= SIZE - 1; ++i) {
            this.brothers[i] = new CalabashBrother(i);
        }
    }

    //Ranking枚举类型转换为string
    public String getRanking(CalabashBrother temp) {
        switch (temp.ranking()) {
            //break语句在此可省略
            case first:
                return "老大";
            case second:
                return "老二";
            case third:
                return "老三";
            case fourth:
                return "老四";
            case fifth:
                return "老五";
            case sixth:
                return "老六";
            case seventh:
                return "老七";
            default:
                return "Error! Only seven brothers!";
        }
    }

    //Color枚举类型转换为string
    public String getColor(CalabashBrother temp) {
        switch (temp.color()) {
            //break语句在此可省略
            case red:
                return "红色";
            case orange:
                return "橙色";
            case yellow:
                return "黄色";
            case green:
                return "绿色";
            case cyan:
                return "青色";
            case blue:
                return "蓝色";
            case purple:
                return "紫色";
            default:
                return "Error! Only seven colors!";
        }
    }

    private void exchange(int p1, int p2) {
        CalabashBrother temp = brothers[p1];
        brothers[p1] = brothers[p2];
        brothers[p2] = temp;
    }

    //根据位置随机排序
    public void randomSort() {
        for(int index = SIZE - 1; index >= 0; --index) {
            exchange(random.nextInt(index + 1), index);
        }
    }

    //根据Ranking冒泡排序
    public void bubbleSort() {
        for (int times = 1; times <= SIZE - 1; ++times) {
            for (int i = 1; i <= SIZE - times; ++i) {
                // s1.compareTo(s2) returns s1.ordinal() - s2.ordinal()
                if(brothers[i - 1].ranking().compareTo(brothers[i].ranking()) > 0) {
                    System.out.print(getRanking(brothers[i - 1]) + ":" + i + "->" + (i + 1) + "; ");
                    System.out.println(getRanking(brothers[i]) + ":" + (i + 1) + "->" + i);
                    exchange(i - 1, i);
                }
            }
        }
    }

    //根据Color二分排序
    public void binarySort() {
        for(int i = 1; i <= SIZE - 1; ++i) {
            CalabashBrother temp = brothers[i];
            int left = 0, right = i - 1;
            int mid = -1;
            while(left <= right) {
                mid = left + (right - left) / 2;
                if(temp.color().compareTo(brothers[mid].color()) < 0)
                    right = mid - 1;
                else
                    left = mid + 1;
            }

            for(int j = i - 1; j >= left; --j) {
                System.out.print(getRanking(brothers[j]) + ":" + (j + 1) + "->" + (j + 2) + "; ");
                brothers[j + 1] = brothers[j];
            }
            if(i != left)
                System.out.println(getRanking(temp) + ":" + (i + 1) + "->" + (left + 1));
            brothers[left] = temp;
        }
    }

    //根据位置依次报告Ranking
    public void reportRanking() {
        for (int i = 0; i < SIZE - 1; ++i) {
            System.out.print(getRanking(brothers[i]) + ", ");
        }
        System.out.println(getRanking(brothers[SIZE - 1]));
    }

    //根据位置依次报告Color
    public void reportColor() {
        for (int i = 0; i < SIZE - 1; ++i) {
            System.out.print(getColor(brothers[i]) + ", ");
        }
        System.out.println(getColor(brothers[SIZE - 1]));
    }
}
