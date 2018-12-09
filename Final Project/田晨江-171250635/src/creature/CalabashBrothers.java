package creature;

import java.util.Random;

public class CalabashBrothers extends Creature implements Comparable{


    /** 请让初始乱序的七个兄弟按下图所示阵型中的长蛇形依序（老大至老七）站队；*/


    CalabashBrothers cb[] = new CalabashBrothers[7];
    private NAME NAME;
    private COLOR COLOR;
    private SENIORITY SENIORITY;


    public CalabashBrothers(NAME name, SENIORITY seniority, COLOR color){
        this.NAME = name;
        this.SENIORITY = seniority;
        this.COLOR = color;
    }

    public CalabashBrothers() {}

    public CalabashBrothers[] initialCB() {
        CalabashBrothers[] brothers = new CalabashBrothers[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new CalabashBrothers(NAME.values()[i], SENIORITY.values()[i], COLOR.values()[i]);
        }
        return brothers;
    }

    @Override
    public String toString(){
        return NAME + "";
    }
    /**
     * 随机站队
     */
    @Deprecated
    public void randomQueue(){
        Random random = new Random();
        for(int i=7; i>=1; i--){
            int j = random.nextInt(i);
            CalabashBrothers temp = cb[i-1];
            cb[i-1] = cb[j];
            cb[j] = temp;
        }
    }

    @Deprecated
    public void BubbleSort(){
        CalabashBrothers temp;
        for(int i=0; i<cb.length-1; i++){
            for(int j=0; j<cb.length-1; j++){
                if(cb[j].getSENIORITY().ordinal() > cb[j+1].getSENIORITY().ordinal()){
                    temp = cb[j+1];
                    cb[j+1] = cb[j];
                    cb[j] = temp;
                }
            }
        }

    }


    @Override
    public boolean compareTo(Comparable another) {
        if (another instanceof CalabashBrothers) {
            if (this.getSENIORITY().ordinal() > ((CalabashBrothers) another).getSENIORITY().ordinal()){
                return true;
            }
         return false;
        }

        return false;
    }

    public creature.COLOR getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(creature.COLOR COLOR) {
        this.COLOR = COLOR;
    }

    public creature.SENIORITY getSENIORITY() {
        return SENIORITY;
    }

    public void setSENIORITY(creature.SENIORITY SENIORITY) {
        this.SENIORITY = SENIORITY;
    }
}


enum COLOR {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}

enum SENIORITY {
    一, 二, 三, 四, 五, 六, 七
}

enum NAME {
    大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃
}