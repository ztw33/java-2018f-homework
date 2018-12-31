package calabash;

public class Control {
    private static Grandfather grandfather;
    private static Calabash []calabashes;
    private static Scorpion scorpion;
    private static Snake snake;
    private static Underling []underlings;
    private static Map map;
    public void changelocation(Map m, Creature c1, Location l){
        //Locate locat = c1.getlocate();
        m.creatureleave(c1.getlocate());
        m.setmap(c1, l);
        c1.setlocation(l);
    }
    public static void init(){
        //map
        map = new Map();

        //grandfather
        grandfather = new Grandfather("G", 0, 0);
        map.setmap(grandfather, new Location(0, 0));

        //calabash_brothers
        calabashes = new Calabash[7];
        int []order = {3,5,6,1,0,2,4};
        calabashes[0] = new Calabash("R", 0, 1, 1, order[0]);
        map.setmap(calabashes[0], new Location(1, 1));
        calabashes[1] = new Calabash("O", 1, 2, 2, order[1]);
        map.setmap(calabashes[1], new Location(2, 2));
        calabashes[2] = new Calabash("Y", 2, 3, 3, order[2]);
        map.setmap(calabashes[2], new Location(3, 3));
        calabashes[3] = new Calabash("g", 3, 4, 4, order[3]);
        map.setmap(calabashes[3], new Location(4, 4));
        calabashes[4] = new Calabash("b", 4, 5, 5, order[4]);
        map.setmap(calabashes[4], new Location(5, 5));
        calabashes[5] = new Calabash("i", 5, 6, 6, order[5]);
        map.setmap(calabashes[5], new Location(6, 6));
        calabashes[6] = new Calabash("v", 6, 7, 7, order[6]);
        map.setmap(calabashes[6], new Location(7, 7));

        //Scorpion
        scorpion = new Scorpion("s", new Location(8,9));
        map.setmap(scorpion, new Location(8, 9));

        //Snake
        snake = new Snake("S", 13, 7);
        map.setmap(snake, new Location(13, 7));

        //Underling
        underlings = new Underling[6];
        underlings[0] = new Underling("u", 0, new Location(14, 13));
        map.setmap(underlings[0], new Location(14, 13));
        underlings[1] = new Underling("u", 1, new Location(13, 12));
        map.setmap(underlings[1], new Location(13, 12));
        underlings[2] = new Underling("u", 2, new Location(12, 11));
        map.setmap(underlings[2], new Location(12, 11));
        underlings[3] = new Underling("u", 3, new Location(11, 10));
        map.setmap(underlings[3], new Location(11, 10));
        underlings[4] = new Underling("u", 4, new Location(10, 9));
        map.setmap(underlings[4], new Location(10, 9));
        underlings[5] = new Underling("u", 5, new Location(9, 8));
        map.setmap(underlings[5], new Location(9, 8));
    }
    public static void calabashessequence(){
        for(int i = 0; i < 7; i++){
            calabashes[i].changeorder(calabashes[i].getrank());
        }
    }
    public static void longsnake(){
        int location_x = 1;
        int location_y = 1;
        //Location startlocation = new Location(location_x ,location_y);
        for(int i = 0; i < 7; i++){
            map.creatureleave(calabashes[i].getlocate());
            calabashes[i].setlocation(new Location(location_x + i, location_y));
            map.setmap(calabashes[i], new Location(location_x + i, location_y));
        }
    }
    public static void cranewing(){
        int location_x = 7;
        int location_y = 10;

        map.creatureleave(scorpion.getlocate());
        scorpion.setlocation(new Location(location_x, location_y));
        map.setmap(scorpion, new Location(location_x, location_y));

        for(int i = 0; i < 3; i++){
            map.creatureleave(underlings[i].getlocate());
            underlings[i].setlocation(new Location(location_x - 1 - i, location_y - 1 - i));
            map.setmap(underlings[i], new Location(location_x - 1 - i, location_y - 1 - i));
        }

        for(int i = 0; i < 3; i++){
            map.creatureleave(underlings[i + 3].getlocate());
            underlings[i + 3].setlocation(new Location(location_x - 1 - i, location_y + 1 + i));
            map.setmap(underlings[i + 3], new Location(location_x - 1 - i, location_y + 1 + i));
        }
    }
    public static void gooseflying(){
        int location_x = 7;
        int location_y = 10;
        map.creatureleave(scorpion.getlocate());
        scorpion.setlocation(new Location(location_x, location_y));
        map.setmap(scorpion, new Location(location_x, location_y));
        for(int i = 0 ; i < 6; i++){
            location_x += 1;
            location_y -= 1;
            map.creatureleave(underlings[i].getlocate());
            underlings[i].setlocation(new Location(location_x, location_y));
            map.setmap(underlings[i], new Location(location_x, location_y));
        }
    }
    public static void sharpvow(){
        int start_x = 7;
        int start_y = 10;
        int location_x = start_x;
        int location_y = start_y;
        map.creatureleave(scorpion.getlocate());
        scorpion.setlocation(new Location(location_x, location_y));
        map.setmap(scorpion, new Location(location_x, location_y));
        for(int i = 0; i < 6; i++){
            if(i < 2){
                if(i == 0){
                    location_x += 1;
                }
                location_x += 2 * i;
                location_y -= 1;
            }
            else if(i < 4){
                if(i == 2){
                    location_x = start_x;
                    location_y = start_y;
                }
                location_x += 2;
            }
            else{
                if(i == 4){
                    location_x = start_x + 1;
                    location_y = start_y;
                }
                location_x += 2 * (i - 4);
                location_y += 1;
            }
            map.creatureleave(underlings[i].getlocate());
            underlings[i].setlocation(new Location(location_x, location_y));
            map.setmap(underlings[i], new Location(location_x, location_y));
        }
    }

    public static void henge(){
        int location_x = 3;
        int location_y = 10;

        map.creatureleave(scorpion.getlocate());
        scorpion.setlocation(new Location(location_x, location_y));
        map.setmap(scorpion, new Location(location_x, location_y));

        for(int i = 0; i < 6; i++){
            if(i % 2 == 0){
                location_x += 1;
                location_y -= 1;
            }
            else{
                location_x += 1;
                location_y += 1;
            }
            map.creatureleave(underlings[i].getlocate());
            underlings[i].setlocation(new Location(location_x, location_y));
            map.setmap(underlings[i], new Location(location_x, location_y));
        }
    }
    public static void main(String []args){

        init();
        map.printmap();

        calabashessequence();
        longsnake();
        cranewing();
        map.printmap();

        gooseflying();
        map.printmap();

        sharpvow();
        map.printmap();

        henge();
        map.printmap();

    }
}
