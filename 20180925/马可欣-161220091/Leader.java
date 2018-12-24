public class Leader extends Space{
    private String name;

    public Leader() {
        this.name = "leader";
    }

    public Leader(String name,int x,int y){
        super(x,y);
        this.name=name;
    }

    public String getName() {
        return this.name;
    }



}
