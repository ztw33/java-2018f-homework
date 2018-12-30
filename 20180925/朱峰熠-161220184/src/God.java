public class God {
    public static final void main(String []args){
        Instructor instructor = new Instructor();

        CommanderCalabro.Grandpa.SetFormation_CalaBros(Formation.Snake,3,3);
        CommanderMonster.Serpent.SetFormation_Monster(Formation.Crane,8,6);
        //CommanderMonster.Serpent.GetToSite(0,0);
        Map.PrintMap();
        CommanderMonster.Serpent.SetFormation_Monster(Formation.Bow,8,6);
        Map.PrintMap();
        CommanderMonster.Serpent.SetFormation_Monster(Formation.Scale,8,6);
        Map.PrintMap();
    }
}
