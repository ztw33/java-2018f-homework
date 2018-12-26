public class Battlefield {
    private Blocks fields[][];
    private int sizeofBattlefields;
    private Grandfather grandPa;
    private  SheJing snake;
    private HuluBro Brothers;
    private XieZiJing Soldiers[];
    public Battlefield(int N) {
        fields = new Blocks[N][N];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                fields[i][j] = new Blocks();
        }
        sizeofBattlefields = N;
        grandPa = new Grandfather();
        snake = new SheJing();
        Brothers = new HuluBro();
        Soldiers = new XieZiJing[19];
        Soldiers[0] = new XieZiJing("蝎子精");
        Soldiers[0].setJob(XieZiJing.Job.大哥);
        for(int i = 1; i < 19; i++) {
            Soldiers[i] = new XieZiJing("小喽啰");
            Soldiers[i].setJob(XieZiJing.Job.小弟);
        }
    }
    public void printBattlefields() {
        for (int i = 0; i < sizeofBattlefields; i++) {
            for (int j = 0; j < sizeofBattlefields; j++) {
                if (fields[i][j].isAnyCreature()) {
                    if(fields[i][j].getCreature().Getname() == "葫芦娃") {
                        System.out.print(fields[i][j].getHuluWa().getRank().ordinal()+1);
                    }
                    else if(fields[i][j].getCreature().Getname() == "爷爷") {
                        System.out.print('*');
                    }
                    else if(fields[i][j].getCreature().Getname() == "蛇精") {
                        System.out.print('#');
                    }
                    else {
                        System.out.print('$');
                    }
                }
                else
                    System.out.print('-');
                System.out.print(' ');
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }
    public int getSize() {
        return sizeofBattlefields;
    }
    public static void main(String[] args) {
        Battlefield zone = new Battlefield(10);
        zone.Brothers.getMember(0).formation.ChangShe(zone.fields, zone.Brothers.getMembers(), 1, 1, zone.grandPa, zone);
        zone.printBattlefields();
        zone.Brothers.myBubbleSort();
        zone.Brothers.getMember(0).formation.initFormation(zone.fields, zone.Brothers.getMembers(), zone.grandPa);
        zone.Brothers.getMember(0).formation.ChangShe(zone.fields, zone.Brothers.getMembers(), 1, 1, zone.grandPa, zone);
        zone.printBattlefields();
        zone.Soldiers[0].formation.HeYi(zone.fields, zone.Soldiers, 5, 6, zone.snake, zone);
        zone.printBattlefields();
        zone.Soldiers[0].formation.initFormation(zone.fields, zone.Soldiers, zone.snake);
        zone.Soldiers[0].formation.YanXing(zone.fields, zone.Soldiers, 4, 6, zone.snake, zone);
        zone.printBattlefields();
        zone.Soldiers[0].formation.initFormation(zone.fields, zone.Soldiers, zone.snake);
        zone.Soldiers[0].formation.YanYue(zone.fields, zone.Soldiers, 4, 6, zone.snake, zone);
        zone.printBattlefields();
        zone.Soldiers[0].formation.initFormation(zone.fields, zone.Soldiers, zone.snake);
        zone.Soldiers[0].formation.FengShi(zone.fields, zone.Soldiers, 2, 6, zone.snake, zone);
        zone.printBattlefields();
    }
}

