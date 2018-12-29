package renyi2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Field {
    int N;
    int element_size;

    List<List<Creature>> field=new ArrayList<List<Creature>>();
    List<List<ImageView>> imv=new ArrayList<List<ImageView>>();
    Field()
    {
        /*System.out.println("请输入战场的规格N（N>10）");
        Scanner in =new Scanner(System.in);
        N=in.nextInt();
        while(N<=10)
        {
            System.out.println("N的规格不符合标准，请重新输入");
            in =new Scanner(System.in);
            N=in.nextInt();
        }*/
        InputStream is=Main.class.getResourceAsStream("/Field.properties");
        Properties ps = new Properties();
        try {
            ps.load(is);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        N=new Integer(ps.getProperty("field_N"));
        element_size=new Integer(ps.getProperty("element_size"));
        Creature one;
        ImageView two;
        for(int i=0;i<N;i++)
        {
            List<Creature> line=new ArrayList<Creature>();
            List<ImageView> imvline=new ArrayList<ImageView>();
            for(int j=0;j<N;j++)
            {
                line.add(one=new NullCreature(i,j));
                two=new ImageView();
                two.setVisible(false);
                two.setY(i*element_size);
                two.setX((j*element_size));
                imvline.add(two);
            }
            field.add(line);
            imv.add(imvline);
        }
    }
    public void setposition(int x,int y,Creature one)
    {
        field.get(x).set(y,one);
    }
    public void resetfield()
    {
        Creature one;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                field.get(i).set(j,one=new NullCreature(i,j));
        }
    }
    public void show()
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(this.field.get(i).get(j).name+" ");
                if(field.get(i).get(j).getClass()!=NullCreature.class)
                {
                    imv.get(i).get(j).setVisible(true);
                    imv.get(i).get(j).setImage(new Image(field.get(i).get(j).Imageurl));
                    imv.get(i).get(j).setFitWidth(element_size);
                    imv.get(i).get(j).setFitHeight(element_size);
                }
            }
            System.out.print("\n");
        }
    }
}
