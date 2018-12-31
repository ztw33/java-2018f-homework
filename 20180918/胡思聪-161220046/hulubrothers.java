package com.company;

enum character{
    one("老大","红色",0), two("老二","橙色",1),three("老三","黄色",2),four("老四","绿色",3),
    five("老五","青色",4),six("老六","蓝色",5),seven("老七","紫色",6);
    private String name;
    private String color;
    private int index;
    character(String in_name, String in_color, int in_index) {
        this.name=in_name;
        this.color=in_color;
        this.index = in_index;
    }
    void print_name(){
        System.out.print(name);
    }
    void print_color(){
        System.out.print(color);
    }
    int get_index(){
        return index;
    }
}

class huluwa{ //葫芦娃类
    character huluwa_character; //每个葫芦娃具有特征：姓名，颜色
    private int pre_location; //改变前的位置
    private int location; //改变后的位置
    huluwa(character n){
        huluwa_character=n;
        pre_location=0;
        location=0;
    }
    void change_location(int n){ //位置变更
        pre_location=location;
        location=n;
    }
    void count_off(){ //报数
        huluwa_character.print_name();
    }
    void report_color(){ //报颜色
        huluwa_character.print_color();
    }
    void report_location(){ //报告位置更改
        huluwa_character.print_name();
        System.out.println(": "+pre_location+"->"+location);
    }
}

public class hulubrothers { //葫芦兄弟类
    private huluwa []Calabash_Brothers=new huluwa[7]; //葫芦兄弟由7个葫芦娃构成，葫芦兄弟具有葫芦娃的成员对象
    private huluwa []line=new huluwa[7]; //用数组表示葫芦娃的排列顺序
    private hulubrothers(){
        Calabash_Brothers[0]=new huluwa(character.one);
        Calabash_Brothers[1]=new huluwa(character.two);
        Calabash_Brothers[2]=new huluwa(character.three);
        Calabash_Brothers[3]=new huluwa(character.four);
        Calabash_Brothers[4]=new huluwa(character.five);
        Calabash_Brothers[5]=new huluwa(character.six);
        Calabash_Brothers[6]=new huluwa(character.seven);
        for(int i=0;i<7;i++){
            Calabash_Brothers[i].change_location(i);
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
            line[i]=Calabash_Brothers[arr[i]];
            Calabash_Brothers[arr[i]].change_location(i);
        }
    }
    void bubble_sort(){ //冒泡排序
        int arr[]=new int[7];
        for(int i=0;i<7;i++){
            arr[i]=line[i].huluwa_character.get_index();
        }
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6 - i; j++)
            {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    line[j]=Calabash_Brothers[arr[j + 1]];
                    Calabash_Brothers[arr[j + 1]].change_location(j);
                    Calabash_Brothers[arr[j + 1]].report_location();

                    line[j + 1]=Calabash_Brothers[arr[j]];
                    Calabash_Brothers[arr[j]].change_location(j + 1);
                    Calabash_Brothers[arr[j]].report_location();
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序完成，开始报数：");
        for (int i = 0; i < 7; i++){
            line[i].count_off();
        }
        System.out.print('\n');
    }

    void Binary_Insert_Sort() { //二分排序
        int arr[] = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = line[i].huluwa_character.get_index();
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
                line[j + 1]=Calabash_Brothers[arr[j]];
                Calabash_Brothers[arr[j]].change_location(j + 1);
                Calabash_Brothers[arr[j]].report_location();
            }
            if(arr[low] != temp) {
                line[low] = Calabash_Brothers[temp];
                Calabash_Brothers[temp].change_location(low);
                Calabash_Brothers[temp].report_location();
            }
            arr[low] = temp;

        }
        System.out.println("二分排序完成，开始报颜色：");
        for (int i = 0; i < 7; i++){
            line[i].report_color();
        }
    }

    public static void main(String[] args) {
        hulubrothers brothers=new hulubrothers();
        brothers.stand_ramdomly();
        brothers.bubble_sort();
        brothers.stand_ramdomly();
        brothers.Binary_Insert_Sort();
    }
}
