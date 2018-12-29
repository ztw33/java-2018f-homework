设计思路
=======
## 要存在的对象有
- 生物：葫芦娃，妖怪，爷爷，蛇精
- 阵营：葫芦娃和爷爷属于一方，妖怪蛇精属于另外一方，各自的阵营里可以使用各自的阵型
- 战场：用于双方进行战斗，战斗开始时，操作者用上帝之手运行该代码，开辟战场，战场召唤双方进行战斗
## 要设计的类
- 生物（以下的类全部继承自该类）
  - 葫芦娃
  ```java
  public class brother extends creatures{
    static String[] Name = {"1", "2", "3", "4", "5", "6", "7"};
    brother(int a) {
        name = Name[a];
        x=y=0;
    }
  ```
  - 爷爷
  ```java
  public class grandpa extends creatures{
    grandpa(){
        name=new String("G");
        x=y=0;
    }
    grandpa(int get_x,int get_y){
        name=new String("G");
        x=get_x;y=get_y;
    }
    public void report_name(){//打印名字
        System.out.print(name+"  ");
    }
    }
  ```
  - 妖怪
  ```java
  public class monsters extends creatures {
    int flag;
    monsters()
    {
        name=new String("M");
        flag=0;
        x=y=0;
    }
    monsters(int get_flag){
        flag=get_flag;
        if(flag==1)
            name=new String("BM");
        else
            name=new String("M");
    }
    public void report_name(){//打印名字
        System.out.print(name+"  ");
    }
    }
  ```
  - 蛇精
- 战场
- 双方阵营
## 运作过程
- 首先开始战争，战争的第一步是开辟战场，所以在war类中调用battlefield,创建一个新的战场对象，战场对象负责开辟一片固定大小的空间,并且指定妖怪数量
```java
 public static void main(String[] args) {
        War war = new War(19, 12);
     }
```
```java
class battlefield{
    private creatures[][] field;
    private  int N;
    }
```
- 然后召唤双方开始布阵
  war.ChangeCalabashArray();
  war.ChangeMonsterArray(i);
- 显示布阵后的结果
  war.showWar();

