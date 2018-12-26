/**The second assignment.
 * 1.0: Create an array list and sort it's elements by MyQuickSort.
 * 2.0: Create two objects: HuluBrother and Grandfather, and add some ways of sorting(Bubble sort and Binary sort).
 * @author Jingtao Wang
 * @author 161220123
 * @version 2.0
 */

public class MainDemo {
    public static void main(String[] args) {
        Grandfather mySelf = new Grandfather();

        mySelf.initPosition();
        System.out.println("原始位置序列：");
        for(int i = 0; i < 7; i++)
            System.out.print(mySelf.position[i] + 1 + " ");
        System.out.print("\n");
        System.out.println("移动过程：");
        mySelf.sortByName();
        System.out.print("\n\n");

        mySelf.initPosition();
        System.out.println("原始位置序列：");
        for(int i = 0; i < 7; i++)
            System.out.print(mySelf.position[i] + 1 + " ");
        System.out.print("\n");
        System.out.println("移动过程：");
        mySelf.sortByColor();
        System.out.print("\n");
    }
}
