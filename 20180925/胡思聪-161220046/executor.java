package hsc.hw;

interface Creature{
    public void move_to(BattleField x, int i, int j);
    public String getname();
    enum NULL implements Creature{
        Null(null,null,-1,-1);
        private String name;
        private String color;
        private int lx;
        private int ly;
        private NULL(String name, String color, int Lx, int Ly){
            this.name=name;
            this.color=color;
            this.lx=Lx;
            this.ly=Ly;
        }
        @Override
        public String getname(){
            return this.name;
        }
        public void move_to(BattleField x, int i, int j){
            return;
        }
    }

    enum CalabashBrothers implements Creature{
        calabash_one("老大","红色",-1,-1), calabash_two("老二","橙色",-1,-1),
        calabash_three("老三","黄色",-1,-1), calabash_four("老四","绿色",-1,-1),
        calabash_five("老五","青色",-1,-1),calabash_six("老六","蓝色",-1,-1),
        calabash_seven("老七","紫色",-1,-1);
        private String name;
        private String color;
        private int lx;
        private int ly;
        private CalabashBrothers(String name, String color, int Lx, int Ly){
            this.name=name;
            this.color=color;
            this.lx=Lx;
            this.ly=Ly;
        }
        @Override
        public String getname(){
            return this.name;
        }
        public void move_to(BattleField x, int i, int j){
            x.map[i][j]=this;
            this.lx=i;
            this.ly=j;
        }
    }
    enum Grandfather implements Creature {
        grandfather("爷爷", null, -1, -1);
        private String name;
        private String color;
        private int lx;
        private int ly;

        private Grandfather(String name, String color, int Lx, int Ly) {
            this.name = name;
            this.color = color;
            this.lx = Lx;
            this.ly = Ly;
        }

        @Override
        public String getname() {
            return this.name;
        }

        public void move_to(BattleField x, int i, int j) {
            x.map[i][j] = this;
            this.lx = i;
            this.ly = j;
        }
    }

    enum Serpent implements Creature {
        serpent("蛇精", null, -1, -1);
        private String name;
        private String color;
        private int lx;
        private int ly;

        private Serpent(String name, String color, int Lx, int Ly) {
            this.name = name;
            this.color = color;
            this.lx = Lx;
            this.ly = Ly;
        }

        @Override
        public String getname() {
            return this.name;
        }

        public void move_to(BattleField x, int i, int j) {
            x.map[i][j] = this;
            this.lx = i;
            this.ly = j;
        }
    }
    enum Scorpion implements Creature{
        scorpion("蝎子精",null,-1,-1);
        private String name;
        private String color;
        private int lx;
        private int ly;
        private Scorpion(String name, String color, int Lx, int Ly){
            this.name=name;
            this.color=color;
            this.lx=Lx;
            this.ly=Ly;
        }
        @Override
        public String getname(){
            return this.name;
        }
        public void move_to(BattleField x, int i, int j) {
            x.map[i][j]=this;
            this.lx=i;
            this.ly=j;
        }
    }
    enum monster implements Creature {
        monster_one("小喽啰", null, -1, -1), monster_two("小喽啰", null, -1, -1),
        monster_three("小喽啰", null, -1, -1), monster_four("小喽啰", null, -1, -1),
        monster_five("小喽啰", null, -1, -1), monster_six("小喽啰", null, -1, -1);
        private String name;
        private String color;
        private int lx;
        private int ly;

        private monster(String name, String color, int Lx, int Ly) {
            this.name = name;
            this.color = color;
            this.lx = Lx;
            this.ly = Ly;
        }

        @Override
        public String getname() {
            return this.name;
        }
        public void move_to(BattleField x, int i, int j) {
            x.map[i][j]=this;
            this.lx=i;
            this.ly=j;
        }
    }
}

class BattleField{
    public Creature [][]map;
    private int n;
    BattleField(int n){
        this.n=n;
        map=new Creature[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j]= Creature.NULL.Null;
            }
        }
    }
    public void refresh(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j]= Creature.NULL.Null;
            }
        }
    }
    public void print(){
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                String name=map[i][j].getname();
                if(name==null)
                    System.out.print("  ");
                else if(name=="老大")
                    System.out.print("一");
                else if(name=="老二")
                    System.out.print("二");
                else if(name=="老三")
                    System.out.print("三");
                else if(name=="老四")
                    System.out.print("四");
                else if(name=="老五")
                    System.out.print("五");
                else if(name=="老六")
                    System.out.print("六");
                else if(name=="老七")
                    System.out.print("七");
                else if(name=="蝎子精")
                    System.out.print("蝎");
                else if(name=="蛇精")
                    System.out.print("蛇");
                else if(name=="爷爷")
                    System.out.print("爷");
                else
                    System.out.print("小");

            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }
}

