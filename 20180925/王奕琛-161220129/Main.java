import map.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Map map = new Map();
        HuluCamp huluCamp = new HuluCamp();
        MonsterCamp monsterCamp = new MonsterCamp();
        Scanner src = new Scanner(System.in);
        System.out.println("请选择葫芦娃的阵型：");
        System.out.println("1.鹤翼 \n2.雁行 \n3.衡轭 \n4：长蛇 \n5.鱼鳞 \n6.方门 \n7.偃月 \n8.锋矢");
        int n = src.nextInt();
        switch(n){
            case 1:huluCamp.queue1(map);break;
            case 2:huluCamp.queue2(map);break;
            case 3:huluCamp.queue3(map);break;
            case 4:huluCamp.queue4(map);break;
            case 5:huluCamp.queue5(map);break;
            case 6:huluCamp.queue6(map);break;
            case 7:huluCamp.queue7(map);break;
            case 8:huluCamp.queue8(map);break;
            default:huluCamp.queue4(map);break;
        }
        System.out.println("请选择妖怪的阵型：");
        System.out.println("1.鹤翼 \n2.雁行 \n3.衡轭 \n4：长蛇 \n5.鱼鳞 \n6.方门 \n7.偃月 \n8.锋矢");
        int m = src.nextInt();
        switch(m){
            case 1:monsterCamp.queue1(map);break;
            case 2:monsterCamp.queue2(map);break;
            case 3:monsterCamp.queue3(map);break;
            case 4:monsterCamp.queue4(map);break;
            case 5:monsterCamp.queue5(map);break;
            case 6:monsterCamp.queue6(map);break;
            case 7:monsterCamp.queue7(map);break;
            case 8:monsterCamp.queue8(map);break;
            default:monsterCamp.queue4(map);break;
        }

        map.printMap();
        return;
    }
}
