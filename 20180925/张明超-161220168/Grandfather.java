public class Grandfather extends Creature{
    private String name = "爷爷";
    public Grandfather(){

    }
    public String getName() {
        return name;
    }
    public void toldname(){
        System.out.println(name);
    }
    @Override
    public void toldCreatureCategoryAndName(){
        System.out.println("grandfather:"+name);
    }
    @Override
    public void toldCreature(){
        System.out.print("|"+name+"  ");
    }
}
