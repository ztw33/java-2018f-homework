public class sort {
    public static void Selectsort(int[] arr){
        for(int i = 0; i < arr.length; i ++){
            int k  = i;
            for(int j = i + 1; j < arr.length; j ++){
                if(arr[j] < arr[k]){
                    k = j;
                }
            }
            if(k != i){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }

    }

    public static void main(String[] args){
        int[] arrays  = {2, 95, 47, 36, 57, 84, 26, 72};
        System.out.println("排序前：");
        for(int i = 0; i < arrays.length; i++){
            System.out.print(arrays[i]+"  ");
        }
        System.out.print("\n");
        Selectsort(arrays);
        System.out.println("排序后：");
        for(int i = 0; i < arrays.length; i++){
            System.out.print(arrays[i]+"  ");
        }
        System.out.print("\n");
    }


}