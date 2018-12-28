package backstage.creature.fighter.gourdboys;

/**
 * @program: gourdBoys
 * @description: Object SecondChild
 * @auther: Wen Zongru
 * @create: 2018-12-28
 **/
public class SecondChild extends GourdBoy {
    private static SecondChild instance;
    public static SecondChild getInstance(int position){
        if(instance == null){
            synchronized (SecondChild.class) {
                if(instance == null) {
                    instance = new SecondChild(position);
                }
            }
        }
        return instance;
    }
    private SecondChild(int position){
        this.position = position;
        remoteAttack = false;
        name = Attribute.SECOND.getName();
        attack = Attribute.SECOND.getAttack();
        maxhp = Attribute.SECOND.getMaxhp();
        hp = maxhp;
        defense = Attribute.SECOND.getDefense();
        imageUrl = "/common/images/fighter/gourdboys/secondChild.png";
        attackUrl = "/common/images/fighter/gourdboys/secondChildAttack.jpg";
        setImageView();
    }
}
