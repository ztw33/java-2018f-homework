package qx3;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;

public class Battlefield {
    private int N;
    private static int scale=40;
    private List<List<Boolean>> isbeing;
    private List<List<Creature>> creature;
    private List<List<ImageView>> image;
    public Battlefield(int N)
    {
        this.N=N;
        isbeing=new ArrayList<List<Boolean>>();
        creature=new ArrayList<List<Creature>>();
        image=new ArrayList<List<ImageView>>();
        for(int i=0;i<N;i++)
        {
            List<Boolean> isbeinglist=new ArrayList<Boolean>();
            List<Creature> creaturelist=new ArrayList<Creature>();
            List<ImageView> imagelist=new ArrayList<ImageView>();
            for(int j=0;j<N;j++)
            {
                isbeinglist.add(false);
                creaturelist.add(null);
                ImageView temp=new ImageView();
                temp.setVisible(false);
                temp.setX(j*scale);
                temp.setY(i*scale);
                imagelist.add(temp);
            }
            isbeing.add(isbeinglist);
            creature.add(creaturelist);
            image.add(imagelist);
        }
    }
    public int getN()
    {
        return N;
    }
    public int getScale(){return scale;}
    public List<List<ImageView>> getImage()
    {
        return image;
    }
    public void setPosition(int x,int y,Creature creature)
    {
        if(x<0||y<0||x>N-1||y>N-1)
        {
            System.out.print("超出了战场范围！\n");
        }
        else if(isbeing.get(x).get(y))
        {
            System.out.print("战场上该位置有人了！！！");
        }
        else
        {
            this.isbeing.get(x).set(y,true);
            this.creature.get(x).set(y,creature);
            ImageView temp=new ImageView();
            temp.setVisible(true);
            temp.setImage(new Image(creature.getUrl()));
            temp.setFitWidth(scale);
            temp.setFitHeight(scale);
            temp.setX(image.get(x).get(y).getX());
            temp.setY(image.get(x).get(y).getY());
            this.image.get(x).set(y,temp);
        }
    }
    public void printBattlefield()
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(isbeing.get(i).get(j))
                {
                    System.out.print(creature.get(i).get(j).getName());
                }
                else
                {
                    System.out.print("    ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
