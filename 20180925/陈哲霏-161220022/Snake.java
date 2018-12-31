public class Snake extends Creature {
    Snake(){
        this.name = "蛇精";
        this.alive = true;
        this.posX = 0;
        this.posY = 0;
    }

    public void cheerMonsters(){
        System.out.println("蛇精为妖怪们助威：小的们，上！！！");
    }
}
