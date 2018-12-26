package characters;

//葫芦娃信息的枚举类型
public enum CalabashInfo {
	//实例化
	Red("老大"),
	Orange("老二"),
	Yellow("老三"),
	Green("老四"),
	Cyan("老五"),
	Blue("老六"),
	Purple("老七");
	//数据成员
	private String name;
	
	//构造函数
	private CalabashInfo(String name) {
		this.name=name;
	}
	
}
