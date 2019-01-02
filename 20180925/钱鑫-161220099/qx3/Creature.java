package qx3;

public abstract class Creature {
    protected String name;
    protected String url;
    public void setName(String name)
    {
        this.name = name;
    }
    public void setUrl(String url){this.url=url;}
    public String getName()
    {
        return name;
    }
    public String getUrl(){return url;}
}
