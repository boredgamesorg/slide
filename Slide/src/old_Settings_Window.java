import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class old_Settings_Window implements ActionListener,MouseListener{
	
	JFrame Settings_Frame;
	ImageIcon image;
	JPanel Head,Body,Container;
	JButton Confirm;
	JComboBox<String> choiceBox;
	JLabel Choice_Label;
	
	Color Foreground_Color = Color.CYAN;
	
	old_Settings_Window(){
	   
	   image = new ImageIcon("C:\\Users\\Rohit Sinha\\SlideGameGUI\\SlideGameGUI\\OIP (1).jpg");
	   
	   
		
	   Settings_Frame= new JFrame();

       Settings_Frame.setTitle("Slide Settings");
       Settings_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Settings_Frame.setIconImage(image.getImage());
       Settings_Frame.getContentPane().setBackground(Color.BLACK);
       Settings_Frame.setLayout(new BorderLayout());
       Settings_Frame.setSize(250,150);
       Settings_Frame.setUndecorated(true);
       Settings_Frame.setLocationRelativeTo(Settings_Frame);
       Settings_Frame.setResizable(false);
       
       Head = new JPanel();
       Head.setBackground(Color.BLACK);
       Head.setBorder(BorderFactory.createLineBorder(Foreground_Color,2));
       
       Body = new JPanel();
       Body.setBackground(Color.BLACK);
       Body.setBorder(BorderFactory.createLineBorder(Foreground_Color,2));
       Body.setLayout(new BorderLayout());
       
       Container= new JPanel();
       Container.setBackground(Color.BLACK);
       Container.setLayout(new FlowLayout());
       
       
       //Foot = new JPanel();
       //Foot.setBackground(Color.BLACK);
       //Foot.setBorder(BorderFactory.createLineBorder(Foreground_Color,2));
       
       Choice_Label = new JLabel("Choose Starting Tile");
       Choice_Label.setBackground(Color.BLACK);
       Choice_Label.setForeground(Foreground_Color);
       Choice_Label.setFont(new Font("MV Boli",Font.BOLD,20));
       Choice_Label.setFocusable(false);
       
       String[] choices = {"Upper Left", "Lower Right"};
       choiceBox = new JComboBox<>(choices);
       choiceBox.setForeground(Foreground_Color);
       choiceBox.setSelectedIndex(-1);
       choiceBox.setBackground(Color.BLACK);
       choiceBox.setUI(new old_CustomComboBoxUI());
       choiceBox.setBorder(BorderFactory.createLineBorder(Foreground_Color,2));
       //choiceBox.hasFocus();
       
       Confirm = new JButton("Confirm");
       Confirm.setBackground(Color.BLACK);
       Confirm.setForeground(Foreground_Color);
       Confirm.setFont(new Font("MV Boli",Font.PLAIN,13));
       Confirm.setBorder(BorderFactory.createLineBorder(Foreground_Color,1));
       
       Confirm.addActionListener(this);
       
       Confirm.addMouseListener(this);
       
       Container.add(choiceBox);
       
       Head.add(Choice_Label);
       Body.add(Container,BorderLayout.CENTER);
       Body.add(Confirm,BorderLayout.SOUTH);
       //Foot.add(Confirm);
       
       Settings_Frame.add(Head,BorderLayout.NORTH);
       Settings_Frame.add(Body,BorderLayout.CENTER);
       //Settings_Frame.add(Foot,BorderLayout.SOUTH);
       
       Settings_Frame.setVisible(true);
       
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
		Confirm.setBackground(Foreground_Color);
        Confirm.setForeground(Color.BLACK);
        Confirm.setFont(new Font("MV Boli",Font.BOLD,13));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Confirm.setBackground(Color.BLACK);
        Confirm.setForeground(Foreground_Color);
        Confirm.setFont(new Font("MV Boli",Font.PLAIN,13));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Confirm) {
			System.out.println(choiceBox.getSelectedItem());
			Settings_Frame.dispose();
		}
		
	}

}
