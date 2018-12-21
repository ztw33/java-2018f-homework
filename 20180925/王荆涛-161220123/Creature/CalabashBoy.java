package Creature;

public class CalabashBoy extends GoodGuy{

    public enum boy{
        RED("赤",1,"1"),ORANGE("橙",2,"2"),YELLOW("黄",3,"3"),GREEN("绿",4,"4"),
        CYAN("青",5,"5"),BLUE("蓝",6,"6"),PURPLE("紫",7,"7");
        private String color;
        private String name;
        private int rank;


        boy(String color, int rank, String name){
            this.color = color;
            this.rank = rank;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getRank() {
            return rank;
        }

        public void speakMyName(){
            System.out.print(name + " ");
        }

        public void speakMyColor(){
            System.out.print(color + " ");
        }

        public void exchangeMyPosition(int oldPos, int nowPos){
            System.out.println(name + ": " + (int)(oldPos + 1) + "->" + (int)(nowPos + 1));
            oldPos = nowPos;
        }
    }
}
