import java.util.*;
class Monsters extends Creature{
    public Monsters(String c) {
        super(c);
    }
}
class Snake extends Creature {
    public Snake() {
        super("*Éß¾«*");
    }

    public void changeLine(Line line, Monsters[] monsters, String[][] ground, int num) {
        switch (num) {
            case 1: {
                System.out.println("º×Òí");
                line.Heyi(monsters, ground);
                break;
            }
            case 2: {
                System.out.println("ÑãĞĞ");
                line.Yanxing(monsters, ground);
                break;
            }
            case 3: {
                System.out.println("³åéî");
                line.Chonge(monsters, ground);
                break;
            }
            case 4: {
                System.out.println("ÓãÁÛ");
                line.Yulin(monsters, ground);
                break;
            }
            case 5: {
                System.out.println("·½ƒÒ");
                line.Fangyuan(monsters, ground);
                break;
            }
            case 6: {
                System.out.println("ÙÈÔÂ");
                line.Yanyue(monsters, ground);
                break;
            }
            case 7: {
                System.out.println("·æÊ¸");
                line.Fengshi(monsters, ground);
                break;
            }
        }

    }
}


