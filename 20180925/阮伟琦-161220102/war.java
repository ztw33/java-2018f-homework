enum colours{red,orange,yellow,green,cyan,blue,purple}

public class war {
    public static void main(String[] args)
    {
        battlefield bf = new battlefield();
        bf.initialize();
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
        bf.print();
    }
}


class human {
    java.lang.String name;
    char code;
    //int no;
    //colours colour;
    int row;
    int col;
}

class stggc_student extends human
{
    /*private TEAM ;
    enum SGTTC{
        darjeeling("darjeeling", colours.red);// assam

        private java.lang.String name;
        private colours colour;

        TEAM(java.lang.String name, colours colour)
        {
            this.colour = colour;
            this.name = name;
        }
    }*/
    private TEAM team;
    enum TEAM{
        //FIRST("老大", colours.red), SECOND("老二", colours.orange), THIRD("老三", "黄色"),
       //FORTH("老四", "绿色"), FIFTH("老五","青色"), SIXTH("老六", "蓝色"), SEVENTH("老七", "紫色");
        darjeeling("darjeeling", colours.red), assam("assam", colours.yellow),
        orange_pekoe("orange pekoe", colours.orange), rose_hip("rose hip", colours.green),
        rukuriri("rukuriri", colours.cyan), hurb("hurb", colours.blue),
        cranberry("cranberry", colours.purple);

        private java.lang.String name;
        private colours colour;

        TEAM(java.lang.String name, colours colour)
        {
            this.colour = colour;
            this.name = name;
        }
    }
    colours colour;
}

class shimada extends human
{
    void do_nothing(){};
}

class university_student extends human
{
    university_student()
    {
        this.code = 'U';
    }
}

class unit
{
    boolean is_occupied;
    human people;
    unit()
    {
        is_occupied = false;
        //people = new human();
    }
}

class battlefield
{
    unit[][] field = new unit[17][17];
    unit[][] oldfield = new unit[17][17];

    stggc_student[] stggc_members;
    stggc_student oral_gray = new stggc_student();
    shimada alice = new shimada();
    shimada kasam = new shimada();
    university_student[] university_members;
    //field = new human
    void initialize() {
        for (int i = 0; i < 17; i++)
            for (int j = 0; j < 17; j++)
                field[i][j] = new unit();

        for (int i = 0; i < 17; i++)
            for (int j = 0; j < 17; j++)
                oldfield[i][j] = new unit();

        stggc_members = new stggc_student[7];
        //stggc_members[0].no = 1;
        for (int i = 0; i < 7; i++)
            stggc_members[i] = new stggc_student();
        stggc_members[0].name = "darjeeling";
        stggc_members[0].colour = colours.red;
        stggc_members[0].code = 'D';
        stggc_members[1].name = "assam";
        stggc_members[1].colour = colours.orange;
        stggc_members[2].name = "orange pekoe";
        stggc_members[2].colour = colours.yellow;
        stggc_members[3].name = "rose hip";
        stggc_members[3].colour = colours.green;
        stggc_members[4].name = "rukuriri";
        stggc_members[4].colour = colours.cyan;
        stggc_members[5].name = "hurb";
        stggc_members[5].colour = colours.blue;
        stggc_members[6].name = "cranberry";
        stggc_members[6].colour = colours.purple;
        stggc_members[1].code = 'A';
        stggc_members[2].code = 'O';
        stggc_members[3].code = 'R';
        stggc_members[4].code = 'K';
        stggc_members[5].code = 'H';
        stggc_members[6].code = 'C';
        alice.name = "alice";
        alice.code = 'E';
        kasam.name = "chiyo";
        kasam.code = 'Y';
        oral_gray.name = "oral gray";
        oral_gray.code = 'G';
        university_members = new university_student[6];
        for(int i = 0; i < 6; i++)
          university_members[i] = new university_student();
    }

    void cheer()
    {
        field[1][0].is_occupied = true;
        field[1][0].people = oral_gray;
        field[1][16].is_occupied = true;
        field[1][16].people = kasam;
    }

    //变换阵型之前要先记录当前阵型
    void stggc_snaketype()
    {
        for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }
        for(int i = 5; i < 12; i++)
        {
            field[i][0].is_occupied = true;
            field[i][0].people = stggc_members[i - 5];
        }

        //field[0][1].people = stggc_members[0];
    }

    void university_snaketype()
    {
        for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }
        field[5][16].is_occupied = true;
        field[5][16].people = alice;
       for(int i = 6; i < 12; i++)
       {
           field[i][16].is_occupied = true;
           field[i][16].people = university_members[i - 6];
       }
    }

    void cranewingtype()
    {
        for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }
        for(int i = 7; i < 10; i++)
        {
            field[i][i + 3].people = university_members[i - 7];
            field[i][i + 3].is_occupied = true;
        }
        for(int i = 14; i < 17; i++)
        {
            field[23 - i][i].people = university_members[i - 11];
            field[23 - i][i].is_occupied = true;
        }
        field[10][13].people = alice;
        field[10][13].is_occupied = true;
    }

    void gooseflyingtype()
    {
        for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }
        field[11][10].is_occupied = true;
        field[11][10].people = alice;
        for(int i = 11; i < 17; i++)
        {
            field[21 - i][i].is_occupied = true;
            field[21 - i][i].people = university_members[i - 11];
        }
    }

    void horizontalwheeltype()
    {
        for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }
        field[5][15].is_occupied = true;
        field[5][15].people = alice;
        for(int i = 7; i < 12; i+=2)
        {
            field[i][15].is_occupied = true;
            field[i][15].people = university_members[i - 7];
        }
        for(int i = 6; i < 11; i+=2)
        {
            field[i][16].is_occupied = true;
            field[i][16].people = university_members[i - 5];
        }
    }

    void arrowtype()
    {
        for(int i = 0; i < 17; i++)
        {
            oldfield[i][0].is_occupied = field[i][0].is_occupied;
            oldfield[i][0].people = field[i][0].people;
        }
        field[6][14].is_occupied = true;
        field[6][14].people = alice;
        field[7][13].is_occupied = true;
        field[7][13].people = university_members[0];
        field[7][15].is_occupied = true;
        field[7][15].people = university_members[1];
        field[8][12].is_occupied = true;
        field[8][12].people = university_members[2];
        field[8][14].is_occupied = true;
        field[8][14].people = university_members[3];
        field[8][16].is_occupied = true;
        field[8][16].people = university_members[4];
        field[9][14].is_occupied = true;
        field[9][14].people = university_members[5];

    }

    void restart()
    {
        for (int i = 0; i < 17; i++)
            for (int j = 0; j < 17; j++)
                field[i][j].is_occupied = false;
    }

    void print()
    {
        for(int i = 0; i < 17; i++)
            for(int j = 0; j < 17; j++)
                if(!field[i][j].is_occupied && j != 16)
                    System.out.print(' ');
                else if(!field[i][j].is_occupied && j == 16)
                    System.out.println(' ');
                else if(field[i][j].is_occupied && j != 16)
                    System.out.print(field[i][j].people.code);
                else
                    System.out.println(field[i][j].people.code);
    }
}

