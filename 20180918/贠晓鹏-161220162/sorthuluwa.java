class hulubrothers{
    static String[] Name = {"大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃"};
    static String[] Color = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};
    private int age;
    private String name;
    private String color;
    public void setage(int age1) {
        age = age1;
    }
    public void setname(String name1) { name = name1; }
    public void setcolor(String color1) { color = color1; }
    hulubrothers(int a) {
        age = a;
        color = Color[a - 1];
        name = Name[a - 1];
    }
    int get_age() {return age;}
    String get_name(){return name;}
    String get_color(){return color;}
}

public class sorthuluwa{
    static void bubble_sort(hulubrothers[] members) {
        for(int i=0;i<6;i++) {
            for(int j=0;j<6-i;j++) {
                if(members[j].get_age()>members[j+1].get_age()) {
                    System.out.println(members[j].get_name()+": "+j+"->"+(j+1));
                    System.out.println(members[j+1].get_name()+": "+(j+1)+"->"+j);
                    hulubrothers temp=members[j];
                    members[j]=members[j+1];
                    members[j+1]=temp;
                }
            }
        }
    }
    static void binary_sort(hulubrothers[] members) {
        for(int i=0;i<7;i++) {
            int left=0,right=i-1,mid=0;
            hulubrothers temp=members[i];
            while(left<=right) {
                mid=(left+right)/2;
                if(members[mid].get_age()>temp.get_age()) {
                    right=mid-1;
                }
                else {
                    left=mid+1;
                }
            }
            for(int j=i-1;j>=left;j--) {
                System.out.println(members[j].get_name()+": "+j+"->"+(j+1));
                members[j+1]=members[j];
            }
            if(left!=i){
                System.out.println(temp.get_name()+": "+i+"->"+left);
                members[left]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] pos1={2,1,5,6,7,3,4};
        int[] pos2={4,3,2,7,1,6,5};
        hulubrothers[] members = new hulubrothers[7];
        for (int i = 0; i < 7; i++)
        {
            members[i]=new hulubrothers(pos1[i]);
        }
        System.out.println("站队......年龄排序");
        bubble_sort(members);
        for(int j=0;j<members.length;j++) {
            System.out.print(members[j].get_name() + " ");
        }
        System.out.println();
        System.out.println("再次站队......颜色排序");
        for (int i = 0; i < 7; i++)
        {
            members[i]=new hulubrothers(pos2[i]);
        }
        binary_sort(members);
        for(int j=0;j<members.length;j++) {
            System.out.print(members[j].get_color() + " ");
        }
        System.out.println();
    }





}

