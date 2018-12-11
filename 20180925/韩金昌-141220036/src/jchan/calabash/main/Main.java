package jchan.calabash.main;


import jchan.calabash.calabashworld.*;
import jchan.calabash.creatures.*;
import jchan.calabash.formation.*;
import jchan.calabash.groups.*;
import jchan.calabash.output.*;


import java.io.*;

public class Main {
    public static void main(String []s){
        Field field = new Field();
        CalabashGourd calabashgroud = new CalabashGourd(field);
        Spirits spirits = new Spirits(field,10);
        Oldman oldman = new Oldman(field.getxMax()/2,0,field);
        Snake snake = new Snake(field.getxMax()/2,field.getyMax() - 1,field );
        Printerxy printer = new Printerxy();
        GraphPrinterxy graphPrinter = new GraphPrinterxy();
        printer.print(field);
        graphPrinter.print(field);
        calabashgroud.sort();
        spirits.sort();
        oldman.cheer();
        snake.cheer();
        printer.print(field);
        graphPrinter.print(field);
        spirits.setformation(new Heyi(10,15,10));
        spirits.sort();
        printer.print(field);
        graphPrinter.print(field);
        spirits.setformation(new Yanxing(10,15,10));
        spirits.sort();
        printer.print(field);
        graphPrinter.print(field);
        spirits.setformation(new Henge(10,15,10));
        spirits.sort();
        printer.print(field);
        graphPrinter.print(field);
        spirits.setformation(new Yulin(10,15,10));
        spirits.sort();
        printer.print(field);
        graphPrinter.print(field);
        spirits.setformation(new Fangyuan(10,15,10));
        spirits.sort();
        oldman.cheer();
        snake.cheer();
        printer.print(field);
        graphPrinter.print(field);
    }
}
