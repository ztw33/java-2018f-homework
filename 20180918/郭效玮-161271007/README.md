




#葫芦娃排序

##葫芦娃类

        public enum CalabashBro
为枚举类型，总共只有七个实例

```java

    private int order;
    private String name;
    private String color;

    private CalabashBro(String name,String color,int order);
    public String getName();
    public String getColor();
    public int getOrder();
    public void tellName();
    public void tellColor()；
    public void tellPosEx(int i,int j) {
    	System.out.print(name+": "+i+" -> "+j+"\n");
    }//交换位置的时候报告
```
##葫芦娃排序员类

        public class CalabashSorter



```java

    private CalabashBro[] calabashList;
	public CalabashSorter();
	public void randomList();//用于打乱排序
	public void reportName()；//调用葫芦娃类实例的tellName方法
	public void reportColor()；//同上
	public void bubbleSort()；
	public void binarySort()；
```


            