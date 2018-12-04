public enum Enemy {
    XZJ("蝎子精"), XLL1("小喽啰1"), XLL2("小喽啰2"), XLL3("小喽啰3"), XLL4("小喽啰4"),
    XLL5("小喽啰5"), XLL6("小喽啰6"), XLL7("小喽啰7"), XLL8("小喽啰8");
    private String name;
    private int x;
    private int y;

    private Enemy(String name) {
        this.name = name;
        //初始化坐标
        this.x = this.ordinal();
        this.y = 15;
    }

    public boolean ifempty() {
        return false;
    }


    public Space getSpace() {
        Space e = new Space(x, y);
        return e;
    }

    public String getName() {
        return name;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setSpace(int x,int y){
        this.x=x;
        this.y=y;
    }
/*    public void setXzj(int x,int y){
        XZJ.x=x;
        XZJ.y=y;
    }
    public void setXll1(int x,int y){
        XLL1.x=x;
        XLL1.y=y;
    }
    public void setXll2(int x,int y){
        XLL1.x=x;
        XLL1.y=y;
    }
    public void setXll3(int x,int y){
        XLL1.x=x;
        XLL1.y=y;
    }
    public void setXll4(int x,int y){
        XLL1.x=x;
        XLL1.y=y;
    }
    public void setXll5(int x,int y){
        XLL1.x=x;
        XLL1.y=y;
    }
    public void setXll6(int x,int y){
        XLL1.x=x;
        XLL1.y=y;
    }
    public void setXll7(int x,int y){
        XLL1.x=x;
        XLL1.y=y;
    }
    public void setXll8(int x,int y){
        XLL1.x=x;
        XLL1.y=y;
    }
*/
}


