package Formation;
import CommonMethods.PointNode;
import Ground.GroundCreater;
import Creature.Creature;

public class Formation {

    public Formation(){}

    public void Formation(String name, String camp,PointNode[] array, int xBase, int yBase){
        switch(name){
            case "鹤翼": crane(array, camp, xBase, yBase); break;
            case "雁行": wildgoose(array, camp, xBase, yBase); break;
            case "衡轭": cross(array, camp, xBase, yBase); break;
            case "长蛇": snake(array, camp, xBase, yBase); break;
            case "鱼鳞": fish(array, camp, xBase, yBase); break;
            case "方门": door(array, camp, xBase, yBase); break;
            case "偃月": moon(array, camp, xBase, yBase); break;
            case "锋矢": arrow(array, camp, xBase, yBase); break;
        }
    }

    public void crane(PointNode[] array, String name, int xBase, int yBase){
        if(name=="正义"){
            array[0].xPoint = 5;
            array[0].yPoint = 7;
            for(int i = 1; i < (array.length / 2) + 1; i++){
                array[i].xPoint = array[0].xPoint - i;
                array[i].yPoint = array[0].yPoint + i;
                array[i + 3].xPoint = array[0].xPoint - (4 - i);
                array[i + 3].yPoint = array[0].yPoint - (4 - i);
            }
        }
        else{
            array[3].xPoint = 8;
            array[3].yPoint = 7;
            for(int i = 0 ; i < array.length / 2; i++){
                array[i].xPoint = array[3].xPoint + i + 1;
                array[i + 4].xPoint = array[3].xPoint + i + 1;
                array[i].yPoint = array[3].yPoint + i + 1;
                array[i + 4].yPoint = array[3].yPoint - i - 1;
            }
        }
    }

    public void wildgoose(PointNode[] array, String name, int xBase, int yBase){
        if(name == "正义"){
            array[3].xPoint = 3;
            array[3].yPoint = 7;
            for(int i = 0; i < array.length / 2; i++){
                array[i].xPoint = array[3].xPoint + (3 - i);
                array[i].yPoint = array[3].yPoint - (3 - i);
                array[i + 4].xPoint = array[3].xPoint - (i + 1);
                array[i + 4].yPoint = array[3].yPoint + (i + 1);
            }
        }
        else{
            array[3].xPoint = 11;
            array[3].yPoint = 7;
            for(int i = 0 ; i < array.length / 2; i++) {
                array[i].xPoint = array[3].xPoint + i + 1;
                array[i].yPoint = array[3].yPoint + (i + 1);
                array[i + 4].xPoint = array[3].xPoint - (3 - i);
                array[i + 4].yPoint = array[3].yPoint + (i - 3);
            }
        }

    }

    public void cross(PointNode[] array, String name, int xBase, int yBase){
        if(name == "正义"){
            array[0].xPoint = 4;array[0].yPoint = 7;
            array[1].xPoint = 4;array[1].yPoint = 5;
            array[2].xPoint = 4;array[2].yPoint = 9;
            array[3].xPoint = 3;array[3].yPoint = 4;
            array[4].xPoint = 3;array[4].yPoint = 6;
            array[5].xPoint = 3;array[5].yPoint = 8;
            array[6].xPoint = 3;array[6].yPoint = 10;
        }
        else{
            array[0].xPoint = 10;array[0].yPoint = 4;
            array[1].xPoint = 9;array[1].yPoint = 5;
            array[2].xPoint = 9;array[2].yPoint = 9;
            array[3].xPoint = 9;array[3].yPoint = 7;
            array[4].xPoint = 10;array[4].yPoint = 6;
            array[5].xPoint = 10;array[5].yPoint = 8;
            array[6].xPoint = 10;array[6].yPoint = 10;
        }
    }

    public void snake(PointNode[] array, String name, int xBase, int yBase){
        if(name=="正义"){
            array[3].xPoint = 4;
            array[3].yPoint = 7;
            for(int i = 0; i < array.length; i++){
                array[i].xPoint = array[3].xPoint;
                array[i].yPoint = array[3].yPoint + 3 - i;
            }
        }
        else{
            array[3].xPoint = 10;
            array[3].yPoint = 7;
            for(int i = 0; i < array.length; i++){
                array[i].xPoint = array[3].xPoint;
                array[i].yPoint = array[3].yPoint + 3 - i;
            }
        }
    }

