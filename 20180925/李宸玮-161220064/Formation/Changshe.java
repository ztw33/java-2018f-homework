package Formation;

import Creature.Creature;

import java.util.List;

public class Changshe {
        protected String name;

        public void setName() {
            this.name = "长蛇阵";
        }
        public void setChangshe(Creature crowd[]){
            for(int i=0;i<7;i++){
                crowd[i].moveto(0,0+i);//根据需排阵的群体设置其位置，这里长蛇阵横坐标一样
            }
        }
}
