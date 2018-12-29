import java.util.Random;

enum Color{红色, 橙色, 黄色, 绿色,  青色, 蓝色, 紫色}
enum Rank{老大, 老二, 老三, 老四, 老五, 老六, 老七}

class Brothers {
        private Rank rank;
        private Color color;

        //private int num;
        Brothers(int ranking) {
        // this.num = ranking;
            Color[] values = Color.values();
            Rank[] ranks = Rank.values();
        this.color = values[ranking - 1];
        this.rank = ranks[ranking - 1];

    }

    public Rank GetRank() {
        return this.rank;
    }

    public Color GetColor() {
        return this.color;
    }
}

public class CalabashBrothers {
    private final int NUM = 7;
    private Brothers[] brothers = new Brothers[NUM];

    CalabashBrothers() {
        for (int i = 0; i < NUM; i++) {
            brothers[i] = new Brothers(i + 1);
        }
    }

    public void RandomArray() {
        Random random = new Random();
        for (int i = NUM - 1; i >= 0; i--) {
            int index = random.nextInt(i + 1);
            Brothers temp = brothers[i];
            brothers[i] = brothers[index];
            brothers[index] = temp;
        }
    }

    public void BubbleSort() {
        for (int i = 0; i < NUM - 1; i++)
            for (int j = 0; j < NUM - 1 - i; j++) {
                if (brothers[j].GetRank().ordinal() > brothers[j + 1].GetRank().ordinal()) {
                    System.out.print(brothers[j].GetRank() + ":" + (j+1) + "->" + (j + 2)+"\n");
                    System.out.print(brothers[j + 1].GetRank() + ":" + (j + 2) + "->" + (j+1)+"\n");
                    Brothers temp = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = temp;
                }
            }
    }

    public void ShowRank(){
        for(int i = 0; i < NUM; i++){
            System.out.print(brothers[i].GetRank() + " ");
        }
        System.out.print("\n");
    }

    public void ShowColor(){
        for(int i = 0; i < NUM; i++){
            System.out.print(brothers[i].GetColor() + " ");
        }
        System.out.print("\n");
    }

    public void BinarySort(){
        int low, high, mid;
        Brothers temp;
        for(int i = 1; i < NUM; i++){
            temp = brothers[i];
            low = 0;
            high = i-1;
            while(low <= high) {
                mid = (low + high) / 2;
                if (brothers[mid].GetColor().ordinal() > temp.GetColor().ordinal())
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for(int j = i - 1; j >= low; j--){
                System.out.print(brothers[j].GetRank() + ":" + (j+1) + "->" + (j+2)+"\n");
                brothers[j+1] = brothers[j];

            }
            if(i!= NUM-1) {
                System.out.print(brothers[i].GetRank() + ":" + (i+1) + "->" + (low+1) + "\n");
            }
            brothers[low] = temp;
        }

    }
    public static void main(String[] args) {
        CalabashBrothers p = new CalabashBrothers();
        p.RandomArray();
        System.out.println("冒泡排序前：");
        p.ShowRank();
        p.BubbleSort();
        System.out.println("冒泡排序后：");
        p.ShowRank();
        p.RandomArray();
        System.out.println("二分排序前：");
        p.ShowColor();
        p.BinarySort();
        System.out.println("二分排序后：");
        p.ShowColor();
    }
}



