class Car {
    Car(GourdBoy gourdBoy) {
        this.gourdBoy = gourdBoy;
    }

    GourdBoy getGourdBoy() {
        return gourdBoy;
    }

    private GourdBoy gourdBoy;

    void move(int startPoint, int endPoint){
        System.out.println("车载着"+gourdBoy.attribute.getName()+"移动:"+startPoint+"->"+endPoint);
    }
}
