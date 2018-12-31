enum Color {红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色}

enum Rank {老大, 老二, 老三, 老四, 老五, 老六, 老七}

class HuluWa {
    public Rank Num;
    public Color color;
    // 报告移动变化
    public void reportTheChange(int i, int j) {
        System.out.println(Num+":"+i+"->"+j);
    }
    // 报告排名
    public void reportTheRank() {
        System.out.println(Num);
    }
    // 报告颜色
    public void reportTheColor() {
        System.out.println(color);
    }
}

public class HuluBro {
    // 考虑到排序算法是对葫芦娃数组进行排序，因而葫芦兄弟类中包含两种排序方法
    public HuluWa[] Members;
    // 默认构造函数，初始化一个随机站位
    HuluBro() {
        Members = new HuluWa[7];
        for(int i = 0; i < Members.length; i++)
            Members[i] = new HuluWa();
        Members[0].Num = Rank.老三;
        Members[1].Num = Rank.老大;
        Members[2].Num = Rank.老五;
        Members[3].Num = Rank.老七;
        Members[4].Num = Rank.老四;
        Members[5].Num = Rank.老二;
        Members[6].Num = Rank.老六;
        for(int i = 0; i < Members.length; i++)
            Members[i].color = Color.values()[Members[i].Num.ordinal()];
    }
    // 冒泡排序
    public void myBubbleSort() {
        for(int i = 0; i < Members.length-1; i++) {
            for(int j = 0; j < Members.length-1-i; j++) {
                if(Members[j].Num.ordinal() > Members[j+1].Num.ordinal()) {
                    Members[j].reportTheChange(j, j+1);
                    HuluWa temp = Members[j];
                    Members[j] = Members[j+1];
                    Members[j+1] = temp;
                }
            }
        }
        for(int i = 0; i < Members.length; i++)
            Members[i].reportTheRank();
    }
    // 二分排序
    public void mybinaryInsertSort() {
        for(int i = 0; i < Members.length; i++) {
            HuluWa tmp = Members[i];
            int left = 0, right = i-1, middle = 0;
            while(left <= right) {
                middle = (left + right) / 2;
                if (Members[i].color.ordinal() < Members[middle].color.ordinal())
                    right = middle - 1;
                else
                    left = middle + 1;
            }
            for(int k = i-1; k >= left; k--) {
                Members[k + 1] = Members[k];
                Members[k].reportTheChange(k, k+1);
            }
            Members[left] = tmp;
            Members[left].reportTheChange(i, left);
        }
        for(int i = 0; i < Members.length; i++)
            Members[i].reportTheColor();
    }

    public static void main(String[] args) {
        HuluBro A = new HuluBro();
        A.myBubbleSort();
        HuluBro B = new HuluBro();
        B.mybinaryInsertSort();
    }
}