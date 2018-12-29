package map;

import creature.*;

public class HuluCamp {
    //葫芦娃阵营，含葫芦兄弟与葫芦爷爷；该阵营有不同的阵型；
    private CalaBrother calaBrother;
    private GrandFather grandFather;

    public HuluCamp(){
        calaBrother  = new CalaBrother();
        grandFather = new GrandFather();
    }

    public void queue1(Map map){
        map.initHuluwa();
        calaBrother.queue1(map);
        grandFather.standOn(map,1,5);
    }

    public void queue2(Map map){
        map.initHuluwa();
        calaBrother.queue2(map);
        grandFather.standOn(map,4,1);
    }

    public void queue3(Map map){
        map.initHuluwa();
        calaBrother.queue3(map);
        grandFather.standOn(map,4,1);
    }

    public void queue4(Map map){
        map.initHuluwa();
        calaBrother.queue4(map);
        grandFather.standOn(map,4,1);
    }

    public void queue5(Map map){
        map.initHuluwa();
        calaBrother.queue5(map);
        grandFather.standOn(map,4,1);
    }

    public void queue6(Map map){
        map.initHuluwa();
        calaBrother.queue6(map);
        grandFather.standOn(map,4,1);
    }

    public void queue7(Map map){
        map.initHuluwa();
        calaBrother.queue7(map);
        grandFather.standOn(map,5,5);
    }
    public void queue8(Map map){
        map.initHuluwa();
        calaBrother.queue8(map);
        grandFather.standOn(map,4,1);
    }
}
