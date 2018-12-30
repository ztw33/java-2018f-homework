public interface Creature<T> {
	public String getName();

	public String getSymbol();

	public int getRank();

	public boolean less(T t);

}
