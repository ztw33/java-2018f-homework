public class sort {
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        for(int i=0; i< numbers.length; i++)
        {
            int temp = numbers[i];
            int count=0;
            for(int j=0;j<numbers.length;j++)
            {
                if(numbers[j] < temp)
                    count++;
            }
            int temp2 =numbers[count];
            numbers[count]=numbers[i];
            numbers[i]=temp2;
        }

        System.out.println("The Numbers from small to big is : " );
        for(int i=0;i<numbers.length;i++)
            System.out.printf( "%d %c",numbers[i] ," ");
        System.out.printf( "\n");
    }
}