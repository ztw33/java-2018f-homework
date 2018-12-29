import java.util.Random;

public class Sort {
    CalabashBrothers[] brothers;
    Sort() {
        brothers = new CalabashBrothers[7];
        brothers[0] = new RedBoy();
        brothers[1] = new OrangeBoy();
        brothers[2] = new YellowBoy();
        brothers[3] = new GreenBoy();
        brothers[4] = new CyanBoy();
        brothers[5] = new BlueBoy();
        brothers[6] = new PurpleBoy();
    }
    public void RandomSort(){
        int[] queue = new int[7];
        for(int j = 0;j < 7;j++)
            queue[j] = -1;
        int ran = 0;
        int count = 0;
        boolean flag = false;
        while(count < 7)
        {
            Random RandomNumber = new Random();
            ran = Math.abs(RandomNumber.nextInt()) % 7 + 1;
            for(int i = 0;i < count;i++) {
                if (ran == queue[i]) {
                    flag = true;
                    break;
                } else
                    flag = false;
            }
            if(!flag)
            {
                queue[count] = ran;
                count++;
            }
        }

        CalabashBrothers[] new_line = new CalabashBrothers[7];
        for(int i = 0;i < 7;i++)
        {
            switch (queue[i])
            {
                case 1:new_line[i] = brothers[0];break;
                case 2:new_line[i] = brothers[1];break;
                case 3:new_line[i] = brothers[2];break;
                case 4:new_line[i] = brothers[3];break;
                case 5:new_line[i] = brothers[4];break;
                case 6:new_line[i] = brothers[5];break;
                case 7:new_line[i] = brothers[6];break;
                default:new_line[i] = new CalabashBrothers();break;
            }
        }
        brothers = new_line;

        //for(int i = 0;i < 7;i++)
        //    brothers[i].TellMyName();

    }
    void MoveBoys(CalabashBrothers Boy1,CalabashBrothers Boy2 )
    {
        if(Boy1 == Boy2)
            return;
        Boy2 = Boy1;
    }
    public void BubbleSort()
    {
        for(int i = 0;i < 7;i++)
        {
            for(int j = i+1; j < 7;j++)
            {
                if(brothers[i].FamilyRank > brothers[j].FamilyRank)
                {
                    brothers[i].TellPositionChange(i,j);
                    brothers[j].TellPositionChange(j,i);

                    CalabashBrothers temp = brothers[i];
                    brothers[i] = brothers[j];
                    brothers[j] = temp;
                }
            }
        }
        for(int i = 0;i < 7;i++)
            brothers[i].TellMyName();
    }
    public void BinarySort()
    {
        int left,right,middle;
        for(int i = 1;i < 7;i++) {
            left = 0;
            right = i - 1;
            CalabashBrothers temp = brothers[i];
            while (left <= right) {
                middle = (left + right) / 2;
                if (brothers[middle].FamilyRank > temp.FamilyRank)
                    right = middle - 1;
                else
                    left = middle + 1;
            }
            for (int j = i - 1; j >= left; j--) {
                brothers[j].TellPositionChange(j, j + 1);

                brothers[j+1] = brothers[j];
            }
            if(i != left) {
                brothers[left] = temp;
                brothers[left].TellPositionChange(7, left);
            }
        }
        for (int m = 0; m < 7; m++)
            brothers[m].TellMyColor();
    }
    public static void main(String []args)
    {
        Sort sort = new Sort();
        sort.RandomSort();
        sort.BubbleSort();
        sort.RandomSort();
        sort.BinarySort();
    }
}
