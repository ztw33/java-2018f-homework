import java.util.Random;

public class HuluBrothers {
    private HuluWa[] members;
    private int[] order;
    public HuluBrothers(){
        order = new int[7];
        members = new HuluWa[7];
        for (int i = 0; i < 7; i++){
            members[i] = new HuluWa(i+1);
        }
    }
    public static void main(String[] args){
        HuluBrothers brothers = new HuluBrothers();
        System.out.println("打乱：");
        brothers.random();
        brothers.shoutBrothersName();
        brothers.prioritySort();
        System.out.println("按排行排序：");
        brothers.shoutBrothersName();
        System.out.println("\n打乱：");
        brothers.random();
        brothers.shoutBrothersColor();
        brothers.colorSort();
        System.out.println("按颜色排序：");
        brothers.shoutBrothersColor();
    }

    public void shoutBrothersName(){
        for (HuluWa h : members){
            h.shoutOutName();
            System.out.print(' ');
        }
        System.out.println();
    }
    public void shoutBrothersColor(){
        for (HuluWa h : members){
            h.shoutOutColor();
            System.out.print(' ');
        }
        System.out.println();
    }
    public void random(){
        Random rand = new Random();
        for (int i = 7; i >= 1; i--){
            int x = rand.nextInt(i);
            HuluWa temp = members[i-1];
            members[i-1] = members[x];
            members[x] = temp;
        }
    }

    public void prioritySort(){
        Sort sort = new Sort();
        sort.bubbleSort(members);
    }

    public void colorSort(){
        Sort sort = new Sort();
        sort.biInsertSort(members);
    }
}


