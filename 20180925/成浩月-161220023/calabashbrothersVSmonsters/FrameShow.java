package calabashbrothersVSmonsters;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class FrameShow {
	private JFrame frame=new JFrame();
	private final String title="葫芦娃大战妖精";
	private JPanel imagepanel=new JPanel();
	private String formationname="";
	private JLabel[] labels;
	private GridLayout imagelayout;
	
	private Image frameicon;
	private Image lattice;
	private ImageIcon[] icons;
	private String wholepath="\\src\\calabashbrothersVSmonsters\\additions";
	private final String iconpath="\\calabashbrothers.jpg";
	private final String latticepath="\\lattice.jpg";
	
	private int WIDTH;
	private int HEIGHT;
	private final int rows=Stance.dimension;
	private final int cols=Stance.dimension;
	FrameShow() throws IOException{
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int min=screensize.height<screensize.width?screensize.height:screensize.width;
        WIDTH=(int)(0.75*min);
        HEIGHT=WIDTH;
		frame.setSize(WIDTH,HEIGHT);
		frame.setTitle(title+formationname);
		File file=new File("");
		String tmp=file.getCanonicalPath();
		wholepath=tmp+wholepath;
		try {
			frameicon=ImageIO.read(new File(wholepath+iconpath));
			lattice=ImageIO.read(new File(wholepath+latticepath));
		}catch(IOException e) {
			System.out.println("error "+e);
		}
		frame.setIconImage(frameicon);
		imagelayout=new GridLayout(rows,cols);
		imagepanel.setLayout(imagelayout);
		frame.setContentPane(imagepanel);
		imagepanel.setSize(WIDTH,HEIGHT);
		labels=new JLabel[rows*cols];
		icons=new ImageIcon[rows*cols];
		for(int i=0;i<rows*cols;i++) {
			labels[i]=new JLabel();
			icons[i]=new ImageIcon();
			icons[i].setImage(lattice);
			labels[i].setIcon(icons[i]);
			imagepanel.add(labels[i]);
		}
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	void setformationname(String formationname) {
		clearout();
		this.formationname=formationname;
		frame.setTitle(title+"_"+this.formationname);
	}
	void place(Image img,int row,int col) {
		if(row<0||row>=rows||col<0||col>=cols) {
			System.out.println("position out of range!");
			return;
		}
		int pos=row*cols+col;
		Image tmp=img.getScaledInstance((int)(WIDTH/cols), (int)(HEIGHT/rows), Image.SCALE_SMOOTH);
		icons[pos].setImage(tmp);
		frame.repaint();
	}
	void clearout() {
		formationname="";
		frame.setTitle(title+formationname);
		for(int i=0;i<rows*cols;i++) {
			icons[i].setImage(lattice);
			frame.repaint();
		}
	}
}