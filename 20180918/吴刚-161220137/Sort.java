
public class Sort {
    private void sort(int[] data){
        this.quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] data, int begin, int end){
        if(begin < end){
            int index = returnIndex(data, begin, end);
            quickSort(data, begin, index - 1);
            quickSort(data, index + 1, end);
        }
    }

    private int returnIndex(int[] data, int begin, int end){
        int compareNum = data[begin];
        int returnIndex = begin;
        for(int i = begin + 1; i <= end; i++){
            if(data[i] < compareNum){
                returnIndex++;
                int temp = data[returnIndex];
                data[returnIndex] = data[i];
                data[i] = temp;
            }
        }
        int temp = data[returnIndex];
        data[returnIndex] = data[begin];
        data[begin] = temp;
        return returnIndex;
    }

    /*葫芦娃的冒泡排序*/
    public static void bubbleSort(CalabashBrother[] calabashBrothers){
        for(int i = 0; i < calabashBrothers.length; i++){
            for(int j = 1; j <calabashBrothers.length - i; j++){
                if(calabashBrothers[j].getRankings() < calabashBrothers[j - 1].getRankings()){
                    System.out.println(calabashBrothers[j].getName() + ": " + j + "->" + (j - 1));
                    System.out.println(calabashBrothers[j - 1].getName() + ": " + i + "->" + (j - 1));
                    CalabashBrother temp = calabashBrothers[j];
                    calabashBrothers[j] = calabashBrothers[j - 1];
                    calabashBrothers[j - 1] = temp;
                }
            }
        }
    }
    /*葫芦娃的二分法插入排序*/
    public static void binarySort(CalabashBrother[] calabashBrothers){
        for(int i = 0;i < calabashBrothers.length; i++){
            int start, end, mid;
            start = 0;
            end = i - 1;
            mid = 0;
            CalabashBrother temp = calabashBrothers[i];
            while (start <= end) {
                mid = (start + end) / 2;
                if (calabashBrothers[mid].getColor().getIndex() > temp.getColor().getIndex()) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            for (int j = i - 1; j > end; j--){
                System.out.println(calabashBrothers[j].getName() + ": " + j + "->" + (j + 1));
                calabashBrothers[j + 1] = calabashBrothers[j];
            }
            if(end + 1 != i) {
                System.out.println(temp.getName() + ": " + i + "->" + (end + 1));
                calabashBrothers[end + 1] = temp;
            }
        }
    }
}
