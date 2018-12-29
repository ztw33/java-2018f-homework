package Ground;
import CommonMethods.Dispatcher;
import CommonMethods.PointNode;

import java.util.*;
/**单个坐标点的类
 * 考虑到战斗场地是由矩阵所构成，而每个坐标点在之后的完善过程中，可能产生自己的功能
 * 比如某些特定坐标能产生新葫芦，可以帮助葫芦娃抵挡一次攻击，诸如此类的功能
 * 为了方便接口使用和扩展，将单个横纵坐标定义为类
 */
public class Point{
    private boolean isCreature;
    private String name;

    Point(){
        this.isCreature = false;
        this.name = null;
    }

    public boolean isCreature() {
        return isCreature;
    }

    public void setCreature(boolean creature) {
        isCreature = creature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


