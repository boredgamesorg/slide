import javax.swing.JFrame;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Slide_Start implements ActionListener,MouseListener{

    JFrame frame;
    ImageIcon image;
    JPanel center,north,south;
    JButton Start,Exit,Settings;
    JLabel Welcome,ver_label;


    Slide_Start(){

        image = new ImageIcon("C:\\Users\\Rohit Sinha\\SlideGameGUI\\SlideGameGUI\\OIP (1).jpg");

        frame = new JFrame();

        frame.setTitle("Slide Tile!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setSize(550,550);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        center = new JPanel();
        center.setBackground(Color.BLACK);
        center.setLayout(new GridLayout(2,1));
        center.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));

        north = new JPanel();
        north.setBackground(Color.BLACK);
        north.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        
        south = new JPanel();
        south.setBackground(Color.BLACK);
        south.setLayout(new BorderLayout());
        south.setBorder(BorderFactory.createLineBorder(new Color(255,145,43),3));
        
        Welcome = new JLabel("Ready To Slide!");
        Welcome.setBackground(Color.BLACK);
        Welcome.setForeground(new Color(255,145,43));
        Welcome.setFont(new Font("MV Boli",Font.BOLD,40));
        Welcome.setFocusable(false);
        
        ver_label = new JLabel("SlideGame Version 1.0.0.1 ");
        ver_label.setBackground(Color.BLACK);
        ver_label.setForeground(new Color(255,145,43));
        ver_label.setFont(new Font("MV Boli",Font.BOLD,20));
        ver_label.setFocusable(false);
        

        Start = new JButton("Start");

        Start.setPreferredSize(new Dimension(50,400));
        Start.setBackground(Color.BLACK);
        Start.setForeground(new Color(255,145,43));
        Start.setFont(new Font("MV Boli",Font.PLAIN,75));
        Start.setBorder(null);
        Start.setFocusable(false);

        Exit = new JButton("Exit");

        Exit.setPreferredSize(new Dimension(50,400));
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(new Color(255,145,43));
        Exit.setBorder(null);
        Exit.setFont(new Font("MV Boli",Font.PLAIN,75));
        Exit.setFocusable(false);
        
        Settings = new JButton();
        
        ImageIcon setpic = new ImageIcon("C:\\Users\\Rohit Sinha\\SlideGameGUI\\SlideGameGUI\\cog_yellow.png");
        
        Settings.setIcon(setpic);
        Settings.setPreferredSize(new Dimension(40,40));
        Settings.setBackground(Color.BLACK);
        Settings.setForeground(new Color(255,145,43));
        Settings.setBorder(null);
        Settings.setFont(new Font("MV Boli",Font.PLAIN,75));
        Settings.setFocusable(false);

        Start.addMouseListener(this);
        Exit.addMouseListener(this);
        Settings.addMouseListener(this);

        Start.addActionListener(this);
        Exit.addActionListener(this);
        Settings.addActionListener(this);
        
        north.add(Welcome);

        center.add(Start);
        center.add(Exit);
        
        south.add(ver_label,BorderLayout.WEST);
        south.add(Settings,BorderLayout.EAST);

        frame.add(center,BorderLayout.CENTER);
        frame.add(north,BorderLayout.NORTH);
        frame.add(south,BorderLayout.SOUTH);

        frame.setVisible(true);



    }
    public void playSound(String soundName)
 {
   try 
   {
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
    Clip clip = AudioSystem.getClip( );
    clip.open(audioInputStream);
    clip.start( );
   }
   catch(Exception ex)
   {
     System.out.println("Error with playing sound.");
     //ex.printStackTrace( );
   }

 }

    @Override
    public void actionPerformed(ActionEvent args) {
        
        if(args.getSource()==Start){
            //new Game_Screen();
            frame.dispose();
            
        }
        if(args.getSource()==Exit){
            System.exit(0);
        }
        if(args.getSource()==Settings) {
        	new Settings_Window();
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Start){
            Start.setBackground(Color.BLACK);
            Start.setForeground(new Color(255,145,43));
            
            
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==Start){
            Start.setBackground(new Color(255,145,43));
            Start.setForeground(Color.BLACK);
            Start.setFont(new Font("MV Boli",Font.BOLD,95));
            
            playSound("zapsplat_multimedia_button_click_004_78081.wav");

        }
        if(e.getSource()==Exit){
            Exit.setBackground(new Color(255,145,43));
            Exit.setForeground(Color.BLACK);
            Exit.setFont(new Font("MV Boli",Font.BOLD,95));

            playSound("zapsplat_multimedia_button_click_004_78081.wav");
        }
        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==Start){
            Start.setBackground(Color.BLACK);
            Start.setForeground(new Color(255,145,43));
            Start.setFont(new Font("MV Boli",Font.PLAIN,75));
        }
        if(e.getSource()==Exit){
            Exit.setBackground(Color.BLACK);
            Exit.setForeground(new Color(255,145,43));
            Exit.setFont(new Font("MV Boli",Font.PLAIN,75));
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == Start){
            Start.setBackground(Color.BLACK);
            Start.setForeground(new Color(255,145,43));
;
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == Start){
            Start.setPreferredSize(new Dimension(100,400));
            Start.setBackground(Color.BLACK);
            Start.setForeground(new Color(255,145,43));
            Start.setFont(new Font("MV Boli",Font.BOLD,75));
            Start.setBorder(null);
            Start.setFocusable(false);
        }
        
    }
    
}
