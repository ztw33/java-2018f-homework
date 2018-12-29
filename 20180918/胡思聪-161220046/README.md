# 作业2_v2 (executor.java)
## 共有四个类，枚举类型的葫芦娃类 ，小车类，车队类，以及调度者类
### 枚举葫芦娃类
葫芦娃有限且唯一。故用枚举类。葫芦娃类只有名字和颜色两个属性
```
enum Huluwa{
    one("老大","红色"), two("老二","橙色"),three("老三","黄色"),
    four("老四","绿色"), five("老五","青色"),six("老六","蓝色"),
    seven("老七","紫色");
    private String name;
    private String color;
    Huluwa(String in_name, String in_color) {
        this.name=in_name;
        this.color=in_color;
    }
    void count_off(){ //报数
        System.out.print(name);
    }
    void report_color(){
        System.out.print(color);
    }
}
```
### 小车类
每个小车装一个葫芦娃，且小车具有编号，位置属性。同时具有改变位置，报告位置变更的方法。
```
class Car{
    Huluwa huluwa;
    private int index;
    private int pre_location;
    private int location;
    Car(Huluwa x,int i){
        huluwa=x;
        index=i;
        pre_location=-1;
        location=-1;
    }
    int get_index(){
        return index;
    }
    void change_location(int n){ //位置变更
        pre_location=location;
        location=n;
    }
    void report_location(){ //报告位置更改
        huluwa.count_off();
        System.out.println(": "+pre_location+"->"+location);
    }
}
```
### 车队类
一个车队由7个小车构成，7个小车装了7个葫芦娃。
小车具有位置排序的方法。
葫芦娃排序实际上变成了小车的按序移动。
### 调度者类
调度者类创建车队对象并命令小车按顺序排列
```
public class executor {
    public static void main(String[] args){
        Cars cars=new Cars();
        cars.stand_ramdomly();
        cars.bubble_sort();
        cars.stand_ramdomly();
        cars.Binary_Insert_Sort();
    }
}
```
