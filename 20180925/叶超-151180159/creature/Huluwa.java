package creature;

import battlefield.BattleField;

public enum Huluwa implements Creature
{
		hongwa("老大","红色"),chengwa("老二","橙色"),huangwa("老三","黄色"),lvwa("老四","绿色"),qingwa("老五","青色"),lanwa("老六","蓝色"),ziwa("老七","紫色");
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

