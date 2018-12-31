package com.company.Being;

public class Snake extends Monster implements Cheer{
    public Snake(){
        super("蛇");
    }

    @Override
    public void cheer() {
        assert false;
    }
}
