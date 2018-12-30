package com.company.Formation;
import java.util.*;
import com.company.BattleField.BattleField;
import com.company.Being.Minion;
import com.company.Being.CalabashBrother;
public class YanYue implements Formation{
    public void setBeing(BattleField field, CalabashBrother[] brother){
        field.battlefield[11][0].being=brother[0];
        field.battlefield[11][0].isEmpty=false;

        field.battlefield[12][0].being=brother[1];
        field.battlefield[12][0].isEmpty=false;

        field.battlefield[13][0].being=brother[2];
        field.battlefield[13][0].isEmpty=false;

        field.battlefield[10][1].being=brother[3];
        field.battlefield[10][1].isEmpty=false;

        field.battlefield[14][1].being=brother[4];
        field.battlefield[14][1].isEmpty=false;

        field.battlefield[9][2].being=brother[5];
        field.battlefield[9][2].isEmpty=false;

        field.battlefield[15][2].being=brother[6];
        field.battlefield[15][2].isEmpty=false;
    }
    public void setBeing(BattleField field, Minion[] minion){
        field.battlefield[11][21].being=minion[0];
        field.battlefield[11][21].isEmpty=false;

        field.battlefield[12][21].being=minion[1];
        field.battlefield[12][21].isEmpty=false;

        field.battlefield[13][21].being=minion[2];
        field.battlefield[13][21].isEmpty=false;

        field.battlefield[10][22].being=minion[3];
        field.battlefield[10][22].isEmpty=false;

        field.battlefield[11][22].being=minion[4];
        field.battlefield[11][22].isEmpty=false;

        field.battlefield[12][22].being=minion[5];
        field.battlefield[12][22].isEmpty=false;

        field.battlefield[13][22].being=minion[6];
        field.battlefield[13][22].isEmpty=false;

        field.battlefield[14][22].being=minion[7];
        field.battlefield[14][22].isEmpty=false;

        field.battlefield[10][23].being=minion[8];
        field.battlefield[10][23].isEmpty=false;

        field.battlefield[14][23].being=minion[9];
        field.battlefield[14][23].isEmpty=false;

        field.battlefield[9][24].being=minion[10];
        field.battlefield[9][24].isEmpty=false;

        field.battlefield[15][24].being=minion[12];
        field.battlefield[15][24].isEmpty=false;
    }
}
