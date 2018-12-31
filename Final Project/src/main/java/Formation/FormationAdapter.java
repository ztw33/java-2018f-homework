package Formation;

import java.util.ArrayList;

public class FormationAdapter {
    private static final ArrayList<Formation> Formations = new ArrayList<Formation>();
    public static void initFormations() {
        int[] rx1 = new int[]{1, 1, 2, 2, 3, 3, 4, 4};
        int[] ry1 = new int[]{1, -1, 2, -2, 3, -3, 4, -4};
        Formation Crane = new Formation("Crane", rx1, ry1);//鹤
        Formations.add(Crane);

        int[] rx2 = new int[]{1, -1, 2, -2, 3, -3, 4, -4};
        int[] ry2 = new int[]{-1, 1, -2, 2, -3, 3, -4, 4};
        Formation Goose = new Formation("Goose", rx2, ry2);//雁
        Formations.add(Goose);

        int[] rx3 = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int[] ry3 = new int[]{2, 1, 4, 3, 6, 5, 8, 7};
        Formation Yoke = new Formation("Yoke", rx3, ry3);//冲轭阵
        Formations.add(Yoke);

        int[] rx4 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        int[] ry4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        Formation Snake = new Formation("Snake", rx4, ry4);//蛇
        Formations.add(Snake);

        int[] rx5 = new int[]{1, 1, 1, 2, 2, 2, 2, 2};
        int[] ry5 = new int[]{1, 0, -1, 2, 1, 0, -1, -2};
        Formation Scale = new Formation("Scale", rx5, ry5);//鱼鳞
        Formations.add(Scale);

        int[] rx6 = new int[]{1, 1, 2, 2, 3, 3, 4, 4};
        int[] ry6 = new int[]{1, -1, 2, -2, 1, -1, 2, -2};
        Formation Square = new Formation("Square", rx6, ry6);//方
        Formations.add(Square);

        int[] rx7 = new int[]{0, 0, 1, 2, 2, 3, 3, 2};
        int[] ry7 = new int[]{1, -1, 0, 2, -2, 3, -3, 0};
        Formation Moon = new Formation("Moon", rx7, ry7);//月
        Formations.add(Moon);

        int[] rx8 = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
        int[] ry8 = new int[]{1, 0, -1, 2, -2, 0, 3, -3};
        Formation Bow = new Formation("Bow", rx8, ry8);//弓矢
        Formations.add(Bow);
    }

    public static Formation getFormationId(String name){
        //throws FormationException{
        int id;
        for(int i = 0; i < Formations.size(); i++) {
            if (Formations.get(i).getName().equals(name))
                return Formations.get(i);
        }
            return Formations.get(0);
        //throw new FormationException("错误的阵型名称",name);
    }
}
