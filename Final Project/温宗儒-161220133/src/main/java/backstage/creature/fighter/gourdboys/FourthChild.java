package backstage.creature.fighter.gourdboys;

/**
 * @program: gourdBoys
 * @description: Object FourthChild
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class FourthChild extends GourdBoy {
    private static FourthChild instance;
    public static FourthChild getInstance(int position){
        if(instance == null){
            synchronized (FourthChild.class) {
                if(instance == null) {
                    instance = new FourthChild(position);
                }
            }
        }
        return instance;
    }
    private FourthChild(int position){
        this.position = position;
        remoteAttack = true;
        name = Attribute.FOURTH.getName();
        attack = Attribute.FOURTH.getAttack();
        maxhp = Attribute.FOURTH.getMaxhp();
        hp = maxhp;
        defense = Attribute.FOURTH.getDefense();
        imageUrl = "/common/images/fighter/gourdboys/fourthChild.png";
        attackUrl = "/common/images/fighter/gourdboys/fourthChildAttack.jpg";
        setImageView();
    }
}