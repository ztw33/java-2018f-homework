public class Huluwa extends Creature {
    // constructor
    Huluwa(int i) {
        super(HuluwaNames.values()[i].toString(), HuluwaColors.values()[i].toString());
    }
}
enum HuluwaNames {
    大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃
}

enum HuluwaColors {
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}
