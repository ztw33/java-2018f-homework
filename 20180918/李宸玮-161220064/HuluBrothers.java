import java.util.*;
public class HuluBrothers {
    Hulu []BrothersArray=new Hulu[7];
    public void Initialize(){
        for(int i=0;i<7;i++)
        BrothersArray[i]=new Hulu();
    }
    public void Shuffle(){
     System.out.print("请输入葫芦娃的任意一个战队(顺序输入葫芦娃的序号*注意不要重复)：");
     Scanner x=new Scanner(System.in);
      for(int i=0;i<7;) {
          int HuluNum=x.nextInt();
          if((0<HuluNum)&&(HuluNum<8)) {
              BrothersArray[i].setNum(HuluNum);
              switch(BrothersArray[i].num) {
                  case 1:
                      BrothersArray[i].setColor(Color.red);
                      BrothersArray[i].setOrder(Order.老大);
                      break;
                  case 2:
                      BrothersArray[i].setColor(Color.orange);
                      BrothersArray[i].setOrder(Order.老二);
                      break;
                  case 3:
                      BrothersArray[i].setColor(Color.yellow);
                      BrothersArray[i].setOrder(Order.老三);
                      break;
                  case 4:
                      BrothersArray[i].setColor(Color.green);
                      BrothersArray[i].setOrder(Order.老四);
                      break;
                  case 5:
                      BrothersArray[i].setColor(Color.ching);
                      BrothersArray[i].setOrder(Order.老五);
                      break;
                  case 6:
                      BrothersArray[i].setColor(Color.blue);
                      BrothersArray[i].setOrder(Order.老六);
                      break;
                  case 7:
                      BrothersArray[i].setColor(Color.purple);
                      BrothersArray[i].setOrder(Order.老七);
                      break;
                 default:
                     throw new RuntimeException("输入错误!");
              }
              i++;
          }
      }
    }
    public void swapReport(int i,int j){
        System.out.println(BrothersArray[i].order+":"+i+"->"+j);
        System.out.println(BrothersArray[j].order+":"+j+"->"+i);

    }
   public void bubbleSort(){
        Hulu temp=new Hulu();
        for(int i=0;i<7;i++) {
            for(int j=i+1;j<7;j++) {
                if(BrothersArray[i].num>BrothersArray[j].num){
                    swapReport(i,j);
                    temp=BrothersArray[i];
                    BrothersArray[i]=BrothersArray[j];
                    BrothersArray[j]=temp;
                }
            }
        }
    }
   public void quickSort(){
            for (int i = 1; i < 7; i++) {
                Hulu temp = BrothersArray[i];
                int low = 0, high = i - 1;
                int mid = -1;
                while (low <= high) {
                    mid = low + (high - low) / 2;
                    if (BrothersArray[mid].num > temp.num) {
                        high = mid - 1;
                    } else { // 元素相同时，也在后面的位置插入
                        low = mid + 1;
                    }
                }
                for(int j = i - 1; j >= low; j--) {
                    System.out.println(BrothersArray[j].order+":"+j+"->"+(j+1));
                    BrothersArray[j + 1] = BrothersArray[j];
                }
                System.out.println(temp.order+":"+i+"->"+low);
                BrothersArray[low] = temp;
            }
        }

}