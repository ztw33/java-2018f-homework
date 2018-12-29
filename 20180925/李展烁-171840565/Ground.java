import java.util.Random;

public class Ground implements MoveDevice, ViewDvice{
    private Creature ground[][];
    private Formation formation;
    public void moveMethod(int x1, int y1, int x2, int y2){
        Creature temp = ground[x1][y1];
        ground[x1][y1] = ground[x2][y2];
        ground[x2][y2] = temp;
    }

    Ground(int length, int width){
        ground = new Creature[width][length];
        GourdBoys gourdBoys[] = {GourdBoys.老大,GourdBoys.老三,GourdBoys.老七,GourdBoys.老六,GourdBoys.老四,GourdBoys.老二,GourdBoys.老五};
        for(int i=0;i<gourdBoys.length;i++){
            gourdBoys[i].setMoveDevice(this);
        }
        Goblins goblins[] = new Goblins[7];
        for(int i=0;i<goblins.length;i++){
            goblins[i] = new Goblins();
            goblins[i].setMoveDevice(this);
        }
        Scorpion scorpion = new Scorpion();
        scorpion.setMoveDevice(this);
        Snake snake = new Snake();
        snake.setMoveDevice(this);
        snake.setViewDevice(this);
        Grandpa grandpa = new Grandpa();
        grandpa.setMoveDevice(this);
        grandpa.setViewDevice(this);

        for(int i=3+gourdBoys.length+goblins.length; i<ground.length;i++){
            ground[0][i]=new Air();
        }
        for(int i = 0; i < ground.length; i++){
            for(int j = 0; j < ground[0].length; j++){
                ground[i][j] = new Air();
            }
        }
        ground[0][0] = grandpa;
        ground[0][1] = snake;
        ground[0][2] = scorpion;
        for(int i = 0; i < gourdBoys.length; i++){
            ground[0][3+i]=gourdBoys[i];
        }
        for(int i = 0; i < goblins.length; i++){
            ground[0][3+gourdBoys.length+i]=goblins[i];
        }

        randomArrange();

    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    @Override
    public void viewMethod() {
        for(Creature[] a : ground){
            for(Creature c : a){
                c.print();
            }
            System.out.print("\n");
        }
    }

    public void show(){
        for(Creature[] a : ground){
            for(Creature c : a){
                c.print();
            }
            System.out.print("\n");
        }
    }
    private void randomArrange (){
        Random random = new Random();
        for(int i = 0; i < ground.length; i++){
            int posx = random.nextInt(ground.length);
            for(int j = 0; j < ground[i].length; j++){
                int posy = random.nextInt(ground[i].length);
                moveMethod(posx,posy,i,j);
            }
        }
    }
    public void fallIn(){
        for(int i = 0; i < ground.length; i++){
            for(int j = 0; j < ground[0].length; j++){
                String temp = ground[i][j].getClass().getName();
                if(temp=="Snake"){
                    ((Leader)ground[i][j]).move(i,j,ground.length-1,ground[0].length*2/3);
                    ((Leader)ground[ground.length-1][ground[0].length*2/3]).setOrderDevice(formation);
                }
                if(temp=="Grandpa"){
                    ((Leader)ground[i][j]).move(i,j,ground.length-1,ground[0].length/3);
                    ((Leader)ground[ground.length-1][ground[0].length/3]).setOrderDevice(formation);
                }
            }
        }

    }

    public int getLength() {
        return ground.length;
    }

    public int getWidth() {
        return ground[0].length;
    }

    public Creature getCreature(int i, int j){return ground[i][j];}

    public Snake getSnake(){
        return (Snake)ground[ground.length-1][ground[0].length*2/3];
    }
    public Grandpa getGrandpa(){
        return (Grandpa)ground[ground.length-1][ground[0].length/3];
    }
}
