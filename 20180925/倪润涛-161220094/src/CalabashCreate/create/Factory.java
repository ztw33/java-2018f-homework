package CalabashCreate.create;

import CalabashCreate.beings.*;

interface InterFactory<T> {
    T createO();
    T []createN(int n);
    T [][]createMatrix(int n);
}

public class Factory implements InterFactory<Beings> {
    public Beings createO()
    {
        return new Beings();
    }
    public Beings[] createN(int n)
    {
        return new Beings[n];
    }

    public Beings[][] createMatrix(int n)
    {
        return new Beings[n][n];
    }
}
