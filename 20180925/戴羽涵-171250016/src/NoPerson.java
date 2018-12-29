public enum NoPerson implements Creature<NoPerson> {
	NO_PERSON;

	private final int rank=-1;

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getSymbol() {
		return "  ";
	}

	@Override
	public int getRank() {
		return this.rank;
	}

	@Override
	public boolean less(NoPerson noPerson) {
		return false;
	}

}
