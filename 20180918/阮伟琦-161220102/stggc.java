enum colours{red,orange,yellow,green,cyan,blue,purple}

class people {
    java.lang.String name;
    int no;
    colours colour;
    int location;
}

class Queue
{
    people[] members;// = new people[7];
    int girls[] = new int[]{5,2,3,0,6,1,4};//record the location of girls

    void initialize()
    {
        members = new people[7];
        //members[0].no = 1;
        for(int i = 0; i < 7; i++)
            members[i] = new people();
        members[0].name = "darjeeling";
        members[0].colour = colours.red;
        members[1].name = "assam";
        members[1].colour = colours.orange;
        members[2].name = "orange pekoe";
        members[2].colour = colours.yellow;
        members[3].name = "rose hip";
        members[3].colour = colours.green;
        members[4].name = "rukuriri";
        members[4].colour = colours.cyan;
        members[5].name = "hurb";
        members[5].colour = colours.blue;
        members[6].name = "cranberry";
        members[6].colour = colours.purple;
        for (int i = 0; i < 7; i++)
            members[i].no = i + 1;
        members[0].location = 3;
        members[1].location = 5;
        members[2].location = 1;
        members[3].location = 2;
        members[4].location = 6;
        members[5].location = 0;
        members[6].location = 4;
    }



    void bubbleSort()
    {
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6 - i; j++)
            {//-1为了防止溢出
                if(girls[j]>girls[j+1])
                {
                    int temp = girls[j];

                    girls[j] = girls[j + 1];

                    girls[j + 1] = temp;

                    int first = girls[j + 1];
                    int second = girls[j];
                    report(j + 1, first);
                    report(j, second);
                    members[first].location = j + 1;
                    members[second].location = j;
                }
                /*int thej = 0, behindj = 0;
                for (int k = 0; k < 7; k++) {
                    if (members[k].location == j)
                        thej = k;
                    if (members[k].location == j + 1)
                        behindj = k;
                }
                if (members[thej].no > members[behindj].no) {
                    int temp = members[thej].location;
                    members[thej].location = members[behindj].location;
                    members[behindj].location = temp;
                }*/
            }
        }
    }

    void report(int now, int no)
    {
        //System.out.println(members[no].location)
        System.out.print(members[no].name);
        System.out.print(':');
        System.out.print(members[no].location);
        System.out.print("->");
        System.out.println(now);
        /*System.out.print(members[second].name);
        System.out.print(':');
        System.out.print(members[second].location);
        System.out.print("->");
        System.out.println(j);*/
    }

    void renewqueue()
    {
        members[0].location = 3;
        members[1].location = 5;
        members[2].location = 1;
        members[3].location = 2;
        members[4].location = 6;
        members[5].location = 0;
        members[6].location = 4;
        //girls[] = {5,2,3,0,6,1,4};
        girls[0] = 5;
        girls[1] = 2;
        girls[2] = 3;
        girls[3] = 0;
        girls[4] = 6;
        girls[5] = 1;
        girls[6] = 4;
    }

    void binarySort()
    {
        for (int i = 1; i < 7; i++)
        {
            int temp = girls[i];
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high)
            {
                mid = low + (high - low) / 2;
                if (girls[mid] > temp)
                    high = mid - 1;

                 else // 元素相同时，也插入在后面的位置
                    low = mid + 1;

            }
            for(int j = i - 1; j >= low; j--)
            {
                girls[j + 1] = girls[j];
                int no = girls[j];
                int now = j + 1;
                report(now,no);
                members[no].location = j + 1;
            }
            girls[low] = temp;
            int no = temp;
            int now = low;
            report(now,no);
            members[no].location = low;
        }
    }

    void reportname()
    {
        for(int i = 0;i < 7; i++)
        {
            System.out.println(members[girls[i]].name);
        }
    }
    void reportcolour()
    {
        for(int i = 0;i < 7; i++)
        {
            System.out.println(members[girls[i]].colour);
        }
    }
}

public class stggc
{
    public static void main(String[] args)
    {
        Queue queue = new Queue();
        queue.initialize();
        queue.bubbleSort();
        queue.reportname();
        System.out.println("*****");
        //queue.renewqueue();
        queue.reportname();
        queue.binarySort();
        queue.reportcolour();
    }
}