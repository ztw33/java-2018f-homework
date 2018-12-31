public class Formation {
    public static boolean HeYi(Creature creature[], int leadX, int leadY, String direction, Map map){
        int rangeX = (creature.length-1)/2;
        int rangeY = (creature.length-1)/2;
        if(direction.equals("Left")){
            if(leadX-rangeX<0 || leadX>map.getSize()/2 || leadY-rangeY<0 || leadY+rangeY>map.getSize()){
                return false;
            }
            else{
                int creatureCount = 0;
                map.setCreature(creature[creatureCount], leadX, leadY);
                creatureCount++;
                for(int x = leadX-1, yUp = leadY-1, yDown = leadY+1; x>=leadX-rangeX;x--, yUp--, yDown++, creatureCount++){
                    map.setCreature(creature[creatureCount], x, yUp);
                    creatureCount++;
                    map.setCreature(creature[creatureCount], x, yDown);
                }
                if(creatureCount<creature.length){
                    map.setCreature(creature[creatureCount], leadX-rangeX-1, leadY-rangeY-1);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX<map.getSize()/2 || leadX+rangeX>map.getSize() || leadY-rangeY<0 || leadY+rangeY>map.getSize()){
                return false;
            }
            else{
                int creatureCount = 0;
                map.setCreature(creature[0], leadX, leadY);
                creatureCount++;
                for(int x = leadX+1, yUp = leadY-1, yDown = leadY+1; x<=leadX+rangeX; x++, yUp--, yDown++, creatureCount++){
                    map.setCreature(creature[creatureCount], x, yUp);
                    creatureCount++;
                    map.setCreature(creature[creatureCount], x, yDown);
                }
                if(creatureCount<creature.length){
                    map.setCreature(creature[creatureCount], leadX+rangeX+1, leadY-rangeY-1);
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public static boolean HengE(Creature creature[], int leadX, int leadY, String direction, Map map){
        int rangeX = creature.length-1;
        int rangeY = 1;
        if(direction.equals("Left")) {
            if(leadX-rangeX<0 || leadX>map.getSize()/2 || leadY-rangeY<0){
                return false;
            }
            else{
                for(int x = leadX, creatureCount = 0;x>=leadX-rangeX;x--, creatureCount++){
                    map.setCreature(creature[creatureCount], x, (x%2==0?leadY:(leadY-1)));
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX<map.getSize()/2 || leadX+rangeX>map.getSize() || leadY-rangeY<0){
                return false;
            }
            else {
                for(int x = leadX, creatureCount = 0;x<=leadX+rangeX;x++, creatureCount++){
                    map.setCreature(creature[creatureCount], x, (x%2==0?leadY:(leadY-1)));
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public static boolean YanXing(Creature creature[], int leadX, int leadY, String direction, Map map){
        int rangeX = creature.length-1;
        if(direction.equals("Left")) {
            if (leadX - rangeX < 0) {
                return false;
            }
            else {
                for(int x=leadX, y = leadY, creatureCount = 0;x>=leadX-rangeX;x--, y++, creatureCount++){
                    map.setCreature(creature[creatureCount], x, y);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX+rangeX>map.getSize()){
                return false;
            }
            else{
                for(int x=leadX, y = leadY, creatureCount = 0;x<=leadX+rangeX;x++, y--, creatureCount++){
                    map.setCreature(creature[creatureCount], x, y);
                }
                return true;
            }
        }
        else {
            return false;
        }
    }
    public static boolean ChangShe(Creature creature[], int leadX, int leadY, String direction, Map map){
        int rangeX = creature.length-1;
        if(direction.equals("Left")){
            if(leadX-rangeX<0){
                return false;
            }
            else{
                for(int x=leadX, creatureCount = 0;x>=leadX-rangeX;x--, creatureCount++){
                    map.setCreature(creature[creatureCount], x, leadY);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX+rangeX>map.getSize()){
                return false;
            }
            else{
                for(int x=leadX, creatureCount = 0;x<=leadX+rangeX;x++, creatureCount++){
                    map.setCreature(creature[creatureCount], x, leadY);
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public static boolean YuLin(Creature creature[], int leadX, int leadY, String direction, Map map){
        int creatureCount = 0;
        if(direction.equals("Left")) {
            int xLayer = 0;
            RenderRoop:
            while (creatureCount < creature.length) {
                for (int y = leadY - xLayer; y <= leadY + xLayer; y += 2) {
                    map.setCreature(creature[creatureCount], leadX - xLayer, y);
                    creatureCount++;
                    if (creatureCount >= creature.length) {
                        xLayer++;
                        break RenderRoop;
                    }
                }
                xLayer++;
            }
            map.setCreature(creature[1], leadX-xLayer, leadY);
            map.removeCreature(leadX-1, leadY-1);
            return true;
        }
        else if(direction.equals("Right")){
            int xLayer = 0;
            RenderRoop:
            while (creatureCount < creature.length) {
                for (int y = leadY - xLayer; y <= leadY + xLayer; y += 2) {
                    map.setCreature(creature[creatureCount], leadX + xLayer, y);
                    creatureCount++;
                    if (creatureCount >= creature.length) {
                        xLayer++;
                        break RenderRoop;
                    }
                }
                xLayer++;
            }
            map.setCreature(creature[1], leadX+xLayer, leadY);
            map.removeCreature(leadX+1, leadY-1);
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean FangYuan(Creature creature[], int leadX, int leadY, String direction, Map map){
        int beInCircle = creature.length - creature.length%4;
        //int beOutside = creature.length%4;
        int halfSide = (beInCircle+2)/2;
        int rangeX = halfSide/2;
        int rangeY = 2*rangeX;
        if(direction.equals("Left")){
            if(leadX-rangeX<0 || leadX>map.getSize()/2 || leadY-rangeY<0 || leadY+rangeY>map.getSize()){
                return false;
            }
            else{
                int creatureCount=0, yUp = leadY-1, yDown = leadY+1;
                map.setCreature(creature[creatureCount], leadX, leadY);
                creatureCount++;
                for(int x = leadX-1; x>=leadX-rangeX; x--, yUp--, yDown++, creatureCount++){
                    map.setCreature(creature[creatureCount], x, yUp);
                    creatureCount++;
                    map.setCreature(creature[creatureCount], x, yDown);
                }
                yUp+=2;
                yDown-=2;
                for(int x = leadX-rangeX-1;x>=leadX-2*rangeX+1;x--, yUp++, yDown--, creatureCount++){
                    map.setCreature(creature[creatureCount], x, yUp);
                    creatureCount++;
                    map.setCreature(creature[creatureCount], x, yDown);
                }
                map.setCreature(creature[creatureCount], leadX-2*rangeX, leadY);
                creatureCount++;
                for(int x=leadX-2*rangeX-1;creatureCount<creature.length;x--, creatureCount++){
                    map.setCreature(creature[creatureCount], x, leadY);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX<map.getSize()/2 || leadX+rangeX>map.getSize() || leadY-rangeY<0 || leadY+rangeY>map.getSize()){
                return false;
            }
            else{
                int creatureCount=0, yUp = leadY-1, yDown = leadY+1;
                map.setCreature(creature[creatureCount], leadX, leadY);
                creatureCount++;
                for(int x = leadX+1; x<=leadX+rangeX; x++, yUp--, yDown++, creatureCount++){
                    map.setCreature(creature[creatureCount], x, yUp);
                    creatureCount++;
                    map.setCreature(creature[creatureCount], x, yDown);
                }
                yUp+=2;
                yDown-=2;
                for(int x = leadX+rangeX+1;x<=leadX+2*rangeX-1;x++, yUp++, yDown--, creatureCount++){
                    map.setCreature(creature[creatureCount], x, yUp);
                    creatureCount++;
                    map.setCreature(creature[creatureCount], x, yDown);
                }
                map.setCreature(creature[creatureCount], leadX+2*rangeX, leadY);
                creatureCount++;
                for(int x=leadX+2*rangeX+1;creatureCount<creature.length;x++, creatureCount++){
                    map.setCreature(creature[creatureCount], x, leadY);
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public static boolean YanYue(Creature creature[], int leadX, int leadY, String direction, Map map){
        int[] positionX = new int[] {-1, -1, -1, -3, -3, -3, -4, -4, -5, -5, -5, -5, -5, -6, -6, -7, -7, -8, -8};
        int[] positionY = new int[] {1, 0, -1, 1, 0, -1, 2, -2, 3, 1, 0, -1, -3, 2, -2, 3, -3, 4, -4};
        if(direction.equals("Left")){
            for(int i=0;i<creature.length;i++){
                map.setCreature(creature[i], leadX+positionX[i], leadY+positionY[i]);
            }
            return true;
        }
        else{
            for(int i=0;i<creature.length;i++){
                map.setCreature(creature[i], leadX-positionX[i], leadY+positionY[i]);
            }
            return true;
        }
    }
    public static boolean FengShi(Creature creature[], int leadX, int leadY, String direction, Map map) {
        int rangeX = (creature.length - 1) / 3 * 2;
        int rangeY = (creature.length - 1) / 3;
        if (direction.equals("Left")) {
            if (leadX - rangeX < 0 || leadX > map.getSize() / 2 || leadY - rangeY < 0 || leadY + rangeY > map.getSize()) {
                return false;
            } else {
                map.setCreature(creature[0], leadX, leadY);
                boolean flag = true;
                int creatureCount = 0;
                for (int x = leadX - 1, yUp = leadY - 1, yDown = leadY + 1; x >= leadX - rangeX && creatureCount < creature.length; x--, creatureCount++) {
                    if (flag) {
                        map.setCreature(creature[creatureCount], x, leadY);
                    } else {
                        map.setCreature(creature[creatureCount], x, yUp);
                        creatureCount++;
                        map.setCreature(creature[creatureCount], x, yDown);
                        yUp--;
                        yDown++;
                    }
                    flag = !flag;
                }
                for (int x = leadX - rangeX - 1; creatureCount < creature.length; creatureCount++, x -= 2) {
                    map.setCreature(creature[creatureCount], x, leadY);
                }
                return true;
            }
        } else if (direction.equals("Right")) {
            if (leadX < map.getSize() / 2 || leadX + rangeX > map.getSize() || leadY - rangeY < 0 || leadY + rangeY > map.getSize()) {
                return false;
            } else {
                boolean flag = true;
                int creatureCount = 0;
                for (int x = leadX + 1, yUp = leadY - 1, yDown = leadY + 1; x <= leadX + rangeX && creatureCount < creature.length; x++, creatureCount++) {
                    if (flag) {
                        map.setCreature(creature[creatureCount], x, leadY);
                    } else {
                        map.setCreature(creature[creatureCount], x, yUp);
                        creatureCount++;
                        map.setCreature(creature[creatureCount], x, yDown);
                        yUp--;
                        yDown++;
                    }
                    flag = !flag;
                }
                for (int x = leadX + rangeX + 1; creatureCount < creature.length; creatureCount++, x += 2) {
                    map.setCreature(creature[creatureCount], x, leadY);
                }
                return true;
            }
        } else {
            return false;
        }
    }
}

