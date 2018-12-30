public class Creature {
    public String name;
    public boolean alive;
    public int posX;
    public int posY;
    public void die(){
        alive = false;
    }
    public int getPosX(){ return posX; }
    public int getPosY(){ return posY; }
    public void changePosX(int newPosX){
        this.posX = newPosX;
    }
    public void changePosY(int newPosY){
        this.posY  = newPosY;
    }
    public boolean aliveCheck(){
        if(this.alive) return true;
        else return false;
    }
//    public int attack;
//    public int defence;
//    public int lifePoint;
}
