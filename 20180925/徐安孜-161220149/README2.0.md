# 第三次作业修改

## 改善了代码文件布局
### 将原来单个java文件拆分为多个java文件
## 修改了类的实现及类之间的关系
### 修改前，Grandpa和Snake是Creature的两个子类，修改后GoodBoss和BadBoss为Creature的两个子类，grandpa和snake分别为GoodBoss和BadBoss的实体
### 修改前，阵型Formation原先通过枚举类实现，并且在其中有ArrayList类型的成员用于记录构成这个阵型的实体，并且一种阵型成员的数目是固定的。修改后，编写基类Formation，其中只包含记录各成员位置信息的动态数组pattern，不同的阵型如SnakeFormation、WingFormation都继承Formation类，在其构造器中根据传入的参数生成位置信息

```
public class Formation{
    ArrayList <Coordinate>pattern;
    Formation(){
        pattern = new ArrayList<>();
    }
}
class SnakeFormation extends Formation{
    SnakeFormation(int num){
        for(int i=0;i<num;i++)
            pattern.add(new Coordinate(i,0));
    }
}
```