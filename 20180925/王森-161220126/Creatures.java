public class Creatures {
    protected String creatureName;
    protected int pos_x, pos_y;
    public String Getname() {
        return creatureName;
    }
    public int Getx() {
        return pos_x;
    }
    public int Gety() {
        return pos_y;
    }
}

class Grandfather extends Creatures {
    public Grandfather() {
        creatureName = "爷爷";
        pos_x = pos_y = -1;
    }
    public void Refueling() {
        System.out.println("爷爷：“孩子们，加油！”");
    }
    public void setPosition(int x, int y, Blocks fields[][]) {
        if(!fields[x][y].isAnyCreature()) {
            pos_x = x;
            pos_y = y;
            fields[x][y].Summon(this);
        }
        else {
            System.out.println("error! 此处已有生物占领!");
        }
    }
    public void leavePosition(Blocks fields[][]) {
        if(fields[pos_x][pos_y].isAnyCreature()) {
            fields[pos_x][pos_y].DeSummon(this);
            pos_x = pos_y = -1;
        }
        else {
            System.out.println("error! 此处无生物占领!");
        }
    }
}

class SheJing extends  Creatures {
    public SheJing() {
        creatureName = "蛇精";
        pos_x = pos_y = -1;
    }
    public void Refueling() { System.out.println("蛇精：“崽子们，冲鸭！”"); }
    public void setPosition(int x, int y, Blocks fields[][]) {
        if(!fields[x][y].isAnyCreature()) {
            pos_x = x;
            pos_y = y;
            fields[x][y].Summon(this);
        }
        else {
            System.out.println("error! 此处已有生物占领!");
        }
    }
    public void leavePosition(Blocks fields[][]) {
        if(fields[pos_x][pos_y].isAnyCreature()) {
            fields[pos_x][pos_y].DeSummon(this);
            pos_x = pos_y = -1;
        }
        else {
            System.out.println("error! 此处无生物占领!");
        }
    }
}

class HuluWa extends Creatures {
    public enum Rank {老大, 老二, 老三, 老四, 老五, 老六, 老七}
    private Rank creatureRank;
    protected Formation formation;
    public HuluWa() {
        creatureName = "葫芦娃";
        pos_x = pos_y = -1;
        formation = new Formation();
    }
    public Rank getRank() {
        return creatureRank;
    }
    public void setRank(Rank a) {
        creatureRank = a;
    }
    public void reportTheChange(int i, int j) {
        System.out.println(creatureRank+":"+i+"->"+j);
    }
    public void reportTheRank() {
        System.out.println(creatureRank);
    }
    public void setPosition(int x, int y, Blocks fields[][]) {
        if(!fields[x][y].isAnyCreature()) {
            pos_x = x;
            pos_y = y;
            fields[x][y].Summon(this);
        }
        else {
            System.out.println("error! 此处已有生物占领!");
        }
    }
    public void leavePosition(Blocks fields[][]) {
        if(fields[pos_x][pos_y].isAnyCreature()) {
            fields[pos_x][pos_y].DeSummon(this);
            pos_x = pos_y = -1;
        }
        else {
            System.out.println("error! 此处无生物占领!");
        }
    }
}

class XieZiJing extends Creatures {
    public enum Job {大哥, 小弟};
    protected Formation formation;
    protected Job job;
    public XieZiJing(String name) {
        creatureName = name;
        pos_x = pos_y = -1;
        formation = new Formation();
    }
    public void setJob(Job a) {
        job = a;
    }
    public Job getJob() {
        return job;
    }
    public void setPosition(int x, int y, Blocks fields[][]) {
        if(!fields[x][y].isAnyCreature()) {
            pos_x = x;
            pos_y = y;
            fields[x][y].Summon(this);
        }
        else {
            System.out.println("error! 此处已有生物占领!");
        }
    }
    public void leavePosition(Blocks fields[][]) {
        if(fields[pos_x][pos_y].isAnyCreature()) {
            fields[pos_x][pos_y].DeSummon(this);
            pos_x = pos_y = -1;
        }
        else {
            System.out.println("error! 此处无生物占领!");
        }
    }
}
