public enum CalabashBrother {

    RED(COLOR.RED, RANK.FIRST), ORANGE(COLOR.ORANGE, RANK.SECOND), YELLOW(COLOR.YELLOW, RANK.THIRD),
    GREEN(COLOR.GREEN, RANK.FOURTH), CYAN(COLOR.CYAN, RANK.FIFTH), BLUE(COLOR.BLUE, RANK.SIXTH),
    PURPLE(COLOR.PURPLE, RANK.SEVENTH);

    private COLOR color;
    private RANK rank;

    CalabashBrother(COLOR color, RANK rank) {
        this.color = color;
        this.rank = rank;
    }

    public RANK getRank() {
        return rank;
    }

    public COLOR getColor() {
        return color;
    }
}





