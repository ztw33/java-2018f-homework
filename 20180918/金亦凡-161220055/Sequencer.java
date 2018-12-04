import java.util.Random;

public class Sequencer {
    private Huluwa[] Hs = Huluwa.values();

    private void swapHuluwa(int i, int j) {
        Huluwa temp = Hs[i];
        Hs[i] = Hs[j];
        Hs[j] = temp;
    }

    private void RandomArrange() {
        Random random = new Random();
        for(int i = 0; i < 1000; i++) {
            int index1 = random.nextInt(7);
            int index2 = random.nextInt(7);
            swapHuluwa(index1, index2);
        }
    }

    private void NumberOff() {
        for(int i = 0; i < 7; i++) {
            Hs[i].NumberOff();
            System.out.print(' ');
        }
        System.out.print('\n');
    }

    private void ColorOff() {
        for(int i = 0; i < 7; i++) {
            Hs[i].ColorOff();
            System.out.print(' ');
        }
        System.out.print('\n');
    }

    private void BubbleSort() {
        for(int i = 5; i >=0; i--) {
            for(int j = i; j < 6; j++) {
                if(Hs[j].getNum() > Hs[j + 1].getNum()) {
                    Hs[j].move(j, j + 1);
                    Hs[j + 1].move(j + 1, j);
                    swapHuluwa(j, j + 1);
                }
            }
        }
    }

    private void BinarySort() {
        for(int i = 1; i < 7; i++) {
            int start = 0;
            int end = i - 1;
            int middle = (start + end) / 2;
            while(end >= start) {
                if(Hs[i].getNum() > Hs[middle].getNum())
                    start = middle + 1;
                else
                    end = middle - 1;
                middle = (start + end) / 2;
            }
            Hs[i].move(i, start);
            Huluwa temp = Hs[i];
            for(int j = i; j > start; j--) {
                Hs[j] = Hs[j - 1];
                Hs[j - 1].move(j - 1, j);
            }
            Hs[start] = temp;
        }
    }

    public static void main(String[] argv) {
        Sequencer sequencer = new Sequencer();
        System.out.println("七个葫芦娃随意站队，并报数：");
        sequencer.RandomArrange();
        sequencer.NumberOff();
        System.out.println("按排行冒泡排序：");
        sequencer.BubbleSort();
        sequencer.NumberOff();
        System.out.println("七个葫芦娃随意站队，并报颜色：");
        sequencer.RandomArrange();
        sequencer.ColorOff();
        System.out.println("按颜色二分排序：");
        sequencer.BinarySort();
        sequencer.ColorOff();
    }
}

