enum FormationType {
    HeYi, YanXing, HengE, ChangShe, YuLin, FangMen, YanYue, FengShi
}
public class Formation {
    private FormationType type;
    private int direction;
    private Ground space;
    private int midX;
    private int midY;
    private Creature[] creatures;
    public Formation() {
        type = null;
        direction = 0;
        space = null;
        creatures = null;
        midX = -1;
        midY = -1;
    }
    public Formation(FormationType type, int direction, Ground room, Creature[] creatures, int X, int Y) {
        this.type = type;
        space = room;
        this.direction = direction;
        this.creatures = creatures;
        midX = X;
        midY = Y;
    }
    private void HeYiFormation() {
        creatures[0].gotoPlace(space, midX, midY);
        int step = 1;
        for(int i = 1; i < creatures.length; i++) {
            if(i % 2 == 1)
                creatures[i].gotoPlace(space, midX + step*direction, midY + step);
            else {
                creatures[i].gotoPlace(space, midX + step*direction, midY - step);
                step++;
            }
        }
    }
    private void YanXingFormation() {
        //creatures[0].gotoPlace(space, midX, midY);
        //int step = 0;
        for(int i = 0, step = 0; i < creatures.length; i++) {
            creatures[i].gotoPlace(space, midX + step*direction, midY + step);
            step++;
        }
    }
    private void HengEFormation() {
        creatures[0].gotoPlace(space, midX, midY);
        for(int i = 1; i < creatures.length; i++) {
            if(i % 2 == 1)
                creatures[i].gotoPlace(space, midX - 1, midY - 1 - i/2 * 2);
            else
                creatures[i].gotoPlace(space, midX, midY - i/2 * 2);
        }
    }
    private void ChangSheFormation() {
        //creatures[0].gotoPlace(space, midX, midY);
        //int step = 0;
        for(int i = 0, step= 0; i < creatures.length; i++) {
            creatures[i].gotoPlace(space, midX, midY + step);
            step++;
        }
    }
    private void YuLinFormation() {
        if(creatures.length < 10)
            return;
        creatures[0].gotoPlace(space, midX, midY);
        creatures[1].gotoPlace(space, midX + direction, midY - 1);
        creatures[2].gotoPlace(space, midX + 2*direction, midY - 2);
        creatures[3].gotoPlace(space, midX + 2*direction, midY);
        creatures[4].gotoPlace(space, midX + 2*direction, midY + 2);
        creatures[5].gotoPlace(space, midX + 3*direction, midY - 3);
        creatures[6].gotoPlace(space, midX + 3*direction, midY -1);
        creatures[7].gotoPlace(space, midX + 3*direction, midY + 1);
        creatures[8].gotoPlace(space, midX + 3*direction, midY + 3);
        creatures[9].gotoPlace(space, midX + 4*direction, midY);
    }
    private void FangMenFormation() {
        if(creatures.length < 8)
            return;
        creatures[0].gotoPlace(space, midX, midY);
        creatures[1].gotoPlace(space, midX + 1*direction, midY + 1);
        creatures[2].gotoPlace(space, midX + 1*direction, midY - 1);
        creatures[3].gotoPlace(space, midX + 2*direction, midY + 2);
        creatures[4].gotoPlace(space, midX + 2*direction, midY - 2);
        creatures[5].gotoPlace(space, midX + 3*direction, midY + 1);
        creatures[6].gotoPlace(space, midX + 3*direction, midY - 1);
        creatures[7].gotoPlace(space, midX + 4*direction, midY);
    }
    private void YanYueFormation() {
        if(creatures.length < 19)
            return;
        creatures[0].gotoPlace(space, midX, midY);
        creatures[1].gotoPlace(space, midX, midY + 1);
        creatures[2].gotoPlace(space, midX, midY - 1);
        creatures[3].gotoPlace(space, midX + direction, midY);
        creatures[4].gotoPlace(space, midX + direction, midY + 1);
        creatures[5].gotoPlace(space, midX + direction, midY - 1);
        creatures[6].gotoPlace(space, midX + 2*direction, midY + 2);
        creatures[7].gotoPlace(space, midX + 2*direction, midY + 1);
        creatures[8].gotoPlace(space, midX + 2*direction, midY);
        creatures[9].gotoPlace(space, midX + 2*direction, midY - 1);
        creatures[10].gotoPlace(space, midX + 2*direction, midY - 2);
        creatures[11].gotoPlace(space, midX + 3*direction, midY + 2);
        creatures[12].gotoPlace(space, midX + 3*direction, midY + 3);
        creatures[13].gotoPlace(space, midX + 3*direction, midY - 2);
        creatures[14].gotoPlace(space, midX + 3*direction, midY - 3);
        creatures[15].gotoPlace(space, midX + 4*direction, midY + 3);
        creatures[16].gotoPlace(space, midX + 4*direction, midY - 3);
        creatures[17].gotoPlace(space, midX + 5*direction, midY + 4);
        creatures[18].gotoPlace(space, midX + 5*direction, midY - 4);
    }
    private void FengShiFormation() {
        if(creatures.length < 12)
            return;
        creatures[0].gotoPlace(space, midX, midY);
        creatures[1].gotoPlace(space, midX + 1*direction, midY + 1);
        creatures[2].gotoPlace(space, midX + 1*direction, midY);
        creatures[3].gotoPlace(space, midX + 1*direction, midY - 1);
        creatures[4].gotoPlace(space, midX + 2*direction, midY + 2);
        creatures[5].gotoPlace(space, midX + 2*direction, midY);
        creatures[6].gotoPlace(space, midX + 2*direction, midY - 2);
        creatures[7].gotoPlace(space, midX + 3*direction, midY - 3);
        creatures[8].gotoPlace(space, midX + 3*direction, midY);
        creatures[9].gotoPlace(space, midX + 3*direction, midY + 3);
        creatures[10].gotoPlace(space, midX + 4*direction, midY);
        creatures[11].gotoPlace(space, midX + 5*direction, midY);
    }
    public void DealFormation() {
        switch (type) {
            case HeYi: HeYiFormation(); break;
            case HengE: HengEFormation(); break;
            case YuLin: YuLinFormation(); break;
            case YanYue: YanYueFormation(); break;
            case FangMen: FangMenFormation(); break;
            case FengShi: FengShiFormation(); break;
            case ChangShe: ChangSheFormation(); break;
            case YanXing: YanXingFormation(); break;
        }
    }
    public void SetDirection(int direction) {
        this.direction = direction;
    }
    public void SetFormation(FormationType type) {
        this.type = type;
    }
    public void SetGound(Ground space) {
        this.space = space;
    }
    public void SetCreature(Creature[] creatures) {
        this.creatures = creatures;
    }
    public void SetMidPoint(int X, int Y) {
        this.midX = X;
        this.midY = Y;
    }
}
