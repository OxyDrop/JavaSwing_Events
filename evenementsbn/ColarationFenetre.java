package evenementsbn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ColarationFenetre {
	public static void main(String[] args){
		JFrame.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				MaFen fen = new MaFen();
				fen.setOpacity(0.85f);
				fen.setVisible(true);
			}
		});
	}
}
class MaFen extends JFrame{
	private JPanel pan;
	public MaFen(){
		setTitle("Colorations"); setSize(300,150);
		pan=new JPanel();
		getContentPane().add(pan);
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(e.isControlDown() && e.isAltDown()){
					int touche=e.getKeyCode();
					switch(touche){
						case KeyEvent.VK_R : pan.setBackground(Color.red); break;
						case KeyEvent.VK_B : pan.setBackground(Color.blue); break;
						case KeyEvent.VK_J : pan.setBackground(Color.green); break;
						case KeyEvent.VK_W : pan.setBackground(Color.white); break;
						case KeyEvent.VK_N : pan.setBackground(Color.black); break;
					}
				}
			}
		});
	}
}