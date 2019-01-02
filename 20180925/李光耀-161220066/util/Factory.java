package util;

public interface Factory<T> {
	T create();
	T back();
}
