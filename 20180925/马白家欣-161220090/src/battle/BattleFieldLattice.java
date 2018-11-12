package com.homework3.battle;

import com.homework3.being.CartoonCharacter;

/**
 * @Description 战场方格，每个方格都含有一个CartoonCharacter角色，注意什么都没有也是一种特殊的CartoonCharacter
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class BattleFieldLattice {

    private CartoonCharacter cartoonCharacter;

    public BattleFieldLattice()
    {
        cartoonCharacter = new CartoonCharacter(" ");
    }

    public BattleFieldLattice(CartoonCharacter cartoonCharacter)
    {
        this.cartoonCharacter = cartoonCharacter;
    }

    public CartoonCharacter getCartoonCharacter() {
        return cartoonCharacter;
    }
}
