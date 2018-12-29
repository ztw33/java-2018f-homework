import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CalabashMan {
    public CalabashMan(String name, Color color) {
        totalCalabashManNum++;
        this.sequence = totalCalabashManNum;
        this.name = name;
        this.color = color;
    }

    static private int totalCalabashManNum = 0;
    private int sequence;
    private String name;
    private Color color;

    public int getSequence() {
        return sequence;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}

enum Color {
    RED("红色"), ORANGE("橙色"), YELLOW("黄色"), GREEN("绿色"), CYAN("青色"), BLUE("蓝色"), VIOLET("紫色");

    private String label;

    private Color(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}

class CalabashManSort {
    public static void sortBySequence(CalabashMan[] brothers) {
        for (int i = 0; i < brothers.length - 1; i++) {
            for (int j = 0; j < brothers.length - i - 1; j++) {
                if (brothers[j].getSequence() > brothers[j + 1].getSequence()) {
                    // report
                    reportExchange(brothers[j], j, j + 1);
                    reportExchange(brothers[j + 1], j + 1, j);

                    // exchange
                    CalabashMan temp = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = temp;
                }
            }
        }
    }

    public static void sortByColor(CalabashMan[] brothers) {
        for (int i = 1; i < brothers.length; i++) {
            CalabashMan target = brothers[i];
            int location = binarySearchByColor(brothers, 0, i - 1, target);
            if (i != location) {
                for (int j = i; j > location; j--) {
                    reportExchange(brothers[j - 1], j - 1, j);
                    brothers[j] = brothers[j - 1];
                }
                reportExchange(target, i, location);
                brothers[location] = target;
            }
        }
    }

    private static int binarySearchByColor(CalabashMan[] brothers, int left, int right, CalabashMan target) {
        if (left == right) {
            return (brothers[left].getColor().ordinal() > target.getColor().ordinal()) ? left : left + 1;
        }

        // else
        int mid = (left + right) / 2;
        if (target.getColor().ordinal() == brothers[mid].getColor().ordinal()) {
            return mid + 1;
        } else if (target.getColor().ordinal() < brothers[mid].getColor().ordinal()) {
            return binarySearchByColor(brothers, left, mid == left ? mid : mid - 1, target);
        } else {
            return binarySearchByColor(brothers, mid == right ? mid : mid + 1, right, target);
        }
    }

    private static void reportExchange(CalabashMan man, int src, int dst) {
        System.out.println(man.getName() + ": " + src + "->" + dst);
    }
}

class CalabashManSortTest {
    public static void main(String[] args) {
        // create brothersList
        final CalabashMan[] brothers = { new CalabashMan("老大", Color.RED), new CalabashMan("老二", Color.ORANGE),
                new CalabashMan("老三", Color.YELLOW), new CalabashMan("老四", Color.GREEN),
                new CalabashMan("老五", Color.CYAN), new CalabashMan("老六", Color.BLUE),
                new CalabashMan("老七", Color.VIOLET), };
        List<CalabashMan> brothersList = Arrays.asList(brothers);

        // generate random sequence array and test
        Collections.shuffle(brothersList);
        CalabashMan[] randomSequenceBrothers = brothersList.toArray(new CalabashMan[0]);
        CalabashManSort.sortBySequence(randomSequenceBrothers);
        for (CalabashMan x : randomSequenceBrothers) {
            System.out.print(x.getName() + " ");
        }
        System.out.println();

        // generate random color array and test
        Collections.shuffle(brothersList);
        CalabashMan[] randomColorBrothers = brothersList.toArray(new CalabashMan[0]);
        CalabashManSort.sortByColor(randomColorBrothers);
        for (CalabashMan x : randomColorBrothers) {
            System.out.print(x.getColor() + " ");
        }
        System.out.println();

        // check
        boolean sequenceSorted = true, colorSorted = true;
        for (int i = 0; i < randomSequenceBrothers.length - 1; i++) {
            if (randomSequenceBrothers[i].getSequence() > randomSequenceBrothers[i + 1].getSequence()) {
                sequenceSorted = false;
            }
        }
        for (int i = 0; i < randomColorBrothers.length - 1; i++) {
            if (randomColorBrothers[i].getColor().ordinal() > randomColorBrothers[i + 1].getColor().ordinal()) {
                colorSorted = false;
            }
        }
        System.out.println("Both sorted: " + (sequenceSorted && colorSorted));
    }
}
