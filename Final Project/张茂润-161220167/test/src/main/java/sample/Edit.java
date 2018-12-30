package sample;

public @interface Edit {
    String editor()   default "zmr";
    String time();
}
