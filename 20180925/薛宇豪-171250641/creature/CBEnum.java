package creature;

import javafx.scene.image.Image;

public enum CBEnum {
    First("大娃",new Image("/images/老大.png"),"红色"),
    Second("二娃",new Image("/images/老二.png"),"橙色"),
    Third("三娃",new Image("/images/老三.png"),"黄色"),
    Fourth("四娃",new Image("/images/老四.png"),"绿色"),
    Fifth("五娃",new Image("/images/老五.png"),"青色"),
    Sixth("六娃",new Image("/images/老六.png"),"蓝色"),
    Seventh("七娃",new Image("/images/老七.png"),"紫色");

    private String name;
    private String color;
    private Image image;

    CBEnum(String name,Image image, String color){
        this.name=name;
        this.image=image;
        this.color=color;
    }
    public String getName(){
        return name;
    }
    public String getColor(){
        return color;
    }
    public Image getImage(){
        return image;
    }

}
