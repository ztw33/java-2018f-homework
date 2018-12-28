package homework3.creature;

public class GrandPa extends Justice{
    public static GrandPa grandPa = new GrandPa();

    private GrandPa(){
        super();
        name = "爷";
    }

    public static GrandPa getInstance(){
        return grandPa;
    }
}
