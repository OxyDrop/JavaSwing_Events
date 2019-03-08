package TextGraphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TexteSeq {
	public static void main(String[] args){
		MaFenetre fen = new MaFenetre();
		fen.setVisible(true);
	}
}
class MaFenetre extends JFrame{
	private final JPanel pan;
	public MaFenetre(){
		setTitle("Saisie texte"); setSize(300,150);
		pan = new Panneau();
		getContentPane().add(pan);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ev){
				System.exit(0);
			}
		});
	}
}
class Panneau extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int x = 20, y = 30;
		final String ch1 = "bonjour", ch2 = " monsieur", ch3 = "et madame";
		FontMetrics fm = g.getFontMetrics();
		g.drawString(ch1,x,y);
		x+= fm.stringWidth(ch1);
		g.drawString(ch2,x,y);
		y+= fm.getHeight();
		x-= fm.stringWidth(ch1);
		g.drawString(ch3,x,y);
	}
}
