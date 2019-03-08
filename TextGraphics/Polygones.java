package TextGraphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Polygones {
	public static void main(String[] args){
		PolyFen fen = new PolyFen();
		fen.setVisible(true);
	}
}
class PolyFen extends JFrame{
	private JPanel pan;
	public PolyFen(){
		setTitle("Traces de Polygones"); setSize(400,180);
		pan = new PolyPan();
		getContentPane().add(pan);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ev){
				System.exit(0);
			}
		});
	}
}
class PolyPan extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		/* trace d'un hexagone */
		int r = 60;
		g.translate(10+r,10+r);
		int[] x = new int[6], y = new int[6];
		for(int i = 0; i<x.length ; i++){
			x[i]=(int)(r*Math.cos(i*Math.PI/3));
			y[i]=(int)(r*Math.sin(i*Math.PI/3));
		}
		g.setColor(Color.green); g.fillPolygon(x, y, 6);
		g.setColor(Color.yellow); g.drawPolygon(x,y,6);
		/* trace d'un noeud papillon */
		g.translate(2*r+20,0);
		x=new int[4]; y=new int[4];
		x[0] = y[0] = -r;
		x[1] = y[1] = r;
		x[2]=r ; y[2]=0;
		x[3]=0 ; y[3]=r;
		g.setColor(Color.orange); g.fillPolygon(x, y, 4);
		g.setColor(Color.red); g.drawPolygon(x,y,4);
		/* trace de ligne brisee */
		g.translate(r+20,-r);
		int[] x3 = {0,r,r,r/2,3*r/2};
		int[] y3 = {0,0,2*r,r/2,r/2};
		g.drawPolyline(x3,y3,5);
	}
}