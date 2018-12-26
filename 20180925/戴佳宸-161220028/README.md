#**一、程序说明**
这个程序实现的是在一个11×11的方格图上显示葫芦娃与蝎子精对峙的局面，葫芦娃固定长蛇阵，蝎子精率领小喽啰可以变阵。为了使显示更加形象，我用了图形化用户界面，swing程序设计。
***
#**二、运行步骤**
把src、img还有jar包文件放在**同一个目录**下然后在javajdk环境下可以直接双击jar文件运行。
***
#**三、代码说明**
`int row=11;`

`int col=11;`
	
`static JLabel lab[]=new JLabel[121];`

row和col定义了方格图的行和列数，lab数组是一个储存了121个JLabel的数组，用于显示121个方格。把每个JLabel看成一个对象。

在主类hom3（继承JFrame）的构造函数中，建立了一个11行11列的网格布局管理器。

`Container container=getContentPane();`

`setLayout(new GridLayout(11,11));`

为了实现“根据用户需求自由变阵”的功能，我设置了几个按钮JButton，每个按钮对应的点击事件就是完成一次变阵。位置分别是7、8、9、10、18格。

为了在某个特定位置的方格上显示角色（葫芦娃、老爷爷、蝎子精、蛇精、小喽啰），需要实现一个函数setwa

	
`public static void setwa(JLabel jl,String url) `
	
		{ java.net.URL imgURL1 = hom3.class.getResource(url);
		ImageIcon image = new ImageIcon(imgURL1);
		image.setImage(image.getImage().getScaledInstance(jl.getWidth(), jl.getHeight(),Image.SCALE_DEFAULT ));
		jl.setIcon(image);
		jl.setHorizontalAlignment(0); }

该函数实现的是在某个JLabel上显示地址为url的图片。

其他的变阵函数包括葫芦娃长蛇阵的初始化都是调用这个函数来实现的，简单明了。

***
#**四、程序运行效果**
开始：
![](https://i.imgur.com/nxW6J3K.png)

点击右上角某个按钮即可变阵（以衡轭阵为例）
![](https://i.imgur.com/7KvecOd.png)
其他的阵法可以自行点击查看结果。