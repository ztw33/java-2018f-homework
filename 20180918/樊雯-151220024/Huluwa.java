package work2_huluwa;

enum Name { �ϴ�, �϶�, ����, ����, ����, ����, ����; }
enum Color { ��ɫ, ��ɫ, ��ɫ, ��ɫ, ��ɫ, ��ɫ, ��ɫ; }
public class Huluwa{
	 private int order; //��¼����վλ
	 private int trueorder;//ʵ������
	 Name name;
	 Color colour;	 

	 public Huluwa() {}
	    public Huluwa(int num,int place) {
	    	this.trueorder = num;
	        this.order = place;
	        name =Name.values()[num];
	        colour = Color.values()[num];
	    } 
	    
	    public void changeplace(int newpos){
	    	int tmp = this.order;
	    	this.order = newpos;
	    	System.out.printf(name + " :"+tmp+"->"+newpos+"  ");
	    }//��λ�ò���үү�����Լ����ƶ���
	    
	    
	    public void getname() {
	    	System.out.printf(name + " ");
	    }
	    public void getcolor() {
	    	System.out.printf(colour + " ");
	    }
	    public void getposition() {
	    	System.out.printf(order + " ");
	    }
	    public int gettrue() {
	        return this.trueorder;
	    }
}