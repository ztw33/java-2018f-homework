class Creature {
    public int px;
    public int py;
    public String desc;
    public Creature(String desc){
        this.desc=desc;
    }
    public String getDesc() {
        return desc;
    }

    public void movetoline(String[][] ground, int px , int py){
        ground[px][py]=this.desc;
        this.px = px;
        this.py = py;
    }

}