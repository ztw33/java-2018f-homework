package com.company.Formation;
import java.util.*;
import com.company.BattleField.BattleField;
import com.company.Being.Minion;
import com.company.Being.CalabashBrother;

public class FengShi implements Formation {
    public void setBeing(BattleField field, CalabashBrother[] brother){
        field.battlefield[12][2].being=brother[0];
        field.battlefield[12][2].isEmpty=false;

        field.battlefield[11][1].being=brother[1];
        field.battlefield[11][1].isEmpty=false;

        field.battlefield[13][1].being=brother[2];
        field.battlefield[13][1].isEmpty=false;

        field.battlefield[12][1].being=brother[3];
        field.battlefield[12][1].isEmpty=false;

        field.battlefield[14][0].being=brother[4];
        field.battlefield[14][0].isEmpty=false;

        field.battlefield[10][0].being=brother[5];
        field.battlefield[10][0].isEmpty=false;

        field.battlefield[12][0].being=brother[6];
        field.battlefield[12][0].isEmpty=false;
    }
    public void setBeing(BattleField field, Minion[] minion){
        field.battlefield[12][19].being=minion[0];
        field.battlefield[12][19].isEmpty=false;

        field.battlefield[11][20].being=minion[1];
        field.battlefield[11][20].isEmpty=false;

        field.battlefield[12][20].being=minion[2];
        field.battlefield[12][20].isEmpty=false;

        field.battlefield[13][20].being=minion[3];
        field.battlefield[13][20].isEmpty=false;

        field.battlefield[10][21].being=minion[4];
        field.battlefield[10][21].isEmpty=false;

        field.battlefield[12][21].being=minion[5];
        field.battlefield[12][21].isEmpty=false;

        field.battlefield[14][21].being=minion[6];
        field.battlefield[14][21].isEmpty=false;

        field.battlefield[9][22].being=minion[7];
        field.battlefield[9][22].isEmpty=false;

        field.battlefield[12][22].being=minion[8];
        field.battlefield[12][22].isEmpty=false;

        field.battlefield[15][22].being=minion[9];
        field.battlefield[15][22].isEmpty=false;

        field.battlefield[12][23].being=minion[10];
        field.battlefield[12][23].isEmpty=false;

        field.battlefield[12][24].being=minion[11];
        field.battlefield[12][24].isEmpty=false;
    }
}

