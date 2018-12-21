package com.company;

public class SortIntArray {/**创建人：陈剑豪 创建时间：2018.9.11*/
    void sort(int[] array){/**默认从小到大排序,采用冒泡排序的方式*/
        for(int i = 0; i < array.length; i++)
        {
            for(int j = i + 1; j < array.length; j++)
            {
                if(array[i] > array[j])
                {
                    int temp = 0;
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
    public static void main(String[] args)/*程序测试接口*/
    {
        // 随便初始化一个数组
        int[] array = {67, 9889, 123, 234, 1, 6, 9, -4, 0, 43};
        SortIntArray A = new SortIntArray();
        // 调用排序方法
        A.sort(array);
        // 输出结果
        for(int i = 0;i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}
