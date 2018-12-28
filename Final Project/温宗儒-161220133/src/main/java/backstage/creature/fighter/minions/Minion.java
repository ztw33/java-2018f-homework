package backstage.creature.fighter.minions;
import backstage.battleGround.Space;
import backstage.creature.fighter.Fighter;

public class Minion extends Fighter {
    private int maxNumber;
    int number; //怪物数量

    Minion(int number){
        maxNumber = number;
        this.number = number;
    }

    @Override
    public void beAttacked(int attack) {
        setAttackImageView();
        int decreaseNumber = (attack - defense) / hp;
        number -= decreaseNumber;
        if(number < 0) {
            number = 0;
            Space.addText(name + "失去" + decreaseNumber + "个, 当前还剩下"+number+"个,"+name+"被击杀\n");
        }else {
            Space.addText(name + "失去" + decreaseNumber + "个, 当前还剩下"+number+"个\n");
        };
        double nowLength = ((double)number/maxNumber)*30;
        if(nowLength <=0){
            green.setFitWidth(0.1);
        }else {
            green.setFitWidth(nowLength);
        }
    }

    public int getNumber() {
        return number;
    }
}
