import java.util.*;
import Being.*;

public enum Formation {
    YanXing(12, 12, 0), FengShi(10, 12, 1), HeYi(12, 15, 2);
    ArrayList<Followers> louluo;
    Scorpion XieZiJing;
    private void YanXingInit(int i, int j) {

        for(int k = 0; k < 5; k++) {
            Followers p = new Followers(i - k - 1, j + k + 1);
            louluo.add(p);
        }
    }
    private void FengShiInit(int i, int j) {
        int k = 1;
        for(; k <= 5;k++) {
            Followers p = new Followers(i, j + k);
            louluo.add(p);
        }
        k = 1;
        for(; k <= 2;k++) {
            Followers p = new Followers(i - k, j + k);
            louluo.add(p);
        }
        k = 1;
        for(; k <= 2;k++) {
            Followers p = new Followers(i + k, j + k);
            louluo.add(p);
        }
    }
    private void HeyiInit(int i, int j) {
        int k = 1;
        for(; k <= 3; k++) {
            Followers p = new Followers(i - k, j - k);
            louluo.add(p);
        }
        k = 1;
        for(; k <= 3; k++) {
            Followers p = new Followers(i - k, j + k);
            louluo.add(p);
        }
    }
    Formation(int i, int j, int k){
        XieZiJing = new Scorpion(i, j);
        louluo = new ArrayList<>();
        switch(k) {
            case 0:YanXingInit(i, j);break;
            case 1:FengShiInit(i, j);break;
            case 2:HeyiInit(i, j);break;
        }
    }
}