public class Sort {
    public void bubbleSort(HuluWa[] brothers){
        for (int i = 0; i < brothers.length; i++) {
            for (int j = 0; j < brothers.length-i-1; j++) {
                if (!brothers[j].comparePriority(brothers[j+1])) {
                    brothers[j].swapHuluWa(brothers[j+1], j,j+1);

                    HuluWa temp = brothers[j+1];
                    brothers[j+1] = brothers[j];
                    brothers[j] = temp;

                }
            }
        }
    }

    public void biInsertSort(HuluWa[] brothers){
        for (int i = 1; i < brothers.length; i++){
            int mid = 0;
            int begin = 0;
            int end = i - 1;
            int pos = 0;
            while (begin <= end){
                mid = (begin + end) / 2;
                if (brothers[i].compareColor(brothers[mid]) > 0){
                    begin = mid + 1;
                } else if (brothers[i].compareColor(brothers[mid]) < 0){
                    end = mid - 1;
                } else {
                    break;
                }
            }

            if (brothers[i].compareColor(brothers[mid]) > 0){
                pos = mid+1;
            } else if (brothers[i].compareColor(brothers[mid]) < 0){
                pos = mid;
            }

            int p = i;
            while (p >= pos+1){
                brothers[p].swapHuluWa(brothers[p-1], p, p-1);
                HuluWa temp = brothers[p-1];
                brothers[p-1] = brothers[p];
                brothers[p] = temp;
                p--;
            }
        }
    }


}
