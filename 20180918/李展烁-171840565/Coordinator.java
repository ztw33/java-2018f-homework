import java.util.Collections;
import java.util.Random;

public class Coordinator{
    enum ReportMethod{color, name, positionChange};

    static void orderReport(GourdBoys gbs, ReportMethod rm, int ... key){
        switch (rm){
            case name:
                gbs.report_name();
                break;
            case color:
                gbs.report_color();
                break;
            case positionChange:
                gbs.report_change(key[0],key[1]);
        }
    }
    static void randomArrange (GourdBoys[] gbs){
        Random random = new Random();
        for(int i = 0; i < gbs.length; i++){
            int pos = random.nextInt(gbs.length);
            GourdBoys gb = gbs[i];
            gbs[i] = gbs[pos];
            gbs[pos] = gb;
        }
    }
    static void swap(GourdBoys[] gbs, int pos1, int pos2){
        orderReport(gbs[pos1],ReportMethod.positionChange,pos1,pos2);
        orderReport(gbs[pos2],ReportMethod.positionChange,pos2,pos1);
        GourdBoys temp = gbs[pos1];
        gbs[pos1] = gbs[pos2];
        gbs[pos2] = temp;

    }

    static void bubbleSort (GourdBoys[] gbs){
        for(int i = 0; i < gbs.length; i++){
            for(int j = gbs.length - 1; j > i; j--){
                if(gbs[j-1].compareTo(gbs[j]) > 0){
                    swap(gbs,j-1, j);
                }
            }
        }
        for(GourdBoys gb:gbs){
            orderReport(gb,ReportMethod.name);
        }
    }

    static void biInsertSort(Object a[]){
        GourdBoys[] gbs = (GourdBoys[]) a;
        for(int pos = 1; pos < gbs.length; pos++){
            int start = 0;
            int end = pos;
            int aim = pos / 2;
            boolean less = aim != 0 && gbs[aim - 1].compareTo(gbs[pos]) > 0;
            boolean more = gbs[aim].compareTo(gbs[pos]) < 0;
            while(less || more){
                if(more){

                    start = aim;
                    aim = (start + end) / 2 + 1;
                    less = aim != 0 && gbs[aim - 1].compareTo(gbs[pos]) > 0;
                    more = gbs[aim].compareTo(gbs[pos]) < 0;
                }
                else{
                    end = aim;
                    aim = (start + end) / 2;
                    less = aim != 0 && gbs[aim - 1].compareTo(gbs[pos]) > 0;
                    more = gbs[aim].compareTo(gbs[pos]) < 0;
                }
            }
            if(aim != pos){
                GourdBoys temp = gbs[pos];
                for(int j = pos; j > aim; j--){
                    orderReport(gbs[j-1],ReportMethod.positionChange,j-1,j);
                    gbs[j] = gbs[j - 1];
                }
                gbs[aim] = temp;
                orderReport(gbs[aim],ReportMethod.positionChange,pos,aim);//gbs[aim].report_change(pos, aim);
            }
        }
        for(GourdBoys gb:gbs){
            orderReport(gb,ReportMethod.color);
        }
    }



}
