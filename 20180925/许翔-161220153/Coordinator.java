public class Coordinator {
    public static void main(String[] args){
        int mapSize = 20;
        Map map = new Map(mapSize);
        CalabashBros[] calabashBros = { new CalabashBros(0),
                                        new CalabashBros(1),
                                        new CalabashBros(2),
                                        new CalabashBros(3),
                                        new CalabashBros(4),
                                        new CalabashBros(5),
                                        new CalabashBros(6),
        };
        GrandFather grandFather = new GrandFather();
        Snake snake = new Snake();
        Scorpion scorpion = new Scorpion();
        Underling[] underling = { new Underling(0),
                                  new Underling(1),
                                  new Underling(2),
                                  new Underling(3),
                                  new Underling(4),
                                  new Underling(5),
                                  new Underling(6),
        };
        Creature[] badGuys = new Creature[underling.length+1];
        badGuys[0] = scorpion;
        System.arraycopy(underling, 0, badGuys, 1, underling.length);
        Formation.ChangShe(calabashBros, 8, 10, "Left", map);
        grandFather.cheer(map);
        Formation.FengShi(badGuys, 11, 10, "Right", map);
        snake.cheer(map);
        map.printWholeMap();
        System.out.println("***** Change the formation. *****");
        map.clearHalfMap("Right");
        Formation.FangYuan(badGuys, 11, 10, "Right", map);
        snake.cheer(map);
        map.printWholeMap();
    }
}
