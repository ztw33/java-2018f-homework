public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        HuLuBros hulubros = new HuLuBros();
        Monsters monsters = new Monsters();
        hulubros.initialize();
        hulubros.shuffle();
        board.clear();
        board.setmap1(hulubros,monsters);
        board.printmap();
        board.clear();
        hulubros.shuffle();
        board.setmap2(hulubros,monsters);
        board.printmap();
        board.clear();
        hulubros.sort();
        board.setmap3(hulubros,monsters);
        board.printmap();
        board.clear();
        board.setmap4(hulubros,monsters);
        board.printmap();
        board.clear();
        board.setmap5(hulubros,monsters);
        board.printmap();
    }
}
