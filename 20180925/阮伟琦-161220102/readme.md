# 前言（谢罪）
这次的作业其实很早之前就已经做完了，但是后来一直在思考怎么改进的事所以迟迟没有提交，然后在后来就逐渐被其他事务给掩盖了。真的是非常的抱歉。后续版本也会及时跟进的！
# 类
这个程序中我有一个human类作为总的人物的大类，然后有子类stggc_students，university_students，shimada等。作为战场的比较关键的类是一个叫battlefield的类。这个field是由一个unit类的二维数组组成的，unit类里面有关于是否有人的一个布尔参数以及一个human的对象。
```
class unit
{
    boolean is_occupied;
    human people;
    unit()
    {
        is_occupied = false;
        //people = new human();
    }
}
```
# 方法
我把有关阵型的一些方法全部放在了battlefield的类里面，然后其余的一些小的方法比如show之类的也在里面。
# 效果
现在的效果可以说是比较的low了。基本上就是能在底下显示结果的窗口中打印几个字母阵型这样。
