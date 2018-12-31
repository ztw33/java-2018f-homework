import java.util.ArrayList;
import java.util.Iterator;

public class Formation {
    private Controller controller;
    Formation(Controller controller){
        this.controller = controller;
    }
    public boolean HeYi(ArrayList<Creature> creature, int leadX, int leadY, String direction){
        int rangeX = (creature.size()-1)/2;
        int rangeY = (creature.size()-1)/2;
        if(direction.equals("Left")){
            if(leadX-rangeX<0 || leadX>10 || leadY-rangeY<0 || leadY+rangeY>20){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                controller.setCreature(iterator.next(), leadX, leadY);
                for(int x = leadX-1, yUp = leadY-1, yDown = leadY+1; x>=leadX-rangeX;x--, yUp--, yDown++){
                    controller.setCreature(iterator.next(), x, yUp);
                    controller.setCreature(iterator.next(), x, yDown);
                }
                if(iterator.hasNext()){
                    controller.setCreature(iterator.next(), leadX-rangeX-1, leadY-rangeY-1);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX<10 || leadX+rangeX>20 || leadY-rangeY<0 || leadY+rangeY>20){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                controller.setCreature(iterator.next(), leadX, leadY);
                for(int x = leadX+1, yUp = leadY-1, yDown = leadY+1; x<=leadX+rangeX; x++, yUp--, yDown++){
                    controller.setCreature(iterator.next(), x, yUp);
                    controller.setCreature(iterator.next(), x, yDown);
                }
                if(iterator.hasNext()){
                    controller.setCreature(iterator.next(), leadX+rangeX+1, leadY-rangeY-1);
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public boolean HengE(ArrayList<Creature> creature, int leadX, int leadY, String direction){
        int rangeX = creature.size()-1;
        int rangeY = 1;
        if(direction.equals("Left")) {
            if(leadX-rangeX<0 || leadX>10 || leadY-rangeY<0){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                for(int x = leadX;x>=leadX-rangeX;x--){
                    controller.setCreature(iterator.next(), x, (x%2==0?leadY:(leadY-1)));
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX<10 || leadX+rangeX>20 || leadY-rangeY<0){
                return false;
            }
            else {
                Iterator<Creature> iterator = creature.iterator();
                for(int x = leadX;x<=leadX+rangeX;x++){
                    controller.setCreature(iterator.next(), x, (x%2==0?leadY:(leadY-1)));
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public boolean YanXing(ArrayList<Creature> creature, int leadX, int leadY, String direction){
        int rangeX = creature.size()-1;
        if(direction.equals("Left")) {
            if (leadX - rangeX < 0) {
                return false;
            }
            else {
                Iterator<Creature> iterator = creature.iterator();
                for(int x=leadX, y = leadY;x>=leadX-rangeX;x--, y++){
                    controller.setCreature(iterator.next(), x, y);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX+rangeX>20){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                for(int x=leadX, y = leadY;x<=leadX+rangeX;x++, y--){
                    controller.setCreature(iterator.next(), x, y);
                }
                return true;
            }
        }
        else {
            return false;
        }
    }
    public boolean ChangShe(ArrayList<Creature> creature, int leadX, int leadY, String direction){
        int rangeX = creature.size()-1;
        if(direction.equals("Left")){
            if(leadX-rangeX<0){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                for(int x=leadX;x>=leadX-rangeX;x--){
                    controller.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX+rangeX>20){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                for(int x=leadX;x<=leadX+rangeX;x++){
                    controller.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public boolean YuLin(ArrayList<Creature> creature, int leadX, int leadY, String direction){
        Iterator<Creature> iterator = creature.iterator();
        if(direction.equals("Left")) {
            int xLayer = 0;
            RenderRoop:
            while (iterator.hasNext()) {
                for (int y = leadY - xLayer; y <= leadY + xLayer; y += 2) {
                    controller.setCreature(iterator.next(), leadX - xLayer, y);
                    if (!iterator.hasNext()) {
                        xLayer++;
                        break RenderRoop;
                    }
                }
                xLayer++;
            }
            controller.removeCreature(creature.get(1));
            controller.setCreature(creature.get(1), leadX-xLayer, leadY);
            return true;
        }
        else if(direction.equals("Right")){
            int xLayer = 0;
            RenderRoop:
            while (iterator.hasNext()) {
                for (int y = leadY - xLayer; y <= leadY + xLayer; y += 2) {
                    controller.setCreature(iterator.next(), leadX + xLayer, y);
                    if (!iterator.hasNext()) {
                        xLayer++;
                        break RenderRoop;
                    }
                }
                xLayer++;
            }
            controller.removeCreature(creature.get(1));
            controller.setCreature(creature.get(1), leadX+xLayer, leadY);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean FangYuan(ArrayList<Creature> creature, int leadX, int leadY, String direction){
        int beInCircle = creature.size()- creature.size()%4;
        //int beOutside = creature.length%4;
        int halfSide = (beInCircle+2)/2;
        int rangeX = halfSide/2;
        int rangeY = 2*rangeX;
        if(direction.equals("Left")){
            if(leadX-rangeX<0 || leadX>10 || leadY-rangeY<0 || leadY+rangeY>20){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                int yUp = leadY-1, yDown = leadY+1;
                controller.setCreature(iterator.next(), leadX, leadY);
                for(int x = leadX-1; x>=leadX-rangeX; x--, yUp--, yDown++){
                    controller.setCreature(iterator.next(), x, yUp);
                    controller.setCreature(iterator.next(), x, yDown);
                }
                yUp+=2;
                yDown-=2;
                for(int x = leadX-rangeX-1;x>=leadX-2*rangeX+1;x--, yUp++, yDown--){
                    controller.setCreature(iterator.next(), x, yUp);
                    controller.setCreature(iterator.next(), x, yDown);
                }
                controller.setCreature(iterator.next(), leadX-2*rangeX, leadY);
                for(int x=leadX-2*rangeX-1;iterator.hasNext();x--){
                    controller.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        }
        else if(direction.equals("Right")){
            if(leadX<10 || leadX+rangeX>20 || leadY-rangeY<0 || leadY+rangeY>20){
                return false;
            }
            else{
                Iterator<Creature> iterator = creature.iterator();
                int yUp = leadY-1, yDown = leadY+1;
                controller.setCreature(iterator.next(), leadX, leadY);
                for(int x = leadX+1; x<=leadX+rangeX; x++, yUp--, yDown++){
                    controller.setCreature(iterator.next(), x, yUp);
                    controller.setCreature(iterator.next(), x, yDown);
                }
                yUp+=2;
                yDown-=2;
                for(int x = leadX+rangeX+1;x<=leadX+2*rangeX-1;x++, yUp++, yDown--){
                    controller.setCreature(iterator.next(), x, yUp);
                    controller.setCreature(iterator.next(), x, yDown);
                }
                controller.setCreature(iterator.next(), leadX+2*rangeX, leadY);
                for(int x=leadX+2*rangeX+1;iterator.hasNext();x++){
                    controller.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        }
        else{
            return false;
        }
    }
    public boolean YanYue(ArrayList<Creature> creature, int leadX, int leadY, String direction){
        int[] positionX = new int[] {-1, -1, -1, -3, -3, -3, -4, -4, -5, -5, -5, -5, -5, -6, -6, -7, -7, -8, -8};
        int[] positionY = new int[] {1, 0, -1, 1, 0, -1, 2, -2, 3, 1, 0, -1, -3, 2, -2, 3, -3, 4, -4};
        //Iterator<Creature> iterator = creature.iterator();
        if(direction.equals("Left")){
            for(int i=0;i<creature.size();i++){
                controller.setCreature(creature.get(i), leadX+positionX[i], leadY+positionY[i]);
            }
            return true;
        }
        else{
            for(int i=0;i<creature.size();i++){
                controller.setCreature(creature.get(i), leadX-positionX[i], leadY+positionY[i]);
            }
            return true;
        }
    }
    public boolean FengShi(ArrayList<Creature> creature, int leadX, int leadY, String direction) {
        int rangeX = (creature.size() - 1) / 3 * 2;
        int rangeY = (creature.size() - 1) / 3;
        if (direction.equals("Left")) {
            if (leadX - rangeX < 0 || leadX > 10 || leadY - rangeY < 0 || leadY + rangeY > 20) {
                return false;
            } else {
                Iterator<Creature> iterator = creature.iterator();
                //map.setCreature(iterator.next(), leadX, leadY);
                boolean flag = true;
                for (int x = leadX - 1, yUp = leadY - 1, yDown = leadY + 1; x >= leadX - rangeX && iterator.hasNext(); x--) {
                    if (flag) {
                        controller.setCreature(iterator.next(), x, leadY);
                    } else {
                        controller.setCreature(iterator.next(), x, yUp);
                        controller.setCreature(iterator.next(), x, yDown);
                        yUp--;
                        yDown++;
                    }
                    flag = !flag;
                }
                for (int x = leadX - rangeX - 1; iterator.hasNext(); x -= 2) {
                    controller.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        } else if (direction.equals("Right")) {
            if (leadX < 10 || leadX + rangeX > 20 || leadY - rangeY < 0 || leadY + rangeY > 20) {
                return false;
            } else {
                Iterator<Creature> iterator = creature.iterator();
                boolean flag = true;
                for (int x = leadX + 1, yUp = leadY - 1, yDown = leadY + 1; x <= leadX + rangeX && iterator.hasNext(); x++) {
                    if (flag) {
                        controller.setCreature(iterator.next(), x, leadY);
                    } else {
                        controller.setCreature(iterator.next(), x, yUp);
                        controller.setCreature(iterator.next(), x, yDown);
                        yUp--;
                        yDown++;
                    }
                    flag = !flag;
                }
                for (int x = leadX + rangeX + 1; iterator.hasNext(); x += 2) {
                    controller.setCreature(iterator.next(), x, leadY);
                }
                return true;
            }
        } else {
            return false;
        }
    }
    public boolean LieDui(ArrayList<Creature> creature, int leadX, int leadY, String direction){
        Iterator<Creature> iterator = creature.iterator();
        for(int y=0;y<creature.size();y++){
            controller.setCreature(iterator.next(), leadX, y);
        }
        return true;
    }
}

