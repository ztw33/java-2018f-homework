package creature;

import javafx.scene.image.Image;

import java.net.URL;

public class Calabash extends Creature {
    private enum Members {
        Cala1("老大", 1, "/image/cala1.jpg"),
        Cala2("老二", 2, "/image/cala2.jpg"),
        Cala3("老三", 3, "/image/cala3.jpg"),
        Cala4("老四", 4, "/image/cala4.jpg"),
        Cala5("老五", 5, "/image/cala5.jpg"),
        Cala6("老六", 6, "/image/cala6.jpg"),
        Cala7("老七", 7, "/image/cala7.jpg");
        public String name;
        public int rank;
        public String path;


        private Members(String name, int rank, String path) { // 构造方法
            this.name = name;
            this.rank = rank;
            this.path = path;
        }
    }

    private Members cala;

    public Calabash(int b) { // b 从 0 到 6，代表老大到老七，若不在此范围则取 mod 7
        super();
        cala = Members.values()[b-1];
        URL url = getClass().getResource(cala.path);
        this.image = new Image(url.toString());
        name = cala.name;
        this.camp=true;
    }
}

