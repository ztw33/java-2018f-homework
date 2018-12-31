package Update3.Creature;

public class Rock implements Identity{
    String name;
    public Rock(){
        name = new String("大石头");
    }
    public void Show(){
        System.out.print("  Rock  ");
    }
    public String Identity(){return name;};
}
