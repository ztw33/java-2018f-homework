package Homework2;

public enum HuluBrothers {
    RED("老大"), ORANGE("老二"), YELLOW("老三"), GREEN("老四"), WATHET("老五"), BLUE("老六"), PURPLE("老七");
    private final String name;
    private int placeNum;

    HuluBrothers(String name){
        this.name = name;
        this.placeNum = 0;
    }

    public void randomSit(Seats s){
        int seat = (int)(1 + Math.random()*7);  //from 1 to 7
        while(true){
            if(s.getInfo(seat))
                break;
            else
                seat = (seat)%7 + 1;
        }
        placeNum = seat;
        s.set(seat);
    }

    public void exchangeSeat(HuluBrothers x){
        int tmp = x.placeNum;
        x.placeNum = this.placeNum;
        this.placeNum = tmp;
        System.out.println(this.toString() + " moves " + " from " + x.placeNum + " to " + this.placeNum);
        System.out.println(x.toString() + " moves " + " from " + this.placeNum + " to " +  x.placeNum);
    }

    public void show(){
        System.out.println(this.toString() + " " + this.placeNum);
    }

    public int tellNo(){
        return this.ordinal();
    }

    public int tellSeat(){
        return this.placeNum;
    }

    /*public static void main(String[] args){
        Seats s = new Seats();
        RED.randomSit(s);
        RED.show();
        ORANGE.randomSit(s);
        ORANGE.show();
        YELLOW.randomSit(s);
        YELLOW.show();
        GREEN.randomSit(s);
        GREEN.show();
        WATHET.randomSit(s);
        WATHET.show();
        BLUE.randomSit(s);
        BLUE.show();
        PURPLE.randomSit(s);
        PURPLE.show();
        RED.exchangeSeat(BLUE);
        RED.show();
        BLUE.show();
        return ;
    }*/
}
