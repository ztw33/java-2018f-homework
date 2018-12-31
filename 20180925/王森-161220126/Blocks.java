public class Blocks {
    private Grandfather Onwardgrandpa;
    private SheJing OnwardSnake;
    private HuluWa OnwardHuluWA;
    private XieZiJing OnwardXieZi;
    private boolean isAnyCreature;
    public Blocks() {
        isAnyCreature = false;
        Onwardgrandpa = null;
        OnwardSnake = null;
        OnwardHuluWA = null;
        OnwardXieZi = null;
    }
    public void Summon(Grandfather A) {
        Onwardgrandpa = A;
        OnwardSnake = null;
        OnwardHuluWA = null;
        OnwardXieZi = null;
        isAnyCreature = true;
    }
    public void Summon(SheJing A) {
        OnwardSnake = A;
        Onwardgrandpa = null;
        OnwardHuluWA = null;
        OnwardXieZi = null;
        isAnyCreature = true;
    }
    public void Summon(HuluWa A) {
        OnwardHuluWA = A;
        Onwardgrandpa = null;
        OnwardSnake = null;
        OnwardXieZi = null;
        isAnyCreature = true;
    }
    public void Summon(XieZiJing A) {
        OnwardXieZi = A;
        Onwardgrandpa = null;
        OnwardSnake = null;
        OnwardHuluWA = null;
        isAnyCreature = true;
    }
    public void DeSummon(Grandfather A) {
        Onwardgrandpa = null;
        isAnyCreature = false;
    }
    public void DeSummon(SheJing A) {
        OnwardSnake = null;
        isAnyCreature = false;
    }
    public void DeSummon(HuluWa A) {
        OnwardHuluWA = null;
        isAnyCreature = false;
    }
    public void DeSummon(XieZiJing A) {
        OnwardXieZi = null;
        isAnyCreature = false;
    }
    public Grandfather getGrandpa() {
        return Onwardgrandpa;
    }
    public SheJing getSnake() {
        return OnwardSnake;
    }
    public HuluWa getHuluWa() {
        return OnwardHuluWA;
    }
    public XieZiJing getXieZi() {
        return OnwardXieZi;
    }
    public boolean isAnyCreature() {
        return isAnyCreature;
    }
    public Creatures getCreature() {
        if(isAnyCreature) {
            if (Onwardgrandpa != null)
                return Onwardgrandpa;
            else if (OnwardSnake != null)
                return OnwardSnake;
            else if (OnwardHuluWA != null)
                return OnwardHuluWA;
            else
                return OnwardXieZi;
        }
        return null;
    }
}
