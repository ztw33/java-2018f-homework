interface IFactory<T> {
    T createOnes();

    T[][] createMatrix(int n);
}

class BeingsFactory implements IFactory<Being> {
    public Being[][] createMatrix(int n) {
        return new Being[n][n];
    }

    public Being createOnes() {
        return new Being();
    }
}
