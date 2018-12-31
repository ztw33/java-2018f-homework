package creature.justice;


import creature.Creature;

public class Calabashs extends Creature {
    private static int allNum = 0;

    public Calabashs() {
        if (allNum >= 7) {
            System.out.println("出事了，葫芦多了");
        } else {
            allNum++;
            coorX = coorY = -1;
            name = CalaList.GetNameByList(allNum);
            symbolForCrea = (char) ((int) '0' + allNum);
            kind = true;
            System.out.println(this.getName() + allNum + " success");

        }
    }
}

class CalaList {
   private static final  String[] list={"Red","Orange","Yellow","Green","Cyan","Blue","Purple"};
   public  static  String GetNameByList(int rank)
   {
       return  list[rank-1];
   }

}
