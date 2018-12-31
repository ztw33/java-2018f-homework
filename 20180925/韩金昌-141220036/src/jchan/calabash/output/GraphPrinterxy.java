package jchan.calabash.output;

import jchan.calabash.calabashworld.*;
import jchan.calabash.picture.*;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

public class GraphPrinterxy implements Printable {
    JFrame frame;
    JLabel pic;
    public void print(Field field){
        BufferedImage image = DrawBackground.drawBackground(field,0,0,20,20);
        DrawNPCs.drawNPCs(image,field,0,0,20,20);
        pic.setIcon(new ImageIcon(image));
        pic.repaint();
        try{
        TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
    public GraphPrinterxy(){
        frame = new JFrame("Calabash World");
        PicPath.initialImage();
        pic = new JLabel(new ImageIcon());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pic);
        frame.setSize(840,840);
        frame.setVisible(true);
    }
}
