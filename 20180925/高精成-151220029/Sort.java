public class Sort {

    public void BubbleSort (Creature []cre) {
        for(int i=0;i<cre.length-1;i++){
            for(int j=0;j<cre.length-i-1;j++){
                //通过获取葫芦娃的颜色进行排序
                if(cre[j].getColor().compareTo(cre[j+1].getColor())>0){
                    Creature temp = cre[j];
                    cre[j] = cre[j+1];
                    cre[j+1] = temp;
                }

            }
        }
    }
}
