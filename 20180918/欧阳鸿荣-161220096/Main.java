package calabashBrothers;

/**
 * @ Author     ：Young
 * @ Description：一个有关葫芦娃的程序
 */
public class Main {
    public static void Test(){
        Test sortTest = new Test();
        sortTest.binaryTest();
        sortTest.bubbleTest();
    }

    public static void main(String[] args) {

        Grandpa grandpa = new Grandpa();

        System.out.println("----有一天，爷爷在山上发现了七个葫芦娃，于是爷爷让他们报数：");
        grandpa.tellBoysReportDetails();
        System.out.println("----他们竟然是，有组织有纪律作风优良的葫芦娃？爷爷很吃惊，打乱了他们");
        grandpa.disruptQueue();
        System.out.println("----打乱了他们后，爷爷又让他们报数");
        grandpa.tellBoysReportDetails();
        System.out.println("----“果然是一群机灵的小鬼！”爷爷心里想。于是爷爷决定教他们用冒泡排序法的思想排队");
        grandpa.calabashBrothersBubbleSort();
        System.out.println("----排序后，爷爷又让他们报数");
        grandpa.tellBoysReportNames();
        System.out.println("----“只教一遍就会！”爷爷感到很欣慰,决定教他们用二分排序法的思想排队");
        System.out.println("----于是爷爷让他们随机站位，打乱了他们，然后让他们再报数：");
        grandpa.disruptQueue();
        grandpa.tellBoysReportNames();
        System.out.println("----经过爷爷的教育，葫芦娃们学会了二分排序法，当场展示了一下：");
        grandpa.calabashBrothersBinarySort();
        grandpa.tellBoysReportColors();
        System.out.println("----“真是聪明的小葫芦娃！”，爷爷激动地把他们带回了家");

    }
}
