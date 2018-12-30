public enum CreatureName {
    Calabash1("老大"),Calabash2("老二"),Calabash3("老三"),Calabash4("老四"),
    Calabash5("老五"),Calabash6("老六"),Calabash7("老七"),
    GrandFather("老爷爷"),Scorpion("蝎子精"),Snake("蛇精"),Undefined("未知生物"),
    Underling1("小喽啰"),Underling2("小喽啰"),Underling3("小喽啰"),Underling4("小喽啰"),
    Underling5("小喽啰"),Underling6("小喽啰"),Underling7("小喽啰"),Underling8("小喽啰");
    CreatureName(String n) {
        creatureName = new String(n);
    }
    private String creatureName;
}
