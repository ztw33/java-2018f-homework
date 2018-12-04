public class Scorpion {
    private String name;
    private int abscissa;
    private int ordinate;
    public Scorpion()
    {
        name = "蝎子精";
        abscissa = 10;
        ordinate = 10;
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
    public void setFormation(int ScorpionAbscissa, int ScorpionOrdinate)
    {
        setAbscissa(ScorpionAbscissa);
        setOrdinate(ScorpionOrdinate);
    }
    public void changeFormation(int x, int y)
    {
        setFormation(x, y);
    }
}
