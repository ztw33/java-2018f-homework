public class virtualField {          //战场类
    public static int width=15;     //战场大小
    public static int height=15;
    public static Charactors field[][]=new Charactors[height][width];
    public static void clear()      //清空之前的残留信息
    {
        for(int i=0;i<height;i++)
            for (int j = 0; j < width; j++)
                field[i][j]=null;
    }
}
