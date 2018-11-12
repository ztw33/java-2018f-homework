package com.homework2;

public enum CalabashBoy {

    RED("老大", 1, "红色"), ORANGE("老二", 2, "橙色"), YELLOW("老三", 3, "黄色"), GREEN("老四", 4, "绿色"),
    CYAN("老五", 5, "青色"), BLUE("老六", 6, "蓝色"), PURPLE("老七", 7, "紫色");

    private int rank;
    private String name;
    private String color;

    CalabashBoy(String name, int rank, String color) {
        this.name = name;
        this.rank = rank;
        this.color = color;
    }


    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public int getRank() {
        return this.rank;
    }
}
