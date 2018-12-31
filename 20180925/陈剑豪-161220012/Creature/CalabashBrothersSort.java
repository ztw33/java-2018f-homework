package Creature;
/**
 * @ Author     ：cjh
 * @ Description：葫芦娃排序
 */
public class CalabashBrothersSort {
    public static void sortByName(CalabashBrothers[] brothers)/**冒泡法*/
    {
        for(int i = 0; i < brothers.length; i++)
        {
            for(int j = i + 1; j < brothers.length; j++)
            {
                if(brothers[i].rank>brothers[j].rank)
                {
                    //brothers[i].reportSwap(i,j);
                    //brothers[j].reportSwap(j,i);
                    CalabashBrothers.swapPosition(brothers,i,j);
                }
            }
        }
    }

    public static void sortByColor(CalabashBrothers[] brothers)/**二分法*/
    {
        for(int i=1;i<brothers.length;i++)
        {
            if(brothers[i].rank<brothers[i-1].rank)
            {
                int left=0;
                int right=i-1;
                while (left<=right)
                {
                    int mid = (left + right) / 2;
                    if (brothers[i].rank < brothers[mid].rank)
                    {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                //brothers[i].reportSwap(i,left);
                CalabashBrothers temp=brothers[i];
                for(int j = i; j > left; j--)
                {
                    //brothers[j-1].reportSwap(j-1,j);
                    brothers[j]=brothers[j-1];
                }
                brothers[left]=temp;
            }
        }
    }
}
