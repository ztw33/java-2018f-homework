
public class Main {
	public static final int land_length = 15; 
	public static final int land_width = 15;
	public static void main(String[] args)
	 {	 
		 //很久很久以前，有一片神奇的葫芦大地
		 Land huluLand=new Land(land_length,land_width);
		 //上面生活着蝎子精和蛇精以及一位老爷爷
		 Scorpion scorpion=new Scorpion();				
		 Snake snake=new Snake();
		 Grandpa grandpa=new Grandpa();
		 //有一天老爷爷偶然发现了一根葫芦藤，种下去后竟生出了葫芦娃！	 
		 HuLuWa []huluwa=grandpa.huluwaBorn(); 			
		//葫芦娃的诞生打破了葫芦大地的沉寂...
		 huluLand.showActivities(grandpa,huluwa,scorpion,snake);
		 
	 }	 
}
