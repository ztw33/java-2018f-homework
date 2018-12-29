package calabashBrothers.beings;

/**
 * @ Author     ：Young
 * @ Description：上帝创生，则有存在
 */

public class Beings {
    protected String name;

    public Beings(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

