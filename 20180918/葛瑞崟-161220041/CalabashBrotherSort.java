
enum CalabashBrother{
    FIRST("老大", "红色"), SECOND("老二", "橙色"), THIRD("老三", "黄色"),
    FORTH("老四", "绿色"), FIFTH("老五","青色"), SIXTH("老六", "蓝色"), SEVENTH("老七", "紫色");

    private String name;
    private String color;

    CalabashBrother(String name, String color){
        this.name = name;
        this.color = color;
    }
    void setPos(int pos, int newPos){
        System.out.print(name + ", " + pos + "->" + newPos + " ");
    }
    void numberOffByName(){
        System.out.print(name + " ");
    }
    void numberOffByColor(){
        System.out.print(color + " ");
    }
}

class CalabashQueue {
    private final static int NUM = 7;
    private CalabashBrother[] brothers;
    //ArrayList<Integer> line;
    private int[] line;
    CalabashQueue() {
        brothers = CalabashBrother.values();
        line = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            line[i] = -1;
        }
        //random();
    }
    private boolean contains(int num) {
        for (int i = 0; i < NUM; i++) {
            if (line[i] == num)
                return true;
        }
        return false;
    }
    void random() {
        for (int i = 0; i < NUM; i++)
            line[i] = -1;
        for (int i = 0; i < NUM; i++) {
            int num = (int) (Math.random() * 7);
            if (contains(num))
                i--;
            else {
                line[i] = num;
                //brothers[num].rePos(i);
            }
        }
        System.out.print("Random line up: ");
        for (int i = 0; i < NUM; i++)
            System.out.print(line[i] + " ");
        System.out.println();
    }
    void bubbleSort() {
        for (int i = 0; i < NUM - 1; i++){
            for (int j = 0; j < NUM - i - 1; j++){
                if (line[j] > line[j + 1]) {
                    brothers[line[j]].setPos(j,j + 1);
                    brothers[line[j + 1]].setPos(j + 1, j);
                    System.out.println();
                    int temp = line[j];
                    line[j] = line[j + 1];
                    line[j + 1] = temp;
                }
            }
        }
        numberOffByName();
    }
    void binaryInsertSort(){
        for (int i = 0; i < NUM; i++){
            int temp = line[i], num = i;
            int left = 0, right = i - 1, mid = 0;
            while (left <= right){
                mid = (left + right) / 2;
                if (temp < line[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            for (int j = i - 1 ; j >= left; j--){
                brothers[line[j]].setPos(j,j + 1);
                line[j + 1] = line[j];
            }
            if (left != i){
                brothers[temp].setPos(num, left);
                System.out.println();
                line[left] = temp;
            }
        }
        numberOffByColor();
    }
    private void numberOffByName(){
        System.out.print("Number off: ");
        for (int i = 0; i < NUM; i++)
            brothers[line[i]].numberOffByName();
        System.out.println();
    }
    private void numberOffByColor(){
        System.out.print("Number off: ");
        for (int i = 0; i < NUM; i++)
            brothers[line[i]].numberOffByColor();
        System.out.println();
    }
}

public class CalabashBrotherSort {
    public static void main(String[] args) {
        CalabashQueue q = new CalabashQueue();
        q.random();
        q.bubbleSort();
        q.random();
        q.binaryInsertSort();
        return;
    }
}
