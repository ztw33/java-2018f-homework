# BattleField

Calabash brothers are battling against monsters in a battlefield.





## Contents

+ Class Introduction
+ Process Route
+ Final Output





### Class Introduction

1. ####Living

   class **Living** is defined in ***Living.java***,  and it creates enum type **CAMP**, which stands for its camp. (CalabashBrothers or Monsters)

   class **Living** includes member variables as follow

   ```java
   String myName;         //name
   boolean isAlive;       //life status
   boolean hasMount;      //Does it has a mount?
   CAMP myCamp;           //its camp
   int myFamilyRank;      //its family rank
   Mount myMount;         //its mount
   ```

​	class **Living** includes member functions as follow

```java
Living();                         //Construction function
public void TellMyName();         //Return its name
public CAMP TellMyCamp();         //Return its mount
public int TellMyRowPosition();   //Return its row position
public int TellMyColumnPosition(); 
//Return its column position
public void SitInBattleField(Land[][] land);
//Go to Battlefield
public void GoTo(int rowPosition,int columnPosition,Land oldLand,Land newLand);
//Move to certain position in Battlefield
```



2. #### Calabash Brothers

   class **CalabashBrothers** extends from class **Living**.

   class **CalabashBrothers** includes member variables as follow

   ```java
   COLOR myColor;			//its color
   ```

   class **CalabashBrothers** includes member functions as follow 

   ```java
   CalabashBrothers();			//Construction function
   ```

   + ##### Grandpa

     class **Grandpa** is defined in ***Grandpa.java***, and it extends from class **Living**.

     class **Grandpa** includes member functions as follow

     ```java
     Grandpa();			//Construction function
     ```

   + ##### [Color]Boy

     **[Color]** can be replaced by **Red**、**Orange**、**Yellow**、**Green**、**Cyan**、**Blue** and **Purple**.

     class **[Color]Boy** is defined in ***[Color]Boy.java***, and it extends from class **CalabashBrothers**.

     class **[Color]Boy** includes member functions as follow

     ```java
     [Color]Boy();			//Construction function
     ```

3. #### Monsters

   + ##### [Monster]

     **[Monster]** can be replaced by **Scorpion**、**Snake** and **Minions**.

     class **[Monster]** is defined in ***[Monster].java***, and it extends from class **Living**.

     class **[Monster]** includes member functions as follow

     ```java
     [Monster]();			//Construction function
     ```

4. #### Land

   class **Land** is defined in ***Land.java***. It stands for the land of Battlefield.

   class **Land** includes member variables as follow

   ```java
   boolean isUsed;				//Has it been used up?
   String userName;			//Its owner's name
   ```

   class **Land** includes member functions as follow 

   ```java
   Land();					//Construction function
   public void SitHere(String name);
   //Someone sits in this land
   public void GoAway();
   //Someone leaves this land
   public boolean isUsedUp();
   //Return its status
   public String GetUserName();
   //Return its owner's name
   public void GetSimpleName();
   //Return its owner's simplified name
   ```

5. #### Mount

   class **Mount** is defined in ***Mount.java***,  and it creates enum type **MountType**, which stands for its mount's type. (Lotus、Foot or Unknown)

   class **Mount** includes member variables as follow

   ```java
   String ownerName;				//Its owner's name
   MountType myType;				//Its type
   int rowPosition;				//Its row position
   int columnPosition;				//Its column position
   boolean isUsed;					//Has it been used?
   ```

   class **Mount** includes member functions as follow

   ```java
   Mount();				//Construction function
   Mount(String name, MountType type);
   //Construction function with variables
   public boolean PickUp(String name, MountType type);
   //Someone rides on this mount
   public boolean AskForOwner();
   //Return its status
   public void EnterBattleField(Land[][] land);
   //Go to battlefield
   public void MoveTo(int newRow, int newColumn,Land oldLand,Land newLand);
   //Move to certain position in battlefield
   public int GetRowPosition();
   //Return its row position;
   public int GetColumnPosition();
   //Return its column position;
   ```

6. #### BattleField

   class **BattleField** is defined in ***BattleField.java***,  and it creates enum type **FormationType**, which stands for creatures' formation. 

   **FormationType**:

   + Snake: 长蛇
   + Wing: 鹤翼
   + Goose: 雁行
   + Zig: 踟蹰
   + Square: 方圆
   + Moon: 偃月
   + Arrow: 锋矢

   class **BattleField** includes member variables as follow

   ```java
   Living[] lives;				//lives in battlefield
   Land[][] land;				//land of battlefield
   ```

   class **BattleField** includes member functions as follow

   ```java
   BattleField();				//Construction function
   void ZigFormation(int[][] positionMap, CAMP camp);
   //Zig Formation
   void WingFormation(int[][]positionMap,CAMP camp);
   //Wing Formation
   void GooseFormation(int [][]positionMap, CAMP camp);
   //Goose Formation
   void FishFormation(int[][] positionMap,CAMP camp);
   //Fish Formation
   void SquareFormation(int[][] positionMap, CAMP camp);
   //Square Formation
   void MoonFormation(int[][] positionMap, CAMP camp);
   //Moon Formation
   void ArrowFormation(int[][] positionMap, CAMP camp);
   //Arrow Formation
   void SnakeFormation(int[][] positionMap, CAMP camp);
   //Snake Formation
   public void PutLeaders(FormationType ft,CAMP camp);
   //Each side's leader goes to battlefield
   public void Formation(FormationType ft,CAMP camp);
   //The Constructor orders creatures to formate
   static FormationType GetRondomFormation();
   //Decide a formation type at random
   Land GetFreeLandOutside();
   //Search for free land outside battlefield
   public void MoveOutside(CAMP camp);
   //Move someone out of battlefield
   public void ShowBattleField();
   //Show current status of battlefield
   public static void main(String []args);
   //Function Main
   ```



### Process Route

1. Program start from function **Main** in ***BattleField.java***, and initialize a instance of class **BattleField**, then class **BattleField** initialize two sides' creatures in its construction function. After that all creatures have its initial position in battlefield.
2. Then program goes to funciton **Formation** and function **PutLeaders**, Therefore two sides' creatures are ready to battle.
3. Program goes to function **MoveOutside** and move monsters out of battlefield, and goes to funtion **Formation** and function **PutLeaders** as well as function **GetRandomFormation** again in order to get a new formation for monsters.
4. During the two formation, Program output the status of battlefield. 





### Final Output

Run it!





### Designer's Idea

+ All creature class extends from class **Living**.
+ Class **BattleField** works as a constructor, who orders all creatures to move and formate.
+ When some creature is ordered to move to somewhere, it tells its mount to go to the destination.
+ Once someone went to battlefield, it is sociated with one piece of land in battlefield, this piece of land records the creature's name and won't let others use it unless its owner moves to somewhere else.
+ ......
