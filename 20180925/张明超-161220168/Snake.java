public class Snake extends Creature{
    private String name = "蛇精";
    public Snake(){

    }
    public String getName() {
        return name;
    }
    public void toldname(){
        System.out.println(name);
    }
    @Override
    public void toldCreatureCategoryAndName(){
        System.out.println("Snake:"+name);
    }
    @Override
    public void toldCreature(){
        System.out.print("|"+name+"  ");
    }
}
