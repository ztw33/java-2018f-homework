
public class Main {
    public static void main(String[] args) {
        Formation f = new Formation();
        f.getRandHulu();/***/
        f.printHulus();
        f.sortHulu();
        f.printHulus();

        f.addHuluToMap();
        f.map.printAll();
        f.map.clearAll();

        f.addHuluToMap();
        f.FENGSHIAddMonsToMap();
        f.map.printAll();
        f.map.clearAll();

        f.addHuluToMap();
        f.YANYUEAddMonsToMap();
        f.map.printAll();
        f.map.clearAll();
    }
}
