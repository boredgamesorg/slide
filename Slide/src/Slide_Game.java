import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Slide_Game  implements ActionListener,MouseListener{
	
	JFrame game_window;
	JPanel Header,Body,Foot,RightPanel,LeftPanel;
	
	ImageIcon image;
	BufferedImage image1;
	BufferedImage[][] TileImages;
	
	JLabel Time_Label;
	JLabel Moves;
	
	
	
	File file = new File("R.jpeg");
	
	Color Foreground_Color = Color.CYAN;
	Font Global_Font = new Font("MV Boli",Font.BOLD,30);
	
	
	@SuppressWarnings("static-access")
	Slide_Game(){
		
		ImageSplitter imageGen= new ImageSplitter();
		TimerLabel time = new TimerLabel();
		
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
        
        Header = new JPanel();
        Header.setBackground(Color.BLACK);
        Header.setBorder(BorderFactory.createLineBorder(Foreground_Color,2));
        Header.setLayout(new FlowLayout());        
        
        Body = new JPanel();
        Body.setBackground(Color.BLACK);
        Body.setBorder(BorderFactory.createLineBorder(Foreground_Color,2));
        Body.setLayout(new GridLayout(3,3));
        
        Foot = new JPanel();
        Foot.setBackground(Color.BLACK);
        Foot.setBorder(BorderFactory.createLineBorder(Foreground_Color,2));
        Foot.setLayout(new FlowLayout());
        
        LeftPanel = new JPanel();
        LeftPanel.setBackground(Color.BLACK);
        LeftPanel.setBorder(BorderFactory.createLineBorder(Foreground_Color,2));
        LeftPanel.setLayout(new FlowLayout());
        
        RightPanel = new JPanel();
        RightPanel.setBackground(Color.BLACK);
        RightPanel.setBorder(BorderFactory.createLineBorder(Foreground_Color,2));
        RightPanel.setLayout(new FlowLayout());
        
        
        Time_Label = time.createTimerLabel(Color.BLACK, Foreground_Color, null, Global_Font);
        
        Moves = new JLabel("Moves : 0     ");
        Moves.setBackground(Color.BLACK);
        Moves.setForeground(Foreground_Color);
        Moves.setBorder(null);
        Moves.setFont(Global_Font);
        
        Header.add(Moves);
        Header.add(Time_Label);
        
        game_window.add(Header,BorderLayout.NORTH);
        game_window.add(Body,BorderLayout.CENTER);
        game_window.add(Foot,BorderLayout.SOUTH);
        game_window.add(LeftPanel,BorderLayout.WEST);
        game_window.add(RightPanel,BorderLayout.EAST);
        
        game_window.setVisible(true);
        
        
        
        
        
        try {
        	image1 = ImageIO.read(file);
			TileImages = ImageSplitter.splitImage(image1, 3, 4, Color.BLACK);
		} catch (IOException e) {
			System.out.println("Error While Parsing Image!");
		}
        for(int i = 0; i<TileImages.length; i++) {
    		for(int j = 0; j<TileImages.length; j++) {
    			if(!(i == TileImages.length-1 && j==TileImages.length-1)) {
    				ImageIcon icon = new ImageIcon(TileImages[i][j].getScaledInstance(game_window.getWidth() / TileImages.length, game_window.getHeight() / TileImages.length, 0));
        			JLabel label = new JLabel(icon);
        			label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        	        Body.add(label);
    				
    			}
    			
    		}
    	}
		
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
}
