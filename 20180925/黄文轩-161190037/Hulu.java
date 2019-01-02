
class Hulu extends Creature{
    public enum Color{
        c1("赤"),c2("橙"),c3("黄"),c4("绿"),c5("青"),c6("蓝"),c7("紫");
        String color;
        Color(String color){
            this.color = color;
        }
        String getColor(){
            return this.color;
        }
    }

    Color color;
    int ranking;


    Hulu(int rank){
        super();
        this.ranking = rank;
        this.type = CreatureType.valueOf("Hulu"+rank);
        this.name = this.type.name();
        this.color = Color.valueOf("c"+rank);
    }

    @Override
    public String toString(){
        return color.getColor();
    }



}