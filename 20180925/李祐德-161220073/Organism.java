public abstract class Organism {
    Block position;
    void  moveTo(Block b){
        b.being = this;
        position = b;
    }
    void fallBack(){
        position = null;
    }
    public abstract String tellName();
}
