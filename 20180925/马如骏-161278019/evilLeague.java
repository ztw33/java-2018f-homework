public class evilLeague extends League {
    leader evilLeader = new Serpent();

    class Serpent extends leader{
        private Serpent(){
            this.name = "蛇精";
        }
    }
    class Scorpion extends Creature{
        private Scorpion(){
            this.name = "蝎精";
        }
    }
    class Underling extends Creature{
        private Underling(){
            this.name = "喽啰";
        }
    }
    public evilLeague(int number){
        if (number<3){
            System.out.println("邪恶势力最少有蝎子精");
        }else{
            this.creatures = new Creature[number];
            this.creatures[0] = new Scorpion();
            for(int i=1; i<number;i++){
                this.creatures[i] = new Underling();
            }
            this.NUMBER = number;
        }
    }
}
