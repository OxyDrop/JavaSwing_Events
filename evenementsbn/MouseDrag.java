package evenementsbn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MouseDrag {
	public static void main(String[] args) {
		MaFenetre fen = new MaFenetre();
		fen.setVisible(true);
	}
}
class MaFenetre extends JFrame{
	private Panneau pan;
	public MaFenetre(){
		setTitle("drags souris");
		setSize(400,200);
		pan = new Panneau();
		getContentPane().add(pan);
	}
}
class Panneau extends JPanel implements MouseMotionListener{
	private boolean enCours = false;
	private int xDeb, xFin, yFin, yDeb;
	public Panneau(){
		addMouseMotionListener(this);
		addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				enCours=false;
				System.out.println("Release "+e.getX()+"x "+e.getY()+"y");
			}
		});
		repaint();
	}
	public void mouseDragged(MouseEvent e){
		System.out.println("Drag "+e.getX()+"x "+e.getY()+"y");
		if(!enCours){
			xDeb=e.getX(); yDeb=e.getY();
			xFin=xDeb; yFin=yDeb;
			enCours=true;
		}else{
			xFin=e.getX(); yFin=e.getY();
		}
		repaint();
	}
	public void mouseMoved(MouseEvent e){}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int xd, xf, yd, yf;
		xd = Math.min(xDeb,xFin);
		xf = Math.max(xDeb,xFin);
		yd = Math.min(yDeb, yFin);
		yf = Math.max(yDeb,yFin);
		g.setColor(Color.blue);
		g.fillRect(xd, yd, xf-xd, yf-yd);
	}
}
