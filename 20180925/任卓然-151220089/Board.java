package cre_define;

import java.util.Scanner;

public class Board {
    public Creature c[][];
    public Huluwa []h;
    public Oldman o;
    public Xiezi x;
    public Snake s;
    public Luoluo []l;
    Board()
    {
        c = new Creature[17][11];
        h = new Huluwa[7];
        String []name1 = {"老大","老二","老三","老四","老五","老六","老七"};
        for(int i = 0;i<h.length;++i)
            h[i] = new Huluwa(name1[i]);
        o = new Oldman("爷爷");
        c[3][9] = o;
        x = new Xiezi("蝎精");
        s = new Snake("蛇精");
        c[13][9] = s;
        l = new Luoluo[10];
        for(int i = 0;i<l.length;++i)
            l[i] = new Luoluo("啰啰"+i);

    }

    protected void set(Creature cre)
    {
        c[cre.x][cre.y] = cre;
    }

    private void rank(int n1,int n2) throws outlineException
    {
        clear();
        if(n1>4 || n1 < 1 || n2 > 4 || n2 < 1)
            throw new outlineException();
        switch (n1) {
            case 1:new HeRank(h, this);break;
            case 2:new YanRank(h, this);break;
            case 3:new TwoLineRank(h, this);break;
            case 4:new SnakeRank(h, this);break;

        }
        switch (n2) {
            case 1:new FishRank(x, l, this);break;
            case 2:new FangRank(x, l, this);break;
            case 3:new YueRank(x, l, this);break;
            case 4:new FengRank(x, l, this);break;
        }
    }

    private void output()
    {
        for(int i = 0;i<17;++i) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < 11; ++j) {
                if (c[i][j] != null )
                    temp.append(c[i][j].name);
                else
                    temp.append("     ");

            }
            System.out.println(temp+"\t");
        }
    }
    private void clear()
    {
        for(int i = 0;i<17;++i)
            for(int j = 0;j<11;++j)
                if(c[i][j] != null && !(c[i][j] instanceof Oldman || c[i][j] instanceof Snake))
                c[i][j] = null;
    }
    public static void main(String []args)
    {
        System.out.println("是否继续，输入1继续，输入其他结束");
        Board b = new Board();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        while(input.equals("1"))
        {
            int w1,w2;
            System.out.println("请输入葫芦娃的布阵：\n1.鹤翼阵\n2.雁行阵\n3.双轭阵\n4.蛇阵");
            w1 = sc.nextInt();
            System.out.println("请输入蝎子精和小啰啰的布阵：\n1.鱼鳞阵\n2.方形阵\n3.偃月阵\n4.锋矢阵");
            w2 = sc.nextInt();
            try {
                b.rank(w1, w2);
                b.output();
            }
            catch (outlineException e)
            {
                System.out.println(e.getCause().getMessage());
            }

            System.out.println("是否继续，输入1继续，输入其他结束");
            input = sc.next();

        }

    }
}
