package jchan.calabash.output;

import jchan.calabash.calabashworld.Field;
import jchan.calabash.calabashworld.Cell;
import jchan.calabash.calabashworld.Thing;

public class Printerxy implements Printable {
    public void print(Field field){
        for(int i = 0;i < field.getxMax();i++){
            //System.out.print(i);
            System.out.print(':');
            for(int t = 0;t < field.getyMax();t++){
                if(field.cells[i][t][0].isExist()==true)
                    printThing(field.cells[i][t][0].getThing());
                else
                    printBackground(field.cells[i][t][0]);
            }
            System.out.print('\n');
        }
        System.out.println("--------------------");
    }
    private void printThing(Thing thing){
        System.out.print(thing.whoami());
    }
    private void printBackground(Cell cell){
        System.out.print(cell.whoami());
    }
}
