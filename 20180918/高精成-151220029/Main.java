public class Main{
	public static void main(String[] args) {
		CalabashBrothers test = new CalabashBrothers();
		test.start();
	}
}
//定义葫芦娃类，包含属性有名字、颜色、等阶(老大排名第一，即rank = 1，按此类推)
class Calabash{
	public int rank;
	protected String name;
	protected String color;
	public int position;
	Calabash (int i) {
		rank = i;
		position = i;
		switch (i){
			case 1:
				name = "老大"; color = "红色"; break;
			case 2:
				name = "老二"; color = "橙色"; break;
			case 3:
				name = "老三"; color = "黄色";  break;
			case 4:
				name = "老四"; color = "绿色"; break;
			case 5:
				name = "老五"; color = "青色"; break;
			case 6:
				name = "老六"; color = "蓝色"; break;
			case 7:
				name = "老七"; color = "紫色"; break;
			default:
				break;
		}
	}
}
//定义葫芦娃兄弟类，有7个葫芦娃，因此实例化7个成员变量

class CalabashBrothers {
	Calabash[] cucurbit = new Calabash[7];
	// 该数组记录每个位置是站了那个葫芦娃 比如 array[0] = 2 表示1号位置是老二橙娃
	int[] array = new int[7]; 
	// 构造函数
	CalabashBrothers () {
		for(int i=0;i<7;i++){
			cucurbit[i] = new Calabash(i+1);
		}
	}
	// 随机排列葫芦娃
	void randomArrange() {
		int count = 10;
		positionToRank();
		while (count>0) {
			for(int i=1;i<7;i++){
				if(Math.random()<0.6){
					int temp = cucurbit[0].position;
					cucurbit[0].position = cucurbit[i].position;
					cucurbit[i].position = temp; 
				}
			}
			positionToRank();
			count--;
		}
	}
	// 将葫芦娃的位置放入数组array
	void positionToRank () {
		for(int i=0;i<7;i++){
			array[cucurbit[i].position-1] = cucurbit[i].rank;
		}
	}
	// 冒泡排序交换2个葫芦娃
	void exchangeOfBubbleSort (int a,int b) {
		System.out.println(cucurbit[a].name +": "+cucurbit[a].position + "->"+cucurbit[b].position);
		//System.out.println(cucurbit[b].name +": "+cucurbit[b].position + "->"+cucurbit[a].position);
		System.out.println();
		int temp = cucurbit[a].position;
		cucurbit[a].position = cucurbit[b].position;
		cucurbit[b].position = temp;
	}
	// 葫芦娃报数
	void reportNum () {
		for(int i=0;i<array.length;i++) {
			System.out.print(cucurbit[array[i]-1].name+" ");
		}
		System.out.println();
	}
	// 葫芦娃报告颜色
	void reportColor () {
		for(int i=0;i<array.length;i++) {
			System.out.print(cucurbit[array[i]-1].color+" ");
		}
		System.out.println();
	}
	// 冒泡排序
	void bubbleSort () {
		for(int i=0;i<array.length-1;i++)
    	for(int j=1;j<array.length-i;j++){
    		if(array[j-1] > array[j]){
    			exchangeOfBubbleSort(array[j-1]-1,array[j]-1);
    			int temp = array[j];
    			array[j] = array[j-1];
    			array[j-1] = temp;
    		}
		}
	}
	// 2分法插入排序
	void binaryInsertSort () {
		for(int i = 1;i<array.length;i++){
			int temp = array[i];//待插入到前面有序序列的值
			int left = 0;//有序序列的左侧
			int right = i-1;//有序序列的右侧
			int middle = 0;//有序序列的中间
			while(left <= right){
				middle = (left + right)/2;//赋值
				if(temp<array[middle]){
					right = middle-1;
				}else{
					left = middle + 1;
				}
			}
			for(int j = i-1;j>=left;j--){
			//从i-1到left依次向后移动一位,等待temp值插入
				String name = cucurbit[array[j]-1].name;
				System.out.println(name +": "+(j+1)+"->"+(j+2));
				array[j+1] = array[j];
			}
			if(left != i ){
				System.out.println(cucurbit[temp-1].name+": "+(i+1)+"->"+(left+1));				
				array[left] = temp;
			}
			System.out.println();
		}
	}
	void start () {
		randomArrange(); // 产生随机序列
		reportNum(); // 打印随机站队的葫芦娃兄弟
		bubbleSort(); // 冒泡排序
		reportNum(); // 打印排序后的葫芦娃兄弟
		System.out.print("\n\n");
		randomArrange(); // 产生随机序列
		reportNum(); // 打印随机序列
		reportColor(); // 报告颜色
		binaryInsertSort(); // 2分法插入排序
		reportColor(); // 报告颜色
	}
}
