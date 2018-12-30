import static java.lang.System.out;
import java.util.Random;

enum HuLuBroAge {
    老大, 老二, 老三, 老四, 老五, 老六, 老七
}

enum HuLuBroColor {
    红色, 橙色, 黄色, 绿色, 蓝色, 青色, 紫色
}


class HuLuBro {
    private int rank;

    public HuLuBro(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}

class SortHuLuBro {
    public void ageSort(HuLuBro[] brother) {
        boolean changeSign = false;

        for (int i = 0; i < brother.length - 1; i++) {
            changeSign = false;

            for (int j = 0; j < brother.length - 1 - i; j++) {
                if (HuLuBroAge.values()[brother[j].getRank()].ordinal() > HuLuBroAge.values()[brother[j + 1].getRank()].ordinal()) {
                    changeSign = true;
                    out.println(HuLuBroAge.values()[brother[j + 1].getRank()] + ": " + (j + 1) + "->" + j);
                    out.println(HuLuBroAge.values()[brother[j].getRank()] + ": " + j + "->" + (j + 1));
                    HuLuBro tmp = brother[j];
                    brother[j] = brother[j + 1];
                    brother[j + 1] = tmp;
                }   
            }
            if (!changeSign) {
                break;
            }
        }
        for (int i = 0; i < brother.length; i++) {
                out.print(HuLuBroAge.values()[brother[i].getRank()] + " ");
        }
        out.println();
    }

    public void colorSort(HuLuBro[] brother) {
        for (int i = 1; i < brother.length; i++) {
            int left = 0, right = i - 1, mid = 0;
            while (left < right) {
                mid = (left + right) / 2;
                if (HuLuBroColor.values()[brother[i].getRank()].ordinal() > HuLuBroColor.values()[brother[mid].getRank()].ordinal()) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            int insertPos = 0;
            if (HuLuBroColor.values()[brother[i].getRank()].ordinal() > HuLuBroColor.values()[brother[left].getRank()].ordinal()) {
                insertPos = left + 1;
            } else {
                insertPos = left;
            }

            HuLuBro tmp = brother[i];
            for (int j = i; j > insertPos; j--) {
                brother[j] = brother[j - 1];
                out.println(HuLuBroAge.values()[brother[j].getRank()] + ": " + (j - 1) + "->" + j);
            }
            brother[insertPos] = tmp;
            if (insertPos != i) {
                out.println(HuLuBroAge.values()[brother[insertPos].getRank()] + ": " + i + "->" + insertPos);
            }
        }

        for (int i = 0; i < brother.length; i++) {
                out.print(HuLuBroColor.values()[brother[i].getRank()] + " ");
        }
        out.println();
    }
}

public class TestHuLuBro {
    public static void main(String[] args) {
        HuLuBro[] huluBros = {new HuLuBro(0), new HuLuBro(1),  new HuLuBro(2),  new HuLuBro(3),  new HuLuBro(4),  new HuLuBro(5),  new HuLuBro(6)};
        
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int pos1 = random.nextInt(7), pos2 = random.nextInt(7);
            HuLuBro tmp = huluBros[pos1];
            huluBros[pos1] = huluBros[pos2];
            huluBros[pos2] = tmp;
        }

        
        SortHuLuBro sort = new SortHuLuBro();
        out.println("Sorted by Age:");
        sort.ageSort(huluBros);

        for (int i = 0; i < 10; i++) {
            int pos1 = random.nextInt(7), pos2 = random.nextInt(7);
            HuLuBro tmp = huluBros[pos1];
            huluBros[pos1] = huluBros[pos2];
            huluBros[pos2] = tmp;
        }
        out.println("\nSorted by Color:");
        sort.colorSort(huluBros);
    }
}