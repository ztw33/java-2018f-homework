package battle;

import being.*;

/**
 * @Description 战场方格，每个方格都含有一个CartoonCharacter角色，注意什么都没有也是一种特殊的CartoonCharacter
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class BattleFieldLattice {

    private CartoonCharacter cartoonCharacter;

    public BattleFieldLattice() {
        this.cartoonCharacter = new CartoonCharacter(" ");
    }

    public BattleFieldLattice(CartoonCharacter cartoonCharacter) {
        assert cartoonCharacter != null;
        this.cartoonCharacter = cartoonCharacter;
    }

    public CartoonCharacter getCartoonCharacter() {
        return cartoonCharacter;
    }
}
