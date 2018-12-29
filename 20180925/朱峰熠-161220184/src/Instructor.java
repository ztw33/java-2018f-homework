import java.io.CharArrayReader;
import java.security.PublicKey;
import java.util.Random;
public class Instructor {
    Instructor(){
        CalaBrothers.Init_Array_Bros();
        Monster.Init_Mice();
        Map.Init_Map();
    }

    public void GetRandomArray() {

        Random rand = new Random();
        int seed = rand.nextInt(4);
        CalaBrothers temp = CalaBrothers.CalaBros[seed];
        CalaBrothers.CalaBros[seed] = CalaBrothers.CalaBros[(seed + 3) % 7];
        CalaBrothers.CalaBros[(seed + 3) % 7] = temp;

        Random rand2 = new Random();
        int seed2 = rand2.nextInt(4);
        CalaBrothers temp2 = CalaBrothers.CalaBros[seed2];
        CalaBrothers.CalaBros[seed2] = CalaBrothers.CalaBros[(seed2 + 3) % 7];
        CalaBrothers.CalaBros[(seed2 + 3) % 7] = temp2;

        for (int i = 0; i < 7; i++) {
            CalaBrothers.CalaBros[i].site = i;
        }
    }

    public void Bubble_Sort(){
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6 - i; j++)
            {
                if (CalaBrothers.CalaBros[j].GetRank() > CalaBrothers.CalaBros[j + 1].GetRank())
                {
                    //array[j].Number_Off(array[j+1]);
                    //array[j+1].Number_Off(array[j]);

                    CalaBrothers temp = CalaBrothers.CalaBros[j];
                    CalaBrothers.CalaBros[j] = CalaBrothers.CalaBros[j + 1];
                    CalaBrothers.CalaBros[j + 1] = temp;

                }
            }
        for(int i = 0; i < 7; i++) {
            CalaBrothers.CalaBros[i].Name_Call();
        }
    }

    public void Binary_Sort(){
        for(int i = 1; i < 7; i++){
            int left = 0;
            int right = i - 1;
            int middle = 0;
            CalaBrothers temp = CalaBrothers.CalaBros[i];
            while(left <= right){
                middle = left + (right - left)/2;
                if(temp.GetRank() < CalaBrothers.CalaBros[middle].GetRank())
                {
                    right = middle - 1;
                }
                else {
                    left = middle + 1;
                }
            }
            for(int j = i - 1; j >= left; j--)
                CalaBrothers.CalaBros[j+1] = CalaBrothers.CalaBros[j];
            CalaBrothers.CalaBros[left] = temp;
            //array[left].Number_Off(array[i]);
            //array[left+1].Number_Off(array[left]);
        }
         for(int i = 0; i < 7; i++){
             CalaBrothers.CalaBros[i].Color_Call();
        }
    }

}
