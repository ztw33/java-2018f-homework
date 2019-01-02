package Huluwa;

public class Snake extends Creature{
    //蛇精
    public Snake(String newName)
    {
        name = newName;
    }

    @Override
    public void report(){System.out.print(name+"\t\t");}
}
