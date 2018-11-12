public class CommanderMonster extends Creature{
    CommanderMonster(String name,char symbol){
        this.name = name;
        this.indentity = Global.COMMANDER;
        this.camp = Global.MONSTER;
        this.symbol = symbol;
    }

    public static CommanderMonster Serpent = new CommanderMonster("Serpent",'$');

    public void SetFormation_Monster(Formation formation,int coreX,int coreY){
        Monster.Scorpion.GetToSite(coreX,coreY);
        for(int i = 0;i < 8; i++){
            Monster.Mice[i].GetToSite(coreX+formation.relationX[i],coreY+formation.relationY[i]);
        }
        Serpent.GetToSite(coreX,coreY-2);
    }

}
