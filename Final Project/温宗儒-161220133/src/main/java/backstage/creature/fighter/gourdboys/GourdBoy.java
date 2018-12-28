package backstage.creature.fighter.gourdboys;

import backstage.battleGround.Space;
import backstage.creature.fighter.Fighter;
import backstage.creature.fighter.minions.Bat;
import backstage.creature.fighter.minions.Centipede;
import backstage.creature.battle.Minions;
import backstage.creature.fighter.minions.Minion;
import backstage.creature.fighter.minions.Toad;

public abstract class GourdBoy extends Fighter {
    protected int position;

    public void attackMinions(Minions minions){
        setAttackImageView();
        Bat bat = minions.getBat();
        Centipede centipede = minions.getCentipede();
        Toad toad = minions.getToad();
        Minion[] minions1 = new Minion[3];
        if(position == 1){
            minions1[0] = bat;
            minions1[1] = centipede;
            minions1[2] = toad;
        }else if(position == 2){
            minions1[0] = centipede;
            minions1[1] = bat;
            minions1[2] = toad;
        }else if(position == 3){
            minions1[0] = toad;
            minions1[1] = centipede;
            minions1[2] = bat;
        }
        if(remoteAttack || getLocationY()==19){
            int index;
            for(index = 0; index<3; index++){
                if(minions1[index].getNumber() > 0) {
                    minions1[index].beAttacked(attack);
                    break;
                }
                if(index == 2){
                    Space.setWarEnd(true);
                }
            }
        }

    }

}
