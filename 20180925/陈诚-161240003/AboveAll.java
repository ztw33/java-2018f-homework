package njucs.java2018;

public class AboveAll {
    private Field field = new Field();
    private Calabash[] brothers = new Calabash[7];
    private Soldiers[] soldiers = new Soldiers[7];
    private Grandpa grandpa = new Grandpa(new Position((field.Height - 1)/2,0));
    private Snake snake = new Snake(new Position((field.Height - 1)/2, field.Width - 1));
    private Scorpion scorpion = new Scorpion();

    private AboveAll() {
        for(int i = 0; i < 7; i ++) {
            brothers[i] = new Calabash(i + 1);
            soldiers[i] = new Soldiers();
        }
    }

    private void setNPC() { //放置NPC人物 爷爷和蛇精
        field.square[grandpa.getPosition().getX()][grandpa.getPosition().getY()].setBeing(grandpa);
        field.square[snake.getPosition().getX()][snake.getPosition().getY()].setBeing(snake);
    }

    private void setBrothers(Calabash[] brothers) { //依据長蛇阵型放置 葫芦兄弟
        Formation formation = new Formation("長蛇");
        formation.leader = new Position((field.Height - 1)/2 - 3, 2);
        for(int i = 0; i < 7; i ++) {
            brothers[i].setPosition(new Position(formation.leader.getX() + formation.Relpos[i].getX(),
                    formation.leader.getY() + formation.Relpos[i].getY()));
            field.square[brothers[i].getPosition().getX()][brothers[i].getPosition().getY()].setBeing(brothers[i]);
        }
    }

    private void setSoldiers(Soldiers[] soldiers) { //依据蝎子精的安排放置 喽啰阵营
        Formation formation = scorpion.getFormation();
        formation.leader = new Position((field.Height - 1)/2 - 3, (field.Width + 1)/2);
        for(int i = 0; i < 7; i ++) {
            soldiers[i].setPosition(new Position(formation.leader.getX() + formation.Relpos[i].getX(),
                    formation.leader.getY() + formation.Relpos[i].getY()));
        }
        field.square[soldiers[0].getPosition().getX()][soldiers[0].getPosition().getY()].setBeing(scorpion); // 蝎子
        for(int i = 1; i < 7; i ++) {
            field.square[soldiers[i].getPosition().getX()][soldiers[i].getPosition().getY()].setBeing(soldiers[i]);
        }
    }

    private void storyTell() { //OAA开始讲故事
        SortCala sort = new SortCala();
        //初始乱序
        sort.De_sort(brothers);
        //排序
        sort.BubbleSort_byName(brothers);
        //長蛇阵型
        this.setBrothers(brothers);
        //偃月阵型
        scorpion.setFormation("偃月");
        this.setSoldiers(soldiers);
        //观战
        this.setNPC();
        field.show();

        field.clearField();

        this.setBrothers(brothers);
        //喽啰阵营变换阵型
        scorpion.setFormation("鶴翼");
        this.setSoldiers(soldiers);
        this.setNPC();
        field.show();
    }

    public static void main(String[] args) {
        AboveAll OAA = new AboveAll();
        OAA.storyTell();
    }
}
