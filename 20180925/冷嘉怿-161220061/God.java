public class God {
    private Brotherhood brotherhood=new Brotherhood();      //创造葫芦娃们
    private Scorpion scorpion=new Scorpion();               //创造蝎子精和喽罗们
    private Grandpa grandpa=new Grandpa();                  //创造老爷爷
    private Snake snake=new Snake();                        //创造蛇精
    public static void main(String[] args){
        God god=null;
        try{
            god=new God();                          //创造新世界
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        god.scorpion.alive=false;               //首先蝎子精和喽罗们没有登场
        god.viewField();                           //查看战场情况
        god.brotherhood.BiSort();                //葫芦娃们按序排队
        god.viewField();
        god.scorpion.alive=true;                //蝎子精和喽罗们出现
        god.viewField();
        god.scorpion.changeFMT();                //蝎子精和喽啰们改变阵型
        god.viewField();
    }

    God() throws Exception {
        brotherhood.randomize();
    }

    public void viewField()                     //查看战场情况，更新所有角色的位置后输出
    {
        BattleField.clear();
        scorpion.StandStill();
        grandpa.StandStill();
        snake.StandStill();
        brotherhood.StandStill();
        BattleField.print();
    }

}
