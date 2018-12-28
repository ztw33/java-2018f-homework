public class CommanderCalabro extends Creature{
    CommanderCalabro(String name,char symbol){
        this.name = name;
        this.indentity = Global.COMMANDER;
        this.camp = Global.CALABROS;
        this.symbol = symbol;
    }

    public static CommanderCalabro Grandpa = new CommanderCalabro("Grandpa",'@');

    public void SetFormation_CalaBros(Formation formation,int coreX,int coreY){
        CalaBrothers.CalaBros[0].GetToSite(coreX,coreY);
        for(int i = 1;i < 7;i++){
            CalaBrothers.CalaBros[i].GetToSite(coreX+formation.relationX[i-1],coreY+formation.relationY[i-1]);
        }
        Grandpa.GetToSite(coreX,coreY-2);
    }
}
