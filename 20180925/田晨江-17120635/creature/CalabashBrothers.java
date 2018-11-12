package creature;

import java.util.Random;

public class CalabashBrothers extends Creature {


    /** 请让初始乱序的七个兄弟按下图所示阵型中的长蛇形依序（老大至老七）站队；*/


    private CalabashBrothers calabashBrothers;
    CalabashBrothers cb[] = new CalabashBrothers[7];
    private int order;


    public CalabashBrothers[] createCalabashBrothers(){
        //Creature cb[] = new CalabashBrothers[7];
        String calabashStr = "大二三四五六七";
        for(int i=0; i<7; i++){
            cb[i] = new CalabashBrothers(""+ calabashStr.charAt(i)+"娃  ",i+1);
            //cb[i].setName(""+ calabashStr.charAt(i)+"娃");
        }
        return cb;
    }

    public CalabashBrothers(){

    }

    public CalabashBrothers(String name,int order){
        this.name = name;
        this.order = order;
    }

    public void setCb(CalabashBrothers[] cb) {
        this.cb = cb;
    }

    public CalabashBrothers[] getCb() {
        return cb;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }


    /**
    enum CalabashBrothersenum{
        大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃;

        protected String name;

        public String getName() {
            return name;
        }

        };

    public String getName(){
        return "" + calabashBrothers.name;
    }



    @Override
    public String toString() {

        return calabashBrothers.getName() ;
    }

*/

    /**
     * 随机站队
     */
    public void randomQueue(){
        Random random = new Random();
        for(int i=7; i>=1; i--){
            int j = random.nextInt(i);
            CalabashBrothers temp = cb[i-1];
            cb[i-1] = cb[j];
            cb[j] = temp;
        }
    }

    public void BubbleSort(){
        CalabashBrothers temp;
        for(int i=0; i<cb.length-1; i++){
            for(int j=0; j<cb.length-1; j++){
                if(cb[j].getOrder() > cb[j+1].getOrder()){
                    temp = cb[j+1];
                    cb[j+1] = cb[j];
                    cb[j] = temp;
                }
            }
        }

    }



}
