public class Block <T extends Organism>{
    private T being;
    public Block(){
        being = null;
    }
    public void set(T being){ this.being = being; }
    public T get(){ return this.being; }
}
