public class Grandpa extends Organism{
    public enum enum_Grandpa {
        GRANDPA("爷爷");
        private String name;
        enum_Grandpa(String name) {
            this.name = name;
        }
    }
    private enum_Grandpa grandpa;
    Grandpa(){
        grandpa = enum_Grandpa.values()[0];
    }
    public String tellName(){ return this.grandpa.name; }
    public void cheers() {
        //TODO
    }
}
