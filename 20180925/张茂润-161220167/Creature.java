package Homework3;

public class Creature {
    protected int x, y;
    protected int group;

    Creature(){
        x = 0;
        y = 0;
        group = 0;
    }
    public void move(int x, int y, Ground g){
        g.set(this.x, this.y, 0);
        g.set(x, y, group);
    }
}
enum Color{
    RED, ORANGE, YELLOW, GREEN, WATHET, BLUE, PURPLE,
}

class HuluBro extends Creature{
    private Color c;
    private String name;

    HuluBro(Color c, Ground g){
        this.c = c;
        switch(c){
            case RED : name = "老大"; group = 1; break;
            case ORANGE : name = "老二"; group = 2; break;
            case YELLOW : name = "老三"; group = 3; break;
            case GREEN : name = "老四"; group = 4; break;
            case WATHET : name = "老五"; group = 5; break;
            case BLUE : name = "老六"; group = 6; break;
            case PURPLE : name = "老七"; group = 7; break;
            default: break;
        }
        int size = g.getSize();
        x = (int)(1 + Math.random()*size) - 1;
        y = (int)(1 + Math.random()*size) - 1;
        while(g.getInfo(x, y) != 0){
            x = (int)(1 + Math.random()*size) - 1;
            y = (int)(1 + Math.random()*size) - 1;
        }
        move(x, y, g);
    }
}

class Grandpa extends Creature implements Formation{
    private HuluBro queue[] = new HuluBro[7];

    Grandpa(Ground g){
        group = 8;
        for(int i = 0; i < 7; i++){
            switch(i){
                case 0: queue[i] = new HuluBro(Color.RED, g); break;
                case 1: queue[i] = new HuluBro(Color.ORANGE, g); break;
                case 2: queue[i] = new HuluBro(Color.YELLOW, g); break;
                case 3: queue[i] = new HuluBro(Color.GREEN, g); break;
                case 4: queue[i] = new HuluBro(Color.WATHET, g); break;
                case 5: queue[i] = new HuluBro(Color.BLUE, g); break;
                case 6: queue[i] = new HuluBro(Color.PURPLE, g); break;
                default : break;
            }
        }
    }

    public void wing(Ground g){

    }// class 1
    public void goose(Ground g){

    }    // class 2
    public void yoke(Ground g){

    }     // class 3
    public void longSnake(Ground g){
        int size = g.getSize();
        this.x = 0;
        this.y = size/2;
        g.set(this.x, this.y , this.group);

        for(int i = 0; i < 7; i++){
            int x = (int)(0.3 * size);
            int y = (size- 7)/2 + i + 1;
            queue[i].move(x, y, g);
            //g.set(queue[i].x, queue[i].y, queue[i].group);
        }
    }// class 4
    public void scale(Ground g){

    }    // class 5
    public void square(Ground g){

    }   // class 6
    public void moon(Ground g){

    }     // class 7
    public void arrow(Ground g){

    }   // class 8
}

class Snake extends Creature{
    Snake(){
        group = -1;
    }
}

