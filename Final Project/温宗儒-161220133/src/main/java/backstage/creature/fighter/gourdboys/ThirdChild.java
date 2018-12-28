package backstage.creature.fighter.gourdboys;

/**
 * @program: gourdBoys
 * @description: Object ThirdChild
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class ThirdChild extends GourdBoy {
    private static ThirdChild instance;
    public static ThirdChild getInstance(int position){
        if(instance == null){
            synchronized (ThirdChild.class) {
                if(instance == null) {
                    instance = new ThirdChild(position);
                }
            }
        }
        return instance;
    }
    private ThirdChild(int position){
        this.position = position;
        remoteAttack = false;
        name = Attribute.THIRD.getName();
        attack = Attribute.THIRD.getAttack();
        maxhp = Attribute.THIRD.getMaxhp();
        hp = maxhp;
        defense = Attribute.THIRD.getDefense();
        imageUrl = "/common/images/fighter/gourdboys/thirdChild.png";
        attackUrl = "/common/images/fighter/gourdboys/thirdChildAttack.jpg";
        setImageView();
    }
}