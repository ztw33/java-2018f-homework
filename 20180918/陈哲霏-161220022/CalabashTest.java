public class CalabashTest {
    public static void main(String[] args){
        CalabashBro[] calabashArray = CalabashBro.values();
/*        for(int i = 0; i < calabashArray.length; i++){
            System.out.print(calabashArray[i].getBroName() + " ");
        }*/
        for(int i = 0; i < calabashArray.length / 2; i++){//初始化为倒序
            CalabashBro tmp = calabashArray[i];
            calabashArray[i] = calabashArray[6 - i];
            calabashArray[6 - i] = tmp;
        }
        CalabashSort.bubbleSort(calabashArray, 7);
        for(int i = 0; i < calabashArray.length; i++){//报数(老大)
            System.out.print(calabashArray[i].getBroName() + " ");
        }
        System.out.println();
        for(int i = 0; i < calabashArray.length / 2; i++){//初始化为倒序
            CalabashBro tmp = calabashArray[i];
            calabashArray[i] = calabashArray[6 - i];
            calabashArray[6 - i] = tmp;
        }
        CalabashSort.mergeSort(calabashArray, 0, 6);
        for(int i = 0; i < calabashArray.length; i++){//报数(红色)
            System.out.print(calabashArray[i].getBroColor() + " ");
        }
        System.out.println();
    }
}