class Scorpion extends Creature implements Formation{
    protected int SlimeQuantity;
    Scorpion(){
        SlimeQuantity = 0;
        group = -2;
    }
    public void wing(Ground g){
        int size = g.getSize();
        this.x = (int)(0.75*size);
        this.y = (int)(0.75*size);
        move(x, y, g);

        Slime queue[] = new Slime[6];
        for(int i = 0; i< 6; i++)
            queue[i] = new Slime();

        for(int i = 0; i < 3; i++){
            queue[i].move(x-1-i, y-1-i, g);
            queue[i+3].move(x+1+i, y-1-i, g);
        }

    }// class 1
    public void goose(Ground g){
        int size = g.getSize();
        this.x = (int)(0.75*size);
        this.y = (int)(size/2);
        move(x, y, g);

        Slime queue[] = new Slime[4];
        for(int i = 0; i< 4; i++)
            queue[i] = new Slime();

        for(int i = 0; i < 2; i++){
            queue[i].move(x+1+i, y-1-i, g);
            queue[i+2].move(x-1-i, y+1+i, g);
        }
    }    // class 2
    public void yoke(Ground g){
        int size = g.getSize();
        this.x = (int)(0.75*size);
        this.y = (int)(size/2);
        move(x, y, g);
        Slime queue[] = new Slime[5];
        for(int i = 0; i< 5; i++)
            queue[i] = new Slime();

        queue[0].move(x+1, y-3, g);
        queue[1].move(x, y-2, g);
        queue[2].move(x+1, y-1, g);
        queue[3].move(x+1, y+1, g);
        queue[4].move(x, y+2, g);
    }     // class 3
    public void longSnake(Ground g){

    }// class 4
    public void scale(Ground g){
        int size = g.getSize();
        this.x = (int)(0.75*size);
        this.y = (int)(size/2);
        move(x, y, g);
        Slime queue[] = new Slime[9];
        for(int i = 0; i< 9; i++)
            queue[i] = new Slime();

        queue[0].move(x, y-2, g);
        queue[1].move(x+1, y-1, g);
        queue[2].move(x-2, y, g);
        queue[3].move(x+2, y, g);
        queue[4].move(x-3, y+1, g);
        queue[5].move(x-1, y+1, g);
        queue[6].move(x+1, y+1, g);
        queue[7].move(x+3, y+1, g);
        queue[8].move(x, y+2, g);
    }    // class 5
    public void square(Ground g){
        int size = g.getSize();
        this.x = (int)(size/2);
        this.y = (int)(size/2);
        move(x, y, g);
        Slime queue[] = new Slime[7];
        for(int i = 0; i< 7; i++)
            queue[i] = new Slime();

        queue[0].move(x+1, y-1, g);
        queue[1].move(x+1, y+1, g);
        queue[2].move(x+2, y-2, g);
        queue[3].move(x+2, y+2, g);
        queue[4].move(x+3, y-1, g);
        queue[5].move(x+3, y+1, g);
        queue[6].move(x+4, y, g);
    }   // class 6
    public void moon(Ground g){
        int size = g.getSize();
        this.x = size/2 + 1;
        this.y = size/2;
        move(x, y, g);
        Slime queue[] = new Slime[16];
        for(int i = 0; i < 16; i++)
            queue[i] = new Slime();
        queue[0].move(x-1, y-1, g);
        queue[1].move(x, y-1, g);
        queue[2].move(x+1, y-1, g);
        queue[3].move(x-1, y, g);
        queue[4].move(x+1, y, g);
        queue[5].move(x-1, y+1, g);
        queue[6].move(x, y+1, g);
        queue[7].move(x+1, y+1, g);
        queue[8].move(x+1, y-2, g);
        queue[9].move(x+2, y-2, g);
        queue[10].move(x+2, y-3, g);
        queue[11].move(x+3, y-4, g);
        queue[12].move(x+1, y+2, g);
        queue[13].move(x+2, y+2, g);
        queue[14].move(x+2, y+3, g);
        queue[15].move(x+3, y+4, g);
    }     // class 7
    public void arrow(Ground g){
        int size = g.getSize();
        this.x = (int)(0.75*size);
        this.y = (int)(size/2)-3;
        move(x, y, g);
        Slime queue[] = new Slime[12];
        for(int i = 0; i< 12; i++)
            queue[i] = new Slime();

        queue[0].move(x-1, y+1, g);
        queue[1].move(x,y+1, g);
        queue[2].move(x+1, y+1, g);
        queue[3].move(x-2, y+2, g);
        queue[4].move(x,y+2, g);
        queue[5].move(x+2, y+2, g);
        queue[6].move(x-3, y+3, g);
        queue[7].move(x, y+3, g);
        queue[8].move(x+3, y+3, g);
        queue[9].move(x, y+4, g);
        queue[10].move(x, y+4, g);
        queue[11].move(x, y+5, g);
    }   // class 8
}

class Slime extends Creature{
    Slime(){
        group = -3;
    }
}
