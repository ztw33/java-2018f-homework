package Huluwa;

public class Scorpion extends Creature{
    //蝎子精

    public Scorpion(String newName)
    {
        name = newName;
    }

    @Override
    public void report(){System.out.print(name+"\t\t");}
}

