package factory;

import being.*;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/11/18
 */
public class EvilFactory implements IFactory<Evil> {
    public Evil create() {
        return new Evil();
    }
}
