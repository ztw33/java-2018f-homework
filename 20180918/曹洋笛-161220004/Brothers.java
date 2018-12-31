import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 定义枚举类型
enum Guys {
    ST1("老大","红色"), ND2("老二","橙色"), RD3("老三","黄色"),
    TH4("老四","绿色"), TH5("老五","青色"), TH6("老六","蓝色"), TH7("老七","紫色");
    private String rank;
    private String color;
    // 构造方法
    private Guys(String rank, String color) {
        this.rank = rank;
        this.color = color;
    }
    // 接口
    public String getRank() {
        return rank;
    }
    public String getColor() {
        return color;
    }
    public String getPosRank(int from, int to) { // from,to: 0 ~ 7
        return rank+": "+String.valueOf(from)+"->"+String.valueOf(to);
    }
    public String getPosColor(int from, int to) { // from,to: 0 ~ 7
        return color+": "+String.valueOf(from)+"->"+String.valueOf(to);
    }
}

// 维护排序数组
class SortBrothers {
    private Guys[] brothers;
    // 由数字得到对应人物对象
    private Guys getGuy(int no) {
        switch(no){
            case 1: return Guys.ST1;
            case 2: return Guys.ND2;
            case 3: return Guys.RD3;
            case 4: return Guys.TH4;
            case 5: return Guys.TH5;
            case 6: return Guys.TH6;
            case 7: return Guys.TH7;
            default: return Guys.ST1;
        }
    }
    // 构造函数：获取1~7的随机排列
    public SortBrothers() {
        List<Integer> randArray = new ArrayList<Integer>();
        Random allRand = new Random();
        while (randArray.size() < 7) {
            int rand = allRand.nextInt(7) % 7; // 0 ~ 6
            //System.out.print(rand);
            if (!randArray.contains(rand))
                randArray.add(rand);
        }
        for (int i : randArray)
            System.out.print(i);
        System.out.println();
        brothers = new Guys [7];
        int i = 1;
        for (int r : randArray) { // 0 ~ 6
            brothers[r] = getGuy(i);
            i++;
        }
    }
    // 输出原随机序列
    public void printOrigin() {
        for (int i = 0; i < 7; i++)
            System.out.print(brothers[i].getRank()+"/"+brothers[i].getColor()+"  ");
        System.out.println();
    }
    // 冒泡排序
    private Guys[] sortRank() {
        Guys[] brotherSort = brothers.clone();
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6 - i; j++){
                if (brotherSort[j].compareTo(brotherSort[j+1]) > 0) {
                    // 仅对排序向后的人物打印一句话
                    System.out.println(brotherSort[j].getPosRank(j, j+1));
                    Guys tmp = brotherSort[j];
                    brotherSort[j] = brotherSort[j+1];
                    brotherSort[j+1] = tmp;
                }
            }
        }
        return brotherSort;
    }
    // 输出冒泡排序结果
    public void printSortRank() {
        Guys[] brotherSort = sortRank();
        for (int i = 0; i < 7; i++)
            System.out.print(brotherSort[i].getRank()+" ");
        System.out.println();
    }
    // 二分排序
    private void sortBin(Guys[] brotherSort, int l, int r) {
        if (l >= r)
            return;
        int m = (l + r) / 2; // l <= m < r
        sortBin(brotherSort, l, m);
        sortBin(brotherSort, m + 1, r);
        // 合并前后两部分
        Guys[] tmpSort = brotherSort.clone();
        int i = l, j = m + 1, k = l;
        while ((i <= m)&&(j <= r)&&(k <= r)) {
            if (tmpSort[i].compareTo(tmpSort[j]) > 0) {
                brotherSort[k++] = tmpSort[j++];
                if (k != j)
                    System.out.println(tmpSort[j - 1].getPosColor(j - 1, k - 1));
            }
            else { // if (tmpSort[i].compareTo(tmpSort[j]) < 0)
                brotherSort[k++] = tmpSort[i++];
                if (k != i)
                    System.out.println(tmpSort[i - 1].getPosColor(i - 1, k - 1));
            }
        }
        while ((i <= m)&&(k <= r)) {
            brotherSort[k++] = tmpSort[i++];
            if (k != i)
                System.out.println(tmpSort[i - 1].getPosColor(i - 1, k - 1));
        }
        while ((j <= r)&&(k <= r)) {
            brotherSort[k++] = tmpSort[j++];
            if (k != j)
                System.out.println(tmpSort[j - 1].getPosColor(j - 1, k - 1));
        }
    }
    private Guys[] sortColor() {
        Guys[] brotherSort = brothers.clone();
        sortBin(brotherSort, 0, 6);
        return brotherSort;
    }
    // 输出二分排序结果
    public void printSortColor() {
        Guys[] brotherSort = sortColor();
        for (int i = 0; i < 7; i++)
            System.out.print(brotherSort[i].getColor()+" ");
        System.out.println();
    }
}

public class Brothers {
    public static void main(String[] args) {
        SortBrothers sort = new SortBrothers();
        System.out.println("原随机序列：");
        sort.printOrigin();
        System.out.println("\n冒泡排序：");
        sort.printSortRank();
        System.out.println("\n二分排序：");
        sort.printSortColor();
    }
}