import static java.lang.System.out;

public class Sort
{
    public static void main(String[] args)
    {
        int a[] = new int[]{4, 2, 6, 5, 10, 3, 8, 7, 9, 1};
        boolean exchanged = false;

        for (int i = 0; i < a.length-1; i++)
        {
            exchanged = false;
            for (int j = 0; j < a.length - 1 - i; j++)
                if (a[j] > a[j + 1])
                {
                    exchanged = true;
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            if (!exchanged)
                break;
        }

        for (int i = 0; i < a.length; i++)
            out.print(i + " ");
    }
}
