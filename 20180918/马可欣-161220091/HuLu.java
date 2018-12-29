public class HuLu {
    //冒泡
    public static void mp(Name[] a) {
        int i = 6, j = 0;
        for (i = a.length - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (a[j].ordinal() > a[j + 1].ordinal()) {
                    System.out.print(a[j].toString() + ":" + (j + 1) + "->" + (j + 2) + " ");
                    System.out.print(a[j + 1].toString() + ":" + (j + 2) + "->" + (j + 1) + " ");

                    Name temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.print("\n");

        for (i = 0; i < a.length; i++)
            System.out.print(a[i].toString() + " ");
        System.out.print("\n");

    }

    //二分
    public static void ef(Color[] a) {
        int i = 0, j = 0;
        int left = 0, right = 0;
        int mid = (left + right) / 2;
        for (i = 1; i < a.length; i++) {
            left = 0;
            right = i - 1;
            mid = (left + right) / 2;

            while (left <= right) {
                if (a[i].ordinal() < a[mid].ordinal()) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                mid = (left + right) / 2;
            }
            Color temp = a[i];
            String tempname=a[i].getName();
            for (j = i; j > left; j--) {
                System.out.print(a[j-1].getName() + ":" + j + "->" + (j + 1) + " ");
                a[j] = a[j - 1];
            }
            if(left!=i) {
                System.out.print(tempname + ":" + (i + 1) + "->" + (left + 1) + " ");
                a[left] = temp;
            }
        }
        System.out.print("\n");
        for (i = 0; i < a.length; i++)
            System.out.print(a[i].toString() + " ");
    }

    public static void main(String[] args) {
        Name[] bron = {Name.ONE, Name.FIVE, Name.TWO, Name.FOUR, Name.THREE, Name.SIX, Name.SEVEN};
        Color[] broc = {Color.RED, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.CYAN, Color.BLUE, Color.PURPLE};
        mp(bron);
        ef(broc);
    }
    public enum Name {
        ONE("老大"), TWO("老二"), THREE("老三"), FOUR("老四"), FIVE("老五"), SIX("老六"), SEVEN("老七");
        private String name;
        // private int id;

        private Name(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public enum Color {
        RED("红色", "老大"), ORANGE("橙色", "老二"), YELLOW("黄色", "老三"), GREEN("绿色", "老四"), CYAN("青色", "老五"), BLUE("蓝色", "老六"), PURPLE("紫色", "老七");
        private String color;
        private String name;

        private Color(String color, String name) {
            this.name = name;
            this.color=color;
        }
        public String getName(){
            return name;
        }
        public String getColor(){
            return color;
        }
        @Override
        public String toString() {
            return this.color;
        }
    }


}
