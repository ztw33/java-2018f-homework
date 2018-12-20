package Homework3;

public class Ground {
    private int size;
    private int isEmpty[][];

    Ground(int n){
        size = n;
        isEmpty = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++)
                isEmpty[i][j] = 0;          // 0:nobody, 1-7:HuluBro, 8: Grandpa, -1:Snake, -2:Scropion, -3:Slime
        }
    }

    public int getSize(){
        return size;
    }

    public int getInfo(int x, int y){
        return isEmpty[x][y];
    }
    public void set(int x, int y, int value){
        isEmpty[x][y] = value;
    }
    public void clear(){
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                isEmpty[i][j] = 0;
    }
    public void show(){
        for(int j = 0; j < size; j++){
            for(int i = 0; i < size; i++) {
                if(isEmpty[i][j] > 0)
                    System.out.print(isEmpty[i][j]);
                else if(isEmpty[i][j] == 0)
                    System.out.print("_");
                else if(isEmpty[i][j] == -3)
                    System.out.print("*");
                else if(isEmpty[i][j] == -2)
                    System.out.print("&");  //蝎子精
                else if(isEmpty[i][j] == -1)
                    System.out.print("@");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int size = 16;
        Ground g = new Ground(size);
        Grandpa gp = new Grandpa(g);
        Scorpion sp = new Scorpion();

        System.out.println("鹤翼");
        gp.longSnake(g);
        sp.wing(g);
        g.show();
        g.clear();

        System.out.println("雁行");
        gp.longSnake(g);
        sp.goose(g);
        g.show();
        g.clear();

        System.out.println("衡轭");
        gp.longSnake(g);
        sp.yoke(g);
        g.show();
        g.clear();

        System.out.println("鱼鳞");
        gp.longSnake(g);
        sp.scale(g);
        g.show();
        g.clear();

        System.out.println("方框");
        gp.longSnake(g);
        sp.square(g);
        g.show();
        g.clear();

        System.out.println("偃月");
        gp.longSnake(g);
        sp.moon(g);
        g.show();
        g.clear();

        System.out.println("锋矢");
        gp.longSnake(g);
        sp.arrow(g);
        g.show();
        g.clear();

        return;
    }
}
