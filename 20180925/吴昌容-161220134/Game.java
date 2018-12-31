package environment;

import creature.*;

public class Game {
    public static void main(String[] args) {
        Battlefield world = new Battlefield(7);

        CalabashBrother[] huluwa = {
                new CalabashBrother(6),
                new CalabashBrother(3),
                new CalabashBrother(0),
                new CalabashBrother(2),
                new CalabashBrother(4),
                new CalabashBrother(1),
                new CalabashBrother(5),
        };
        SortController.sort(huluwa);

        Monster[] evils = {
                new Monster("蝎子精", "@"),
                new Monster("小喽啰", "*"),
                new Monster("小喽啰", "*"),
                new Monster("小喽啰", "*"),
                new Monster("小喽啰", "*"),
                new Monster("小喽啰", "*"),
                new Monster("小喽啰", "*"),
        };

        Leader grandpa = new Leader("爷爷");
        Leader snaker = new Leader("蛇精");

        initializeFormation(snaker, grandpa);

        while (true) {
            snaker.embattle(world, evils);
            grandpa.embattle(world, huluwa);

            world.print();

            //Produce a time gap
            for (int i = 0; i < 1e+9; ++i);
            System.out.print("\n\n");
        }
    }

    static void initializeFormation(Leader snaker, Leader grandpa) {
        //Initialize formations
        int[][] fmCoord1 = {{5, 0}, {6, 1}, {5, 2}, {6, 3}, {5, 4}, {6, 5}, {5, 6}};
        int[] pos1 = {4, 3};
        Formation fm1 = new Formation(fmCoord1, "衡轭阵", pos1);
        int[][] fmCoord2 = {{3, 3}, {4, 4}, {4, 2}, {5, 5}, {5, 1}, {6, 4}, {6, 2}};
        int[] pos2 = {5, 3};
        Formation fm2 = new Formation(fmCoord2, "方阵", pos2);
        snaker.addFormation(fm1);
        snaker.addFormation(fm2);

        int[][] fmCoord3 = {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}};
        int[] pos3 = {1, 2};
        Formation fm3 = new Formation(fmCoord3, "长蛇阵", pos3);
        int[][] fmCoord4 = {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}};
        int[] pos4 = {1, 4};
        Formation fm4 = new Formation(fmCoord4, "长蛇阵", pos4);
        grandpa.addFormation(fm3);
        grandpa.addFormation(fm4);
    }
}
