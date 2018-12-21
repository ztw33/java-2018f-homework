public class CalabashBrothers {
    private CalabashBoy []SevenBrothers;
    public CalabashBrothers(int []num)
    {
        SevenBrothers = new CalabashBoy[num.length];
        for(int i = 0; i < num.length; i++)
        {
            SevenBrothers[i] = new CalabashBoy(num[i]);
        }
    }
    public void BubbleSort()
    {
        for(int i = 0; i < SevenBrothers.length - 1; i++)
        {
            for(int j = i + 1; j < SevenBrothers.length; j++)
            {
                if(SevenBrothers[i].CompareOrder(SevenBrothers[j]) > 0)
                {
                    System.out.println(SevenBrothers[i].getName() + "：" + SevenBrothers[i].getOrder() + " -> " + SevenBrothers[j].getOrder());
                    CalabashBoy temp = SevenBrothers[j];
                    SevenBrothers[j] = SevenBrothers[i];
                    SevenBrothers[i] = temp;
                }
            }
        }
    }
    public void CountOff()
    {
        for(int i = 0; i < SevenBrothers.length; i++)
        {
            System.out.println(SevenBrothers[i].getName());
        }
    }
    private void QuickSort(int left,int right)
    {
        int i, j;
        if(left > right)
            return;
        CalabashBoy temp = new CalabashBoy(SevenBrothers[left]); //temp中存的就是基准数
        i = left;
        j = right;
        while(i != j)
        {
            //顺序很重要，要先从右边开始找
            while(SevenBrothers[j].CompareColor(temp) >= 0  && i < j)
                j--;
            //再找右边的
            while(SevenBrothers[i].CompareColor(temp) <= 0  && i < j)
                i++;
            //交换两个数在数组中的位置
            if(i < j)
            {
                System.out.println(SevenBrothers[i].getName() + "：" + SevenBrothers[i].getOrder() + " -> " + SevenBrothers[j].getOrder());
                CalabashBoy tmp = SevenBrothers[j];
                SevenBrothers[j] = SevenBrothers[i];
                SevenBrothers[i] = tmp;
            }
        }
        //最终将基准数归位
        SevenBrothers[left] = SevenBrothers[i];
        SevenBrothers[i] = temp;

        QuickSort(left,i-1);//继续处理左边的，这里是一个递归的过程
        QuickSort(i + 1,right);//继续处理右边的 ，这里是一个递归的过程
    }
    public void ColorOff()
    {
        for(int i = 0; i < SevenBrothers.length; i++)
        {
            System.out.println(SevenBrothers[i].getColorName());
        }
    }
    public static void main(String []args)
    {
        /*int []array = {7, 6, 5, 1, 2, 4, 3};
        CalabashBrothers Brothers = new CalabashBrothers(array);
        Brothers.BubbleSort();
        Brothers.CountOff();*/
        int []newarray = {7, 6, 5, 1, 2, 4, 3};
        CalabashBrothers NewBrothers = new CalabashBrothers(newarray);
        NewBrothers.QuickSort(0, 6);
        NewBrothers.ColorOff();
    }
}
