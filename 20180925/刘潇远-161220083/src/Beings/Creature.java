package java2018.CalabashBrother.Beings;
public class Creature extends Beings{
	protected int CE;//Combat Effectiveness
	protected int DEF;//Defence
	protected int HP;//Health Point
	protected boolean Motivated;
	protected boolean livingStatus;
	Creature(int CE, int DEF, int HP){
		this.CE = CE;
		this.DEF = DEF;
		this.HP = HP;
		Motivated = false;
		livingStatus = true;
	}
	Creature(int CE, int DEF, int HP, boolean Motivated){
		this.CE = CE;
		this.DEF = DEF;
		this.HP = HP;
		this.Motivated = Motivated;
		livingStatus = false;
	}
	public int getDEF() {
		return DEF;
	}
	public int getHP() {
		return HP;
	}
	public boolean isMotivated() {
		return Motivated;
	}
	public boolean isLiving() {
		return livingStatus;
	}
	public void setMotivated(boolean Motivated) {
		this.Motivated = Motivated;
	}
	public void Attack(Creature attackedBeing,int radio) {
		if(this.getCE(radio) > (attackedBeing.HP + attackedBeing.DEF)){
			attackedBeing.livingStatus = false;
			attackedBeing.HP = 0;
		}
		else
			attackedBeing.HP  = attackedBeing.HP - (this.getCE(radio) - attackedBeing.DEF);
	}
	public int getCE(int radio) {
		if(Motivated)
			return CE * radio;
		else
			return CE;
	}
}
