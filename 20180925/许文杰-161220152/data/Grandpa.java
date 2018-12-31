package data;

public class Grandpa extends Unit implements leader
{
    private String name;
    public Grandpa()
    {
        name = "爷爷";
    }
    public String getName(){ return name; }
    public void cheer(){
        System.out.println("爷爷：加油！");
    };
}
