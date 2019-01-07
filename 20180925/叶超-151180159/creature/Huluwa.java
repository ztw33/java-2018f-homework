package creature;

import battlefield.BattleField;

public enum Huluwa implements Creature
{
		hongwa("�ϴ�","��ɫ"),chengwa("�϶�","��ɫ"),huangwa("����","��ɫ"),lvwa("����","��ɫ"),qingwa("����","��ɫ"),lanwa("����","��ɫ"),ziwa("����","��ɫ");
		String name;
		String color;
		Huluwa(String name,String color)
		{
			this.name=name;
			this.color=color;
		}
		
		public String get_name()
		{
			return name;
		}
		public String get_color()
		{
			return color;
		}
		public int get_color_ordinal()
		{
			return this.ordinal();
		}
		@Override
		public char getSymbol()
		{
			return String.valueOf(this.ordinal()+1).charAt(0);
		}
		@Override
		public void move(BattleField field,int x,int y){
			field.setCreature(x, y, this);
		}
		@Override
		public void leave(BattleField field,int x,int y){
			field.clearCreature(x, y);
		}
}

