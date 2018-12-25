package being;

/**
 * @Description 卡通人物（而不是卡通字符）
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class CartoonCharacter extends Being {

    private String label;

    public CartoonCharacter() {
        this.label = " ";
    }


    public CartoonCharacter(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
