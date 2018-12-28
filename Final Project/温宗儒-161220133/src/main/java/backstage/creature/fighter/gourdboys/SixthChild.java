package backstage.creature.fighter.gourdboys;

/**
 * @program: gourdBoys
 * @description: Object SixthChild
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class SixthChild extends GourdBoy {
    private static SixthChild instance;
    public static SixthChild getInstance(int position){
        if(instance == null){
            synchronized (SixthChild.class) {
                if(instance == null) {
                    instance = new SixthChild(position);
                }
            }
        }
        return instance;
    }
    private SixthChild(int position){
        this.position = position;
        remoteAttack = false;
        name = Attribute.SIXTH.getName();
        attack = Attribute.SIXTH.getAttack();
        maxhp = Attribute.SIXTH.getMaxhp();
        hp = maxhp;
        defense = Attribute.SIXTH.getDefense();
        imageUrl = "/common/images/fighter/gourdboys/sixthChild.png";
        attackUrl = "/common/images/fighter/gourdboys/sixthChildAttack.jpg";
        setImageView();
    }
}