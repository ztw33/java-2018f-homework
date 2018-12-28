package backstage.creature.fighter.gourdboys;

/**
 * @program: gourdBoys
 * @description: Object SeventhChild
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class SeventhChild extends GourdBoy{
    private static SeventhChild instance;
    public static SeventhChild getInstance(int position){
        if(instance == null){
            synchronized (SeventhChild.class) {
                if(instance == null) {
                    instance = new SeventhChild(position);
                }
            }
        }
        return instance;
    }
    private SeventhChild(int position){
        this.position = position;
        remoteAttack = true;
        name = Attribute.SEVENTH.getName();
        attack = Attribute.SEVENTH.getAttack();
        maxhp = Attribute.SEVENTH.getMaxhp();
        defense = Attribute.SEVENTH.getDefense();
        imageUrl = "/common/images/fighter/gourdboys/seventhChild.png";
        attackUrl = "/common/images/fighter/gourdboys/seventhChildAttack.jpg";
        hp = maxhp;
        setImageView();

    }
}
