public class Sort {

    /**
     * 冒泡排序
     */
    public void BubbleSort(CalabashBrothersEnum[] cb){
        CalabashBrothersEnum temp;
        for(int i=0; i<cb.length-1; i++){
            for(int j=0; j<cb.length-1; j++){
                if(cb[j].getOrder() > cb[j+1].getOrder()){
                    CalabashBrothers.NumberOff(cb,j,j+1);
                    temp = cb[j+1];
                    cb[j+1] = cb[j];
                    cb[j] = temp;
                }
            }
        }

    }

    /**
     * 二分排序
     */
    public void binaryInsertSort(CalabashBrothersEnum[] cb){
        for(int i=0; i<cb.length; i++){
            CalabashBrothersEnum temp = cb[i];
            int left=0;
            int right=i-1;
            int middle=0;
            while (left <= right){
                middle = (left + right)/2;
                if(temp.getOrder() < cb[middle].getOrder()){
                    right = middle-1;
                }else {
                    left = middle+1;
                }
            }
            for(int j=i-1; j>right;j--){
                CalabashBrothers.NumberOff(cb,j,j+1);
                cb[j+1] = cb[j];
            }
            if(left != i){
                cb[left] = temp;
            }
        }

    }
}


