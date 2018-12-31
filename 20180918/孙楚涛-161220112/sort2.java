public class sort2
{
	public enum huluwa{
		red("老大","红色",1),orange("老二","橙色",2),yellow("老三","黄色",3),green("老四","绿色",4),cyan("老五","青色",5),blue("老六","蓝色",6),purple("老七","紫色",7);
		private String name;
		private String color;
		private int order;

		private huluwa(String name,String color,int order)
		{
			this.name = name;
			this.color = color;
			this.order = order;
		}
	}
	
	public static int [] init_by_name(String [] str)
	{
		int [] a = new int[str.length];
		for(int i = 0;i<str.length;++i)
		{
			for(huluwa n: huluwa.values())
			{
				if(n.name == str[i])
				{
					a[i] = n.order;
					break;
				}
			}
		}
		return a;
	}

	public static void print_name(int a)
	{
		for(huluwa n: huluwa.values())
		{
			if(n.order == a)
			{
				System.out.print(n.name);
			}
		}
	}
	
	public static int [] init_by_color(String [] str)
	{
		int [] a = new int[str.length];
		for(int i = 0;i<str.length;++i)
		{
			for(huluwa n: huluwa.values())
			{
				if(n.color == str[i])
				{
					a[i] = n.order;
					break;
				}
			}
		}
		return a;
	}

	public static void print_color(int a)
	{
		for(huluwa n: huluwa.values())
		{
			if(n.order == a)
			{
				System.out.print(n.color);
			}
		}
	}
	
	public static void sort_bubble(String [] str)
	{
		int [] a = init_by_name(str);

		for(int i = a.length-1;i>=0;--i)
		{
			for(int j = 0;j<i;++j)
			{
				if(a[j] > a[j+1])
				{
					print_name(a[j]);
					System.out.println(":"+ j + "->" + (j+1));
					print_name(a[j+1]);
					System.out.println(":"+ (j+1) + "->" + j);

					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}

		for(int i = 0;i<a.length;++i)
		{
			print_name(a[i]);
			System.out.print(" ");
		}
		System.out.print("\n");
	}

	public static void sort_dichotomy(String [] str)
	{
		int [] a = init_by_color(str);

		sort_dichotomy_merge(a,0,a.length-1);

		for(int i = 0;i<a.length;++i)
		{
			print_color(a[i]);
			System.out.print(" ");
		}
		System.out.print("\n");
	}

	public static void sort_dichotomy_merge(int [] a,int first,int last)
	{
		if(first < last)
		{
			int mid = (first+last)/2;
			sort_dichotomy_merge(a,first,mid);
			sort_dichotomy_merge(a,mid+1,last);
			sort_merge(a,first,mid,last);
		}
	}

	public static void sort_merge(int [] a,int first,int mid,int last)
	{
		int [] temp= new int[last-first+1];
		int i = first;
		int j = mid + 1;
		int k = 0;
			
		while (i <= mid && j <= last)
		{
			if (a[i] <= a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		
		while (i <= mid)
			temp[k++] = a[i++];
		
		while (j <= last)
			temp[k++] = a[j++];
		
		for (i = 0; i < k; i++)
		{
			int place = 0;
			
			for(int x = 0;x<a.length;++x)
			{
				if(a[x] == temp[i])
				{
					place = x;
				}
			}
			
			if(place != first+i)
			{
				print_name(temp[i]);
				System.out.println(":"+ place + "->" + (first+i));
			}
		}
		
		for (i = 0; i < k; i++)
		{
			a[first + i] = temp[i];
		}
	}
	
	public static void main(String [] avg)
	{
		String [] str = {"老二","老六","老五","老七","老大","老四","老三"};
		sort_bubble(str);
		System.out.println();

		String [] str2 = {"橙色","蓝色","青色","紫色","红色","绿色","黄色"};
		sort_dichotomy(str2);
	}
	
}