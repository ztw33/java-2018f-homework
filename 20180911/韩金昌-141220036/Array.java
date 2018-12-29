public class Array {
    private int[] people=new int[] {1,5,-9,49,-85,65,45,10,0,-3,98,77,-56,74,36};

    public int show() {
        if (people.length < 1) {
            System.out.println("array.length<1");
            return people.length;
        }
        for (int i = 0;i < people.length;i++) {
            System.out.print(people[i]);
            System.out.print(' ');
        }
        System.out.print('\n');
        return people.length;
    }

    public int sort() {
        if (people.length < 1) {
            System.out.println("array.length<1");
            return people.length;
        }
        int exchange = 0;
        for (int n = people.length - 1; n > 0; n--) {
            for (int i = 0; i < n; i++) {
                if (people[i] > people[i + 1]) {
                    exchange = people[i];
                    people[i] = people[i + 1];
                    people[i + 1] = exchange;
                }
            }
        }
        return people.length;
    }
}
