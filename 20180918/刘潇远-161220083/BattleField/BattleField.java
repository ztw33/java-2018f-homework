
package BattleField;
import Beings.*;
public class BattleField<T extends Beings> {

	private T Being;
	BattleField(){
		Being = null;
	}
	BattleField(T t){
		Being = t;
	}
	public boolean isEmpty() {
		return Being == null;
	}
	public T getBeing() {
		return Being;
	}
	public T removeBeing() {
		T res = Being;
		Being = null;
		return res;
	}
	public boolean setBeing(T t) {//使用前必须先调用removeBeing()方法，此处为了防止忘记调用，内嵌了调用
		//???真的要先调用remove吗？还没想清楚，暂且保留
		removeBeing();
		if(isEmpty()) {
			Being = t;
			return true;
		}
		else
			return false;
	}
}
