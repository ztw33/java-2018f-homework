package njucs.java2018;

public class Formation {
    private String name;
    public Position leader;
    public Position[] Relpos;
    //7*7的方块中演练阵型
    Formation(String name) {
        this.name = name;
        switch(name) {
            case "鶴翼":
                Relpos = new Position[]{new Position(1,0),
                        new Position(2,1),
                        new Position(3,2),
                        new Position(4,3),
                        new Position(3,4),
                        new Position(2,5),
                        new Position(1,6)};
                break;
            case "雁行":
                Relpos = new Position[]{new Position(6,0),
                        new Position(5,1),
                        new Position(4,2),
                        new Position(3,3),
                        new Position(2,4),
                        new Position(1,5),
                        new Position(0,6)};
                break;
            case "長蛇":
                Relpos = new Position[]{new Position(0,3),
                        new Position(1,3),
                        new Position(2,3),
                        new Position(3,3),
                        new Position(4,3),
                        new Position(5,3),
                        new Position(6,3)};
                break;
            case "衡轭":
                Relpos = new Position[]{new Position(1,2),
                        new Position(0,3),
                        new Position(3,2),
                        new Position(2,3),
                        new Position(5,2),
                        new Position(4,3),
                        new Position(6,3)};
                break;
            case "偃月":
                Relpos = new Position[]{new Position(3,1),
                        new Position(2,2),
                        new Position(4,2),
                        new Position(1,3),
                        new Position(5,3),
                        new Position(0,4),
                        new Position(6,4)};
                break;
            default: System.out.println("蝎子精还不会这种阵型");
        }
    }
}
