package calabashbrothers;

public class Operate{
	public static calabash[] bros=new calabash[7];
	public static scorpion scorp;
	public static minion[] minis;
	public static grandpa grandpa;
	public static snake sna;
	public static void calabash_init(){
		brother[] colors={brother.orange,brother.blue,brother.green,
				brother.purple,brother.red,brother.cyan,brother.yellow};
		for(int i=0;i<7;i++){
			bros[i]=new calabash(colors[i]);
		}
	}
	public static void scorp_init() {
		scorp=new scorpion();
	}
	public static void minions_init(int num) {
		minis=new minion[num];
		for(int i=0;i<num;i++) {
			minis[i]=new minion();
		}
	}
	public static void grandpa_init() {
		grandpa=new grandpa();
	}
	public static void snake_init() {
		sna=new snake();
	}
	
	@SuppressWarnings({ "unused", "static-access" })
	public static void main(String[] argvs) {
		calabash_init();
		Field.c_queue(bros);
		Field.show();
		scorp_init();
		Formation forma=Field.formachose();
		minions_init(forma.num);
		Field.s_queue(forma,scorp,minis);
		Field.show();
		grandpa_init();
		Field.g_join(grandpa);
		Field.show();
		snake_init();
		Field.s_join(sna);
		Field.show();
	}
}
