package njuics.java2018;

import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Sort {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        String str = s.nextLine();
        String []nums = str.split(" ");
        for (int i = 0; i < nums.length; i++)
        {
            int temp = Integer.parseInt(nums[i]);
            list.add(temp);
            for (int j = i - 1, k = i; j >= 0; j--, k--)
                if (list.get(j) > list.get(k))
                    Collections.swap(list, j, k);
        }
        System.out.println(list);
    }
}
