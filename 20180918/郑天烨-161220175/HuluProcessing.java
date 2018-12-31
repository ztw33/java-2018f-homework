import java.util.Random;

public class HuluProcessing
{
    private HuluBrothers Brothers;

    HuluProcessing()
    {
        Brothers = new HuluBrothers();
    }

    public void Reordering()
    {
        // reorder the brothers sequence
        Random ranNum = new Random();
        for (int i = 0; i < HuluBrothers.broNum; i++)
        {
            int temp = ranNum.nextInt(i+1);
            Brothers.Swap(temp,i);
        }
    }

    public void HuluBubbleSort()
    {
        for (int i = 0; i < HuluBrothers.broNum-1; i++) {
            for (int j = 0; j < HuluBrothers.broNum-1-i; j++) {
                if(Brothers.getIthRank(j) > Brothers.getIthRank(j+1))
                {
                    System.out.println(Brothers.getIthName(j) + (j+1) + "->" + (j+2));
                    System.out.println(Brothers.getIthName(j+1) + (j+2) + "->" + (j+1));
                    Brothers.Swap(j,j+1);
                }
            }
        }
        Brothers.NumberOffbyName();
    }

    private void BiSort(int start , int end)
    {
        if(start >= end)
            return;
        int middle = (start + end) / 2;
        BiSort(start,middle);
        BiSort(middle+1,end);

        // merge the two result together
        int mergeNum = end - start + 1;
        SingleHuluBrother[] temp = new SingleHuluBrother[mergeNum];
        int n = 0; // the index of temp
        int n1 = start , n2 = middle+1;
        while((n1 != middle+1) && (n2 != end+1))
        {
            if(Brothers.getIthRank(n1) < Brothers.getIthRank(n2))
            {
                if(n1 != start + n)
                {
                    System.out.println(Brothers.getIthName(n1) + (n1+1) + "->" + (start+n+1));
                }
                temp[n] = Brothers.getBrother(n1);
                n++; n1++;
            }
            else
            {
                if(n2 != start + n)
                {
                    System.out.println(Brothers.getIthName(n2) + (n2+1) + "->" + (start+n+1));
                }
                temp[n] = Brothers.getBrother(n2);
                n++; n2++;
            }
        }
        if(n1 == middle+1)
        {
            while(n2 != end+1)
            {
                temp[n] = Brothers.getBrother(n2);
                n++; n2++;
            }
        }
        else
        {
            while(n1 != middle+1)
            {
                System.out.println(Brothers.getIthName(n1)+ (n1+1) + "->" + (start+n+1));
                temp[n] = Brothers.getBrother(n1);
                n++; n1++;
            }
        }
        for (int i = 0; i < mergeNum; i++) {
            Brothers.setBrother(temp[i],start+i);
        }
    }

    public void HuluBinarySort()
    {
        BiSort(0,HuluBrothers.broNum-1);
        Brothers.NumberOffbyColor();
    }

    public static void main(String[] args) {
        HuluProcessing bro = new HuluProcessing();
        bro.Reordering();
        bro.HuluBubbleSort();
        bro.Reordering();
        bro.HuluBinarySort();
    }
}
