package environment;

public class Formation {
    final static int num = 7;
    String name;
    int[] leaderPos;
    int[][] array;
    {
        array = new int[num][];
        for (int i = 0; i < num; ++i) {
            array[i] = new int[2];
        }
        leaderPos = new int[2];
    }

    public Formation(int[][] arg, String str, int[] argLeaderPos) {
        for (int i = 0; i < num; ++i) {
            array[i][0] = arg[i][0];
            array[i][1] = arg[i][1];
        }
        name = str;
        leaderPos = argLeaderPos;
    }
    public int getSize() {
        return num;
    }
    public int[] getCoord(int n) {
        if (n < 0 || n >= num)
            return null;
        else
            return array[n];
    }
    public int[] getLeaderPos() {
        return leaderPos;
    }
}
