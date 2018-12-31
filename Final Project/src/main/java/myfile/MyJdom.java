package myfile;


import Creature.Creature;
import Instructor.Global;
import MyMap.MyMap;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import ui.MenuController;
import MyMap.MyPosition;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.lang.Thread.sleep;
public class MyJdom implements Runnable{
    public boolean readover = false;
    public boolean readready = false;
    private String filename;
    public MyJdom(String filename){this.filename = filename;}
    public void run(){
        readXML(filename);
    }
    private void readXML(String filename) {
        SAXReader reader = new SAXReader();
        int cround = 1;
        try {
            File file = new File(filename);
            Document document = reader.read(file);
            Element rounds = document.getRootElement();
            Iterator it = rounds.elementIterator();
            while (it.hasNext()) {
                Element round = (Element) it.next();
                Iterator itt = round.elementIterator();
                while (itt.hasNext()) {
                    Element act = (Element) itt.next();
                    List<Attribute> acts = act.attributes();
                    String name = "none";
                    int action = 0, x = 0, y = 0;
                    boolean alive = true;
                    for (Attribute attr : acts) {
                        if (attr.getName() == "name")
                            name = attr.getValue();
                        else if (attr.getName() == "action")
                            action = Integer.parseInt(attr.getValue());
                        else if (attr.getName() == "alive")
                            alive = Boolean.parseBoolean(attr.getValue());
                        else if (attr.getName() == "x")
                            x = Integer.parseInt(attr.getValue());
                        else
                            y = Integer.parseInt(attr.getValue());
                    }
                    //System.out.println(name + " " + action + " " + x + " " + y + " " + alive);
                    readready = false;
                    if(!Thread.currentThread().isInterrupted()) {
                        synchronized (MyMap.LandCreature) {
                            Creature temp = MenuController.getCreature(name);
                            synchronized (MenuController.bullets) {
                                MyPosition pos = MyMap.getNearestEnemy(temp, MyMap.LandCreature);
                                if (action == Global.ACT_SHOOT) {
                                    temp.shootBullet(pos);
                                }
                            }
                            MyMap.setSite(temp, x, y);
                            if (!alive)
                                temp.getDamage(10000);/*TODO*/
                        }/*TODO*/
                        readready = true;
                    }else return;
                }
                System.out.println("round "+cround);
                cround++;
                //MyMap.printMap();
                sleep(4000/(long)MenuController.myspeed);
            }
            readover = true;
        }catch (DocumentException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            return;
        }
    }

    public static void writeXML(String filename, ArrayList<Act> acts){
        int rcount = 1;
        SAXReader reader = new SAXReader();
        try{
            File file = new File(filename);
            Document document = reader.read(file);
            Element rounds = document.getRootElement();

            Element round = rounds.addElement("round");
            round.addAttribute("count",String.valueOf(rcount));
            rcount++;

            for(Act act:acts) {
                Element name = round.addElement("ACT");
                name.addAttribute("name", act.getName());
                name.addAttribute("action", String.valueOf(act.getAction()));
                name.addAttribute("alive",String.valueOf(act.getAlive()));
                name.addAttribute("x",String.valueOf(act.getSitex()));
                name.addAttribute("y",String.valueOf(act.getSitey()));
            }

            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(new FileOutputStream(file),format);
            writer.write(document);
            writer.close();
        }catch (DocumentException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void createRoot(String filename){
        Document document = DocumentHelper.createDocument();
        try {
            File file = new File(filename);
            Element round = document.addElement("rounds");
            document.setRootElement(round);
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(new FileOutputStream(file),format);
            writer.write(document);
            writer.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
