package homework3.creature;

public class Snake extends Creature{
    private static Snake beautySnake = new Snake();

    private Snake(){
        super();
        name = "蛇";
    }

    public static Snake getInstance(){
        return beautySnake;
    }
}
