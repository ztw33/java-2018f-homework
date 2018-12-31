package com.company.Formation;
import java.util.*;
import com.company.BattleField.BattleField;
import com.company.Being.Minion;
import com.company.Being.CalabashBrother;

public class FangYuan implements Formation {
    public void setBeing(BattleField field, CalabashBrother[] brother){
        field.battlefield[12][4].being=brother[0];
        field.battlefield[12][4].isEmpty=false;

        field.battlefield[11][3].being=brother[1];
        field.battlefield[11][3].isEmpty=false;

        field.battlefield[133][3].being=brother[2];
        field.battlefield[13][3].isEmpty=false;

        field.battlefield[10][2].being=brother[3];
        field.battlefield[10][2].isEmpty=false;

        field.battlefield[14][2].being=brother[4];
        field.battlefield[14][2].isEmpty=false;

        field.battlefield[11][1].being=brother[5];
        field.battlefield[11][1].isEmpty=false;

        field.battlefield[13][1].being=brother[6];
        field.battlefield[13][1].isEmpty=false;
    }
    public void setBeing(BattleField field, Minion[] minion){
        field.battlefield[12][24].being = minion[0];
        field.battlefield[12][24].isEmpty=false;

        field.battlefield[11][23].being = minion[1];
        field.battlefield[11][23].isEmpty=false;

        field.battlefield[13][23].being = minion[2];
        field.battlefield[13][23].isEmpty=false;

        field.battlefield[10][23].being = minion[3];
        field.battlefield[10][23].isEmpty=false;

        field.battlefield[14][22].being = minion[4];
        field.battlefield[14][22].isEmpty=false;

        field.battlefield[11][21].being = minion[5];
        field.battlefield[11][21].isEmpty=false;

        field.battlefield[13][21].being = minion[6];
        field.battlefield[13][21].isEmpty=false;

        field.battlefield[12][20].being = minion[7];
        field.battlefield[12][20].isEmpty=false;


    }
}