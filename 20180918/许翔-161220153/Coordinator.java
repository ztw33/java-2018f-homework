/* XuXiang 161220153 2018/9/27 10:00 */
import java.util.Random;

public class Coordinator {
    class CalabashSort implements Sort{
        @Override
        public void binarySort(Object[] array) {
            CalabashBros[] calabashBros = (CalabashBros[]) array;
            for(int i=1;i<7;i++){
                int left = 0, right = i-1;
                while(left<=right){
                    int mid = (left+right)/2;
                    if(calabashBros[i].getNumber()<calabashBros[mid].getNumber()){
                        right = mid-1;
                    }
                    else if(calabashBros[i].getNumber()>calabashBros[mid].getNumber()){
                        left = mid+1;
                    }
                }
                CalabashBros temp = calabashBros[i];
                for(int j=i-1;j>right;j--){
                    calabashBros[j+1] = calabashBros[j];
                    calabashBros[j+1].changeOrder(j+2);
                }
                calabashBros[right+1] = temp;
                calabashBros[right+1].changeOrder(right+2);
            }
        }

        @Override
        public void bubbleSort(Object[] array) {
            CalabashBros[] calabashBros = (CalabashBros[]) array;
            for(int i=6;i>0;i--) {
                for (int j = 6; j >= 7-i; j--) {
                    if (calabashBros[j].getNumber() < calabashBros[j - 1].getNumber()) {
                        CalabashBros temp = calabashBros[j];
                        calabashBros[j] = calabashBros[j - 1];
                        calabashBros[j - 1] = temp;
                        calabashBros[j].changeOrder(j+1);
                        calabashBros[j - 1].changeOrder(j);
                    }
                }
            }
        }
    }
    private CalabashBros[] calabashBros = CalabashBros.values();
    private CalabashSort calabashSort = new CalabashSort();
    private void randomizeCalabashBros() {
        Random rand = new Random();
        for(int i=0;i<10;i++){
            int randomNumA = rand.nextInt(7);
            int randomNumB = rand.nextInt(7);
            if(randomNumA != randomNumB){
                CalabashBros temp = calabashBros[randomNumA];
                calabashBros[randomNumA] = calabashBros[randomNumB];
                calabashBros[randomNumB] = temp;
                calabashBros[randomNumA].changeOrder(randomNumA+1);
                calabashBros[randomNumB].changeOrder(randomNumB+1);
            }
        }
    }
    private void tellName(){
        for(int i=0;i<7;i++){
            calabashBros[i].tellName();
        }
    }
    private void tellColor(){
        for(int i=0;i<7;i++){
            calabashBros[i].tellColor();
        }
    }
    public static void main(String arg[]){
        Coordinator coordinator = new Coordinator();
        coordinator.randomizeCalabashBros();
        System.out.println("Calabash Brothers has been randomized.");
        coordinator.calabashSort.bubbleSort(coordinator.calabashBros);
        coordinator.tellName();
        coordinator.randomizeCalabashBros();
        System.out.println("Calabash Brothers has been randomized.");
        coordinator.calabashSort.binarySort(coordinator.calabashBros);
        coordinator.tellColor();
    }
}

