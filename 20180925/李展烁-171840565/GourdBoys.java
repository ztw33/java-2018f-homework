public enum GourdBoys implements GoodFollower{
    老大("赤色"),老二("橙色"),老三("黄色"),老四("绿色"),老五("青色"),老六("蓝色"),老七("紫色");
    private String color;
    private GourdBoys(String color)
    {
        this.color = color;
    }
    MoveDevice moveDevice;

    @Override
    public void setMoveDevice(MoveDevice moveDevice) {
        this.moveDevice = moveDevice;
    }

    public void print(){
        System.out.print(this.toString().replace("老",""));
    }

    @Override
    public void move(int x1, int y1, int x2, int y2) {
        moveDevice.moveMethod(x1, y1, x2, y2);
    }
}
