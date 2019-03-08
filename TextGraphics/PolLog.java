package TextGraphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PolLog {
	public static void main(String[] args){
		JFrame.setDefaultLookAndFeelDecorated(true);
		Mafen fen = new Mafen();
		fen.setOpacity(0.93f);
		fen.setVisible(true);
	}
}
class Mafen extends JFrame{
	private JPanel pan;
	private JScrollPane defil;
	public Mafen(){
		setTitle("Fonts"); setSize(600,150);
		pan = new Panel();
		Dimension d = new Dimension(500,3000);
		pan.setPreferredSize(d);
		defil = new JScrollPane(pan);	
		getContentPane().add(defil);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ev){
				System.exit(0);
			}
		});
	}
}
class Panel extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		String[] fontes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(getLocale());
		int x = 10, y = 10;
		for(int i = 0; i<fontes.length ; i++){
			g.setFont(new Font(fontes[i],Font.PLAIN,14));
			FontMetrics fm = g.getFontMetrics();
			String ch = fontes[i]+" alphabet";
			y+=fm.getAscent();
			g.drawString(ch,x,y);
			y+=fm.getDescent()+fm.getLeading();
		
		}
	}
}
