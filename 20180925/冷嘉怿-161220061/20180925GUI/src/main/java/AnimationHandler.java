import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AnimationHandler implements Runnable{
    private Charactors chats[]=new Charactors[]{};

    public AtomicInteger cmd=new AtomicInteger(0);
    public AtomicBoolean avaliable=new AtomicBoolean(true);

    public void addChat(Charactors newchat)
    {
        int oldlen=chats.length;
        Charactors tmp[]=new Charactors[oldlen+1];
        for(int i=0;i<oldlen;i++)
            tmp[i]=chats[i];
        tmp[oldlen]=newchat;
        chats=tmp;
    }
    public void addChat(Charactors[] newchats)
    {
        int oldlen=chats.length;
        Charactors tmp[]=new Charactors[oldlen+newchats.length];
        for(int i=0;i<oldlen;i++)
            tmp[i]=chats[i];
        for(int i=0;i<newchats.length;i++)
            tmp[i+oldlen]=newchats[i];
        chats=tmp;
    }
    public void print()
    {
        for(int i=0;i<chats.length;i++)
            System.out.println(chats[i].typename);
    }
    public void run()
    {
        while (true)
        {
            cmdHandler();
        }
    }
    private void cmdHandler()
    {
        switch (cmd.get())
        {
            case 0: break;
            case 1: movement(); cmd.set(0);break;
        }
    }
    private void movement()
    {
//        boolean change=false;
        avaliable.set(false);
        for (Charactors x : chats)
        {
            x.tmpX=x.realX(x.positionX);
            x.tmpY=x.realY(x.positionY);
//            System.out.printf("%s:%d, %d to %d, %d\n",x.typename,x.positionX,x.positionY,x.nextX,x.nextY);
            if(x.animate)
                x.testLabel.setIcon(x.movingimg);
        }
        for(int i=0;i<36;i++)
        {
            for (Charactors x : chats)
            {
                x.tmpX+=(double)(x.realX(x.nextX)-x.realX(x.positionX))/36;
                x.tmpY+=(double)(x.realY(x.nextY)-x.realY(x.positionY))/36;
                x.testLabel.setLocation((int)x.tmpX,(int)x.tmpY);
/*                if(i%9==0)
                {
                    change=!change;
                    if (!change) {
                        x.testLabel.setIcon(x.baseimg);
                        x.testLabel.repaint();
                    } else {
                        x.testLabel.setIcon(x.movingimg);
                        x.testLabel.repaint();
                    }
                }
*/            }
            try {
                Thread.sleep(1000 / 36);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        virtualField.clear();
        for (Charactors x : chats)
        {
            x.testLabel.setIcon(x.baseimg);
            x.animate=false;
            x.positionX=x.nextX;
            x.positionY=x.nextY;
            virtualField.field[x.positionY][x.positionX]=x;
            x.testLabel.setLocation(x.realX((int)x.positionX),x.realY((int)x.positionY));
        }
        avaliable.set(true);
    }
}
