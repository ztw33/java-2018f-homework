package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Main {
    public Main() {
    }

    void sort1(int[] n, String[] ss) {
        int i;
        System.out.println("冒泡排序法：");
        for(i = 0; i < n.length - 1; ++i) {
            for(int j = 0; j < n.length - i - 1; ++j) {
                if (n[j] > n[j + 1]) {
                    System.out.print(ss[n[j]- 1]+":");
                    System.out.print(j + "->");
                    System.out.println((j + 1));
                    int temp = n[j + 1];
                    n[j + 1] = n[j];
                    n[j] = temp;

                }
            }
        }

        System.out.print("排序后的数组：");

        for(i = 0; i < n.length; ++i) {
            System.out.print(n[i] + " ");
        }

        System.out.println();
    };

    void sort2(int[] data, String[] ss) {
        int left,right,num;

        int middle,j;
        //int mid;
        for( int i = 1; i < data.length; i++ ) {

            // 准备

            left = 0;

            right = data.length-1;

            num = i;

            // 二分法查找插入位置

            while( right >= left ) {

                // 指向已排序好的中间位置

                middle = ( left + right ) / 2;
                //mid = middle;

                if( num < data[middle] ) {

                    right = middle - 1;  // 插入的元素在右区间
                }

               else

                left = middle+1;  // 插入的元素在左区间

            }

            // 后移排序码大于R[i]的记录

       // for( j = i-1; j >= left; j-- ) {
         //   System.out.print(ss[data[j]- 1]+":");
           // System.out.print(j + "->");
            //System.out.println((j + 1));
            //data[j+1] = data[j];

        //}
            int mid = 0;
            for(int jj =0;jj < data.length;jj++){
                if(data[jj] == i){
                    mid = jj;
                }
            }

            // 插入
            System.out.print(ss[num- 1]+":");
            System.out.print(mid + "->");
            System.out.println(i);
            int temp = data[i -1];
            data[i-1] = i;
            data[mid] = temp;


        }


        System.out.print("排序后的数组：");

        for(int i = 0; i < data.length; ++i) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }




    void init(int[] n){

        for(int i = 0; i < n.length; ++i) {
            int temp = (int)(Math.random() * 7) + 1;
            int temp1 = 0;
            for(int j = 0;j <=i;j++){
                if(temp == n[j]){
                    temp1 = 1;
                }

            }
            if(temp1 == 1){
                i--;

            }
            else{
                n[i] = temp;
                System.out.print(n[i]+" ");
            }

        }


    }




    public static void main(String[] args) {

        int[] arrat1 = new int[7];
        String[] array2 = new String[7];
        array2[0] = "老大";
        array2[1] = "老2";
        array2[2] = "老3";
        array2[3] = "老4";
        array2[4] = "老5";
        array2[5] = "老6";
        array2[6] = "老7";
        String[] array3 = new String[7];
        array3[0] = "红";
        array3[1] = "橙";
        array3[2] = "黄";
        array3[3] = "绿";
        array3[4] = "青";
        array3[5] = "蓝";
        array3[6] = "紫";


        System.out.print("葫芦娃随机位置：");
        Main m = new Main();
        m.init(arrat1);

        System.out.println();

        m.sort1(arrat1, array2);
        System.out.print("报数集合:");

        for(int i = 0; i <arrat1.length; ++i) {
            System.out.print(array2[i] + " ");
        }

        System.out.println();

        System.out.print("葫芦娃随机位置再次排序：");

        m.init(arrat1);
        m.sort2(arrat1,array2);

        System.out.print("报数集合:");
        for(int i = 0; i <arrat1.length; ++i) {
            System.out.print(array3[i] + " ");
        }

        System.out.println();
    }
}

