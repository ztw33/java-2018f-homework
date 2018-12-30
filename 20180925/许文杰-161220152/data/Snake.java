package data;

public class Snake extends Unit implements leader
{
    private String name;
    public Snake()
    {
        name = "蛇精";
    }
    public String getName(){ return name; }
    public void cheer(){
        System.out.println("蛇精：加油！");
    };
}
