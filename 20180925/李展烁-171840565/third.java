public class third {
    public static void main(String[] args){
        Ground ground = new Ground(20,15);
        Formation formation = new Formation(ground.getWidth(),ground.getLength(),ground);
        ground.setFormation(formation);
        System.out.println("初始化：");
        ground.show();
        System.out.println("爷蛇到位：");
        ground.fallIn();
        ground.show();

        Snake snake=ground.getSnake();
        Grandpa grandpa=ground.getGrandpa();
        System.out.println("长蛇阵：");
        grandpa.order(FormationType.longSnakeArray);
        grandpa.view();
        System.out.println("衝轭阵：");
        snake.order(FormationType.yokeArray);
        snake.view();
        System.out.println("鹤翼阵：");
        snake.order(FormationType.CraneWingArray);
        snake.view();
        System.out.println("雁行阵：");
        snake.order(FormationType.gooseFlyArray);
        snake.view();
        System.out.println("方円阵：");
        snake.order(FormationType.squareArray);
        snake.view();
    }
}
