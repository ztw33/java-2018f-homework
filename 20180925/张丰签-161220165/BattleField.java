import java.util.*;
public class BattleField {
    int[][] battlefield;//战场
    private int n;
    BrotherAct brother_act;
    Soldiers[] soldiers;
    Snake snake;
    Grandpa grandpa;
    Formation formation;
    BattleField(){//两种构造战场，默认和最小均为11*11，否则为n*n
        battlefield=new int[11][11];
        n=11;
    }
    BattleField(int N){
        if(N<=10) {
            battlefield = new int[11][11];
            n=11;
        }
        else {
            battlefield = new int[N][N];
            n=N;
        }
    }
    public void show_all(){
        /*for(int i=0;i<n;i++){
            System.out.println();
            for(int j=0;j<n;j++){
                System.out.print(battlefield[i][j]+" ");
            }
        }*/
        for(int i=0;i<n;i++){
            System.out.println();
            for(int j=0;j<n;j++) {
                if(battlefield[i][j]==0){
                    System.out.print("0     ");
                }
                else if(battlefield[i][j]<=7)
                    brother_act.brother[battlefield[i][j]-1].report_name();
                else if(battlefield[i][j]<=8)
                    grandpa.report_name();
                else if(battlefield[i][j]<=10)
                    snake.report_name();
                else if(battlefield[i][j]<=17)
                    soldiers[battlefield[i][j]-11].report_name();
            }
        }
    }
    public void clear_one(int x,int y){//将某个位置置0
        if(x<n&&y<n){
            battlefield[x][y]=0;
        }
    }
    public void clear_all(){//将所有位置置0
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                battlefield[i][j]=0;
        }
    }
    public boolean set_one(int x,int y,int num){//设置一个位置给某生物，如果成功返回true
        if(x<n&&y<n){
            if(battlefield[x][y]==0){
                battlefield[x][y]=num;
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    public boolean move(int x,int y,int to_x,int to_y){//将位置信息移动
        if(battlefield[x][y]==0)
            return false;
        else{
            int num=battlefield[x][y];
            battlefield[x][y]=0;
            battlefield[to_x][to_y]=num;
            return true;
        }
    }
    public int isWho(int x,int y){//返回该位置信息
        if(x<n&&y<n){
            return battlefield[x][y];
        }
        else
            return 0;
    }


    public static void main(String[] args){
        System.out.println("请输入N（N>10，否则N默认为11）");
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        if(N<=10)
            N=11;
        sc.close();
        BattleField x=new BattleField(N);
        for(int change=1;change<=6;change++) {
            x.clear_all();
            x.formation = new Formation(N, 7, change, x);
            x.formation.change_formaion();
            x.soldiers = new Soldiers[7];
            for (int i = 0, k = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (x.battlefield[i][j] != 0) {
                        if (k == 0) {
                            x.soldiers[k] = new Soldiers(i, j, x.isWho(i, j), true);
                            k++;
                        } else {
                            x.soldiers[k] = new Soldiers(i, j, x.isWho(i, j), false);
                            k++;
                        }
                    }
                }
            }
            x.brother_act = new BrotherAct(7, N, x);
            x.set_one(N / 2, 2, 8);
            x.grandpa = new Grandpa(N / 2, 2);
            x.set_one(N / 2, N / 2, 10);
            x.snake = new Snake(N / 2, N / 2);
            System.out.println("\n\n第"+change+"次变阵:");
            x.show_all();
        }
    }
}