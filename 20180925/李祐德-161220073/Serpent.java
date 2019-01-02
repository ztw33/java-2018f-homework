public class Serpent extends Organism {
    private enum enum_Serpent {
        SERPENT("蛇精");
        String name;

        enum_Serpent(String name) {
            this.name = name;
        }

        public void cheers() {
            //TODO
        }
    }

    private enum_Serpent serpent;
    Serpent(){
        serpent = enum_Serpent.values()[0];
    }
    public String tellName(){ return serpent.name; }
}