class BattleArray<T, K> {
    public T[] soldiers;
    public K leader;
}

class CalabashSide extends BattleArray<Calabash, Grandfather> {
    CalabashSide() {
        leader = new Grandfather();
        soldiers = new Calabash[7];
        for (int i = 0; i < 7; ++i) {
            soldiers[i] = new Calabash(i);
        }
    }

    private void initCalabashGround(BattleField<Being> battleField) {
        int X = battleField.scale();
        int Y = (X - 1) / 2;
        for (int i = 0; i < X; ++i)
            for (int j = 0; j < Y; ++j)
                battleField.initBeing(i, j);
    }

    public void addLeader(BattleField<Being> battleField) {
        int X = battleField.scale();
        int Y = X / 2 - 1;
        if (battleField.isEmpty(X / 2, Y / 4))
            battleField.addBeing(leader, X / 2, Y / 4);
        else
            battleField.addBeing(leader, X / 2, Y / 4 - 1);
    }

    public void snakeArray(BattleField<Being> battleField) {
        int X = battleField.scale();
        int Y = X / 2 - 1;
        initCalabashGround(battleField);
        for (int i = 0; i < 7; ++i)
            battleField.addBeing(soldiers[i], X / 2 - 3 + i, Y / 2);
    }
}

class MonsterSide extends BattleArray<Being, Snake> {
    private final int N;

    MonsterSide(int n) {
        N = n;
        leader = new Snake();
        soldiers = new Being[n];
        soldiers[0] = new Crab();
        for (int i = 1; i < n; ++i)
            soldiers[i] = new Devil();
    }

    private void initMonsterGround(BattleField<Being> battleField) {
        int X = battleField.scale();
        int Y = X / 2;
        for (int i = 0; i < X; ++i)
            for (int j = Y; j < X; ++j)
                battleField.initBeing(i, j);
    }

    public void addLeader(BattleField<Being> battleField) {
        int X = battleField.scale();
        int Y = X / 2;
        int i = Y + 2;
        while (!battleField.isEmpty(Y, i) && (i < X)) {
            ++i;
        }
        if (i < X)
            battleField.addBeing(leader, Y, i);
        else
            battleField.addBeing(leader, Y - 1, i - 1);
    }

    public void craneArray(BattleField<Being> battleField) {
        int X = battleField.scale();
        int Y = X / 2;
        initMonsterGround(battleField);
        battleField.addBeing(soldiers[0], Y, Y);
        int tmp = 1;
        //System.out.println(N);
        while (tmp < N) {
            int delta = (tmp + 1) / 2;
            battleField.addBeing(soldiers[tmp], Y - delta, Y + delta);
            if (tmp + 1 < N)
                battleField.addBeing(soldiers[tmp + 1], Y + delta, Y + delta);
            tmp += 2;
        }
    }

    public void arrowArray(BattleField<Being> battleField) {
        int X = battleField.scale();
        int Y = X / 2;
        initMonsterGround(battleField);
        battleField.addBeing(soldiers[0], Y, Y);
        int tmp = 1;
        //System.out.println(N);
        while (tmp < N) {
            int delta = (tmp + 2) / 3;
            battleField.addBeing(soldiers[tmp], Y - delta, Y + delta);
            if (tmp + 1 < N)
                battleField.addBeing(soldiers[tmp + 1], Y, Y + delta);
            if (tmp + 2 < N)
                battleField.addBeing(soldiers[tmp + 2], Y + delta, Y + delta);
            tmp += 3;
        }
    }
}
