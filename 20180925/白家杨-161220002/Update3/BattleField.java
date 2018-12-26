package Update3;

import Update3.Creature.*;
import Update3.UI;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class BattleField{
    private UI ui;
    final int row = 15;
    final int col = 20;
    private Object[][] map;
    public BattleField(UI u){
        ui = u;
        map = new Object[row][col];
        InitBattleFile();
    }
    public void SetCreature(int i, int j, Object object){
        if(map[i][j] instanceof Rock){
            Identity id = (Identity)object;
            if(id.Identity().equals("Grass"))
                return;
        }
        map[i][j] = object;
        ui.SetCreature(i, j, object);
    }
    public void AppendText(String s){
        ui.AppendText(s);
        System.out.println(s);
    }
    public void InitBattleFile(){
        File filename = new File("src/Picture/rock.txt");
        if(filename.exists()) {
            try{
                BufferedReader buffreader = new BufferedReader(new FileReader(filename));
                String Line;
                while((Line = buffreader.readLine()) != null){
                    String[] sp = Line.split(",");
                    int i = Integer.parseInt(sp[0]);
                    int j = Integer.parseInt(sp[1]);
                    map[i][j] = new Rock();
                }
            }catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }

    public Object GetObject(int i, int j){
        return map[i][j];
    }
}
