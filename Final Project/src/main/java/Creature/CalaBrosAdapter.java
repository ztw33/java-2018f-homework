package Creature;

import java.util.ArrayList;

public class CalaBrosAdapter{
    public static ArrayList<CalaBrothers> CalaBros = new ArrayList<CalaBrothers>();
    public static void initArrayBros(){
        CalaBrothers bro1 = new CalaBrothers(1,"red","大娃","1.jpg",1,"BLUECIRCLE.png");CalaBros.add(bro1);
        CalaBrothers bro2 = new CalaBrothers(2,"orange","二娃","2.jpg",2,"BLUECIRCLE.png");CalaBros.add(bro2);
        CalaBrothers bro3 = new CalaBrothers(3,"yellow","三娃","3.jpg",3,"BLUECIRCLE.png");CalaBros.add(bro3);
        CalaBrothers bro4 = new CalaBrothers(4,"green","四娃","4.jpg",4,"BLUECIRCLE.png");CalaBros.add(bro4);
        CalaBrothers bro5 = new CalaBrothers(5,"cyan","五娃","5.jpg",5,"BLUECIRCLE.png");CalaBros.add(bro5);
        CalaBrothers bro6 = new CalaBrothers(6,"blue","六娃","6.jpg",6,"BLUECIRCLE.png");CalaBros.add(bro6);
        CalaBrothers bro7 = new CalaBrothers(7,"purple","七娃","7.jpg",7,"BLUECIRCLE.png");CalaBros.add(bro7);
    }
}