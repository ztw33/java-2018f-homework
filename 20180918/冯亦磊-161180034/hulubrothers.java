import java.util.*;

public enum hulubrothers {
    RED(1, "红色", "老大"), ORANGE(2, "橙色", "老二"), YELLOW(3, "黄色", "老三"), GREEN(4, "绿色", "老四"),
    CYAN(5, "青色", "老五"), BLUE(6, "蓝色", "老六"), PURPLE(7, "紫色", "老七");
    private int rank;
    private String color;
    private String desc;//中文描述

    private hulubrothers(int rank, String color, String desc) {
        this.rank = rank;
        this.color = color;
        this.desc = desc;
    }



    public static void BubbleSort(hulubrothers[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].rank > arr[j + 1].rank) {
                    System.out.println(arr[i].desc + ":" + (j + 1) + "->" + (j + 2));
                    hulubrothers temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void BinaryInsertSort(hulubrothers[] arr) {
        for (int i = 1; i < arr.length; i++) {
                hulubrothers temp = arr[i];
                int low= 0;
                int high = i - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (arr[mid].rank > temp.rank) {
                        high = mid - 1;
                    } else if(arr[mid].rank < temp.rank){
                        low = mid + 1;
                    }
                }
                    for (int j = i-1; j >= low; j--) {
                        arr[j+1] = arr[j];
                    }
                    arr[low] = temp;
                    System.out.println(temp.desc + ":" + (i + 1) + "->" + (low+1) );

        }
    }

    public static hulubrothers[] RandomArray(hulubrothers[] arr){
        int len=arr.length;
        for(int i=0;i<len-1;i++){
            int randomi=(int)(Math.random()*(len-i));
            hulubrothers tmp=arr[randomi];
            arr[randomi]=arr[len-i-1];
            arr[len-i-1]=tmp;
        }
        return arr;
    }

    public static void PrintName(hulubrothers[] arr) {
        for (int i=0; i < arr.length; i++) {
            System.out.println(arr[i].desc);
        }
    }

    public static void PrintColor(hulubrothers[] arr) {
        for (int i=0; i < arr.length; i++) {
            System.out.println(arr[i].color);
        }
    }

    public static void main(String[] args) {
        hulubrothers[] arr = {RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE};
        RandomArray(arr);
        System.out.println("Random list:");
        PrintName(arr);
        System.out.println("冒泡排序:");
        BubbleSort(arr);
        System.out.println("排序后报数:");
        PrintName(arr);
        RandomArray(arr);
        System.out.println("Random list:");
        PrintName(arr);
        System.out.println("二分排序:");
        BinaryInsertSort(arr);
        System.out.println("排序后报数:");
        PrintColor(arr);
    }
}
