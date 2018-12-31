package Formation;
public class Formation {
    private final String name;
    public final int relationX[];
    public final int relationY[];

    Formation(String name,int rx[],int ry[]) {
        this.name = name;
        this.relationX = rx;
        this.relationY = ry;
    }

    public String getName(){ return name; }

    @Override
    public String toString(){return name;}
}
