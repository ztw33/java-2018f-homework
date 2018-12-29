public class integerSort {
    public static void main(String[] args) {
        //创建数组
        int integerSort[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        //冒泡排序
        for(int i = 0; i < integerSort.length;i++){
            for(int j = i+1; j < integerSort.length; j++){
                if(integerSort[i] > integerSort[j]) {
                    int temp = integerSort[i];
                    integerSort[i] = integerSort[j];
                    integerSort[j] = temp;
                }
            }
        }
        //数组输出
        for(int i = 0; i < integerSort.length;i++){
            System.out.print(integerSort[i]);
            System.out.print(' ');
        }
    }

}
