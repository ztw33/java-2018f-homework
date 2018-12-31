package gup;

public class battlefield
{
    private unit[][] field;// = new unit[17][17];
    public battlefield()
    {
        field = new unit[17][17];
        for (int i = 0; i < 17; i++)
            for (int j = 0; j < 17; j++)
                field[i][j] = new unit();
    }
    //unit[][] oldfield = new unit[17][17];
    /*private stggc_teammember[] stggc_members;
    private stggc_student oral_gray;// = new stggc_teammember();
    private shimada_alice alice;// = new shimada_alice();
    private shimada_chiyo kasam;// = new shimada_chiyo();
    private university_student[] university_members;*/

    //field = new human
    /*public battlefield()
    {
        alice = new shimada_alice();
        kasam = new shimada_chiyo();
        oral_gray = new stggc_student("oral gray", 'G');


        /*for (int i = 0; i < 17; i++)
            for (int j = 0; j < 17; j++)
                oldfield[i][j] = new unit();*/

        //stggc_members = new stggc_teammember[7];
        //stggc_members[0].no = 1;
        /*for (int i = 0; i < 7; i++)
            stggc_members[i] = new stggc_teammember();

        stggc_members[0].name = "darjeeling";
        stggc_members[0].colour = colours.red;
        stggc_members[1].name = "assam";
        stggc_members[1].colour = colours.orange;
        stggc_members[2].name = "orange pekoe";
        stggc_members[2].colour = colours.yellow;
        stggc_members[3].name = "rose hip";
        stggc_members[3].colour = colours.green;
        stggc_members[4].name = "rukuriri";
        stggc_members[4].colour = colours.cyan;
        stggc_members[5].name = "herb";
        stggc_members[5].colour = colours.blue;
        stggc_members[6].name = "cranberry";
        stggc_members[6].colour = colours.purple;
        stggc_members[0].code = 'D';
        stggc_members[1].code = 'A';
        stggc_members[2].code = 'O';
        stggc_members[3].code = 'R';
        stggc_members[4].code = 'K';
        stggc_members[5].code = 'H';
        stggc_members[6].code = 'C';*/
        /*stggc_members[0] = new stggc_teammember("darjeeling", 'D', colours.red);
        stggc_members[1] = new stggc_teammember("orange pekoe", 'O', colours.orange);
        stggc_members[2] = new stggc_teammember("assam", 'A', colours.yellow);
        stggc_members[3] = new stggc_teammember("rose hip", 'R', colours.green);
        stggc_members[4] = new stggc_teammember("rukuriri", 'K', colours.cyan);
        stggc_members[5] = new stggc_teammember("herb", 'H', colours.blue);
        stggc_members[6] = new stggc_teammember("cranberry", 'C', colours.purple);*/
        /*alice.name = "alice";
        alice.code = 'E';
        kasam.name = "chiyo";
        kasam.code = 'Y';
        oral_gray.name = "oral gray";
        oral_gray.code = 'G';*/
        /*university_members = new university_student[6];
        for(int i = 0; i < 6; i++)
            university_members[i] = new university_student();
    }*/



    /*void cheer()
    {
        field[1][0].is_occupied = true;
        field[1][0].people = oral_gray;
        field[1][16].is_occupied = true;
        field[1][16].people = kasam;
    }*/

    //变换阵型之前要先记录当前阵型
    //this has been abandoned in the second time to modify

    public unit[][] getfield()
    {
        return field;
    }

    public void restart()
    {
        for (int i = 0; i < 17; i++)
            for (int j = 0; j < 17; j++)
                field[i][j].is_occupied = false;
        for(int i = 0; i < 17; i++)
            System.out.print('-');
        System.out.println(' ');
    }

    public void print()
    {
        for(int i = 0; i < 17; i++)
            for(int j = 0; j < 17; j++)
                if(!field[i][j].is_occupied && j != 16)
                    System.out.print(' ');
                else if(!field[i][j].is_occupied && j == 16)
                    System.out.println(' ');
                else if(field[i][j].is_occupied && j != 16)
                    System.out.print(field[i][j].people.getcode());
                else
                    System.out.println(field[i][j].people.getcode());
    }
}
