# 葫芦娃大战小妖精  1.0

- 161220129 王奕琛

## 设计说明：
- 初步实现实验要求，包括：
  - 实现一个JavaFX图形界面，用20*10的二维空间用于放置生物
  - 实现生物的站队与战斗
  - 对每个生物实现一个线程，避免多个生物占据同一位置，多个生物杀死同一生物问题
## 设计思路：
- 生物体为一个类型，葫芦娃，老爷爷，小喽啰，蝎精，蛇精以及表示空生物的Blank均继承自生物类；
- 葫芦娃的姓名，颜色以及对应的图片确定，通过枚举实现。
- 由于每个生物是确定存在的（除Blank生物），在Global中实现对所有生物或生物群的创建；
- 建立与每个生物对应的线程(该线程包含该生物)，通过赋给线程信号量，保证每回合每个线程的生物仅移动一次。并在下回合初始化信号量重新移动。
- 用JavaFX构造一个10*20的gridPane来放置地图，每个回合结束后对地图进行重绘。
- map作为全局变量存放于Global中，所有的对地图的操作均在此map上进行。
- 为避免多个生物占据同一位置，多个生物杀死同一生物等问题，在map中对每个position创建一个对应的lock。
- 当生物线程start时，生物开始随机选择一个方向移动，则在map中将尝试对生物当前位置和要前往位置的上锁，短时间内不允许其他线程的生物使用这两个位置。同时使用try{lock,unlock}finally{unlock}保证不会因线程异常导致某个位置一直被锁定。(java文档推荐用法)
- 当生物死亡时，生物isDead置为true，并在原地留下墓碑，当其他生物从墓碑经过时，将铲除墓碑。
- 在GUIWINDOW中实现start函数，初始化个内容并等待用户指令。
- 当用户按下空格键开始游戏后，无法使用其他按键或按钮，只能使用enter键继续游戏。
- 在Global中对生物进行归类，判断每个阵营的生物是否全部死亡。若某一方全部死亡则游戏结束。
- 生物线程的每个循环结束后，判断游戏是否结束，若游戏结束，用户可以重新选择个生物群的阵型开始游戏。

## 类结构
- Creatures Package:
  - Creature:所有生物类的子类，含name，imageURL，Position, isDead, isBlank, isFriend等属性；
  - Calabash：葫芦娃类，内实现对所有葫芦娃的枚举，包括name，color和imageURL；
  - CalabashBrother:葫芦娃的对象的集合，方便在Global中创建葫芦娃对象；
  - Monsters:小喽啰的对象的集合，方便在Global中创建monster对象；
  - Blank类：空生物，表示此地没有生物，亦无对应线程；
  - 其他继承自Creature类，无重要变化。
- Formation Package：
  - Position: 单个位置类，包含其对应的x和y的坐标以及其上生物；
  - Map: 地图类，仅在Global中创建有一个他的对象，包含locks属性以及moveCreature方法
  ```Java
  public class Map {
      //MARK:Properties;
      Position[][] positions;
      private Lock[][] locks = new Lock[cols][rows]
      
      //MARK:function
      public boolean moveCreature(int oldX, int oldY,int newX, int newY){
          if(oldX < 0 || oldX >= cols || oldY < 0 || oldY >= rows || newX < 0 || newX >= cols || newY < 0 || newY >= rows)
              return false;
          boolean flag = false;
          //尝试获取生物当前位置锁，并在移动过程中保证对该位置的锁定；
          if(locks[oldX][oldY].tryLock()){
              try{
                  //尝试获取生物将要前往的位置的锁，并在移动过程中保证对该锁的锁定；
                  if(locks[newX][newY].tryLock()){
                      try{
                          if (!positions[oldX][oldY].getCreature().isBlank()) {
                              //获取当前位置生物(不为空)
                              Creature creature = positions[oldX][oldY].getCreature();
                              if(positions[newX][newY].isEmpty()) {
                                  positions[oldX][oldY].reSetCreature();
                                  positions[newX][newY].setCreature(creature);                            
                                  flag = true;
                              }else{
                                  //若目标位置有墓碑，则铲除墓碑
                                  if(!positions[newX][newY].getCreature().isAlive()){
                                      positions[oldX][oldY].reSetCreature();
                                      positions[newX][newY].setCreature(creature);
                                      flag = true;
                                  }
                                  //目标位置有生物且不是同一阵营，则杀掉他
                                  /*由于每个生物线程相当于随机的顺序，因此此处相当于随机一生物死亡*/
                                  //杀死目标生物后不前往目标生物位置，而是继续随机前往下一位置。
                                  else if(positions[newX][newY].getCreatureCamp() != creature.isFriend()){
                                      positions[newX][newY].getCreature().setDead();
                                      System.out.println("move creature from"+oldX+","+oldY+"to"+newX+","+newY);
                                      flag = false;
                                  }
                                  else {flag = false;}
                              }
                          }else{flag = false;}
                      }finally {
                          //释放目标位置锁
                          locks[newX][newY].unlock();
                      }
                  }
              }finally {
                  //释放当前位置锁
                  locks[oldX][oldY].unlock();
              }
          }
          return flag;
          
      }
  }
  ```
  - Formation：其他queue的子类，含Global.map；
  - Queuei:不同的队列类，根据队列不同，在map的不同位置放置生物；
- GUIPackage：
  - Main：按照实验要求添加
  - GUIWindow:程序真正入口，初始化界面内容，初始化map并在界面上显示。
- Source：

  - Global：常用的常量，以及一些全局函数
- Thread：
  - 每个生物相关Thread：初始化信号量start和end，在run时调用move函数，随即决定方向并move；(以calabashThread为例)
  ```Java
  //MARK:Properties
  Calabash calabash;
  Semaphore startSemaphor;
  Semaphore endSemaphor;
  int pos_x;
  int pos_y;
  
  //MARK:Initialize
  public CalabashThread(...){...}
  
  //MARK:Override function
  public void run(){
      while(true){
          try{
              startSemaphore.acquire();
              if(calabash.isAlive())
                  move();
              endSemaphore.release();
          }catch(Expection e){...}
      }
  }
  
  //MARK:help methods
  
  //move
  public void move(){
      Random random = new Random();
      int i = random.nextInt(3);
      pos_x = calabash.getPos_x();
      pos_y = ...;
      switch(i){
          case 0:{if(Global.map.moveCreature(...)) break; i++;}
          case 1:{...}
          case 2:{...}
          case 3:{Global.map.moveCreature(...);break;}
      }
  }
  ```
  - Game:各线程的初始化及控制,包含start函数和roundTimer函数
    - start函数先获取每个线程的end信号量，再分配给每个线程一个start信号量，各线程执行start；
    - roundTime函数在线程已经start的情况下运行，由于每个线程在每次移动后都会释放end信号量，当roundTime获取到所有的信号量后在释放给每个线程一个start信号量，保证所有线程都正常结束，再重新开始

## 用户说明：
- 用户可在战斗开始前在左上角通过battle栏选择各方阵型；
- 用户按下空格键，战斗开始，用户通过按下enter键使执行下一回合；
- 当一方生物全部阵亡后，战斗结束，用户可重新为两方选择阵型进行战斗，或直接按下空格键使用默认阵型进行战斗。

