public class Formation {
    public String formationName;
    public void HeYi(Blocks fields[][], XieZiJing Team[], int centerX, int centerY, SheJing leader, Battlefield zone) {
        if(centerX-3 < 0 || centerX+3 >= zone.getSize() || centerY+3 >= zone.getSize() || centerY-3 < 0) {
            System.out.println("error!");
            return;
        }
        Team[0].setPosition(centerX, centerY, fields);
        Team[0].formation.formationName = "HeYi";
        for(int i = 1; i < 4; i++) {
            Team[i].setPosition(centerX-i, centerY-i, fields);
            Team[i].formation.formationName = "HeYi";
            Team[i+3].setPosition(centerX-i, centerY+i, fields);
            Team[i+3].formation.formationName = "HeYi";
        }
        leader.setPosition(4, 9, fields);
        leader.Refueling();
    }
    public void YanXing(Blocks fields[][], XieZiJing Team[], int centerX, int centerY, SheJing leader, Battlefield zone) {
        if(centerX-2 < 0 || centerX+2 >= zone.getSize() || centerY+2 >= zone.getSize() || centerY-2 < 0) {
            System.out.println("error!");
            return;
        }
        Team[0].setPosition(centerX, centerY, fields);
        Team[0].formation.formationName = "YanXing";
        for(int i = 1; i < 3; i++) {
            Team[i].setPosition(centerX-i, centerY-i, fields);
            Team[i].formation.formationName = "YanXing";
            Team[i+2].setPosition(centerX+i, centerY+i, fields);
            Team[i+2].formation.formationName = "YanXing";
        }
        leader.setPosition(4, 9, fields);
        leader.Refueling();
    }
    public void ChangShe(Blocks fields[][], HuluWa Team[], int centerX, int centerY, Grandfather leader, Battlefield zone) {
        if(centerX < 0 || centerX+6 >= zone.getSize() || centerY >= zone.getSize() || centerY < 0) {
            System.out.println("error!");
            return;
        }
        Team[0].setPosition(centerX, centerY, fields);
        Team[0].formation.formationName = "ChangShe";
        for(int i = 1; i < 7; i++) {
            Team[i].setPosition(centerX+i, centerY, fields);
            Team[i].formation.formationName = "ChangShe";
        }
        leader.setPosition(4, 0, fields);
        leader.Refueling();
    }
    public void YuLin(Blocks fields[][], XieZiJing Team[], int centerX, int centerY, SheJing leader, Battlefield zone) {
        if(centerX-2 < 0 || centerX+2 >= zone.getSize() || centerY+3 >= zone.getSize() || centerY-3 < 0) {
            System.out.println("error!");
            return;
        }
        Team[0].setPosition(centerX, centerY, fields);
        Team[1].setPosition(centerX, centerY+2, fields);
        Team[2].setPosition(centerX, centerY-2, fields);
        Team[3].setPosition(centerX-1, centerY+1, fields);
        Team[4].setPosition(centerX-2, centerY, fields);
        Team[5].setPosition(centerX+1, centerY-3, fields);
        Team[6].setPosition(centerX+1, centerY-1, fields);
        Team[7].setPosition(centerX+1, centerY+1, fields);
        Team[8].setPosition(centerX+1, centerY+3, fields);
        Team[9].setPosition(centerX+2, centerY, fields);
        for(int i = 0; i < 10; i++)
            Team[i].formation.formationName = "YuLin";
        leader.setPosition(4, 9, fields);
        leader.Refueling();
    }
    public void YanYue(Blocks fields[][], XieZiJing Team[], int centerX, int centerY, SheJing leader, Battlefield zone) {
        if(centerX-4 < 0 || centerX+4 >= zone.getSize() || centerY+3 >= zone.getSize() || centerY-2 < 0) {
            System.out.println("error!");
            return;
        }
        Team[0].setPosition(centerX, centerY, fields);
        Team[1].setPosition(centerX-1, centerY, fields);
        Team[2].setPosition(centerX-2, centerY+1, fields);
        Team[3].setPosition(centerX-3, centerY+2, fields);
        Team[4].setPosition(centerX-4, centerY+3, fields);
        Team[5].setPosition(centerX+1, centerY, fields);
        Team[6].setPosition(centerX+2, centerY+1, fields);
        Team[7].setPosition(centerX+3, centerY+2, fields);
        Team[8].setPosition(centerX+4, centerY+3, fields);
        Team[9].setPosition(centerX, centerY-1, fields);
        Team[10].setPosition(centerX-1, centerY-1, fields);
        Team[11].setPosition(centerX-2, centerY, fields);
        Team[12].setPosition(centerX-3, centerY+1, fields);
        Team[13].setPosition(centerX+1, centerY-1, fields);
        Team[14].setPosition(centerX+2, centerY, fields);
        Team[15].setPosition(centerX+3, centerY+1, fields);
        Team[16].setPosition(centerX, centerY-2, fields);
        Team[17].setPosition(centerX-1, centerY-2, fields);
        Team[18].setPosition(centerX+1, centerY-2, fields);
        for(int i = 0; i < 19; i++)
            Team[i].formation.formationName = "YanYue";
        leader.setPosition(4, 9, fields);
        leader.Refueling();
    }
    public void FengShi(Blocks fields[][], XieZiJing Team[], int centerX, int centerY, SheJing leader, Battlefield zone) {
        if(centerX < 0 || centerX+5 >= zone.getSize() || centerY+3 >= zone.getSize() || centerY-3 < 0) {
            System.out.println("error!");
            return;
        }
        Team[0].setPosition(centerX, centerY, fields);
        Team[1].setPosition(centerX+1, centerY-1, fields);
        Team[2].setPosition(centerX+2, centerY-2, fields);
        Team[3].setPosition(centerX+3, centerY-3, fields);
        Team[4].setPosition(centerX+1, centerY+1, fields);
        Team[5].setPosition(centerX+2, centerY+2, fields);
        Team[6].setPosition(centerX+3, centerY+3, fields);
        Team[7].setPosition(centerX+1, centerY, fields);
        Team[8].setPosition(centerX+2, centerY, fields);
        Team[9].setPosition(centerX+3, centerY, fields);
        Team[10].setPosition(centerX+4, centerY, fields);
        Team[11].setPosition(centerX+5, centerY, fields);
        for(int i = 0; i < 12; i++)
            Team[i].formation.formationName = "FengShi";
        leader.setPosition(4, 9, fields);
        leader.Refueling();
    }
    public void initFormation(Blocks fields[][], XieZiJing Team[], SheJing leader) {
        switch (Team[0].formation.formationName) {
            case "HeYi":
            {
                for(int i = 0; i < 7; i++) {
                    Team[i].leavePosition(fields);
                    Team[i].formation.formationName = null;
                }
                break;
            }
            case "YanXing":
            {
                for(int i = 0; i < 5; i++) {
                    Team[i].leavePosition(fields);
                    Team[i].formation.formationName = null;
                }
                break;
            }
            case "YuLin":
            {
                for(int i = 0; i < 10; i++) {
                    Team[i].leavePosition(fields);
                    Team[i].formation.formationName = null;
                }
                break;
            }
            case "YanYue":
            {
                for(int i = 0; i < 19; i++) {
                    Team[i].leavePosition(fields);
                    Team[i].formation.formationName = null;
                }
                break;
            }
            case "FengShi":
            {
                for(int i = 0; i < 12; i++) {
                    Team[i].leavePosition(fields);
                    Team[i].formation.formationName = null;
                }
                break;
            }
            default: break;
        }
        leader.leavePosition(fields);
    }
    public void initFormation(Blocks fields[][], HuluWa Team[], Grandfather leader) {
        for(int i = 0; i < 7; i++) {
            Team[i].leavePosition(fields);
            Team[i].formation.formationName = null;
        }
        leader.leavePosition(fields);
    }
}
