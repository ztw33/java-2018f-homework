import java.util.Scanner;

public class BattleTest {
    public static void main(String args[]) {
        JusticeLeague calabashBrother = new JusticeLeague();  // 葫芦娃正营出现啦
        evilLeague evilLeague = new evilLeague(5); // 蛇精阵容出现了
        Battlefield battlefield = new Battlefield(12,calabashBrother,evilLeague);  // 他们在战场相遇
        battlefield.evilLeagueFormation.changeFormation("snake"); // 蛇精阵型使用了长蛇阵
        battlefield.justiceLeagueFormation.changeFormation("snake"); // 葫芦娃阵营使用了长蛇阵型

        System.out.println("有一天，葫芦娃和爷爷在野外遇到了蛇精和她的手下，他们即将进行一场激烈的战斗...(回车以继续)");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("葫芦娃阵营:");
        System.out.println("****领导："+calabashBrother.justiceLeader.tellName());
        System.out.println("****作战人数："+calabashBrother.creatures.length);
        System.out.println();
        System.out.println("邪恶阵容:");
        System.out.println("****领导："+evilLeague.evilLeader.tellName());
        System.out.println("****作战人数："+evilLeague.creatures.length);
        System.out.println("回车以继续...");
        sc.nextLine();
        System.out.println("葫芦娃使用了长蛇阵");
        System.out.println("邪恶阵营使用了长蛇阵");
        System.out.println("战况如下：");
        battlefield.printSituation();
        System.out.println("居然都使用了长蛇阵，真是可恶呢！");
        System.out.println("邪恶阵营的军师打算要变阵。军师，变成什么阵容呢？");
        battlefield.evilLeagueFormation.changeFormation(null); // 葫芦娃军师将要变阵
        battlefield.printSituation();
    }
}
