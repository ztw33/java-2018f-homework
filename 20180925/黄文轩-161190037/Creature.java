


public abstract class Creature{
    public enum CreatureType{

        Grandfa("爷爷"),
        Hulu1("老大"),Hulu2("老二"),Hulu3("老三"),Hulu4("老四"),
        Hulu5("老五"),Hulu6("老六"),Hulu7("老七"),

        MonSnake("蛇精"),MonScorpion("蝎子精"),
        MonRetinue1("小喽啰1"),MonRetinue2("小喽啰2"),
        MonRetinue3("小喽啰3"),MonRetinue4("小喽啰4");

        String name;

        CreatureType(String name){
            this.name = name;
        }

        @Deprecated
        String getName(){
            return this.name;
        }
    }



    protected CreatureType type;/**生物类型*/
    protected String name;/**名字*/

    protected int posX;/**x坐标*/
    protected int posY;/**y坐标*/



    public String getName(){
        return this.name;
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }





    Creature(){
        type = null;
        posX = 0;
        posY = 0;
    }



    public void setCreaturePos(int x,int y){
        posX = x;
        posY = y;
    }





}
