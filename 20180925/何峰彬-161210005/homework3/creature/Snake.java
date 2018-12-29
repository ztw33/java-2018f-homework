package homework3.creature;

public class Snake extends Monster{
    private static Snake beautySnake = new Snake();

    private Snake(){
        name = "蛇";
    }

    public static Snake getInstance(){
        return beautySnake;
    }
}
