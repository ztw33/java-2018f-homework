
class MonSnake extends Creature{
    MonSnake(){
        super();
        this.type = CreatureType.MonSnake;
        this.name = this.type.name();

    }

    @Override
    public String toString(){
        return "蛇";
    }
}