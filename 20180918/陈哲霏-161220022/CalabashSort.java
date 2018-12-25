public class CalabashSort {
    public static void bubbleSort(CalabashBro[] arr, int num) {
        for(int i = 0; i < num - 1; i++) {
            for(int j = num - 1; j >= i + 1; j--) {
                if(arr[j].getBroNum() < arr[j - 1].getBroNum()) {
                    System.out.println(arr[j].getBroName() + ":" + (j + 1) + "->" + j);
                    CalabashBro tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    public static void combineArray(CalabashBro[] arr, int left, int medium, int right){
        int length = right - left + 1;
        CalabashBro[] tmp = new CalabashBro[length];
        int i = left, j = medium + 1;
        int cnt = 0;
        while(i <= medium && j <= right){
            if(arr[i].getBroNum() < arr[j].getBroNum()){
                System.out.println(arr[i].getBroName() + ":" + (i + 1) + "->" + (cnt + left + 1));
                tmp[cnt] = arr[i];
                i++; cnt++;
            }else{
                System.out.println(arr[j].getBroName() + ":" + (j + 1) + "->" + (cnt + left + 1));
                tmp[cnt] = arr[j];
                j++; cnt++;
            }
        }
        while(i <= medium){
            System.out.println(arr[i].getBroName() + ":" + (i + 1) + "->" + (cnt + left + 1));
            tmp[cnt] = arr[i];
            i++; cnt++;
        }
        while(j <= right){
            System.out.println(arr[j].getBroName() + ":" + (j + 1) + "->" + (cnt + left + 1));
            tmp[cnt] = arr[j];
            j++; cnt++;
        }
        cnt = 0;
        for(int k = left; k <= right; k++, cnt++){
            arr[k] = tmp[cnt];
        }
    }

    public static void mergeSort(CalabashBro[] arr, int left, int right){
        if(left < right){
            int medium = (left + right) / 2;
            mergeSort(arr, left, medium);
            mergeSort(arr,medium + 1, right);
            combineArray(arr, left, medium, right);
        }
    }


}
