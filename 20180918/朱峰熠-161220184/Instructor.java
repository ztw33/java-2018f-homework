import java.util.Random;
public class Instructor {
    public Calabash_Brothers array[] ;
    Instructor(){
        array = new Calabash_Brothers[7];
    }
    public void Init_Array(){
        array[0] = Calabash_Brothers.Red;
        array[1] = Calabash_Brothers.Orange;
        array[2] = Calabash_Brothers.Yellow;
        array[3] = Calabash_Brothers.Green;
        array[4] = Calabash_Brothers.Cyan;
        array[5] = Calabash_Brothers.Blue;
        array[6] = Calabash_Brothers.Purple;
        for(int i = 0; i < 7; i++){
            array[i].site = i;
        }
    }

    public void GetRandomArray(){

        Random rand = new Random();
        int seed = rand.nextInt(4);
        Calabash_Brothers temp = array[seed];
        array[seed] = array[(seed+3)%7];
        array[(seed+3)%7] = temp;

        Random rand2 = new Random();
        int seed2 = rand2.nextInt(4);
        Calabash_Brothers temp2 = array[seed2];
        array[seed2] = array[(seed2+3)%7];
        array[(seed2+3)%7] = temp2;

        for(int i = 0; i < 7; i++){
            array[i].site = i;
        }
    }

    public void Bubble_Sort(){
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6 - i; j++)
            {
                if (array[j].GetRank() > array[j + 1].GetRank())
                {
                    array[j].Number_Off(array[j+1]);
                    //array[j+1].Number_Off(array[j]);

                    Calabash_Brothers temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
            }
        for(int i = 0; i < 7; i++){
            array[i].Name_Call();
        }
    }

    public void Binary_Sort(){
        for(int i = 1; i < 7; i++){
            int left = 0;
            int right = i - 1;
            int middle = 0;
            Calabash_Brothers temp = array[i];
            while(left <= right){
                middle = left + (right - left)/2;
                if(temp.GetRank() < array[middle].GetRank())
                {
                    right = middle - 1;
                }
                else {
                    left = middle + 1;
                }
            }
            for(int j = i - 1; j >= left; j--)
                array[j+1] = array[j];
            array[left] = temp;
            array[left].Number_Off(array[i]);
            //array[left+1].Number_Off(array[left]);
        }
        for(int i = 0; i < 7; i++){
            array[i].Color_Call();
        }
    }
};