    public void fish(PointNode[] array, String name, int xBase, int yBase){
        if(name=="正义"){
            array[0].xPoint = 2;array[0].yPoint = 7;
            array[1].xPoint = 3;array[1].yPoint = 5;
            array[2].xPoint = 3;array[2].yPoint = 7;
            array[3].xPoint = 3;array[3].yPoint = 9;
            array[4].xPoint = 4;array[4].yPoint = 6;
            array[5].xPoint = 4;array[5].yPoint = 8;
            array[6].xPoint = 5;array[6].yPoint = 7;
        }
        else{
            array[0].xPoint = 10;array[0].yPoint = 5;
            array[1].xPoint = 10;array[1].yPoint = 7;
            array[2].xPoint = 10;array[2].yPoint = 9;
            array[3].xPoint = 11;array[3].yPoint = 7;
            array[4].xPoint = 9;array[4].yPoint = 6;
            array[5].xPoint = 9;array[5].yPoint = 8;
            array[6].xPoint = 8;array[6].yPoint = 7;
        }
    }

    public void door(PointNode[] array, String name, int xBase, int yBase){
        if(name=="正义"){
            array[0].xPoint = 5;array[0].yPoint = 7;
            array[1].xPoint = 4;array[1].yPoint = 6;
            array[2].xPoint = 4;array[2].yPoint = 8;
            array[3].xPoint = 3;array[3].yPoint = 5;
            array[4].xPoint = 3;array[4].yPoint = 9;
            array[5].xPoint = 2;array[5].yPoint = 6;
            array[6].xPoint = 2;array[6].yPoint = 8;
        }
        else{
            array[0].xPoint = 9;array[0].yPoint = 6;
            array[1].xPoint = 9;array[1].yPoint = 8;
            array[2].xPoint = 10;array[2].yPoint = 5;
            array[3].xPoint = 8;array[3].yPoint = 7;
            array[4].xPoint = 10;array[4].yPoint = 9;
            array[5].xPoint = 11;array[5].yPoint = 6;
            array[6].xPoint = 11;array[6].yPoint = 8;
        }

    }

    public void moon(PointNode[] array, String name, int xBase, int yBase){
        if(name=="正义"){
            array[0].xPoint = 4;array[0].yPoint = 7;
            array[1].xPoint = 4;array[1].yPoint = 6;
            array[2].xPoint = 4;array[2].yPoint = 8;
            array[3].xPoint = 5;array[3].yPoint = 5;
            array[4].xPoint = 5;array[4].yPoint = 9;
            array[5].xPoint = 3;array[5].yPoint = 7;
            array[6].xPoint = 2;array[6].yPoint = 7;
        }
        else{
            array[0].xPoint = 8;array[0].yPoint = 6;
            array[1].xPoint = 8;array[1].yPoint = 8;
            array[2].xPoint = 7;array[2].yPoint = 5;
            array[3].xPoint = 8;array[3].yPoint = 7;
            array[4].xPoint = 7;array[4].yPoint = 9;
            array[5].xPoint = 9;array[5].yPoint = 7;
            array[6].xPoint = 10;array[6].yPoint = 7;
        }

    }

    public void arrow(PointNode[] array, String name, int xBase, int yBase){
        if(name=="正义"){
            array[0].xPoint = 5;array[0].yPoint = 7;
            array[1].xPoint = 4;array[1].yPoint = 6;
            array[2].xPoint = 4;array[2].yPoint = 8;
            array[3].xPoint = 4;array[3].yPoint = 7;
            array[4].xPoint = 3;array[4].yPoint = 7;
            array[5].xPoint = 2;array[5].yPoint = 7;
            array[6].xPoint = 1;array[6].yPoint = 7;
        }
        else{
            array[0].xPoint = 8;array[0].yPoint = 6;
            array[1].xPoint = 8;array[1].yPoint = 8;
            array[2].xPoint = 8;array[2].yPoint = 7;
            array[3].xPoint = 7;array[3].yPoint = 7;
            array[4].xPoint = 9;array[4].yPoint = 7;
            array[5].xPoint = 10;array[5].yPoint = 7;
            array[6].xPoint = 11;array[6].yPoint = 7;
        }
    }
}
