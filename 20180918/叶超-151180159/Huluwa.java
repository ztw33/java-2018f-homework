package huluwa;

public enum Huluwa 
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
}

