package Huluwa;

public class GrandFather extends Creature{


    public GrandFather(String newName)
    {
        name = newName;
    }

    @Override
    public void report(){System.out.print(name+"\t\t");}
}
