import java.util.ArrayList;
import java.util.Iterator;

public class Formation {
    public static boolean HeYi(ArrayList<Creature> creature, int leadX, int leadY, String direction, Map map){
        int rangeX = (creature.size()-1)/2;
        int rangeY = (creature.size()-1)/2;
        if(direction.equals("Left")){
            if(leadX-rangeX<0 || leadX>map.getSize()/2 || leadY-rangeY<0 || leadY+rangeY>map.getSize()){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                map.setCreature(iterator.next(), leadX, leadY);
                for(int x = leadX-1, yUp = leadY-1, yDown = leadY+1; x>=leadX-rangeX;x--, yUp--, yDown++){
                    map.setCreature(iterator.next(), x, yUp);
                    map.setCreature(iterator.next(), x, yDown);
                }
                if(iterator.hasNext()){
                    map.setCreature(iterator.next(), leadX-rangeX-1, leadY-rangeY-1);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX<map.getSize()/2 || leadX+rangeX>map.getSize() || leadY-rangeY<0 || leadY+rangeY>map.getSize()){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                map.setCreature((Creature)iterator, leadX, leadY);
                for(int x = leadX+1, yUp = leadY-1, yDown = leadY+1; x<=leadX+rangeX; x++, yUp--, yDown++){
                    map.setCreature(iterator.next(), x, yUp);
                    map.setCreature(iterator.next(), x, yDown);
                }
                if(iterator.hasNext()){
                    map.setCreature(iterator.next(), leadX+rangeX+1, leadY-rangeY-1);
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public static boolean HengE(ArrayList<Creature> creature, int leadX, int leadY, String direction, Map map){
        int rangeX = creature.size()-1;
        int rangeY = 1;
        if(direction.equals("Left")) {
            if(leadX-rangeX<0 || leadX>map.getSize()/2 || leadY-rangeY<0){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                for(int x = leadX;x>=leadX-rangeX;x--){
                    map.setCreature(iterator.next(), x, (x%2==0?leadY:(leadY-1)));
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX<map.getSize()/2 || leadX+rangeX>map.getSize() || leadY-rangeY<0){
                return false;
            }
            else {
                Iterator<Creature> iterator = creature.iterator();
                for(int x = leadX;x<=leadX+rangeX;x++){
                    map.setCreature(iterator.next(), x, (x%2==0?leadY:(leadY-1)));
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public static boolean YanXing(ArrayList<Creature> creature, int leadX, int leadY, String direction, Map map){
        int rangeX = creature.size()-1;
        if(direction.equals("Left")) {
            if (leadX - rangeX < 0) {
                return false;
            }
            else {
                Iterator<Creature> iterator = creature.iterator();
                for(int x=leadX, y = leadY;x>=leadX-rangeX;x--, y++){
                    map.setCreature(iterator.next(), x, y);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX+rangeX>map.getSize()){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                for(int x=leadX, y = leadY;x<=leadX+rangeX;x++, y--){
                    map.setCreature(iterator.next(), x, y);
                }
                return true;
            }
        }
        else {
            return false;
        }
    }
    public static boolean ChangShe(ArrayList<Creature> creature, int leadX, int leadY, String direction, Map map){
        int rangeX = creature.size()-1;
        if(direction.equals("Left")){
            if(leadX-rangeX<0){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                for(int x=leadX;x>=leadX-rangeX;x--){
                    map.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX+rangeX>map.getSize()){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                for(int x=leadX;x<=leadX+rangeX;x++){
                    map.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public static boolean YuLin(ArrayList<Creature> creature, int leadX, int leadY, String direction, Map map){
        Iterator<Creature> iterator = creature.iterator();
        if(direction.equals("Left")) {
            int xLayer = 0;
            RenderRoop:
            while (iterator.hasNext()) {
                for (int y = leadY - xLayer; y <= leadY + xLayer; y += 2) {
                    map.setCreature(iterator.next(), leadX - xLayer, y);
                    if (!iterator.hasNext()) {
                        xLayer++;
                        break RenderRoop;
                    }
                }
                xLayer++;
            }
            map.setCreature(creature.get(1), leadX-xLayer, leadY);
            map.removeCreature(leadX-1, leadY-1);
            return true;
        }
        else if(direction.equals("Right")){
            int xLayer = 0;
            RenderRoop:
            while (iterator.hasNext()) {
                for (int y = leadY - xLayer; y <= leadY + xLayer; y += 2) {
                    map.setCreature(iterator.next(), leadX + xLayer, y);
                    if (!iterator.hasNext()) {
                        xLayer++;
                        break RenderRoop;
                    }
                }
                xLayer++;
            }
            map.setCreature(creature.get(1), leadX+xLayer, leadY);
            map.removeCreature(leadX+1, leadY-1);
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean FangYuan(ArrayList<Creature> creature, int leadX, int leadY, String direction, Map map){
        int beInCircle = creature.size()- creature.size()%4;
        //int beOutside = creature.length%4;
        int halfSide = (beInCircle+2)/2;
        int rangeX = halfSide/2;
        int rangeY = 2*rangeX;
        if(direction.equals("Left")){
            if(leadX-rangeX<0 || leadX>map.getSize()/2 || leadY-rangeY<0 || leadY+rangeY>map.getSize()){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                int yUp = leadY-1, yDown = leadY+1;
                map.setCreature(iterator.next(), leadX, leadY);
                for(int x = leadX-1; x>=leadX-rangeX; x--, yUp--, yDown++){
                    map.setCreature(iterator.next(), x, yUp);
                    map.setCreature(iterator.next(), x, yDown);
                }
                yUp+=2;
                yDown-=2;
                for(int x = leadX-rangeX-1;x>=leadX-2*rangeX+1;x--, yUp++, yDown--){
                    map.setCreature(iterator.next(), x, yUp);
                    map.setCreature(iterator.next(), x, yDown);
                }
                map.setCreature(iterator.next(), leadX-2*rangeX, leadY);
                for(int x=leadX-2*rangeX-1;iterator.hasNext();x--){
                    map.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX<map.getSize()/2 || leadX+rangeX>map.getSize() || leadY-rangeY<0 || leadY+rangeY>map.getSize()){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                int yUp = leadY-1, yDown = leadY+1;
                map.setCreature(iterator.next(), leadX, leadY);
                for(int x = leadX+1; x<=leadX+rangeX; x++, yUp--, yDown++){
                    map.setCreature(iterator.next(), x, yUp);
                    map.setCreature(iterator.next(), x, yDown);
                }
                yUp+=2;
                yDown-=2;
                for(int x = leadX+rangeX+1;x<=leadX+2*rangeX-1;x++, yUp++, yDown--){
                    map.setCreature(iterator.next(), x, yUp);
                    map.setCreature(iterator.next(), x, yDown);
                }
                map.setCreature(iterator.next(), leadX+2*rangeX, leadY);
                for(int x=leadX+2*rangeX+1;iterator.hasNext();x++){
                    map.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public static boolean YanYue(ArrayList<Creature> creature, int leadX, int leadY, String direction, Map map){
        int[] positionX = new int[] {-1, -1, -1, -3, -3, -3, -4, -4, -5, -5, -5, -5, -5, -6, -6, -7, -7, -8, -8};
        int[] positionY = new int[] {1, 0, -1, 1, 0, -1, 2, -2, 3, 1, 0, -1, -3, 2, -2, 3, -3, 4, -4};
        //Iterator<Creature> iterator = creature.iterator();
        if(direction.equals("Left")){
            for(int i=0;i<creature.size();i++){
                map.setCreature(creature.get(i), leadX+positionX[i], leadY+positionY[i]);
            }
            return true;
        }
        else{
            for(int i=0;i<creature.size();i++){
                map.setCreature(creature.get(i), leadX-positionX[i], leadY+positionY[i]);
            }
            return true;
        }
    }
    public static boolean FengShi(ArrayList<Creature> creature, int leadX, int leadY, String direction, Map map) {
        int rangeX = (creature.size() - 1) / 3 * 2;
        int rangeY = (creature.size() - 1) / 3;
        if (direction.equals("Left")) {
            if (leadX - rangeX < 0 || leadX > map.getSize() / 2 || leadY - rangeY < 0 || leadY + rangeY > map.getSize()) {
                return false;
            } else {
                Iterator<Creature> iterator = creature.iterator();
                //map.setCreature(iterator.next(), leadX, leadY);
                boolean flag = true;
                for (int x = leadX - 1, yUp = leadY - 1, yDown = leadY + 1; x >= leadX - rangeX && iterator.hasNext(); x--) {
                    if (flag) {
                        map.setCreature(iterator.next(), x, leadY);
                    } else {
                        map.setCreature(iterator.next(), x, yUp);
                        map.setCreature(iterator.next(), x, yDown);
                        yUp--;
                        yDown++;
                    }
                    flag = !flag;
                }
                for (int x = leadX - rangeX - 1; iterator.hasNext(); x -= 2) {
                    map.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        } else if (direction.equals("Right")) {
            if (leadX < map.getSize() / 2 || leadX + rangeX > map.getSize() || leadY - rangeY < 0 || leadY + rangeY > map.getSize()) {
                return false;
            } else {
                Iterator<Creature> iterator = creature.iterator();
                boolean flag = true;
                for (int x = leadX + 1, yUp = leadY - 1, yDown = leadY + 1; x <= leadX + rangeX && iterator.hasNext(); x++) {
                    if (flag) {
                        map.setCreature(iterator.next(), x, leadY);
                    } else {
                        map.setCreature(iterator.next(), x, yUp);
                        map.setCreature(iterator.next(), x, yDown);
                        yUp--;
                        yDown++;
                    }
                    flag = !flag;
                }
                for (int x = leadX + rangeX + 1; iterator.hasNext(); x += 2) {
                    map.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        } else {
            return false;
        }
    }
}

