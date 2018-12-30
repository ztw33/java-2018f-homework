class Being {
    protected char name;

    Being() {
        name = '*';
    }
}

class Calabash extends Being {
    Calabash(int i) {
        name = (char) ('1' + i);
    }
}

class Grandfather extends Being {
    Grandfather() {
        name = 'G';
    }
}

class Crab extends Being {
    Crab() {
        name = 'C';
    }
}

class Snake extends Being {
    Snake() {
        name = 'S';
    }
}

class Devil extends Being {
    Devil() {
        name = 'd';
    }
}
