import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class ImageSplitter {

    //Method that splits image into n x n parts 
    public static BufferedImage[][] splitImage(BufferedImage image, int n, int borderSize, Color borderColor) throws IOException {
        int width = image.getWidth();
        int height = image.getHeight();

        int size = Math.min(width, height);

        BufferedImage squareImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = squareImage.createGraphics();
        g2d.drawImage(image, (size - width) / 2, (size - height) / 2, null);
        g2d.dispose();

        int tileWidth = size / n;
        int tileHeight = size / n;

        JPanel panel = new JPanel(new GridLayout(n, n, borderSize, borderSize));
        
        panel.setBackground(Color.BLACK);
        
        Border emptyBorder = BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize);
        Border lineBorder = BorderFactory.createLineBorder(borderColor);

        String dirName = System.getProperty("user.home") + "/Desktop/TileImage";
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdir();
        }
        
        BufferedImage[][] tileImages = new BufferedImage[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                BufferedImage tile = squareImage.getSubimage(j * tileWidth, i * tileHeight, tileWidth, tileHeight);
                ImageIO.write(tile, "png", new File(dirName + "/tile" + i + "_" + j + ".png"));

                tileImages[i][j] = tile;
                ImageIcon icon = new ImageIcon(tile);
                JLabel label = new JLabel(icon);
                label.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
                panel.add(label);
            }
        }

        // Mainframe
        JFrame frame = new JFrame();
        frame.setTitle("Split Image");
        frame.setSize(size + (n - 1) * borderSize, size + (n - 1) * borderSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(panel);
        frame.setVisible(true);
        
        return tileImages;
    }
}
