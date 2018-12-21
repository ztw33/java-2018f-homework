public class Formation {
    public String name;
    public int relationX[];
    public int relationY[];

    Formation(String name,int rx[],int ry[]) {
        this.name = name;
        this.relationX = rx;
        this.relationY = ry;
    }
    /*
    public static void Init_Formation(){
        int []rx1 = new int[]{1,2,3,4,1,2,3,4};
        int []ry1 = new int[]{1,2,3,4,-1,-2,-3,-4};
        Formation Crane = new Formation("Crane",7,7,rx1,ry1);//鹤
    }
    */
    static int []rx1 = new int[]{1,1,2,2,3,3,4,4};
    static int []ry1 = new int[]{1,-1,2,-2,3,-3,4,-4};
    public static Formation Crane = new Formation("Crane",rx1,ry1);//鹤

    static int []rx2 = new int[]{1,-1,2,-2,3,-3,4,-4};
    static int []ry2 = new int[]{-1,1,-2,2,-3,3,-4,4};
    public static Formation Goose = new Formation("Goose",rx2,ry2);//雁

    static int []rx3 = new int[]{0,1,0,1,0,1,0,1};
    static int []ry3 = new int[]{2,1,4,3,6,5,8,7};
    public static Formation Yoke = new Formation("Yoke",rx3,ry3);//冲轭阵

    static int []rx4 = new int[]{0,0,0,0,0,0,0,0};
    static int []ry4 = new int[]{1,2,3,4,5,6,7,8};
    public static Formation Snake = new Formation("Snake",rx4,ry4);//蛇

    static int []rx5 = new int[]{1,1,1,2,2,2,2,2};
    static int []ry5 = new int[]{1,0,-1,2,1,0,-1,-2};
    public static Formation Scale = new Formation("Scale",rx5,ry5);//鱼鳞

    static int []rx6 = new int[]{1,1,2,2,3,3,4,4};
    static int []ry6 = new int[]{1,-1,2,-2,1,-1,2,-2};
    public static Formation Square = new Formation("Square",rx6,ry6);//方

    static int []rx7 = new int[]{0,0,1,2,2,3,3,2};
    static int []ry7 = new int[]{1,-1,0,2,-2,3,-3,0};
    public static Formation Moon = new Formation("Moon",rx7,ry7);//月

    static int []rx8 = new int[]{1,1,1,2,2,2,3,3};
    static int []ry8 = new int[]{1,0,-1,2,-2,0,3,-3};
    public static Formation Bow = new Formation("Bow",rx8,ry8);//弓矢

}
