package MotherEarthPack.Scientific;

import MotherEarthPack.Entity.Battlefield;

public class FormationSettle
{
    private FormationSettle() { } // 本类全为静态方法，不需要创建对象

    public static boolean Settle(Battlefield battlefield, int N, Creature[] men, int menNum, Coordinate center, Formation form)
    {
        boolean result = true;
        Coordinate location = new Coordinate(center.getR(),center.getC());  // 每次放置的位置，初始化为中心位置

        if(form == Formation.Changshe)
        {
            for (int i = 0; i < menNum; i++) {
                if((location.getR() < 0)||(battlefield.haveCreature(location))) // 选址不对
                    result = false;
                battlefield.placeACreature(men[i],location);
                location.toUp();
            }
        }
        else if(form == Formation.Henge) {
            boolean left = true;
            battlefield.placeACreature(men[0],location);
            for (int i = 1; i < menNum; i++) {
                location.toUp();
                if(left) {
                    location.toRight();
                }
                else {
                    location.toLeft();
                }
                battlefield.placeACreature(men[i],location);
                left = !left;
            }
        }
        else if(form == Formation.Yanxing) {
            battlefield.placeACreature(men[0],location);
            for (int i = 1; i < menNum; i++) {
                location.toUpperRight();
                battlefield.placeACreature(men[i],location);
            }
        }
        else if(form == Formation.Heyi) {
            if(menNum < 3)
                result = false;
            else{
                battlefield.placeACreature(men[0],location);
                for (int i = 1; i <= menNum/2; i++) {
                    location.toUpperLeft();
                    battlefield.placeACreature(men[i],location);
                }
                location.setR(center.getR()-1);
                location.setC(center.getC()+1);
                for (int i = menNum/2+1; i < menNum; i++) {
                    battlefield.placeACreature(men[i],location);
                    if(i!=menNum) {
                        location.toUpperRight();
                    }
                }
            }
        }
        else if(form == Formation.Yulin) {
            if(menNum!=10)
                result = false;
            else {
                battlefield.placeACreature(men[0],location);
                location.toUpperLeft();
                battlefield.placeACreature(men[1],location);
                location.toRight();
                battlefield.placeACreature(men[2],location);
                location.toRight();
                battlefield.placeACreature(men[3],location);
                location.toRight();
                battlefield.placeACreature(men[4],location);
                location.toUpperLeft();
                battlefield.placeACreature(men[5],location);
                location.toLeft();
                battlefield.placeACreature(men[6],location);
                location.toLeft();
                battlefield.placeACreature(men[7],location);
                location.toUpperRight();
                battlefield.placeACreature(men[8],location);
                location.toUpperLeft();
                battlefield.placeACreature(men[9],location);
            }
        }
        else if(form == Formation.Fangyuan) {
            if(menNum % 4 != 0)
                result = false;
            else {
                int myIndex = 0;
                battlefield.placeACreature(men[myIndex],location);
                myIndex++;
                for (int i = 0; i < menNum / 4; i++) {
                    location.toUpperLeft();
                    battlefield.placeACreature(men[myIndex],location);
                    myIndex++;
                }
                for (int i = 0; i < menNum / 4; i++) {
                    location.toUpperRight();
                    battlefield.placeACreature(men[myIndex],location);
                    myIndex++;
                }
                for (int i = 0; i < menNum / 4; i++) {
                    location.toLowerRight();
                    battlefield.placeACreature(men[myIndex],location);
                    myIndex++;
                }
                for (int i = 0; i < menNum / 4 - 1; i++) {
                    location.toLowerLeft();
                    battlefield.placeACreature(men[myIndex],location);
                    myIndex++;
                }
            }
        }
        else if(form == Formation.Yanyue) {
            if(menNum != 19)
                result = false;
            else {
                int myIndex = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        battlefield.placeACreature(men[myIndex],new Coordinate((center.getR()+i),(center.getC()+j)));
                        myIndex++;
                    }
                }
                location.setR(center.getR());
                location.setC(center.getC()+1);
                for (int i = 0; i < 2; i++) {
                    location.toUpperRight();
                    battlefield.placeACreature(men[myIndex],location);
                    myIndex++;
                }
                location.setR(center.getR());
                location.setC(center.getC()+2);
                for (int i = 0; i < 3; i++) {
                    location.toUpperRight();
                    battlefield.placeACreature(men[myIndex],location);
                    myIndex++;
                }
                location.setR(center.getR()+2);
                location.setC(center.getC()+1);
                for (int i = 0; i < 2; i++) {
                    location.toLowerRight();
                    battlefield.placeACreature(men[myIndex],location);
                    myIndex++;
                }
                location.setR(center.getR()+2);
                location.setC(center.getC()+2);
                for (int i = 0; i < 3; i++) {
                    location.toLowerRight();
                    battlefield.placeACreature(men[myIndex],location);
                    myIndex++;
                }
            }
        }
        else if(form == Formation.Fengshi) {
            if(menNum < 5)
                result = false;
            else {
                int myIndex = 0;
                Coordinate leftLocation = new Coordinate(location.getR(),location.getC());
                Coordinate rightLocation = new Coordinate(location.getR(),location.getC());
                leftLocation.toLowerLeft();
                rightLocation.toLowerRight();
                battlefield.placeACreature(men[myIndex],location); myIndex++;
                battlefield.placeACreature(men[myIndex],leftLocation); myIndex++;
                battlefield.placeACreature(men[myIndex],rightLocation); myIndex++;
                location.toDown();
                battlefield.placeACreature(men[myIndex],location); myIndex++;
                location.toDown();
                battlefield.placeACreature(men[myIndex],location); myIndex++;  // 布置好初始的五个
                for (;myIndex < menNum;myIndex++) {
                    if(myIndex <= menNum - 3)
                    {
                        leftLocation.toLowerLeft();
                        rightLocation.toLowerRight();
                        location.toDown();
                        battlefield.placeACreature(men[myIndex],location); myIndex++;
                        battlefield.placeACreature(men[myIndex],leftLocation); myIndex++;
                        battlefield.placeACreature(men[myIndex],rightLocation); myIndex++;
                    }
                    else if(myIndex == menNum - 2) {
                        leftLocation.toLowerLeft();
                        rightLocation.toLowerRight();
                        battlefield.placeACreature(men[myIndex],leftLocation); myIndex++;
                        battlefield.placeACreature(men[myIndex],rightLocation); myIndex++;
                    }
                    else if(myIndex == menNum - 1) {
                        location.toDown();
                        battlefield.placeACreature(men[myIndex],location); myIndex++;
                    }
                }
            }
        }

        return result;
    }
}
