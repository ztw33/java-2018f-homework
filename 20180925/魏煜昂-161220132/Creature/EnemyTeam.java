package Creature;

import Map.Graph;

public class EnemyTeam {
    private Enemy[] enemyteam;
    private Snake snake;
    private int num;

    public EnemyTeam() {
        snake = new Snake();
        num = 20;
        enemyteam = new Enemy[num];
        enemyteam[0] = new Enemy(0);
        for (int i = 1; i < num; i++) {
            enemyteam[i] = new Enemy(1);
        }
    }

    public void enemyLinedUp(Graph graph, int type) {
        int total = 2;
        switch (type) {
            case 1: {
                total = 6;
                enemyteam[0].setLocation(graph,7,15);
                enemyteam[1].setLocation(graph,6,14);
                enemyteam[2].setLocation(graph,5,13);
                enemyteam[3].setLocation(graph,4,12);
                enemyteam[4].setLocation(graph,6,16);
                enemyteam[5].setLocation(graph,5,17);
                enemyteam[6].setLocation(graph,4,18);
                snake.setLocation(graph,4,15);
            }break;
            case 2: {
                //total = 5;
                enemyteam[0].setLocation(graph,2,18);
                enemyteam[1].setLocation(graph,3,17);
                enemyteam[2].setLocation(graph,4,16);
                enemyteam[3].setLocation(graph,5,15);
                enemyteam[4].setLocation(graph,6,14);
                enemyteam[5].setLocation(graph,7,13);
                enemyteam[6].setLocation(graph,8,12);
                snake.setLocation(graph,5,18);

            }break;

            case 3:{
                enemyteam[0].setLocation(graph,2,15);
                enemyteam[1].setLocation(graph,3,14);
                enemyteam[2].setLocation(graph,4,15);
                enemyteam[3].setLocation(graph,5,14);
                enemyteam[4].setLocation(graph,6,15);
                enemyteam[5].setLocation(graph,7,14);
                enemyteam[6].setLocation(graph,8,15);
                snake.setLocation(graph,5,16);

            }break;
            case 4: {
                total = 8;
                int y = graph.getSize() + graph.getSize() / 2;
                int start_x = (graph.getSize() - total) / 2;
                for (int i = 0; i < total; i++) {
                    enemyteam[i].setLocation(graph, i + start_x, y);
                }
                snake.setLocation(graph,5,16);

            }
            break;
            case 5:{
                enemyteam[0].setLocation(graph,3,15);
                enemyteam[1].setLocation(graph,4,16);
                enemyteam[2].setLocation(graph,5,14);
                enemyteam[3].setLocation(graph,5,15);
                enemyteam[4].setLocation(graph,5,16);
                enemyteam[5].setLocation(graph,6,13);
                enemyteam[6].setLocation(graph,6,14);
                enemyteam[7].setLocation(graph,6,15);
                enemyteam[8].setLocation(graph,6,16);
                enemyteam[9].setLocation(graph,6,17);
                enemyteam[10].setLocation(graph,7,15);
                snake.setLocation(graph,2,15);

            }break;
        }
    }
}


