package creature;


/**
* @ClassName: Being
* @Description: 所有物体的基类
* @author 13745
* @date 2018年11月4日
*
*/
public class Being {
	private String name;
	private StyleImage image;
	
	public Being(String name,StyleImage image) {
		this.name=name;
		this.image=image;
	}
	public String getName(){
		return name;
	}
	public StyleImage getImage(){
		return image;
	}	
}

