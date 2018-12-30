package controllers;

import logic.battleInformation.*;

public class GameModel<T> {
    private Board board;
    private JustSide<T> justSide;
    private EvilSide<T> evilSide;

    public GameModel(Class<T> tClass) {
        this.board = new Board();
        Sides.formation = new Formation(this.board);

        this.justSide = new JustSide<>(tClass);
        this.evilSide = new EvilSide<>(tClass);
    }

    public Board getBoard() {
        return board;
    }

    public JustSide getJustSide() {
        return justSide;
    }

    public EvilSide getEvilSide() {
        return evilSide;
    }
}
