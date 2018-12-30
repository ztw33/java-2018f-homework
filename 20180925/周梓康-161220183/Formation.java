public enum Formation {

    WING {
        void setSoldier() {
            switch (direction) {
                case LEFT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(-1, 1)),
                            new Coordinate(leader.add(1, 1)),
                            new Coordinate(leader.add(-2, 2)),
                            new Coordinate(leader.add(2, 2)),
                            new Coordinate(leader.add(-3, 3)),
                            new Coordinate(leader.add(3, 3))};
                    break;

                case RIGHT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(-1, -1)),
                            new Coordinate(leader.add(1, -1)),
                            new Coordinate(leader.add(-2, -2)),
                            new Coordinate(leader.add(2, -2)),
                            new Coordinate(leader.add(-3, -3)),
                            new Coordinate(leader.add(3, -3))};
                    break;
            }
        }
    },

    FLIGHT {
        void setSoldier() {
            switch (direction) {
                case LEFT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(-1, -1)),
                            new Coordinate(leader.add(-2, -2)),
                            new Coordinate(leader.add(-3, -3)),
                            new Coordinate(leader.add(-4, -4)),
                            new Coordinate(leader.add(-5, -5)),
                            new Coordinate(leader.add(-6, -6))};
                    break;

                case RIGHT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(1, 1)),
                            new Coordinate(leader.add(2, 2)),
                            new Coordinate(leader.add(3, 3)),
                            new Coordinate(leader.add(4, 4)),
                            new Coordinate(leader.add(5, 5)),
                            new Coordinate(leader.add(6, 6))};
                    break;
            }
        }
    },

    YOKE {
        void setSoldier() {
            switch (direction) {
                case LEFT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(-1, -1)),
                            new Coordinate(leader.add(0, -2)),
                            new Coordinate(leader.add(-1, -3)),
                            new Coordinate(leader.add(0, -4)),
                            new Coordinate(leader.add(-1, -5)),
                            new Coordinate(leader.add(0, -6))};
                    break;

                case RIGHT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(1, 1)),
                            new Coordinate(leader.add(0, 2)),
                            new Coordinate(leader.add(1, 3)),
                            new Coordinate(leader.add(0, 4)),
                            new Coordinate(leader.add(1, 5)),
                            new Coordinate(leader.add(0, 6))};
                    break;
            }
        }
    },

    LINE {
        void setSoldier() {
            switch (direction) {
                case LEFT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(0, -1)),
                            new Coordinate(leader.add(0, -2)),
                            new Coordinate(leader.add(0, -3)),
                            new Coordinate(leader.add(0, -4)),
                            new Coordinate(leader.add(0, -5)),
                            new Coordinate(leader.add(0, -6))};
                    break;

                case RIGHT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(0, 1)),
                            new Coordinate(leader.add(0, 2)),
                            new Coordinate(leader.add(0, 3)),
                            new Coordinate(leader.add(0, 4)),
                            new Coordinate(leader.add(0, 5)),
                            new Coordinate(leader.add(0, 6))};
                    break;
            }
        }
    },

    SCALE {
        void setSoldier() {
            switch (direction) {
                case LEFT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(-1, -1)),
                            new Coordinate(leader.add(1, -1)),
                            new Coordinate(leader.add(-2, -2)),
                            new Coordinate(leader.add(0, -2)),
                            new Coordinate(leader.add(2, -2)),
                            new Coordinate(leader.add(0, -3))};
                    break;

                case RIGHT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(-1, 1)),
                            new Coordinate(leader.add(1, 1)),
                            new Coordinate(leader.add(-2, 2)),
                            new Coordinate(leader.add(0, 2)),
                            new Coordinate(leader.add(2, 2)),
                            new Coordinate(leader.add(0, 3))};
                    break;
            }
        }
    },

    SQUARE {
        void setSoldier() {
            switch (direction) {
                case LEFT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(-1, -1)),
                            new Coordinate(leader.add(1, -1)),
                            new Coordinate(leader.add(-2, -2)),
                            new Coordinate(leader.add(2, -2)),
                            new Coordinate(leader.add(-1, -3)),
                            new Coordinate(leader.add(1, -3)),
                            new Coordinate(leader.add(0, -4))};
                    break;

                case RIGHT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(-1, 1)),
                            new Coordinate(leader.add(1, 1)),
                            new Coordinate(leader.add(-2, 2)),
                            new Coordinate(leader.add(2, 2)),
                            new Coordinate(leader.add(-1, 3)),
                            new Coordinate(leader.add(1, 3)),
                            new Coordinate(leader.add(0, 4))};
                    break;
            }
        }
    },

    CRESCENT {
        void setSoldier() {
            this.soldier = new Coordinate[]{};
        }
    },

    ARROW {
        void setSoldier() {
            switch (direction) {
                case LEFT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(-1, -1)),
                            new Coordinate(leader.add(0, -1)),
                            new Coordinate(leader.add(1, -1)),
                            new Coordinate(leader.add(0, -2)),
                            new Coordinate(leader.add(0, -3)),
                            new Coordinate(leader.add(0, -4))};
                    break;

                case RIGHT:
                    this.soldier = new Coordinate[]{
                            new Coordinate(leader.add(-1, 1)),
                            new Coordinate(leader.add(0, 1)),
                            new Coordinate(leader.add(1, 1)),
                            new Coordinate(leader.add(0, 2)),
                            new Coordinate(leader.add(0, 3)),
                            new Coordinate(leader.add(0, 4))};
                    break;
            }
        }
    };

    Direction direction;
    Coordinate leader;
    Coordinate[] soldier;
    Coordinate supporter;

    public enum Direction {LEFT, RIGHT}

    public Direction getDirection() {
        return direction;
    }

    public Coordinate getLeader() {
        return leader;
    }

    public Coordinate[] getSoldier() {
        return soldier;
    }

    public Coordinate getSupporter() {
        return supporter;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        if (this.leader != null)
            setSoldier();
    }

    void setLeader(Coordinate leader) {
        this.leader = leader;
        if (this.direction != null)
            setSoldier();
    }

    abstract void setSoldier();

    public void setSupporter(Coordinate supporter) {
        this.supporter = supporter;
    }

    void instantiate(Direction direction, Coordinate leader, Coordinate supporter) {
        setDirection(direction);
        setLeader(leader);
        setSupporter(supporter);
        setSoldier();
    }
}
