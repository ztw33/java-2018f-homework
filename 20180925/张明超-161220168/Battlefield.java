import java.util.*;
public class Battlefield {
    public Battlefield() {
        field = new Creature[width*height];
        for (int i = 0; i < field.length; i++){
            field[i] = null;
        }
    }
    public void setBattlefield(int x, Creature toStandOn){
        field[x] = toStandOn;
    }
    public void setBattlefield(int x, int y, Creature toStandOn){
        field[x*width+y] = toStandOn;
    }
    public void printField(){
        for (int i = 0; i < field.length; i++){
            if(i%width == 0){
                System.out.print("|\n");
            }
            if(field[i]!= null){
                field[i].toldCreature();
            }
            else{
                System.out.print("|      ");
            }
        }
    }
    private int index;
    private int width = 20;
    private int height = 8;
    private Creature[] field;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public static void main(String[] args){
        Battlefield field = new Battlefield();
        CalabashGroup Calabashs = new CalabashGroup();
        Calabashs.shuffle();
        Calabashs.print();
        Calabashs.getQuickSort().sort(Calabashs.getRank());
        Calabashs.print();
        EnemyGroup enemys = new EnemyGroup();
        Formation formation = new Formation();
        Snake snake = new Snake();
        Grandfather grandfather = new Grandfather();
        field.setBattlefield(4, 0, grandfather);
        field.setBattlefield(4, 19, snake);
        formation.formationCreatrue(field, 3, Calabashs.getFormationCreatrue(), 2);
        Random rand = new Random() ;
        for(int i = 0; i < 6;i++) {
            int index = rand.nextInt(8);
            if(index == 3){
                index ++;
            }
            formation.formationCreatrue(field, index, enemys.getFormationCreatrue(), 1);
            field.printField();
        }
    }
}

