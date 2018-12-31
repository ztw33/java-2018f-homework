public class EnemyGroup {
    public EnemyGroup(){
        group = new Enemy[8];
        for(int i = 0; i < group.length; i++){
            group[i] = new Enemy(1);
        }
        group[group.length/2].setType(0);
    }
    public Creature[] getFormationCreatrue(){
        return (Creature[])group;
    }
    private Enemy[] group;
}
class Enemy extends Creature{
    enum EnemyType{
        SCORPION("蝎子精"),LACKEYS("小喽啰");
        private final String name;
        private EnemyType(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    private EnemyType type;
    public Enemy(int i){
        type = EnemyType.values()[i];
    }

    public void setType(int index) {
        this.type = EnemyType.values()[index];
    }

    public void toldname(){
        System.out.println(type.getName());
    }
    @Override
    public void toldCreatureCategoryAndName(){
        System.out.println("Enemy:"+type.getName());
    }
    @Override
    public void toldCreature(){
        System.out.print("|"+type.getName());
    }
}
