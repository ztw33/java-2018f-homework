package factory;

import being.*;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/11/18
 */
public class JusticeFactory implements IFactory<Justice> {
    public Justice create() {
        return new Justice();
    }
}
