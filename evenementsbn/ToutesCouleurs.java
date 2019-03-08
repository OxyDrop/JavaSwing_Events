package evenementsbn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ToutesCouleurs {
	public static void main(String[] args){
		Colorfen fen = new Colorfen();
		fen.setVisible(true);

	}
}
class Colorfen extends JFrame implements ActionListener{
	private JPanel pan, entree;
	private JTextField hText, sText, bText;
	private JLabel hue, saturation, brightness;
	private JButton display;
	private int i,j,k,s;
	public Colorfen(){
		i=j=k=s=0;
		setTitle("Multicolor"); setSize(700,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan = new JPanel();
		entree = new JPanel(new FlowLayout());
		hText = new JTextField(10); sText = new JTextField(10); bText = new JTextField(10);
		hue = new JLabel("Hue"); saturation = new JLabel("Saturation"); brightness = new JLabel("Brightness");
		display = new JButton("Display");
		entree.add(hue); entree.add(hText);
		entree.add(saturation); entree.add(sText);
		entree.add(brightness); entree.add(bText);
		entree.add(display);
		getContentPane().add(pan);
		getContentPane().add(entree,"South");
		display.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==display){
			try{
				i=Integer.parseInt(hText.getText());
				j=Integer.parseInt(sText.getText());
				k=Integer.parseInt(bText.getText());
				pan.setBackground(Color.getHSBColor(i,j,k));
			}catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Entrée incorrecte, veuillez entrer des nombres dans [0,255]","Exception",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
