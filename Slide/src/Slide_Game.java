<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Slide_Game implements ActionListener,MouseListener{
	
	JFrame game_window;
	ImageIcon image;
	
	
	Slide_Game(){
		
		image = new ImageIcon("C:\\Users\\Rohit Sinha\\SlideGameGUI\\SlideGameGUI\\OIP (1).jpg");

		game_window = new JFrame();

        game_window.setTitle("Slide Tile!");
        game_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_window.setIconImage(image.getImage());
        game_window.getContentPane().setBackground(Color.BLACK);
        game_window.setLayout(new BorderLayout());
        game_window.setSize(550,550);
        game_window.setLocationRelativeTo(null);
        game_window.setResizable(false);
        
        
        game_window.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
=======

public class Slide_Game {

>>>>>>> 686488e16348e6c7c52319e7cd9ddae660e992c1
}
