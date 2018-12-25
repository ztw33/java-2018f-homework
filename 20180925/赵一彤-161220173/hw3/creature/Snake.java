package hw3.creature;

import hw3.Cheerable;

public class Snake extends Monster implements Cheerable {
    public Snake() {
        super();
    }

    @Override
    public String printName() {
        return "蛇精";
    }

    public void cheer() {
        System.out.println("蛇精为怪物们助威");
    }
}
