enum Color{
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}
class  BrotherAct {
    private int num;
    private int n;
    Brother[] brother;
    private BattleField battlefield;
    BrotherAct(int brother_num,int N,BattleField x){
        num=brother_num;
        n=N;
        battlefield=x;
        String[] name={"老大","老二","老三","老四","老五","老六","老七"};//初始化对象
        brother=new Brother[brother_num];
        for(int i=0;i<brother_num;i++){
            switch(i){
                case 0:brother[i]=new Brother(i+1,name[i],Color.RED,n/2,0);battlefield.set_one(n/2,0,i+1);break;
                case 1:brother[i]=new Brother(i+1,name[i],Color.ORANGE,n/2+1,0);battlefield.set_one(n/2+1,0,i+1);break;
                case 2:brother[i]=new Brother(i+1,name[i],Color.YELLOW,n/2-1,0);battlefield.set_one(n/2-1,0,i+1);break;
                case 3:brother[i]=new Brother(i+1,name[i],Color.GREEN,n/2+2,0);battlefield.set_one(n/2+2,0,i+1);break;
                case 4:brother[i]=new Brother(i+1,name[i],Color.CYAN,n/2-2,0);battlefield.set_one(n/2-2,0,i+1);break;
                case 5:brother[i]=new Brother(i+1,name[i],Color.BLUE,n/2+3,0);battlefield.set_one(n/2+3,0,i+1);break;
                case 6:brother[i]=new Brother(i+1,name[i],Color.PURPLE,n/2-3,0);battlefield.set_one(n/2-3,0,i+1);break;
                default:
                    break;
            }
        }
    }
    public void report_allname(){
        for(int i=0;i<num;i++){
            brother[i].report_name();
        }
    }
    public void report_allcolor(){
        for(int i=0;i<num;i++){
            brother[i].report_color();
        }
    }
}