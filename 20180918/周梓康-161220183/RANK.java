public enum RANK {

    FIRST("老大"), SECOND("老二"), THIRD("老三"), FOURTH("老四"), FIFTH("老五"), SIXTH("老六"), SEVENTH("老七");

    private String rank;

    RANK(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return rank;
    }
}