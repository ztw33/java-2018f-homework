public class Sprite {
    private String name;
    private int order;
    private int abscissa;
    private int ordinate;
    public Sprite(int num)
    {
        order = num;
        name = "喽啰";
        abscissa = 11;
        ordinate = 7 + order;
    }
    public int getAbscissa()
    {
        return abscissa;
    }
    public int getOrdinate()
    {
        return ordinate;
    }
    public void setAbscissa(int abscissa)
    {
        this.abscissa = abscissa;
    }
    public void setOrdinate(int ordinate)
    {
        this.ordinate = ordinate;
    }
    public void setFormation(int SpriteAbscissa, int SpriteOrdinate)
    {
        setAbscissa(SpriteAbscissa);
        setOrdinate(SpriteOrdinate);
    }
}
