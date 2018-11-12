public class Player {
    public static void main(String[] args)
    {
        BattleField field = new BattleField(15);
        CalaBashBrother[]gourds = { new CalaBashBrother(1,"大娃","红色"),
                new CalaBashBrother(4,"四娃","绿色"),
                new CalaBashBrother(7,"七娃","紫色"),
                new CalaBashBrother(5,"五娃","青色"),
                new CalaBashBrother(3,"三娃","黄色"),
                new CalaBashBrother(2,"二娃","橙色"),
                new CalaBashBrother(6,"六娃","蓝色")};
        Grandpa grandpa = new Grandpa();
        Formation.bubble_sort(gourds, 7);
        Camp<Grandpa> camp1 = new Camp<>(grandpa,gourds,7);

        Snake snake = new Snake();
        Camp<Snake> camp2 = new Camp<>(snake);
        Scorpion scorpion = new Scorpion();
        camp2.add_unit(scorpion);
        for(int i = 0; i<7;i++) {
            Monster temp = new Monster();
            camp2.add_unit(temp);
        }
        System.out.println("                 -----第一次对峙局面：葫芦娃：长蛇   蝎子精：雁行-----");
        Formation.ChangShe(field, camp1,4);
        Formation.YanXing(field,camp2,11,7);
        field.print();
        camp1.getLeader().cheer();
        //grandpa.cheer();
        System.out.println();
        System.out.println("                 -----第二次对峙局面：葫芦娃：长蛇   蝎子精：衡轭-----");
        Formation.HengE(field,camp2,3,14);
        field.print();
        snake.cheer();
    }
}
