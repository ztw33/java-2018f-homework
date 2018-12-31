import java.util.Random;

public class SevenHuluwa {
    private Huluwa[] huluwas;

    public SevenHuluwa(){
        huluwas = new Huluwa[7];
        for(int i = 0; i < 7; i++){
            huluwas[i] = new Huluwa(i);
        }
    }

    //让葫芦娃随机战队
    public void randomSeque(){
        Random random = new Random();
        for(int i = 0; i < 7; i++){
            int temp = random.nextInt(7);
            Huluwa huluwa = huluwas[i];
            huluwas[i] = huluwas[temp];
            huluwas[i].setLocation(i);
            huluwas[temp] = huluwa;
            huluwas[temp].setLocation(temp);
        }
    }

    //按颜色进行排序（二分法）
    public void sortByColor(){
        for(int i = 0; i < 7; i++) {
            int begin = 0;
            int end = i - 1;
            int mid = 0;
            while (begin <= end) {
                mid = (begin + end) / 2;
                if (huluwas[i].getColor().compareTo(huluwas[mid].getColor()) > 0) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            Huluwa huluwa = huluwas[i];
            for (int j = i - 1; j >= begin; j--) {
                huluwas[j].tellChangeLoc(j + 1);
                huluwas[j].setLocation(j + 1);
                huluwas[j + 1] = huluwas[j];
            }
            huluwa.tellChangeLoc(begin);
            huluwa.setLocation(begin);
            huluwas[begin] = huluwa;
        }
    }

    //报颜色
    public void tellColor(){
        for(int i = 0; i < 7; i++){
            huluwas[i].tellColor();
        }
    }

    //按各自排行进行排序（冒泡排序法）
    public void sortByNum(){
        for(int i = 0; i < 7; i++){
            for(int j = i+1; j < 7; j++){
                if(huluwas[i].getNum() > huluwas[j].getNum()){
                    Huluwa huLuWa = huluwas[i];
                    huluwas[j].tellChangeLoc(i);
                    huluwas[j].setLocation(i);
                    huluwas[i] = huluwas[j];
                    huLuWa.tellChangeLoc(j);
                    huLuWa.setLocation(j);
                    huluwas[j] = huLuWa;
                }
            }
        }
    }

    //报数
    public void tellNum(){
        for(int i = 0; i < 7; i++){
            huluwas[i].tellName();
        }
    }

    //报位置：
    /*
    public void tellLoc(){
        for(int i = 0; i < 7; i++){
            huluwas[i].tellLocation();
        }
    }
    */
}

