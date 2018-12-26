package hsc.hw;

enum Huluwa{
    one("老大","红色"), two("老二","橙色"),three("老三","黄色"),
    four("老四","绿色"), five("老五","青色"),six("老六","蓝色"),
    seven("老七","紫色");
    private String name;
    private String color;
    Huluwa(String in_name, String in_color) {
        this.name=in_name;
        this.color=in_color;
    }
    void count_off(){ //报数
        System.out.print(name);
    }
    void report_color(){
        System.out.print(color);
    }
}

class Car{
    Huluwa huluwa;
    private int index;
    private int pre_location;
    private int location;
    Car(Huluwa x,int i){
        huluwa=x;
        index=i;
        pre_location=-1;
        location=-1;
    }
    int get_index(){
        return index;
    }
    void change_location(int n){ //位置变更
        pre_location=location;
        location=n;
    }
    void report_location(){ //报告位置更改
        huluwa.count_off();
        System.out.println(": "+pre_location+"->"+location);
    }
}

class Cars{
    Car []car=new Car[7];
    Car []parking_space=new Car[7];
    Cars(){
        car[0]=new Car(Huluwa.one,0);
        car[1]=new Car(Huluwa.two,1);
        car[2]=new Car(Huluwa.three,2);
        car[3]=new Car(Huluwa.four,3);
        car[4]=new Car(Huluwa.five,4);
        car[5]=new Car(Huluwa.six,5);
        car[6]=new Car(Huluwa.seven,6);
        for(int i=0;i<7;i++){
            car[i].change_location(i);
        }
    }
    void stand_ramdomly(){ //葫芦娃随机站队
        int arr[] = new int[7];
        for (int i = 0; i < arr.length; i++) {
            int index = (int)(Math.random() * 7);
            arr[i] = index;
            for (int j = 0; j < i; j++) {

                if (arr[j] == arr[i]) {
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            parking_space[i]=car[arr[i]];
            car[arr[i]].change_location(i);
        }
    }
    void bubble_sort(){ //冒泡排序
        int arr[]=new int[7];
        for(int i=0;i<7;i++){
            arr[i]=parking_space[i].get_index();
        }
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6 - i; j++)
            {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    parking_space[j]=car[arr[j + 1]];
                    car[arr[j + 1]].change_location(j);
                    car[arr[j + 1]].report_location();

                    parking_space[j + 1]=car[arr[j]];
                    car[arr[j]].change_location(j + 1);
                    car[arr[j]].report_location();
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序完成，开始报数：");
        for (int i = 0; i < 7; i++){
            parking_space[i].huluwa.count_off();
        }
        System.out.print('\n');
    }
    void Binary_Insert_Sort() { //二分排序
        int arr[] = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = parking_space[i].get_index();
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (arr[mid] > temp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i - 1; j >= low; j--) {
                arr[j + 1] = arr[j];
                parking_space[j + 1]=car[arr[j]];
                car[arr[j]].change_location(j + 1);
                car[arr[j]].report_location();
            }
            if(arr[low] != temp) {
                parking_space[low] = car[temp];
                car[temp].change_location(low);
                car[temp].report_location();
            }
            arr[low] = temp;

        }
        System.out.println("二分排序完成，开始报颜色：");
        for (int i = 0; i < 7; i++){
            parking_space[i].huluwa.report_color();
        }
    }
}

public class executor {
    public static void main(String[] args){
        Cars cars=new Cars();
        cars.stand_ramdomly();
        cars.bubble_sort();
        cars.stand_ramdomly();
        cars.Binary_Insert_Sort();
    }
}
