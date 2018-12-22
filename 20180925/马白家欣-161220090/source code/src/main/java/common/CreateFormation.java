package common;

import being.CartoonCharacter;
import being.Evil;
import factory.IFactory;
import formation.*;

import java.util.*;

/**
 * @Description 创建随机阵型
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class CreateFormation {

    static public <T extends CartoonCharacter> List<Formation> createRandomFormationArray(IFactory<T> factory) {
        ArrayList<Formation> formationArray = new ArrayList<>();
        formationArray.add(new HeYi<>(factory.create()));
        formationArray.add(new YanXing<>(factory.create()));
        formationArray.add(new ChongE<>(factory.create()));
        formationArray.add(new ChangShe<>(factory.create()));
        formationArray.add(new YuLin<>(factory.create()));
        formationArray.add(new FangYuan<>(factory.create()));
        formationArray.add(new YanYue<>(factory.create()));
        formationArray.add(new FengShi<>(factory.create()));
        Collections.shuffle(formationArray);
        return formationArray;
    }

    static public <T extends CartoonCharacter> Formation createSpecifiedFormation(FormationType formationType, IFactory<T> factory) {

        switch (formationType) {
            case ChangShe:
                return new ChangShe<>(factory.create());
            case ChongE:
                return new ChongE<>(factory.create());
            case FangYuan:
                return new FangYuan<>(factory.create());
            case FengShi:
                return new FengShi<>(factory.create());
            case HeYi:
                return new HeYi<>(factory.create());
            case YanXing:
                return new YanXing<>(factory.create());
            case YanYue:
                return new YanYue<>(factory.create());
            case YuLin:
                return new YuLin<>(factory.create());
            default:
                assert false;
        }
        return null;
    }
}
