package creature;
import IO.BufferedInputFile;
import formation.*;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

public class Snake extends Leader implements Creature{

    private Position position;
    private String name;

    public Snake(String name){
        this.name = name;
    }

    public void setPosition(Position t){
        position = t;
    }

    public Position getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public void support(){}
    public void check_S_formation(List<Soldier> soldier, String formation){
        switch(formation){
            case "Line": {
                Formation f = new Line();
                f.form_S_formation(soldier);
                break;
            }
            case "Arrow":{
                Formation f = new Arrow();
                f.form_S_formation(soldier);
                break;
            }
            case "Goose":{
                Formation f = new Goose();
                f.form_S_formation(soldier);
                break;
            }
        }
    }

    @Override
    public void check_S_Random_formation(List<Soldier> x, int num, Scorpion scorpion) throws IOException{
        Formation f = new Formation();
        BufferedInputFile input;
        switch(num){
            case 15:{
                input = new BufferedInputFile("E:\\zmy\\大三上\\java程序设计\\src\\formation\\henge.txt");
                input.setIn();
                f.form_S_Random_formation(x,input,scorpion);                           //直接根据IO画出阵型图
                break;
            }
            case 16:{
                input = new BufferedInputFile("E:\\zmy\\大三上\\java程序设计\\src\\formation\\Arrow.txt");
                input.setIn();
                f.form_S_Random_formation(x,input,scorpion);         //直接根据IO画出阵型图
                break;
            }
            case 17:{
                input = new BufferedInputFile("E:\\zmy\\大三上\\java程序设计\\src\\formation\\crane.txt");
                input.setIn();
                f.form_S_Random_formation(x,input,scorpion);         //直接根据IO画出阵型图
                break;
            }
            case 18:{
                input = new BufferedInputFile("E:\\zmy\\大三上\\java程序设计\\src\\formation\\scale.txt");
                input.setIn();
                f.form_S_Random_formation(x,input,scorpion);                           //直接根据IO画出阵型图
                break;
            }
            case 19:{
                input = new BufferedInputFile("E:\\zmy\\大三上\\java程序设计\\src\\formation\\door.txt");
                input.setIn();
                f.form_S_Random_formation(x,input,scorpion);                           //直接根据IO画出阵型图
                break;
            }
            case 20:{
                input = new BufferedInputFile("E:\\zmy\\大三上\\java程序设计\\src\\formation\\goose.txt");
                input.setIn();
                f.form_S_Random_formation(x,input,scorpion);                           //直接根据IO画出阵型图
                break;
            }
            default:{
                input = new BufferedInputFile("E:\\zmy\\大三上\\java程序设计\\src\\formation\\moon.txt");
                input.setIn();
                f.form_S_Random_formation(x,input,scorpion);                           //直接根据IO画出阵型图
                break;
            }
        }
    }

    public void check_C_formation(List<CalabashBrother> soldier, String formation){}
    @Override
    public String toString(){
        return name;
    }
}
