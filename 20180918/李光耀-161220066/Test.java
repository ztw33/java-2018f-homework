
public class Test {
	Administer ad=new Administer();
	Test(){
		
	}
	public static void main(String[] args) {
		Test test=new Test();
		test.ad.randomStand();
		System.out.println("随机排列:");
		test.ad.speakName();
		test.ad.sortName();
		System.out.println("冒泡排序后:");
		test.ad.speakName();
		
		test.ad.randomStand();
		System.out.println("随机排列:");
		test.ad.speakColor();
		test.ad.sortColor();
		System.out.println("二分排序后:");
		test.ad.speakColor();
	}
}
