package frame;
import formation.*;
import frame.ListModel;
import beings.*;
import battlefield.*;

//import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings({ "serial", "rawtypes" })
class ListModel extends DefaultComboBoxModel{
	@SuppressWarnings("unchecked")
	ListModel(String[] str){
		for(String s:str) {
			addElement(s);
		}
	}
}

@SuppressWarnings({ "serial", "rawtypes" })
class FormList extends JComboBox {
	static String[] form= {"长蛇阵","锋矢阵","鹤翼阵","偃月阵","衡轭阵","鱼鳞阵","方圆阵","雁行阵","自由阵"};
	static ListModel listmodel=new ListModel(form);
	ArrayList<Formation> forms;
	@SuppressWarnings("unchecked")
	FormList(){
		super(listmodel);
		forms=new ArrayList<Formation>();
		forms.add(new SerpentArray());
		forms.add(new Arrow());
		forms.add(new CraneWing());
		forms.add(new CrescentMoon());
		forms.add(new CrossBar());
		forms.add(new FishScale());
		forms.add(new SquareCircle());
		forms.add(new WildGooseRow());
		forms.add(new FreeFormation());
	}
}


@SuppressWarnings("serial")
class BeingLabel extends JLabel {
	Being being=null;
	Integer number=1;
	BeingLabel(Being being){
		this.being=being;
		this.setPreferredSize(new Dimension(50,50));
		this.setIcon(new ImageIcon(being.image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
	}
	public void setnumber() {
		this.setToolTipText(number.toString());
	}
}

@SuppressWarnings("serial")
public class Frame extends JFrame{
	BorderLayout layout=null;
	JPanel panel=null;
	JPanel beingpanel=null;
	FormList formlist=null;
	BattleField battlefield=null;
	
	ArrayList<Being> beings=null;
	
	//Toolkit tk;
	
	int WIDTH;
	int HEIGHT;
	
	public Frame(ArrayList<Being> Beings){
		//获取屏幕尺寸
		/*tk=Toolkit.getDefaultToolkit();
		Dimension d=tk.getScreenSize();*/
		//WIDTH=d.width*5/8;
		WIDTH=900;
		//HEIGHT=d.height;
		HEIGHT=750;
		
		//设置窗体基本参数
		setTitle("葫芦娃VS妖精");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0, 0);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/additions/calabashbrothers.jpg")));
		
		//初始化主体面板和整体布局
		layout=new BorderLayout();
		panel=new JPanel();
		this.setLayout(layout);
		this.setContentPane(panel);
		
		//初始化各面板
		beingpanel=new JPanel();
		beingpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		beingpanel.setPreferredSize(new Dimension(WIDTH,70));
		beingpanel.add(new JLabel("Beings"));
		beings=Beings;
		addbeinglabels();
		
		formlist=new FormList();
		battlefield=new BattleField(formlist.forms.get(0),beings);
		addaction();
		
		panel.add(beingpanel,BorderLayout.NORTH);
		panel.add(formlist,BorderLayout.WEST);
		panel.add(battlefield,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	private void addaction() {
		formlist.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				int len=formlist.forms.size();
				if(e.getStateChange()==ItemEvent.SELECTED) {
					int i;
					for(i=0;i<len;i++) {
						if(formlist.forms.get(i).name.equals((String)e.getItem()))
							break;
					}
					Formation formation=formlist.forms.get(i);
					battlefield.setform(formation);
					battlefield.setbeings(beings);
				}
			}
			
		});
		
	}
	
	private void addbeinglabels() {
		int beinglen=beings.size();
		ArrayList<BeingLabel> tmplabels=new ArrayList<BeingLabel>();
		for(int i=0;i<beinglen;i++) {
			Being tmpbeing=beings.get(i);
			int j,labellen=tmplabels.size();
			BeingLabel bl=null;
			for(j=0;j<labellen;j++) {
				bl=tmplabels.get(j);
				if(!bl.being.getClass().getName().equals(tmpbeing.getClass().getName()))
					continue;
				if(tmpbeing.getClass().getName().equals("beings.CalabashBrother"))
					continue;
				else
					break;
			}
			if(j!=labellen) {
				bl.number++;
				bl.setnumber();
			}
			else {
				BeingLabel bb=new BeingLabel(beings.get(i));
				bb.setnumber();
				tmplabels.add(bb);
				beingpanel.add(bb);
			}
		}
	}
	
	public static void main(String[] arg) {
		ArrayList<Being> Beings=new ArrayList<Being>();
		Beings.add(new CalabashBrother(CalabashAttributes.FIRST));
		Beings.add(new CalabashBrother(CalabashAttributes.SECOND));
		Beings.add(new CalabashBrother(CalabashAttributes.THIRD));
		Beings.add(new CalabashBrother(CalabashAttributes.FOURTH));
		Beings.add(new CalabashBrother(CalabashAttributes.FIFTH));
		Beings.add(new CalabashBrother(CalabashAttributes.SIXTH));
		Beings.add(new CalabashBrother(CalabashAttributes.SEVENTH));
		Beings.add(new Grandpa());
		Beings.add(new Scorpion());
		Beings.add(new Serpent());
		Beings.add(new Toad());
		Beings.add(new Toad());
		Beings.add(new Toad());
		Beings.add(new Toad());
		Beings.add(new Toad());
		Beings.add(new Centipede());
		Beings.add(new Centipede());
		Beings.add(new Centipede());
		Beings.add(new Centipede());
		Beings.add(new Centipede());
		Beings.add(new Toad());
		Beings.add(new Toad());
		Beings.add(new Toad());
		Beings.add(new Centipede());
		Beings.add(new Centipede());
		Beings.add(new Centipede());
		Beings.add(new Toad());
		Beings.add(new Toad());
		Beings.add(new Toad());
		Beings.add(new Centipede());
		Beings.add(new Centipede());
		Beings.add(new Centipede());
		@SuppressWarnings("unused")
		Frame f=new Frame(Beings);
	}
}
