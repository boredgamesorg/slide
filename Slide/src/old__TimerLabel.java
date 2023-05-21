import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class old__TimerLabel {
    public static JLabel createTimerLabel(Color backgroundColor, Color foregroundColor, Border border, Font font) {
        JLabel timerLabel = new JLabel("Time: 00:00:00 ");
        timerLabel.setBackground(backgroundColor);
        timerLabel.setForeground(foregroundColor);
        timerLabel.setOpaque(true);
        timerLabel.setBorder(border);
        timerLabel.setFont(font);
        
        long startTime = System.currentTimeMillis();
        
        Timer timer = new Timer(1000, e -> {
            long elapsedTime = System.currentTimeMillis() - startTime;
            int hours = (int) (elapsedTime / (1000 * 60 * 60));
            int minutes = (int) ((elapsedTime / (1000 * 60)) % 60);
            int seconds = (int) ((elapsedTime / 1000) % 60);
            timerLabel.setText(String.format("Time: %02d:%02d:%02d ", hours, minutes, seconds));
        });
        timer.start();
        return timerLabel;
    }
}