interface Stand_by_array{
    void stand_by_heyi(BattleField x, int c_i, int c_j);
    void stand_by_yanyue(BattleField x, int c_i, int c_j);
    void stand_by_yanxing(BattleField x, int c_i, int c_j);
}

class Justice implements Stand_by_array{
    void stand_randomly(BattleField x, int c_i, int c_j){
        int arr[] = new int[7];
        for (int i = 0; i < arr.length; i++) {
            int index = (int)(Math.random() * 7);
            arr[i] = index;
            for (int j = 0; j < i; j++) {

                if (arr[j] == arr[i]) {
                    i--;
                    break;
                }
            }
        }
        for(int i=0;i<7;i++){
            Creature.CalabashBrothers.calabash_one.move_to(x,(arr[0]+c_i-3),c_j);
            Creature.CalabashBrothers.calabash_two.move_to(x,(arr[1]+c_i-3),c_j);
            Creature.CalabashBrothers.calabash_three.move_to(x,(arr[2]+c_i-3),c_j);
            Creature.CalabashBrothers.calabash_four.move_to(x,(arr[3]+c_i-3),c_j);
            Creature.CalabashBrothers.calabash_five.move_to(x,(arr[4]+c_i-3),c_j);
            Creature.CalabashBrothers.calabash_six.move_to(x,(arr[5]+c_i-3),c_j);
            Creature.CalabashBrothers.calabash_seven.move_to(x,(arr[6]+c_i-3),c_j);
        }

    }
    void stand_by_changshe(BattleField x, int c_i, int c_j){
        Creature.CalabashBrothers.calabash_one.move_to(x,(c_i-3),c_j);
        Creature.CalabashBrothers.calabash_two.move_to(x,(c_i-2),c_j);
        Creature.CalabashBrothers.calabash_three.move_to(x,(c_i-1),c_j);
        Creature.CalabashBrothers.calabash_four.move_to(x,(c_i),c_j);
        Creature.CalabashBrothers.calabash_five.move_to(x,(c_i+1),c_j);
        Creature.CalabashBrothers.calabash_six.move_to(x,(c_i+2),c_j);
        Creature.CalabashBrothers.calabash_seven.move_to(x,(c_i+3),c_j);
    }
    @Override
    public void stand_by_heyi(BattleField x, int c_i, int c_j){
        return;
    }
    public void stand_by_yanyue(BattleField x, int c_i, int c_j){
        return;
    }
    public void stand_by_yanxing(BattleField x, int c_i, int c_j){
        return;
    }
}
class Evil implements Stand_by_array{
    @Override
    public void stand_by_heyi(BattleField x, int c_i, int c_j){
        Creature.monster.monster_one.move_to(x,c_i,c_j);
        Creature.monster.monster_two.move_to(x,c_i+1,c_j+1);
        Creature.monster.monster_three.move_to(x,c_i+2,c_j+2);
        Creature.Scorpion.scorpion.move_to(x,c_i+3,c_j+3);
        Creature.monster.monster_four.move_to(x,c_i+2,c_j+4);
        Creature.monster.monster_five.move_to(x,c_i+1,c_j+5);
        Creature.monster.monster_six.move_to(x,c_i,c_j+6);
    }
    public void stand_by_yanyue(BattleField x, int c_i, int c_j){
        return;
    }
    public void stand_by_yanxing(BattleField x, int c_i, int c_j){
        Creature.monster.monster_one.move_to(x,c_i,c_j);
        Creature.monster.monster_two.move_to(x,c_i-1,c_j+1);
        Creature.Scorpion.scorpion.move_to(x,c_i-2,c_j+2);
        Creature.monster.monster_three.move_to(x,c_i-3,c_j+3);
        Creature.monster.monster_four.move_to(x,c_i-4,c_j+4);
    }
}


public class executor{
    public static void main(String[] args){
        BattleField battleField=new BattleField(15);
        Justice justice =new Justice();
        Evil evil =new Evil();
        justice.stand_randomly(battleField,7,0);
        battleField.print();
        battleField.refresh();
        evil.stand_by_yanxing(battleField,9,10);
        justice.stand_by_changshe(battleField,7,0);
        Creature.Grandfather.grandfather.move_to(battleField,14,0);
        Creature.Serpent.serpent.move_to(battleField,14,14);
        battleField.print();
        battleField.refresh();
        evil.stand_by_heyi(battleField,5,8);
        justice.stand_by_changshe(battleField,7,0);
        Creature.Grandfather.grandfather.move_to(battleField,14,0);
        Creature.Serpent.serpent.move_to(battleField,14,14);
        battleField.print();
    }
}