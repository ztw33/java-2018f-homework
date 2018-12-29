public class Monster extends Creature{
    Monster(String name, char symbol){
        this.name = name;
        this.camp = Global.MONSTER;
        this.indentity = Global.NORMARL;
        this.symbol = symbol;
        if(name == "Scorpion")
            this.indentity = Global.LEADER;
    }

    public static Monster Mice[]= new Monster[9];
    public static void Init_Mice(){
        for(int i = 0;i < 9;i++){
            Mice[i] = new Monster("Mouse",'#');
       }
    }

    public static Monster Scorpion = new Monster("Scorpion",'%');
}
