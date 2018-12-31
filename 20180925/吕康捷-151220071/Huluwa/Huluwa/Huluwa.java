package Huluwa;

public class Huluwa extends Creature implements Comparable{


    private int level;
    private COLOR colorForSort;
    private String color;

    public Huluwa(int newLevel,String newName,String newColor,COLOR newColorForSort)
    {

        level = newLevel;
        color = newColor;
        name = newName;
        colorForSort = newColorForSort;
    }


    public int getLevel(){
        return level;
    }

    public int getColorForSort(){
        return colorForSort.ordinal();
    }

    @Override
    public void report(){System.out.print(name+"\t\t");}

    public void reportColor(){System.out.print(this.color+"\t\t");}

    @Override
    public boolean biggerThan(Comparable another,PROPERTY base){
        switch (base)
        {
            case LEVEL : return (this.getLevel() > ((Huluwa)another).getLevel());
            case COLOR : return (this.getColorForSort() > ((Huluwa)another).getColorForSort());
            default: return false;
        }
    }
}
