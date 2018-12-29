package gup;
//import gup.*;
import gup.character.stggc.*;
import gup.colour.colours;
import gup.character.university.*;

public class war {
    public static void main(String[] args)
    {
        /*battlefield bf = new battlefield();
        //bf.initialize();
        bf.cheer();
        bf.stggc_snaketype();
        bf.university_snaketype();
        bf.print();
        bf.restart();
        bf.cheer();
        bf.stggc_snaketype();
        bf.cranewingtype();
        bf.print();
        bf.restart();
        bf.cheer();
        bf.stggc_snaketype();
        bf.gooseflyingtype();
        bf.print();
        bf.restart();
        bf.cheer();
        bf.stggc_snaketype();
        bf.horizontalwheeltype();
        bf.print();
        bf.restart();
        bf.cheer();
        bf.stggc_snaketype();
        bf.arrowtype();
        bf.print();*/
        battlefield bf = new battlefield();
        stggc_teammember[] stggc_members = new stggc_teammember[7];
        stggc_members[0] = new stggc_teammember("darjeeling", 'D', colours.red);
        stggc_members[1] = new stggc_teammember("orange pekoe", 'O', colours.orange);
        stggc_members[2] = new stggc_teammember("assam", 'A', colours.yellow);
        stggc_members[3] = new stggc_teammember("rose hip", 'R', colours.green);
        stggc_members[4] = new stggc_teammember("rukuriri", 'K', colours.cyan);
        stggc_members[5] = new stggc_teammember("herb", 'H', colours.blue);
        stggc_members[6] = new stggc_teammember("cranberry", 'C', colours.purple);
        stggc_student oral_gray = new stggc_student("oral gray", 'G');
        shimada_alice alice = new shimada_alice();// = new shimada_alice();
        shimada_chiyo kasam= new shimada_chiyo();
        university_student[] university_members = new university_student[6];
        for(int i = 0; i < 6; i++)
            university_members[i] = new university_student();
        stggc_members[0].snaketype(5,3,7, bf, stggc_members);
        alice.snaketype(5,14,7, bf,university_members);
        oral_gray.cheer(bf, 8,1,oral_gray);
        kasam.cheer(bf,8,16,kasam);
        bf.print();
        //bf.restart();
        //stggc_members[0].snaketype(5,3,7, bf, stggc_members);
        alice.cranewingtype(9,12,7,bf,alice,university_members);
        bf.print();
        alice.gooseflyingtype(5,14,7,bf,alice,university_members);
        bf.print();
        alice.horizontalwheeltype(5,13,7,bf,alice,university_members);
        bf.print();
        alice.arrowtype(6,12,7,bf,alice,university_members);
        bf.print();
    }
}