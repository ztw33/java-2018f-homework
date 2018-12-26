package Huluwa;

public class Monster extends Creature{
    //小怪

    public Monster(String newName)
    {
        name = newName;
    }

    @Override
    public void report(){System.out.print(name+"\t\t");}
}
