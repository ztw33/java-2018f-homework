enum FormationType {
    longSnakeArray, CraneWingArray, gooseFlyArray, yokeArray, squareArray
}

public class Formation implements OrderDevice{
    int length,width;
    Ground ground;
    Formation(int length, int width, Ground ground){
        this.width = width;
        this.length = length;
        this.ground=ground;
    }

    @Override
    public void orderMethod(FormationType formationType) {
        //默认长蛇阵是葫芦娃，其他阵型是小喽啰，因此没有设定额外标志位。
        int count=0;
        Creature[] creatures = new Creature[8];
        int[] x = new int[8];
        int[] y = new int[8];
        count=0;
        if(formationType==FormationType.longSnakeArray){
            for(int i=0;i<width;i++) {
                for (int j = 0; j < length; j++) {
                    Creature creature = ground.getCreature(i, j);
                    String interfaceName = creature.getClass().getInterfaces()[0].getName();
                    if (interfaceName == "GoodFollower") {
                        creatures[count] = creature;
                        x[count]=i;
                        y[count]=j;
                        count++;
                    }
                }
            }
        }
        else{
            for(int i=0;i<width;i++) {
                for (int j = 0; j < length; j++) {
                    Creature creature = ground.getCreature(i, j);
                    String interfaceName = creature.getClass().getInterfaces()[0].getName();
                    if (interfaceName == "BadFollower") {
                        creatures[count] = creature;
                        x[count]=i;
                        y[count]=j;
                        count++;
                    }
                }
            }
        }
        switch (formationType){//除方円阵对怪物数量严格限制为7外，其他阵型均使用数学公式实现。阵型可扩展性较好。
            case longSnakeArray:
                for(int i=0;i<count;i++){
                    for(int j=0;j<count;j++){//对每个case中以j计数的循环，均为判断欲移动的位置与待移动的生物是否冲突
                        if(x[j]==width/2-count/2+i&&y[j]==length/3){
                            x[j]=x[i];y[j]=y[i];break;
                        }
                    }
                    ((GoodFollower)creatures[i]).move(x[i],y[i],width/2-count/2+i,length/3);
                }
                break;
            case gooseFlyArray:
                for(int i=0;i<count;i++){
                    for(int j=0;j<count;j++){
                        if(x[j]==width/2-count/2+i&&y[j]==2*length/3-count/2+i){
                            x[j]=x[i];y[j]=y[i];break;
                        }
                    }
                    ((BadFollower)creatures[i]).move(x[i],y[i],width/2-count/2+i,2*length/3-count/2+i);
                }
                break;
            case CraneWingArray:
                for(int i=0;i<count;i++){
                    for(int j=0;j<count;j++){
                        if(x[j]==width/2+(i+1)/2*(i%2*2-1)&&y[j]==2*length/3+(i+1)/2){
                            x[j]=x[i];y[j]=y[i];break;
                        }
                    }
                    ((BadFollower)creatures[i]).move(x[i],y[i],width/2+(i+1)/2*(i%2*2-1),2*length/3+(i+1)/2);
                }
                break;
            case squareArray://对count严格要求为8
                for(int i=0;i<count;i++){
                    switch(i){
                        case 0:
                            for(int j=0;j<count;j++){
                                if(x[j]==width/2&&y[j]==2*length/3){
                                    x[j]=x[i];y[j]=y[i];break;
                                }
                            }
                            ((BadFollower)creatures[i]).move(x[i],y[i],width/2,2*length/3);
                            break;
                        case 1:
                            for(int j=0;j<count;j++){
                                if(x[j]==width/2+1&&y[j]==2*length/3+1){
                                    x[j]=x[i];y[j]=y[i];break;
                                }
                            }
                            ((BadFollower)creatures[i]).move(x[i],y[i],width/2+1,2*length/3+1);
                            break;
                        case 2:
                            for(int j=0;j<count;j++){
                                if(x[j]==width/2+2&&y[j]==2*length/3+2){
                                    x[j]=x[i];y[j]=y[i];break;
                                }
                            }
                            ((BadFollower)creatures[i]).move(x[i],y[i],width/2+2,2*length/3+2);
                            break;
                        case 3:
                            for(int j=0;j<count;j++){
                                if(x[j]==width/2+1&&y[j]==2*length/3+3){
                                    x[j]=x[i];y[j]=y[i];break;
                                }
                            }
                            ((BadFollower)creatures[i]).move(x[i],y[i],width/2+1,2*length/3+3);
                            break;
                        case 4:
                            for(int j=0;j<count;j++){
                                if(x[j]==width/2&&y[j]==2*length/3+4){
                                    x[j]=x[i];y[j]=y[i];break;
                                }
                            }
                            ((BadFollower)creatures[i]).move(x[i],y[i],width/2,2*length/3+4);
                            break;
                        case 5:
                            for(int j=0;j<count;j++){
                                if(x[j]==width/2-1&&y[j]==2*length/3+3){
                                    x[j]=x[i];y[j]=y[i];break;
                                }
                            }
                            ((BadFollower)creatures[i]).move(x[i],y[i],width/2-1,2*length/3+3);
                            break;
                        case 6:
                            for(int j=0;j<count;j++){
                                if(x[j]==width/2-2&&y[j]==2*length/3+2){
                                    x[j]=x[i];y[j]=y[i];break;
                                }
                            }
                            ((BadFollower)creatures[i]).move(x[i],y[i],width/2-2,2*length/3+2);
                            break;
                        case 7:
                            for(int j=0;j<count;j++){
                                if(x[j]==width/2-1&&y[j]==2*length/3+1){
                                    x[j]=x[i];y[j]=y[i];break;
                                }
                            }
                            ((BadFollower)creatures[i]).move(x[i],y[i],width/2-1,2*length/3+1);
                            break;
                    }

                }
                break;
            case yokeArray:
                for(int i=0;i<count/2;i++){
                    for(int j=0;j<count;j++){
                        if(x[j]==width/2-count/2+2*i&&y[j]==2*length/3){
                            x[j]=x[i];y[j]=y[i];break;
                        }
                    }
                    ((BadFollower)creatures[i]).move(x[i],y[i],width/2-count/2+2*i,2*length/3);
                }
                for(int i=count/2;i<count;i++){
                    for(int j=0;j<count;j++){
                        if(x[j]==width/2-count*3/2+2*i+1&&y[j]==2*length/3+1){
                            x[j]=x[i];y[j]=y[i];break;
                        }
                    }
                    ((BadFollower)creatures[i]).move(x[i],y[i],width/2-count*3/2+2*i+1,2*length/3+1);
                }
                break;
        }
    }
}
