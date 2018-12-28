package backstage.creature.fighter.gourdboys;

/**
 * @program: gourdBoys
 * @description: Object FifthChild
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class FifthChild extends GourdBoy {
    private static FifthChild instance;
    public static FifthChild  getInstance(int position){
        if(instance == null){
            synchronized (FifthChild.class) {
                if(instance == null) {
                    instance = new FifthChild(position);
                }
            }
        }
        return instance;
    }
    private FifthChild(int position){
        this.position = position;
        remoteAttack = true;
        name = Attribute.FIFTH.getName();
        attack = Attribute.FIFTH.getAttack();
        maxhp = Attribute.FIFTH.getMaxhp();
        hp = maxhp;
        defense = Attribute.FIFTH.getDefense();
        imageUrl = "/common/images/fighter/gourdboys/fifthChild.png";
        attackUrl = "/common/images/fighter/gourdboys/fifthChildAttack.jpg";
        setImageView();
    }
}
