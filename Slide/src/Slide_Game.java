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
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Slide_Game  implements ActionListener,MouseListener{
	
	JFrame game_window;
	JPanel Header,Body,Foot,RightPanel,LeftPanel;
	
	ImageIcon image;
	BufferedImage image1;
	BufferedImage[][] TileImages;
	
	Tile[] TileArr;
	
	JLabel Time_Label;
	JLabel Moves;
	
	JButton[] clickObj = new JButton[9];
	Tile[] shuffledObj;
	
	File file = new File("C:/Users/Rohit Sinha/Desktop/Slide/slide/Slide/assets/R.jpeg");
	
	Color Foreground_Color = Color.CYAN;
	Font Global_Font = new Font("MV Boli",Font.BOLD,30);
	
	
	public JButton[] setNewPositions() {
		
		JButton newPositions[] = new JButton[9];
		
		
		
		return newPositions;
	}
	
	
	private void updateButtonPositions() {
	    Body.removeAll();

	    for (Tile tile : TileArr) {
	        JButton button = tile.getImg();
	        Body.add(button);
	    }

	    Body.revalidate();
	    Body.repaint();
	}

	
	
	@SuppressWarnings("static-access")
	Slide_Game(){
		
		new Slide();
		
		
		new Shuffling();
		
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
		 }catch (IOException e) {
			System.out.println("Error While Parsing Image!");
		}
        
        int index = 0;
        
        for(int i = 0; i<TileImages.length; i++) {
    		for(int j = 0; j<TileImages.length; j++) {
    			if(!(i == TileImages.length-1 && j==TileImages.length-1)) {
    				
    				ImageIcon icon = new ImageIcon(TileImages[i][j].getScaledInstance(game_window.getWidth() / TileImages.length, game_window.getHeight() / TileImages.length, 0));
        			//JLabel label = new JLabel(icon);
        			
        			clickObj[index] = new JButton(icon);       			
        			clickObj[index].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        			clickObj[index].setBackground(Color.BLACK);
        			clickObj[index].addActionListener(this);
        			
        	        Body.add(clickObj[index]);
    				
        	        index++;
        	        
    			}	
    			else {
    				clickObj[index] = new JButton();       			
        			clickObj[index].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        			clickObj[index].addActionListener(this);
        			clickObj[index].setBackground(Color.BLACK);
        			
        			//Body.add(clickObj[index]);
    			}
    		}
    	}
        
        
        //shuffledObj = clickObj;
        
        
        
        TileArr = Slide.setup(clickObj, 9);
        
        shuffledObj = Shuffling.generateShuffledButtons(TileArr);
        
        for(int i = 0; i < shuffledObj.length; i++) {
        	Body.add(shuffledObj[i].getImg());
    	}
        
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < shuffledObj.length; i++) {
			if(e.getSource() == clickObj[i]) {
				
				shuffledObj = Slide.move(shuffledObj, shuffledObj[i]);
				
				for(int j = 0; j < shuffledObj.length; j++) {
					System.out.println("( "+shuffledObj[j].getID()+", "+shuffledObj[j].getX()+", "+shuffledObj[j].getY()+" )");
				}
				
				//Body.removeAll();
				

				
				
			}
		}
		for(int j = 0; j < shuffledObj.length; j++) {
			int k = j;
			var t = Arrays.asList(shuffledObj).stream().filter(obj -> {return obj.getX() == k%3 && obj.getY() == k/3;}).findFirst().orElse(null);
			Tile temp = (Tile)t;
        	Body.add(temp.getImg());
    	}
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
