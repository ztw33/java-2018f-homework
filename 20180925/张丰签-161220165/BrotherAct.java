public class  BrotherAct {
    private Brother[] brother;
    String[] name={"老大","老二","老三","老四","老五","老六","老七"};
    public BrotherAct(){
        String[] name={"老大","老二","老三","老四","老五","老六","老七"};
        brother=new Brother[7];
        for(int i=0;i<7;i++){
            switch(i){
                case 0:brother[i]=new Brother(name[i],Color.RED,1,1);break;
                case 1:brother[i]=new Brother(name[i],Color.ORANGE,2,2);break;
                case 2:brother[i]=new Brother(name[i],Color.YELLOW,3,3);break;
                case 3:brother[i]=new Brother(name[i],Color.GREEN,4,4);break;
                case 4:brother[i]=new Brother(name[i],Color.CYAN,5,5);break;
                case 5:brother[i]=new Brother(name[i],Color.BLUE,6,6);break;
                case 6:brother[i]=new Brother(name[i],Color.PURPLE,7,7);break;
                default:
                    break;
            }
        }
    }
    public void brother_move(int num,int x,int y){
        brother[num-1].move(x,y);
    }
    public String brother_name(int num){
        return brother[num-1].get_name();
    }
    public void report_allname(){
        for(int i=0;i<7;i++){
            System.out.println(brother[i].get_name());
        }
    }
    public void report_allcolor(){
        for(int i=0;i<7;i++){
            brother[i].report_color();
        }
    }
}