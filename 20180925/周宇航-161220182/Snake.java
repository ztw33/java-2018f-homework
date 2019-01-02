public class Snake {
    private String name;
    private int abscissa;
    private int ordinate;
    public Snake()
    {
        name = "蛇精";
        abscissa = 10;
        ordinate = 19;
    }
    public int getAbscissa()
    {
        return abscissa;
    }
    public int getOrdinate()
    {
        return ordinate;
    }
    /*
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
    }*/
}
