import java.util.Random;
import java.util.Scanner;

public class StandOff {
    static int row;
    static int column;
    static int n;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入二维空间的大小（N的值，N>10，建议取20）：");
        n=scanner.nextInt();
        char[][] space=new char[n][n];
        for (int i=0;i<n;i++){        //初始化总阵列
            for(int j=0;j<n;j++){
                space[i][j]='-';
            }
        }
        row=n;    //两个不同队伍各自的行和列的值
        column=n/2-1;
        Coordinator coordinator=new Coordinator();  //初始化指挥员
        Role[] calabashBrothers=new Role[7];  //初始化葫芦娃队伍
        RandomSort(calabashBrothers);
        BubbleSort(calabashBrothers);  //对起初乱序的七个葫芦娃进行排序
        char[][] leftSpace=coordinator.command(calabashBrothers,new SingleLineBattleArray(row,column));   //得到葫芦娃排列完后的阵列

        System.out.print("请输入蝎子精、小喽啰的总个数（若随机到鱼鳞、方円、偃月、锋矢阵，则总个数已定）：");
        int numOfDemon=scanner.nextInt();
        Role[] demon=new Role[numOfDemon];
        demon[0]=Role.Scorpion;
        for(int i=1;i<numOfDemon;i++){
            demon[i]=Role.Minions;
        }
        char[][] rightSpace=coordinator.command(demon,RandomFormation());  //随机选取一个阵列，得到妖精排列完后的阵列
        if(leftSpace!=null && rightSpace!=null) {  //如果两个阵列均符合总场地的大小，则合并并打印
            EmbattleAndPrint(space,leftSpace,rightSpace);
        }

        rightSpace=coordinator.command(demon,RandomFormation());  //随机将妖精再排列成一个阵列
        if(leftSpace!=null && rightSpace!=null) {
            EmbattleAndPrint(space,leftSpace,rightSpace);
        }
    }

    private static void EmbattleAndPrint(char[][] space,char[][] leftSpace,char[][] rightSpace) {  //合并两个阵列并打印
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                space[i][j] = leftSpace[i][j];
                space[i][n - column + j] = rightSpace[i][j];
            }
        }
        Role grandpa=Role.Grandpa;
        Role snake=Role.Snake;
        space[0][column]=grandpa.getSymbol();
        space[0][(n-1)/2+1]=snake.getSymbol();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(space[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static Formation RandomFormation() {  //随机选取一个阵列
        Random random = new Random();
        int n=random.nextInt(7);
        switch (n){
            case 0:return new CraneWingArray(row,column);
            case 1:return new EnEchelonArray(row,column);
            case 2:return new BluntYokeArray(row,column);
            case 3:return new FishScaleArray(row,column);
            case 4:return new FangYuanArray(row,column);
            case 5:return new CrescentMoonArray(row,column);
            case 6:return new FengVectorArray(row,column);
        }
        return null;
    }

    private static void BubbleSort(Role[] calabashBrothers) {  //冒泡排序
        for(int i=0;i<calabashBrothers.length-1;i++){
            for(int j=i+1;j<calabashBrothers.length;j++){
                if(calabashBrothers[i].compareTo(calabashBrothers[j])>0){
                    Role temp=calabashBrothers[i];
                    calabashBrothers[i]=calabashBrothers[j];
                    calabashBrothers[j]=temp;
                }
            }
        }
    }


    private static void RandomSort(Role[] calabashBrothers) {  //随机排序
        Random random = new Random();
        int[] tag={0,0,0,0,0,0,0};
        int size=calabashBrothers.length;
        int count=-1;
        while (count<6){
            int num=random.nextInt(size);
            if(tag[num]==0){
                count++;
                tag[num]=1;
                switch (num){
                    case 0:calabashBrothers[count]=Role.First;break;
                    case 1:calabashBrothers[count]=Role.Second;break;
                    case 2:calabashBrothers[count]=Role.Third;break;
                    case 3:calabashBrothers[count]=Role.Fourth;break;
                    case 4:calabashBrothers[count]=Role.Fifth;break;
                    case 5:calabashBrothers[count]=Role.Sixth;break;
                    case 6:calabashBrothers[count]=Role.Seventh;break;
                }
            }
        }
    }
}
