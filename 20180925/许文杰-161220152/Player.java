public class Player {
    public void bubble_sort(CalaBashBrother[] gourds, int n)
    {
        for(int i = 0;i < n;i++)
            for(int j = 0;j< n - 1 - i;j++)
                if(gourds[j].getNumber()>gourds[j+1].getNumber())
                {
                    CalaBashBrother temp = gourds[j];
                    gourds[j] = gourds[j+1];
                    gourds[j+1] = temp;
                }
    }
    public void create(Unit unit, BattleField field, int x, int y)
    {
        //更新对象信息
        unit.set(x,y);
        //更新战场信息
        field.getCells()[x][y].setUnit(unit);
        field.getCells()[x][y].setEmpty(false);
    }

    public void change(Unit unit, BattleField field, int x, int y)
    {
        //如果原位置单位与将要移动的单位相同，则将该位置置为空
        if(field.getCells()[unit.getX()][unit.getY()].getUnit() == unit)
            field.getCells()[unit.getX()][unit.getY()].setEmpty(true);
        //更新战场信息
        field.getCells()[x][y].setUnit(unit);
        field.getCells()[x][y].setEmpty(false);
        //更新对象信息
        unit.set(x,y);
    }

    //葫芦娃:长蛇
    public void CB_formation_init(BattleField field,Unit[] gourds, int start)
    {
        for(int i = start;i<=start+6;i++)
            create(gourds[i-start],field,i,0);
    }
    //蝎子精：方円
    public void MO_formation_init(BattleField field,Unit[] monsters, int start_x, int start_y)
    {
        create(monsters[0], field, start_x-1, start_y+1);
        create(monsters[1], field, start_x-2, start_y+2);
        create(monsters[2], field, start_x-1, start_y+3);
        create(monsters[3], field, start_x, start_y+4);
        create(monsters[4], field, start_x+1, start_y+3);
        create(monsters[5], field, start_x+2, start_y+2);
        create(monsters[6], field, start_x+1, start_y+1);
    }
    //蝎子精：雁行
    public void MO_formation_change_1(BattleField field,Unit[] monsters, int start_x, int start_y)
    {
        start_x--;
        start_y++;
        for(int i = 0;i<7;i++)
        {
            change(monsters[i], field, start_x, start_y);
            start_x--;
            start_y++;
        }
    }

    public static void main(String[] args)
    {
        //创建战场、玩家
        BattleField field = new BattleField();
        Player player = new Player();

        //创建对象(数组)：葫芦娃、爷爷、蛇精、蝎子、喽啰
        CalaBashBrother[]gourds = { new CalaBashBrother(1,"大娃","红色"),
                                    new CalaBashBrother(4,"四娃","绿色"),
                                    new CalaBashBrother(7,"七娃","紫色"),
                                    new CalaBashBrother(5,"五娃","青色"),
                                    new CalaBashBrother(3,"三娃","黄色"),
                                    new CalaBashBrother(2,"二娃","橙色"),
                                    new CalaBashBrother(6,"六娃","蓝色")};
        Unit[]monsters = new Monster[7];
        for(int i = 0;i<7;i++)
        {
            Unit temp = new Monster();
            monsters[i] = temp;
        }
        Unit grandpa = new Grandpa();
        Unit snake = new Snake();
        Unit scorpion = new Scorpion();

        //将葫芦娃排序
        player.bubble_sort(gourds, 7);

        System.out.println("                 -----第一次对峙局面：葫芦娃：长蛇   蝎子精：方円-----");
        player.create(grandpa,field,0,0);
        player.create(snake,field,14,14);
        player.CB_formation_init(field, gourds, 4);
        player.create(scorpion, field, 7, 10);
        player.MO_formation_init(field, monsters,7, 10);
        field.print();
        System.out.println();
        System.out.println("                 -----第二次对峙局面：葫芦娃：长蛇   蝎子精：雁行-----");
        player.MO_formation_change_1(field, monsters, 11,7);
        player.change(scorpion, field, 11, 7);
        field.print();
    }
}
