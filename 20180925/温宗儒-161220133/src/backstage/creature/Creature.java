package backstage.creature;

public class Creature {
    public String getName() {
        return name;
    }
    protected String name;
    protected String imageUrl;
    protected double locationX;
    protected double locationY;

    public String getImageUrl(){
        return imageUrl;
    }
}
